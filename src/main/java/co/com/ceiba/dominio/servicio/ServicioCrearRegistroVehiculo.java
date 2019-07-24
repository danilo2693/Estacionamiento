package co.com.ceiba.dominio.servicio;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;

public class ServicioCrearRegistroVehiculo {

	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;
	private ServicioCrearVehiculo servicioCrearVehiculo;
	
	public ServicioCrearRegistroVehiculo(RepositorioRegistroVehiculo repositorioRegistroVehiculo, ServicioCrearVehiculo servicioCrearVehiculo) {
		this.repositorioRegistroVehiculo = repositorioRegistroVehiculo;
		this.servicioCrearVehiculo = servicioCrearVehiculo;
	}
	
	public void ejecutar(RegistroVehiculo registroVehiculo) {
		servicioCrearVehiculo.validarExistenciaPrevia(registroVehiculo.getVehiculo());
		servicioCrearVehiculo.validarCupoLlenoEstacionamiento(registroVehiculo.getVehiculo());
		servicioCrearVehiculo.validarRestriccionEntrada(registroVehiculo.getVehiculo());
		this.repositorioRegistroVehiculo.crear(registroVehiculo);
	}
}