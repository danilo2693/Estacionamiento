package co.com.ceiba.aplicacion.consulta.manejador;

import java.util.List;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;

public class ManejadorMostrarRegistroVehiculo {
	private final RepositorioRegistroVehiculo repositorioRegistroVehiculo;
	
	public ManejadorMostrarRegistroVehiculo(RepositorioRegistroVehiculo repositorioRegistroVehiculo) {
		this.repositorioRegistroVehiculo = repositorioRegistroVehiculo;
	}
	
	public List<RegistroVehiculo> ejecutar() {
		return this.repositorioRegistroVehiculo.mostrar();
	}
	
}