package co.com.ceiba.aplicacion.comando.manejador;

import co.com.ceiba.dominio.servicio.ServicioActualizarRegistroVehiculo;

public class ManejadorActualizarRegistroVehiculo {
	private final ServicioActualizarRegistroVehiculo servicioActualizarRegistroVehiculo;
	
	public ManejadorActualizarRegistroVehiculo(ServicioActualizarRegistroVehiculo servicioActualizarRegistroVehiculo) {
		this.servicioActualizarRegistroVehiculo = servicioActualizarRegistroVehiculo;
	}
	
	public boolean ejecutar(String placa) {
		this.servicioActualizarRegistroVehiculo.ejecutar(placa);
		return true;
	}
	
}