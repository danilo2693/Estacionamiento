package co.com.ceiba.dominio.puerto.dao;
import co.com.ceiba.dominio.modelo.dto.DtoVehiculo;

import java.util.Collection;

public interface DaoVehiculo {

	/**
	 * Permite listar los vehiculos
	 * @return
	 */
	Collection<DtoVehiculo> listar();
}
