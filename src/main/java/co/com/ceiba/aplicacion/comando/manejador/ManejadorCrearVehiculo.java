package co.com.ceiba.aplicacion.comando.manejador;

import co.com.ceiba.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.aplicacion.comando.fabrica.FabricaVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearVehiculo;

public class ManejadorCrearVehiculo {
	private final ServicioCrearVehiculo servicioCrearVehiculo;
	private final FabricaVehiculo fabricaVehiculo;
	
	public ManejadorCrearVehiculo(ServicioCrearVehiculo servicioCrearVehiculo, FabricaVehiculo fabricaVehiculo) {
		this.servicioCrearVehiculo = servicioCrearVehiculo;
		this.fabricaVehiculo = fabricaVehiculo;
	}
	
	public void ejecutar(ComandoVehiculo comandoVehiculo) {
		Vehiculo vehiculo = this.fabricaVehiculo.crear(comandoVehiculo);
		this.servicioCrearVehiculo.ejecutar(vehiculo);
	}
	
}
