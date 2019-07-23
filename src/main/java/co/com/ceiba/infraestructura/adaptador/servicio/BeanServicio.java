package co.com.ceiba.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.aplicacion.comando.fabrica.FabricaRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.fabrica.FabricaVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorCrearRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorCrearVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearRegistroVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearVehiculo;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearVehiculo servicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		System.err.println("Infraestructura BeanServicioServicioCrearVehiculo");
		return new ServicioCrearVehiculo(repositorioVehiculo);
	}
	
	@Bean
    public ManejadorCrearVehiculo manejadorCrearVehiculo(ServicioCrearVehiculo servicioCrearVehiculo, FabricaVehiculo fabricaVehiculo) {
		System.err.println(" Infraestructura BeanServicioManejadorCrearVehiculo");
        return new ManejadorCrearVehiculo(servicioCrearVehiculo, fabricaVehiculo);
    }
	
	@Bean
	public ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo(RepositorioRegistroVehiculo repositorioRegistroVehiculo) {
		System.err.println("Infraestructura BeanServicioServicioCrearVehiculo");
		return new ServicioCrearRegistroVehiculo(repositorioRegistroVehiculo);
	}
	
	@Bean
    public ManejadorCrearRegistroVehiculo manejadorCrearRegistroVehiculo(ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo,
    		FabricaRegistroVehiculo fabricaRegistroVehiculo, ServicioCrearVehiculo servicioCrearVehiculo, FabricaVehiculo fabricaVehiculo) {
		System.err.println(" Infraestructura BeanServicioManejadorCrearVehiculo");
        return new ManejadorCrearRegistroVehiculo(servicioCrearRegistroVehiculo, fabricaRegistroVehiculo, servicioCrearVehiculo, fabricaVehiculo);
    }
	
}
