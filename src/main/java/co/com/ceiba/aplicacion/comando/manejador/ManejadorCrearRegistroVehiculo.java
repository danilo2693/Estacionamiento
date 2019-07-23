package co.com.ceiba.aplicacion.comando.manejador;

import co.com.ceiba.aplicacion.comando.ComandoRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.fabrica.FabricaRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.fabrica.FabricaVehiculo;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearRegistroVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearVehiculo;

public class ManejadorCrearRegistroVehiculo {
	private final ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo;
	private final FabricaRegistroVehiculo fabricaRegistroVehiculo;
	private final ServicioCrearVehiculo servicioCrearVehiculo;
	private final FabricaVehiculo fabricaVehiculo;
	
	public ManejadorCrearRegistroVehiculo(ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo, 
			FabricaRegistroVehiculo fabricaRegistroVehiculo,
			ServicioCrearVehiculo servicioCrearVehiculo, FabricaVehiculo fabricaVehiculo) {
		this.servicioCrearRegistroVehiculo = servicioCrearRegistroVehiculo;
		this.fabricaRegistroVehiculo = fabricaRegistroVehiculo;
		this.servicioCrearVehiculo = servicioCrearVehiculo;
		this.fabricaVehiculo = fabricaVehiculo;
	}
	
	public void ejecutar(ComandoRegistroVehiculo comandoRegistroVehiculo) {
		System.err.println("Aplicacion Comando ManejadorCrearVehiculo ejecutar");
		Vehiculo vehiculo = this.fabricaVehiculo.crear(comandoRegistroVehiculo.getVehiculo());
		this.servicioCrearVehiculo.ejecutar(vehiculo);
		RegistroVehiculo registroVehiculo = this.fabricaRegistroVehiculo.crear(comandoRegistroVehiculo);
		this.servicioCrearRegistroVehiculo.ejecutar(registroVehiculo);
	}
	
}
