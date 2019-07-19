package co.com.ceiba.aplicacion.consulta.manejador;

import java.util.Collection;

import co.com.ceiba.dominio.modelo.dto.DtoVehiculo;
import co.com.ceiba.dominio.puerto.dao.DaoVehiculo;

public class ManejadorListarVehiculos {
	private final DaoVehiculo daoVehiculo;

	public ManejadorListarVehiculos(DaoVehiculo daoVehiculo) {
		this.daoVehiculo = daoVehiculo;
	}
	
	public Collection<DtoVehiculo> ejecutar(){
		return this.daoVehiculo.listar();
	}
	
}
