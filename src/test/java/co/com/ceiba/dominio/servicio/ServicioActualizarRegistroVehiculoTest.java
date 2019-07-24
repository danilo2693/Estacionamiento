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
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoRegistroTestDataBuilder;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioActualizarRegistroVehiculoTest {
	
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
	private static final int UNA_HORA = 1;
	private static final int DOS_DIAS = 2;
	private static final int VALOR_TOTAL_MOTO = 8500;
	private static final int CILINDRAJE_AUMENTO = 501;
	
	@Spy
	@InjectMocks
	private ServicioActualizarRegistroVehiculo servicioActualizarRegistroVehiculo;
	
	@Mock
	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void verificarObtenerDiasTest() throws ParseException {
		//Arrange
		double respuesta;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        Date fechaEntrada = dateFormat.parse("2019-07-24 01:15:00");
        Date fechaSalida = dateFormat.parse("2019-07-26 03:14:00");
        double diferenciaSegundos = ((fechaSalida.getTime() - fechaEntrada.getTime())/ServicioActualizarRegistroVehiculo.MILISEGUNDOS);

		//Act	
		respuesta = servicioActualizarRegistroVehiculo.obtenerDias(diferenciaSegundos);
		
		//Assert
		assertEquals(respuesta, DOS_DIAS, 0);
	}
	
	@Test
	public void verificarObtenerHorasTest() throws ParseException {
		//Arrange
		double respuesta;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:m:s");
        Date fechaEntrada = dateFormat.parse("2019-07-24 01:15:00");
        Date fechaSalida = dateFormat.parse("2019-07-24 03:14:00");
        double diferenciaSegundos = ((fechaSalida.getTime() - fechaEntrada.getTime())/ServicioActualizarRegistroVehiculo.MILISEGUNDOS);

		//Act	
		respuesta = servicioActualizarRegistroVehiculo.obtenerHoras(diferenciaSegundos);
		
		//Assert
		assertEquals(respuesta, UNA_HORA, 0);
	}
	
	@Test
	public void verificarCalcularValorAPagarMotoTest(){
		//Arrange
		double respuesta;
       
		//Act	
		respuesta = servicioActualizarRegistroVehiculo.calcularValorAPagar(DOS_DIAS, 
				UNA_HORA, 
				ServicioActualizarRegistroVehiculo.VALOR_DIA_MOTO, 
				ServicioActualizarRegistroVehiculo.VALOR_HORA_MOTO);
		
		//Assert
		assertEquals(respuesta, VALOR_TOTAL_MOTO, 0);
	}
	
	@Test
	public void verificarAumentoPorCilindrajeMotoTest(){
		//Arrange
		double respuesta;
       
		//Act	
		respuesta = servicioActualizarRegistroVehiculo.verificarAumentoPorCilindrajeMoto(CILINDRAJE_AUMENTO);
		
		//Assert
		assertEquals(respuesta, ServicioActualizarRegistroVehiculo.VALOR_AUMENTO_CILINDRAJE_MOTO, 0);
	}
	
}
