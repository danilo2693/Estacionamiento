package co.com.ceiba.aplicacion.comando.manejador;

import co.com.ceiba.aplicacion.comando.ComandoRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.fabrica.FabricaRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.fabrica.FabricaVehiculo;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearRegistroVehiculo;

public class ManejadorCrearRegistroVehiculo {
	private final ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo;
	private final FabricaRegistroVehiculo fabricaRegistroVehiculo;
	private final FabricaVehiculo fabricaVehiculo;
	
	public ManejadorCrearRegistroVehiculo(ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo, 
			FabricaRegistroVehiculo fabricaRegistroVehiculo,
			FabricaVehiculo fabricaVehiculo) {
		this.servicioCrearRegistroVehiculo = servicioCrearRegistroVehiculo;
		this.fabricaRegistroVehiculo = fabricaRegistroVehiculo;
		this.fabricaVehiculo = fabricaVehiculo;
	}
	
	public void ejecutar(ComandoRegistroVehiculo comandoRegistroVehiculo) {
		Vehiculo vehiculo = fabricaVehiculo.crear(comandoRegistroVehiculo.getVehiculoComando());
		RegistroVehiculo registroVehiculo = fabricaRegistroVehiculo.crear(comandoRegistroVehiculo, vehiculo);
		this.servicioCrearRegistroVehiculo.ejecutar(registroVehiculo);
	}
	
}