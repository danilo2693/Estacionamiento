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
        return new ManejadorCrearVehiculo(servicioCrearVehiculo, fabricaVehiculo);
    }
	
	@Bean
	public ServicioCrearVehiculo servicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		return new ServicioCrearVehiculo(repositorioVehiculo);
	}
}
