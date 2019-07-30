package co.com.ceiba.aplicacion.comando.manejador;

import co.com.ceiba.dominio.servicio.ServicioActualizarRegistroVehiculo;

public class ManejadorActualizarRegistroVehiculo {
	private final ServicioActualizarRegistroVehiculo servicioActualizarRegistroVehiculo;
	
	public ManejadorActualizarRegistroVehiculo(ServicioActualizarRegistroVehiculo servicioActualizarRegistroVehiculo) {
		this.servicioActualizarRegistroVehiculo = servicioActualizarRegistroVehiculo;
	}
	
	public double ejecutar(String placa) {
		return this.servicioActualizarRegistroVehiculo.ejecutar(placa);
	}
	
}