package co.com.ceiba.dominio.servicio;

import java.util.Calendar;

import co.com.ceiba.dominio.excepcion.ExcepcionEstacionamiento;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;
import net.bytebuddy.asm.Advice.Return;

public class ServicioActualizarRegistroVehiculo {

	public static final String EL_VEHICULO_NO_ESTA_PARQUEADO = "El vehiculo no esta en el estacionamiento";
	public static final String LO_SENTIMOS_NO_HAY_CUPOS = "Lo sentimos, no hay cupos en el estacionamiento";
	public static final String ESTE_VELICULO_TIENE_RESTRICCION_DE_PLACA = "Lo sentimos, este vehiculo tiene restricción para entrar el día de hoy";
	private static final long MOTO = 1;
	private static final long CARRO = 0;
	public static final int VALOR_HORA_CARRO = 1000;
	public static final int VALOR_HORA_MOTO = 500;
	public static final int VALOR_DIA_CARRO = 8000;
	public static final int VALOR_DIA_MOTO = 4000;
	public static final int LIMITE_CILINDRAJE_MOTO = 500;
	public static final double VALOR_AUMENTO_CILINDRAJE_MOTO = 2000;
	public static final double SEGUNDOS_EN_HORA = 3600;
	public static final double SEGUNDOS_EN_DIA = 86400;
	public static final double MILISEGUNDOS = 1000;
	
	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;
	
	public ServicioActualizarRegistroVehiculo(RepositorioRegistroVehiculo repositorioRegistroVehiculo) {
		this.repositorioRegistroVehiculo = repositorioRegistroVehiculo;
	}
	
	public void ejecutar(String placa) {
		RegistroVehiculo registroVehiculo = validarExistenciaEnRegistroVehiculo(placa);
		registroVehiculo.setSalida(Calendar.getInstance().getTime());
		registroVehiculo.setTotal(calcularTotal(registroVehiculo));
		this.repositorioRegistroVehiculo.actualizar(registroVehiculo);
	}
	
	public RegistroVehiculo validarExistenciaEnRegistroVehiculo(String placa) {
		RegistroVehiculo registroVehiculo = this.repositorioRegistroVehiculo.obtenerRegistroVehiculoPorPlaca(placa);
		if(registroVehiculo == null) {
			throw new ExcepcionEstacionamiento(EL_VEHICULO_NO_ESTA_PARQUEADO);
		}
		return registroVehiculo;
	}
	
	public double calcularTotal(RegistroVehiculo registroVehiculo) {
		double aumento = verificarAumentoPorCilindrajeMoto(registroVehiculo.getVehiculo().getCilindraje());
		double diferenciaSegundos = ((registroVehiculo.getSalida().getTime() - registroVehiculo.getEntrada().getTime())/MILISEGUNDOS);
		int dias = obtenerDias(diferenciaSegundos);
		int horas = obtenerHoras(diferenciaSegundos- (dias*SEGUNDOS_EN_DIA));
		double total = 0;
		if(registroVehiculo.getVehiculo().getTipoId() == CARRO) {
			total = calcularValorAPagar(dias, horas, VALOR_DIA_CARRO, VALOR_HORA_CARRO);
			registroVehiculo.setTotal(total);
		}else if(registroVehiculo.getVehiculo().getTipoId() == MOTO) {
			total = calcularValorAPagar(dias, horas, VALOR_DIA_MOTO, VALOR_HORA_MOTO);
			registroVehiculo.setTotal(total + aumento);
		}
		return total;
	}
	
	public int obtenerDias(double diferenciaSegundos) {
		int dias = 0;
		if(diferenciaSegundos>=SEGUNDOS_EN_DIA) {
            dias=(int)Math.floor(diferenciaSegundos/SEGUNDOS_EN_DIA);
        }
        return dias;
	}
	
	public int obtenerHoras(double diferenciaSegundos) {
		int horas = 0;
		if(diferenciaSegundos>=SEGUNDOS_EN_HORA) {
            horas=(int)Math.floor(diferenciaSegundos/SEGUNDOS_EN_HORA);
        }
		return horas;
	}
	
	public double calcularValorAPagar(int cantidadDias, int cantidadHoras,
			double valorDia , double valorHora) {
		return (cantidadDias * valorDia) + (cantidadHoras * valorHora); 
	}
	
	public double verificarAumentoPorCilindrajeMoto(int cilindraje) {
		double aumento = 0;
		if(cilindraje > LIMITE_CILINDRAJE_MOTO) {
			aumento = VALOR_AUMENTO_CILINDRAJE_MOTO;
		}
		return aumento;
	}
}