package co.com.ceiba.dominio.modelo;

import org.junit.Test;

import co.com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import co.com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoTest {
	private RepositorioVehiculo repositorioVehiculo;

	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarPlacaObligatoria() {
		//Arrange
		Vehiculo vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(null).build();
		//Act
		ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioVehiculo);		
		servicioCrearVehiculo.ejecutar(vehiculoTestDataBuilder);
	}
	
	@Test(expected = ExcepcionLongitudValor.class)
	public void validarPlacaCorta() {
		//Arrange
		Vehiculo vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca("A1").build();
		//Act
		ServicioCrearVehiculo servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioVehiculo);		
		servicioCrearVehiculo.ejecutar(vehiculoTestDataBuilder);
	}
}
