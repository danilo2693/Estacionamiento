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
	boolean existe(String placa, long tipoId);
	
	/**
	 * Permite determinar si hay para un tipo de vehiculo
	 * @param vehiculo
	 * @return si hay cupo o no
	 */
	boolean validarCuposPorTipoVehiculo(String tipo, long cantidad);
}
