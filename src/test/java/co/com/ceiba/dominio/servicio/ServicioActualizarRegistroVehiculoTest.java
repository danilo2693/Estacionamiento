package co.com.ceiba.dominio.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import co.com.ceiba.dominio.excepcion.ExcepcionEstacionamiento;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;

public class ServicioActualizarRegistroVehiculoTest {
	
	private static final String PLACA = "HXJ12D";
	private static final long TIPO_MOTO_ID = 1;
	private static final long TIPO_CARRO_ID = 0;
	private static final String FORMATO_FECHA = "yyyy-MM-dd H:m:s";
	private static final int CERO_HORAS = 0;
	private static final int UNA_HORA = 1;
	private static final int CERO_DIAS = 0;
	private static final int UN_DIA = 1;
	private static final int OCHO_HORAS = 8;
	private static final int DOS_DIAS = 2;
	private static final int VALOR_TOTAL_MOTO = 8500;
	private static final int CILINDRAJE_AUMENTO = 501;
	private static final double DIEZ_MIL = 10000;
	private static final double OCHO_MIL = 8000;
	private static final double VEINTICUATRO_MIL = 24000;
	private static final String FECHA_ENTRADA_CALCULO_TOTAL = "2019-07-24 00:00:00";
	private static final String FECHA_SALIDA_CALCULO_TOTAL = "2019-07-26 08:00:00";
	private static final String FECHA_SALIDA_CALCULO_TOTAL_UNA_HORA = "2019-07-24 00:30:00";
	private static final String FECHA_SALIDA_CALCULO_TOTAL_UN_DIA = "2019-07-24 10:00:00";
	SimpleDateFormat dateFormat = new SimpleDateFormat(FORMATO_FECHA);
	@Spy
	@InjectMocks
	private ServicioActualizarRegistroVehiculo servicioActualizarRegistroVehiculo;
	
	@Mock
	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected = ExcepcionEstacionamiento.class)
	public void validarExistenciaRegistroVehiculoTest(){
		//Arrange
		when(this.repositorioRegistroVehiculo.obtenerRegistroVehiculoPorPlaca(PLACA)).thenReturn(null);
		//Act	
		servicioActualizarRegistroVehiculo.validarExistenciaEnRegistroVehiculo(PLACA);
	}
	
	@Test
	public void verificarObtenerDiasYHorasTest() throws ParseException {
		//Arrange
		List<Integer> total;
		boolean respuesta;
        Date fechaEntrada = dateFormat.parse(FECHA_ENTRADA_CALCULO_TOTAL);
        Date fechaSalida = dateFormat.parse(FECHA_SALIDA_CALCULO_TOTAL);
        double diferenciaSegundos = ((fechaSalida.getTime() - fechaEntrada.getTime())/ServicioActualizarRegistroVehiculo.MILISEGUNDOS);

		//Act	
		total = servicioActualizarRegistroVehiculo.obtenerDiasYHoras(diferenciaSegundos);
		respuesta = (total.get(0) == 2) && (total.get(1) == 8);

		//Assert
		assertTrue(respuesta);
	}
	
	@Test
	public void verificarObtenerUnaHoraTest() throws ParseException {
		//Arrange
		List<Integer> total;
		boolean respuesta;
		
        Date fechaEntrada = dateFormat.parse(FECHA_ENTRADA_CALCULO_TOTAL);
        Date fechaSalida = dateFormat.parse(FECHA_SALIDA_CALCULO_TOTAL_UNA_HORA);
        double diferenciaSegundos = ((fechaSalida.getTime() - fechaEntrada.getTime())/ServicioActualizarRegistroVehiculo.MILISEGUNDOS);

		//Act	
		total = servicioActualizarRegistroVehiculo.obtenerDiasYHoras(diferenciaSegundos);
		respuesta = (total.get(0) == CERO_DIAS) && (total.get(1) == UNA_HORA);

		//Assert
		assertTrue(respuesta);
	}
	
	@Test
	public void verificarObtenerUnDiaTest() throws ParseException {
		//Arrange
		List<Integer> total;
		boolean respuesta;
		
        Date fechaEntrada = dateFormat.parse(FECHA_ENTRADA_CALCULO_TOTAL);
        Date fechaSalida = dateFormat.parse(FECHA_SALIDA_CALCULO_TOTAL_UN_DIA);
        double diferenciaSegundos = ((fechaSalida.getTime() - fechaEntrada.getTime())/ServicioActualizarRegistroVehiculo.MILISEGUNDOS);

		//Act	
		total = servicioActualizarRegistroVehiculo.obtenerDiasYHoras(diferenciaSegundos);
		respuesta = (total.get(0) == UN_DIA) && (total.get(1) == CERO_HORAS);

		//Assert
		assertTrue(respuesta);
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
	
	@Test
	public void verificarCalculoTotalMotoTest() throws ParseException{
		//Arrange
		double respuesta;
        Date fechaEntrada = dateFormat.parse(FECHA_ENTRADA_CALCULO_TOTAL);
        Date fechaSalida = dateFormat.parse(FECHA_SALIDA_CALCULO_TOTAL);
        double diferenciaSegundos = ((fechaSalida.getTime() - fechaEntrada.getTime())/ServicioActualizarRegistroVehiculo.MILISEGUNDOS);

		when(this.servicioActualizarRegistroVehiculo.verificarAumentoPorCilindrajeMoto(CILINDRAJE_AUMENTO)).thenReturn(ServicioActualizarRegistroVehiculo.VALOR_AUMENTO_CILINDRAJE_MOTO);
		when(this.servicioActualizarRegistroVehiculo.obtenerDiasYHoras(diferenciaSegundos)).thenReturn(Arrays.asList(DOS_DIAS,OCHO_HORAS));
		when(this.servicioActualizarRegistroVehiculo.calcularValorAPagar(DOS_DIAS,
				OCHO_HORAS,
				ServicioActualizarRegistroVehiculo.VALOR_DIA_MOTO, 
				ServicioActualizarRegistroVehiculo.VALOR_HORA_MOTO)).thenReturn(OCHO_MIL);
       
		//Act	
		respuesta = servicioActualizarRegistroVehiculo.calcularTotal(CILINDRAJE_AUMENTO,
				fechaEntrada, fechaSalida, TIPO_MOTO_ID);
		
		//Assert
		assertEquals(respuesta, DIEZ_MIL, 0);
	}
	
	@Test
	public void verificarCalculoTotalCarroTest() throws ParseException{
		//Arrange
		double respuesta;
        Date fechaEntrada = dateFormat.parse(FECHA_ENTRADA_CALCULO_TOTAL);
        Date fechaSalida = dateFormat.parse(FECHA_SALIDA_CALCULO_TOTAL);
        double diferenciaSegundos = ((fechaSalida.getTime() - fechaEntrada.getTime())/ServicioActualizarRegistroVehiculo.MILISEGUNDOS);

		when(this.servicioActualizarRegistroVehiculo.obtenerDiasYHoras(diferenciaSegundos)).thenReturn(Arrays.asList(DOS_DIAS,OCHO_HORAS));
		when(this.servicioActualizarRegistroVehiculo.calcularValorAPagar(DOS_DIAS,
				OCHO_HORAS,
				ServicioActualizarRegistroVehiculo.VALOR_DIA_CARRO, 
				ServicioActualizarRegistroVehiculo.VALOR_HORA_CARRO)).thenReturn(VEINTICUATRO_MIL);
       
		//Act	
		respuesta = servicioActualizarRegistroVehiculo.calcularTotal(CILINDRAJE_AUMENTO,
				fechaEntrada, fechaSalida, TIPO_CARRO_ID);
		
		//Assert
		assertEquals(respuesta, VEINTICUATRO_MIL, 0);
	}
	
}
