package co.com.ceiba.dominio.puerto.repositorio;

import co.com.ceiba.dominio.modelo.entidad.Vehiculo;

public interface RepositorioVehiculo {

	/**
	 * Permite crear los vehiculos
	 * @param vehiculo
	 */
	public Vehiculo crear(Vehiculo vehiculo);
	
	/**
	 * Permite determinar si previamente se registro el vehiculo
	 * @param vehiculo
	 * @return si existe o no
	 */
	boolean existe(Vehiculo vehiculo);
}
