package co.com.ceiba.dominio.modelo;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import co.com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoTest {
	private RepositorioVehiculo repositorioVehiculo;
	private ServicioCrearVehiculo servicioCrearVehiculo;
	
	@Before
	public void setup() {
		servicioCrearVehiculo = new ServicioCrearVehiculo(repositorioVehiculo);
	}

	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarPlacaObligatoria() {
		//Arrange
		Vehiculo vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(null).build();
		//Act			
		servicioCrearVehiculo.ejecutar(vehiculoTestDataBuilder);
	}
	
	@Test(expected = ExcepcionLongitudValor.class)
	public void validarPlacaCorta() {
		//Arrange
		Vehiculo vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca("A1").build();
		//Act			
		servicioCrearVehiculo.ejecutar(vehiculoTestDataBuilder);
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarTipoObligatorio() {
		//Arrange
		Vehiculo vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conTipo(0, null).build();
		//Act
		servicioCrearVehiculo.ejecutar(vehiculoTestDataBuilder);
	}
}
