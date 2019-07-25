package co.com.ceiba.dominio.puerto.repositorio;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;

public interface RepositorioRegistroVehiculo {

	/**
	 * Permite crear los registros de vehiculos
	 * @param vehiculo
	 */
	public RegistroVehiculo crear(RegistroVehiculo vehiculo);
	
	/**
	 * Permite actualizar los registros de vehiculos
	 * @param vehiculo
	 */
	public RegistroVehiculo actualizar(RegistroVehiculo vehiculo);
	
	/**
	 * Permite determinar si previamente se registro el vehiculo
	 * @param vehiculo
	 * @return si existe o no
	 */
	boolean existe(String placa, long tipoId);
	
	/**
	 * Permite obtener un registro de vehiculo a tráves de si placa
	 * @param placa
	 * @return vehiculo
	 */
	RegistroVehiculo obtenerRegistroVehiculoPorPlaca(String placa);
	
	/**
	 * Permite determinar si hay para un tipo de vehiculo
	 * @param vehiculo
	 * @return si hay cupo o no
	 */
	int validarCuposPorTipoVehiculo(String tipo);
	
}
