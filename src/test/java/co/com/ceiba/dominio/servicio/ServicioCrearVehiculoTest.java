package co.com.ceiba.dominio.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import co.com.ceiba.dominio.excepcion.ExcepcionCupos;
import co.com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import co.com.ceiba.dominio.excepcion.ExcepcionRestriccionPlaca;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioCrearVehiculoTest {
	
	private static final String PLACA = "ABC123";
	private static final String PLACA_SIN_A_INICIAL = "BC123";
	private static final String PLACA_A_MINUSCULA = "aBC123";
	private static final long TIPO_MOTO_ID = 1;
	private static final long TIPO_CARRO_ID = 0;
	private static final String TIPO_MOTO = "MOTO";
	private static final String TIPO_CARRO = "CARRO";
	private static final long MOTOS_PARQUEADAS_8 = 8;
	private static final long MOTOS_PARQUEADAS_10 = 10;
	private static final long CARROS_PARQUEADOS_20 = 21;
	private static final String FECHA_MARTES = "2019-07-23";
	private static final String FECHA_DOMINGO = "2019-07-21";
	private static final String FORMATO_FECHA = "yyyy-MM-dd";
	private static final int DIA_MIERCOLES = 4;
	
	@Spy
	@InjectMocks
	private ServicioCrearVehiculo servicioCrearVehiculo;

	@Mock
	private RepositorioVehiculo repositorioVehiculo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected = ExcepcionDuplicidad.class)
	public void validarExistenciaPreviaTest() {
		//Arrange		
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA);
		when(repositorioVehiculo.existe(PLACA, TIPO_MOTO_ID)).thenReturn(true);
		
		//Act	
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		this.servicioCrearVehiculo.ejecutar(vehiculo);
	}
	
	@Test(expected = ExcepcionCupos.class)
	public void validarCupoMotoLlenoEstacionamientoTest() {
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipo(TIPO_MOTO_ID, TIPO_MOTO);
		when(repositorioVehiculo.validarCuposPorTipoVehiculo(TIPO_MOTO)).thenReturn(MOTOS_PARQUEADAS_10);
		//Act	
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		this.servicioCrearVehiculo.validarCupoLlenoEstacionamiento(vehiculo);
	}
	
	@Test
	public void validarCupoCarroLlenoEstacionamientoTest() {
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipo(TIPO_CARRO_ID, TIPO_CARRO);
		when(repositorioVehiculo.validarCuposPorTipoVehiculo(TIPO_CARRO)).thenReturn(CARROS_PARQUEADOS_20);
		//Act	
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		
		try {
			this.servicioCrearVehiculo.validarCupoLlenoEstacionamiento(vehiculo);
		} catch (ExcepcionCupos e) {
			// Assert
			assertEquals("Lo sentimos, no hay cupos en el estacionamiento", e.getMessage());
		}
	}
	
	@Test
	public void sinCupoMotoTest() {
		//Arrange
		boolean respuesta;
		when(repositorioVehiculo.validarCuposPorTipoVehiculo(TIPO_MOTO)).thenReturn(MOTOS_PARQUEADAS_10);
		
		//Act	
		respuesta = this.servicioCrearVehiculo.sinCupoEstacionamiento(TIPO_MOTO, TIPO_MOTO_ID);
		
		//Assert
		assertTrue(respuesta);
	}
	
	@Test
	public void sinCupoCarroTest() {
		//Arrange
		boolean respuesta;
		when(repositorioVehiculo.validarCuposPorTipoVehiculo(TIPO_CARRO)).thenReturn(CARROS_PARQUEADOS_20);
		
		//Act	
		respuesta = this.servicioCrearVehiculo.sinCupoEstacionamiento(TIPO_CARRO, TIPO_CARRO_ID);
		
		//Assert
		assertTrue(respuesta);
	}
	
	@Test
	public void diaNoPermitidoTest() throws ParseException {
		//Arrange
		boolean respuesta;
		Date fecha = new SimpleDateFormat(FORMATO_FECHA).parse(FECHA_MARTES);
		Calendar fechaHoy = Calendar.getInstance();
		fechaHoy.setTime(fecha);
		int diaHoy = fechaHoy.get(Calendar.DAY_OF_WEEK);
		
		//Act	
		respuesta = this.servicioCrearVehiculo.verificarDiasNoPermitidos(diaHoy);
		
		//Assert
		assertTrue(respuesta);
	}
	
	@Test
	public void diaPermitidoTest() throws ParseException {
		//Arrange
		boolean respuesta;
		Date fecha = new SimpleDateFormat(FORMATO_FECHA).parse(FECHA_DOMINGO);
		Calendar fechaHoy = Calendar.getInstance();
		fechaHoy.setTime(fecha);
		int diaHoy = fechaHoy.get(Calendar.DAY_OF_WEEK);
		
		//Act	
		respuesta = this.servicioCrearVehiculo.verificarDiasNoPermitidos(diaHoy);
		
		//Assert
		assertFalse(respuesta);
	}
	
	@Test
	public void validarEmpiezaConATest() {
		//Arrange
		boolean respuesta;
		
		//Act	
		respuesta = this.servicioCrearVehiculo.validarRestriccionLetraA(PLACA);
		
		//Assert
		assertTrue(respuesta);
	}
	
	@Test
	public void validarNoEmpiezaConATest() {
		//Arrange
		boolean respuesta;
		
		//Act	
		respuesta = this.servicioCrearVehiculo.validarRestriccionLetraA(PLACA_SIN_A_INICIAL);
		
		//Assert
		assertFalse(respuesta);
	}
	
	
	@Test(expected = ExcepcionRestriccionPlaca.class)
	public void validarRestriccionEntradaTest(){
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA);
		when(servicioCrearVehiculo.verificarDiasNoPermitidos(DIA_MIERCOLES)).thenReturn(true);
		when(servicioCrearVehiculo.validarRestriccionLetraA(PLACA)).thenReturn(true);
		//Act	
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		this.servicioCrearVehiculo.ejecutar(vehiculo);
	}
	
}
