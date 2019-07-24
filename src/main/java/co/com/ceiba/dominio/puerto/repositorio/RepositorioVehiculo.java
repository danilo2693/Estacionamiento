package co.com.ceiba.dominio.puerto.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Vehiculo;

public interface RepositorioVehiculo {

	/**
	 * Permite crear los vehiculos
	 * @param vehiculo
	 */
	public Vehiculo crear(Vehiculo vehiculo);
}
