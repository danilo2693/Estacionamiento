package co.com.ceiba.dominio.servicio;

import static org.mockito.Mockito.mock;
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
	private static final long TIPO_MOTO_ID = 1;
	private static final String TIPO_MOTO = "MOTO";
	private static final long MOTOS_PARQUEADAS_10 = 10;
	private static final long MOTOS_PARQUEADAS_8 = 8;
	private static final String FECHA_MARTES = "2019-07-23";
	
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
	public void validarCupoEstacionamientoTest() {
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA);
		when(repositorioVehiculo.validarCuposPorTipoVehiculo(TIPO_MOTO)).thenReturn(MOTOS_PARQUEADAS_10);
		//Act	
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		this.servicioCrearVehiculo.ejecutar(vehiculo);
	}
	
	@Test(expected = ExcepcionRestriccionPlaca.class)
	public void validarRestriccionEntradaTest() throws ParseException {
		//Arrange
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder().conPlaca(PLACA);
		Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(FECHA_MARTES);
		Calendar fechaHoy = Calendar.getInstance();
		fechaHoy.setTime(fecha);
		int diaHoy = fechaHoy.get(Calendar.DAY_OF_WEEK);
		when(servicioCrearVehiculo.verificarDiasNoPermitidos(diaHoy)).thenReturn(true);
		//Act	
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		this.servicioCrearVehiculo.ejecutar(vehiculo);
	}
}
