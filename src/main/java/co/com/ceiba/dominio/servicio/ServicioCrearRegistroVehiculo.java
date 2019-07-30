package co.com.ceiba.dominio.servicio;

import java.util.Calendar;

import co.com.ceiba.dominio.excepcion.ExcepcionCupos;
import co.com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import co.com.ceiba.dominio.excepcion.ExcepcionRestriccionPlaca;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;

public class ServicioCrearRegistroVehiculo {

	public static final String EL_VEHICULO_YA_ESTA_ESTACIONADO = "El vehiculo ya esta en el estacionamiento";
	public static final String LO_SENTIMOS_NO_HAY_CUPOS = "Lo sentimos, no hay cupos en el estacionamiento";
	public static final String ESTE_VELICULO_TIENE_RESTRICCION_DE_PLACA = "Lo sentimos, este vehiculo tiene restriccion para entrar el dia de hoy";
	private static final long CANTIDAD_MAXIMA_CARROS = 20;
	private static final long CANTIDAD_MAXIMA_MOTOS = 10;
	private static final long CARRO = 0;
	private static final long MOTO = 1;
	private static final String RESTRICCION_LETRA_PLACA = "A";
	private static final String DIAS_ESPECIALES = "1,7";
	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;
	
	public ServicioCrearRegistroVehiculo(RepositorioRegistroVehiculo repositorioRegistroVehiculo) {
		this.repositorioRegistroVehiculo = repositorioRegistroVehiculo;
	}
	
	public void ejecutar(RegistroVehiculo registroVehiculo) {
		validarExistenciaPrevia(registroVehiculo);
		validarCupoLlenoEstacionamiento(registroVehiculo);
		validarRestriccionEntrada(registroVehiculo);
		this.repositorioRegistroVehiculo.crear(registroVehiculo);
	}
	
	public void validarExistenciaPrevia(RegistroVehiculo registroVehiculo) {
		boolean existe = this.repositorioRegistroVehiculo.existe(registroVehiculo.getPlaca(), registroVehiculo.getTipoId());
		if(existe) {
			throw new ExcepcionDuplicidad(EL_VEHICULO_YA_ESTA_ESTACIONADO);
		}
	}
	
	public void validarCupoLlenoEstacionamiento(RegistroVehiculo registroVehiculo) {
		boolean sinCupo = sinCupoEstacionamiento(registroVehiculo.getTipoId());
		if(sinCupo) {
			throw new ExcepcionCupos(LO_SENTIMOS_NO_HAY_CUPOS);
		}
	}
	
	public boolean sinCupoEstacionamiento(int tipoId) {
		boolean resultado = false;
		int cantidadTipoVehiculo = this.repositorioRegistroVehiculo.validarCuposPorTipoVehiculo(tipoId);
		if(tipoId == CARRO) {
			resultado = cantidadTipoVehiculo >= CANTIDAD_MAXIMA_CARROS;
		}else if(tipoId == MOTO) {
			resultado = cantidadTipoVehiculo >= CANTIDAD_MAXIMA_MOTOS;
		}
		return resultado;
	}
	
	public void validarRestriccionEntrada(RegistroVehiculo registroVehiculo){
		Calendar fechaHoy = Calendar.getInstance();
		int diaHoy = fechaHoy.get(Calendar.DAY_OF_WEEK);
		boolean restriccion = validarRestriccionLetraA(registroVehiculo.getPlaca())
				&& verificarDiasNoPermitidos(diaHoy);
		if(restriccion) {
			throw new ExcepcionRestriccionPlaca(ESTE_VELICULO_TIENE_RESTRICCION_DE_PLACA);
		}
	}
	 
	public boolean validarRestriccionLetraA(String placa) {
		boolean resultado = false;
		if(placa.startsWith(RESTRICCION_LETRA_PLACA)) {
			resultado = true;
		}
		return resultado;
	}
	
	public boolean verificarDiasNoPermitidos(int diaHoy) {
		boolean diaNoPermitido = true;
		String[] dias = DIAS_ESPECIALES.split(","); 
		int cantidadDias = dias.length;
		for (int i = 0; i < cantidadDias; i++) {
			String diaRestriccion = dias[i];
			if(Integer.parseInt(diaRestriccion) == diaHoy){
				diaNoPermitido = false;
			}			
		}    
		return diaNoPermitido;
	}
}