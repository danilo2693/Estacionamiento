package co.com.ceiba.dominio.servicio;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;

public class ServicioCrearRegistroVehiculo {

	private static final String EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA = "El vehiculo ya existe en el sistema";
	private static final String LO_SENTIMOS_NO_HAY_CUPOS = "Lo sentimos, no hay cupos en el estacionamiento";
	private static final String ESTE_VELICULO_TIENE_RESTRICCION_DE_PLACA = "Lo sentimos, este vehiculo tiene restricción para entrar el día de hoy";
	private static final int CANTIDAD_MAXIMA_CARROS = 20;
	private static final int CANTIDAD_MAXIMA_MOTOS = 10;
	private static final String RESTRICCION_LETRA_PLACA = "A";
	private static final String DIAS_ESPECIALES = "1,7";
	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;
	
	public ServicioCrearRegistroVehiculo(RepositorioRegistroVehiculo repositorioRegistroVehiculo) {
		this.repositorioRegistroVehiculo = repositorioRegistroVehiculo;
	}
	
	public void ejecutar(RegistroVehiculo registroVehiculo) {
		this.repositorioRegistroVehiculo.crear(registroVehiculo);
	}
}