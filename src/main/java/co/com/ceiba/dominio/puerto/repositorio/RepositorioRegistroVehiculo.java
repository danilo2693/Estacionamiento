package co.com.ceiba.dominio.puerto.repositorio;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;

public interface RepositorioRegistroVehiculo {

	/**
	 * Permite crear los registros de vehiculos
	 * @param vehiculo
	 */
	public RegistroVehiculo crear(RegistroVehiculo vehiculo);
	
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
	long validarCuposPorTipoVehiculo(String tipo);
	
}
