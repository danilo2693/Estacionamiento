package co.com.ceiba.dominio.servicio;

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
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoRegistroTestDataBuilder;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioCrearRegistroVehiculoTest {
	
	private static final String PLACA = "ABC123";
	private static final String PLACA_SIN_A_INICIAL = "BC123";
	private static final long TIPO_MOTO_ID = 1;
	private static final long TIPO_CARRO_ID = 0;
	private static final String TIPO_MOTO = "MOTO";
	private static final String TIPO_CARRO = "CARRO";
	private static final long MOTOS_PARQUEADAS_10 = 10;
	private static final long CARROS_PARQUEADOS_20 = 21;
	private static final String FECHA_MARTES = "2019-07-23";
	private static final String FECHA_DOMINGO = "2019-07-21";
	private static final String FORMATO_FECHA = "yyyy-MM-dd";
	private static final int DIA_MIERCOLES = 4;
	
	@Spy
	@InjectMocks
	private ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo;
	
	@Mock
	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void crearRegistroVehiculoTest() {
		//Arrange		
		VehiculoRegistroTestDataBuilder registroVehiculoTestDataBuilder = new VehiculoRegistroTestDataBuilder();
		
		//Act	
		RegistroVehiculo registroVehiculo = registroVehiculoTestDataBuilder.build();
		this.servicioCrearRegistroVehiculo.ejecutar(registroVehiculo);
	}
	
	@Test(expected = ExcepcionDuplicidad.class)
	public void validarExistenciaPreviaTest() {
		//Arrange		
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA).build();
		VehiculoRegistroTestDataBuilder vehiculoRegistroTestDataBuilder = new VehiculoRegistroTestDataBuilder().conVehiculo(vehiculo);
		when(repositorioRegistroVehiculo.existe(PLACA, TIPO_MOTO_ID)).thenReturn(true);
		
		//Act	
		RegistroVehiculo registroVehiculo = vehiculoRegistroTestDataBuilder.build();
		this.servicioCrearRegistroVehiculo.ejecutar(registroVehiculo);
	}
	
	@Test(expected = ExcepcionCupos.class)
	public void validarCupoMotoLlenoEstacionamientoTest() {
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipo(TIPO_MOTO_ID, TIPO_MOTO);
		when(repositorioRegistroVehiculo.validarCuposPorTipoVehiculo(TIPO_MOTO)).thenReturn(MOTOS_PARQUEADAS_10);
		//Act	
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		this.servicioCrearRegistroVehiculo.validarCupoLlenoEstacionamiento(vehiculo);
	}
	
	@Test(expected = ExcepcionCupos.class)
	public void validarCupoCarroLlenoEstacionamientoTest() {
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA).conTipo(TIPO_CARRO_ID, TIPO_CARRO);
		when(repositorioRegistroVehiculo.validarCuposPorTipoVehiculo(TIPO_CARRO)).thenReturn(CARROS_PARQUEADOS_20);
		//Act	
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		this.servicioCrearRegistroVehiculo.validarCupoLlenoEstacionamiento(vehiculo);
	}
	
	@Test
	public void sinCupoMotoTest() {
		//Arrange
		boolean respuesta;
		when(repositorioRegistroVehiculo.validarCuposPorTipoVehiculo(TIPO_MOTO)).thenReturn(MOTOS_PARQUEADAS_10);
		
		//Act	
		respuesta = this.servicioCrearRegistroVehiculo.sinCupoEstacionamiento(TIPO_MOTO, TIPO_MOTO_ID);
		
		//Assert
		assertTrue(respuesta);
	}
	
	@Test
	public void sinCupoCarroTest() {
		//Arrange
		boolean respuesta;
		when(repositorioRegistroVehiculo.validarCuposPorTipoVehiculo(TIPO_CARRO)).thenReturn(CARROS_PARQUEADOS_20);
		
		//Act	
		respuesta = this.servicioCrearRegistroVehiculo.sinCupoEstacionamiento(TIPO_CARRO, TIPO_CARRO_ID);
		
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
		respuesta = this.servicioCrearRegistroVehiculo.verificarDiasNoPermitidos(diaHoy);
		
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
		respuesta = this.servicioCrearRegistroVehiculo.verificarDiasNoPermitidos(diaHoy);
		
		//Assert
		assertFalse(respuesta);
	}
	
	@Test
	public void validarEmpiezaConATest() {
		//Arrange
		boolean respuesta;
		
		//Act	
		respuesta = this.servicioCrearRegistroVehiculo.validarRestriccionLetraA(PLACA);
		
		//Assert
		assertTrue(respuesta);
	}
	
	@Test
	public void validarNoEmpiezaConATest() {
		//Arrange
		boolean respuesta;
		
		//Act	
		respuesta = this.servicioCrearRegistroVehiculo.validarRestriccionLetraA(PLACA_SIN_A_INICIAL);
		
		//Assert
		assertFalse(respuesta);
	}
	
	
	@Test(expected = ExcepcionRestriccionPlaca.class)
	public void validarRestriccionEntradaTest(){
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA);
		//Act
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		when(servicioCrearRegistroVehiculo.verificarDiasNoPermitidos(DIA_MIERCOLES)).thenReturn(true);
		when(servicioCrearRegistroVehiculo.validarRestriccionLetraA(PLACA)).thenReturn(true);
		//Act	
		this.servicioCrearRegistroVehiculo.validarRestriccionEntrada(vehiculo);
	}
}
