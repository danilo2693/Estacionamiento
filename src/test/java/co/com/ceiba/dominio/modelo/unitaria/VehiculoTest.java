package co.com.ceiba.dominio.modelo.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import co.com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import co.com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearRegistroVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class VehiculoTest {
	
	private static final String PLACA = "ABC123";
	private static final String PLACA_CORTA = "A1";
	private static final long TIPO_ID = 1;
	private static final String TIPO = "MOTO";
	private static final int CILINDRAJE = 200;

	@Mock
	private RepositorioVehiculo repositorioVehiculo;
	@InjectMocks
	private ServicioCrearRegistroVehiculo servicioCrearVehiculo;
	
	@Test()
	public void crearVehiculoTest() {
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().
				conPlaca(PLACA).
				conTipo(TIPO_ID, TIPO)
				.conCilindraje(CILINDRAJE);
		
		//Act
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		
		//Assert
		assertEquals(PLACA, vehiculo.getPlaca());
		assertEquals(TIPO_ID, vehiculo.getTipoId());
		assertEquals(TIPO, vehiculo.getTipo());
		assertEquals(CILINDRAJE, vehiculo.getCilindraje());
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarPlacaObligatoria() {
		//Arrange
		VehiculoTestDataBuilder vehiculo = new VehiculoTestDataBuilder();
		vehiculo.conPlaca(null).build();

		//Act-Assert	
		vehiculo.build();
	}
	
	@Test(expected = ExcepcionLongitudValor.class)
	public void validarPlacaCorta() {
		//Arrange
		VehiculoTestDataBuilder vehiculo = new VehiculoTestDataBuilder();
		vehiculo.conPlaca(PLACA_CORTA).build();
	
		//Act-Assert		
		vehiculo.build();
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarTipoObligatorio() {
		//Arrange
		VehiculoTestDataBuilder vehiculo = new VehiculoTestDataBuilder();
		vehiculo.conTipo(TIPO_ID, null).build();
		
		//Act-Assert		
		vehiculo.build();
	}
}
