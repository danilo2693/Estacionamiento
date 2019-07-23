package co.com.ceiba.dominio.puerto.repositorio;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;

public interface RepositorioRegistroVehiculo {

	/**
	 * Permite crear los registros de vehiculos
	 * @param vehiculo
	 */
	public RegistroVehiculo crear(RegistroVehiculo vehiculo);
}
