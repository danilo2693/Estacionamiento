package co.com.ceiba.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.aplicacion.comando.fabrica.FabricaVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorCrearVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearVehiculo;

@Configuration
public class BeanServicio {

	
	@Bean
    public ManejadorCrearVehiculo crearVehiculo(ServicioCrearVehiculo servicioCrearVehiculo, FabricaVehiculo fabricaVehiculo) {
		System.err.println(" Infraestructura BeanServicioManejadorCrearVehiculo");
        return new ManejadorCrearVehiculo(servicioCrearVehiculo, fabricaVehiculo);
    }
	
	@Bean
	public ServicioCrearVehiculo servicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		System.err.println("Infraestructura BeanServicioServicioCrearVehiculo");
		return new ServicioCrearVehiculo(repositorioVehiculo);
	}
	
}
