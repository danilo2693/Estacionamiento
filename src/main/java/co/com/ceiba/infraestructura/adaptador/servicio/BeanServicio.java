package co.com.ceiba.infraestructura.adaptador.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.com.ceiba.aplicacion.comando.fabrica.FabricaRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.fabrica.FabricaVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorActualizarRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorCrearRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorCrearVehiculo;
import co.com.ceiba.aplicacion.consulta.manejador.ManejadorMostrarRegistroVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import co.com.ceiba.dominio.servicio.ServicioActualizarRegistroVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearRegistroVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearVehiculo;

@Configuration
public class BeanServicio {
	
	@Bean
	public ServicioCrearVehiculo servicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		return new ServicioCrearVehiculo(repositorioVehiculo);
	}
	
	@Bean
    public ManejadorCrearVehiculo manejaCrearVehiculo(ServicioCrearVehiculo servicioCrearVehiculo,
    		FabricaVehiculo fabricaVehiculo) {
        return new ManejadorCrearVehiculo(servicioCrearVehiculo, fabricaVehiculo);
    }
	
	@Bean
	public ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo(RepositorioRegistroVehiculo repositorioRegistroVehiculo) {
		return new ServicioCrearRegistroVehiculo(repositorioRegistroVehiculo);
	}
	
	@Bean
    public ManejadorCrearRegistroVehiculo manejadorCrearRegistroVehiculo(ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo,
    		FabricaRegistroVehiculo fabricaRegistroVehiculo, FabricaVehiculo fabricaVehiculo) {
        return new ManejadorCrearRegistroVehiculo(servicioCrearRegistroVehiculo, fabricaRegistroVehiculo, fabricaVehiculo);
    }
	
	@Bean
	public ServicioActualizarRegistroVehiculo servicioActualizarRegistroVehiculo(RepositorioRegistroVehiculo repositorioRegistroVehiculo) {
		return new ServicioActualizarRegistroVehiculo(repositorioRegistroVehiculo);
	}
	
	@Bean
    public ManejadorActualizarRegistroVehiculo manejadorActualizarRegistroVehiculo(ServicioActualizarRegistroVehiculo servicioActualizarRegistroVehiculo) {
        return new ManejadorActualizarRegistroVehiculo(servicioActualizarRegistroVehiculo);
    }
	
	@Bean
    public ManejadorMostrarRegistroVehiculo mostrarRegistroVehiculo(RepositorioRegistroVehiculo repositorioRegistroVehiculo) {
        return new ManejadorMostrarRegistroVehiculo(repositorioRegistroVehiculo);
    }
	
}
