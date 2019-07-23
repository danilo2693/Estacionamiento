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
		return new ServicioCrearVehiculo(repositorioVehiculo);
	}
	
	@Bean
    public ManejadorCrearVehiculo manejadorCrearVehiculo(ServicioCrearVehiculo servicioCrearVehiculo, FabricaVehiculo fabricaVehiculo) {
        return new ManejadorCrearVehiculo(servicioCrearVehiculo, fabricaVehiculo);
    }
	
	@Bean
	public ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo(RepositorioRegistroVehiculo repositorioRegistroVehiculo, ServicioCrearVehiculo servicioCrearVehiculo) {
		return new ServicioCrearRegistroVehiculo(repositorioRegistroVehiculo, servicioCrearVehiculo);
	}
	
	@Bean
    public ManejadorCrearRegistroVehiculo manejadorCrearRegistroVehiculo(ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo,
    		FabricaRegistroVehiculo fabricaRegistroVehiculo) {
        return new ManejadorCrearRegistroVehiculo(servicioCrearRegistroVehiculo, fabricaRegistroVehiculo);
    }
	
}
