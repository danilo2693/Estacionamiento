package co.com.ceiba.dominio.servicio;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import co.com.ceiba.dominio.excepcion.ExcepcionEstacionamiento;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;

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
		registroVehiculo.setTotal(calcularTotal(registroVehiculo.getVehiculo().getCilindraje(),
				registroVehiculo.getEntrada(),
				registroVehiculo.getSalida(), 
				registroVehiculo.getVehiculo().getTipoId()));
		this.repositorioRegistroVehiculo.actualizar(registroVehiculo);
	}
	
	public RegistroVehiculo validarExistenciaEnRegistroVehiculo(String placa) {
		RegistroVehiculo registroVehiculo = this.repositorioRegistroVehiculo.obtenerRegistroVehiculoPorPlaca(placa);
		if(registroVehiculo == null) {
			throw new ExcepcionEstacionamiento(EL_VEHICULO_NO_ESTA_PARQUEADO);
		}
		return registroVehiculo;
	}
	
	public double calcularTotal(int cilindraje, Date entrada, Date salida, long tipo) {
		double diferenciaSegundos = ((salida.getTime() - entrada.getTime())/MILISEGUNDOS);
		List<Integer> diasYhoras = obtenerDiasYHoras(diferenciaSegundos);
		double total = 0;
		if(tipo == CARRO) {
			total = calcularValorAPagar(diasYhoras.get(0), diasYhoras.get(1), VALOR_DIA_CARRO, VALOR_HORA_CARRO);
		}else if(tipo == MOTO) {
			double aumento = verificarAumentoPorCilindrajeMoto(cilindraje);
			total = calcularValorAPagar(diasYhoras.get(0), diasYhoras.get(1), VALOR_DIA_MOTO, VALOR_HORA_MOTO);
			total += aumento;
		}
		return total;
	}
	
	public List<Integer> obtenerDiasYHoras(double diferenciaSegundos) {
		double totalHoras = diferenciaSegundos/SEGUNDOS_EN_HORA;
		int horas = 0;
		int dias = 0;
		List<Integer> resultado = new ArrayList<>();
		while (totalHoras >= 0) {
			if(totalHoras<=1) {
				horas = 1;
			}else if(totalHoras <= 9) {
				horas = (int)Math.floor(totalHoras);
			}else if((9 < totalHoras) && ( totalHoras<= 24)) {
				dias++;
			}else {
				dias++;
			}
			totalHoras -= 24;
		}
		resultado.add(dias);
		resultado.add(horas);
		return resultado;
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