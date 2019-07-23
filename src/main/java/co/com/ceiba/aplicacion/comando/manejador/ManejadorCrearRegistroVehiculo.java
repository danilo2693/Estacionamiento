package co.com.ceiba.aplicacion.comando.manejador;

import co.com.ceiba.aplicacion.comando.ComandoRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.fabrica.FabricaRegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearRegistroVehiculo;

public class ManejadorCrearRegistroVehiculo {
	private final ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo;
	private final FabricaRegistroVehiculo fabricaRegistroVehiculo;
	
	public ManejadorCrearRegistroVehiculo(ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo, 
			FabricaRegistroVehiculo fabricaRegistroVehiculo) {
		this.servicioCrearRegistroVehiculo = servicioCrearRegistroVehiculo;
		this.fabricaRegistroVehiculo = fabricaRegistroVehiculo;
	}
	
	public void ejecutar(ComandoRegistroVehiculo comandoRegistroVehiculo) {
		RegistroVehiculo registroVehiculo = this.fabricaRegistroVehiculo.crear(comandoRegistroVehiculo);
		this.servicioCrearRegistroVehiculo.ejecutar(registroVehiculo);
	}
	
}