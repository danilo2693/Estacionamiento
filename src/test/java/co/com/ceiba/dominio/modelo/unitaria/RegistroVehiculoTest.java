package co.com.ceiba.dominio.modelo.unitaria;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import co.com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import co.com.ceiba.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.testdatabuilder.RegistroVehiculoTestDataBuilder;

public class RegistroVehiculoTest {
	
	private static final String PLACA = "HHH12C";  
	private static final String PLACA_CORTA = "A1";
	private static final int CARRO = 0;  
	private static final int CILINDRAJE = 250;  
	private static final int TIPO_INVALIDO = 3;  
	private static final String ENTRADA = "2019-07-23";  
	private static final String SALIDA = "2019-07-24"; 
	private static final double TOTAL = 10203;


	@Test()
	public void crearRegistroVehiculoTest() throws ParseException {
		//Arrange
		Date entrada = new SimpleDateFormat("yyyy-MM-dd").parse(ENTRADA);
		Date salida = new SimpleDateFormat("yyyy-MM-dd").parse(SALIDA);
		RegistroVehiculoTestDataBuilder vehiculoRegistroTestDataBuilder = new RegistroVehiculoTestDataBuilder().
				conPlaca(PLACA).
				conTipoId(CARRO).
				conCilindraje(CILINDRAJE).
				conEntrada(entrada).
				conSalida(salida).
				conTotal(TOTAL);
		
		//Act
		RegistroVehiculo registroVehiculo = vehiculoRegistroTestDataBuilder.build();
		
		//Assert
		assertEquals(PLACA, registroVehiculo.getPlaca());
		assertEquals(CARRO, registroVehiculo.getTipoId());
		assertEquals(CILINDRAJE, registroVehiculo.getCilindraje());
		assertEquals(entrada, registroVehiculo.getEntrada());
		assertEquals(salida, registroVehiculo.getSalida());
		assertEquals(TOTAL, registroVehiculo.getTotal(),0);
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarPlacaObligatoria() {
		//Arrange
		RegistroVehiculoTestDataBuilder registroVehiculoTestDataBuilder = new RegistroVehiculoTestDataBuilder();
		registroVehiculoTestDataBuilder.conPlaca(null);

		//Act-Assert	
		registroVehiculoTestDataBuilder.build();
	}
	
	@Test(expected = ExcepcionLongitudValor.class)
	public void validarPlacaCorta() {
		//Arrange
		RegistroVehiculoTestDataBuilder registroVehiculoTestDataBuilder = new RegistroVehiculoTestDataBuilder();
		registroVehiculoTestDataBuilder.conPlaca(PLACA_CORTA);
	
		//Act-Assert		
		registroVehiculoTestDataBuilder.build();
	}
	
	@Test(expected = ExcepcionTipoVehiculo.class)
	public void validarTipoObligatorio() {
		//Arrange
		RegistroVehiculoTestDataBuilder registroVehiculoTestDataBuilder = new RegistroVehiculoTestDataBuilder();
		registroVehiculoTestDataBuilder.conTipoId(TIPO_INVALIDO);
		
		//Act-Assert		
		registroVehiculoTestDataBuilder.build();
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarEntradaObligatoria() {
		//Arrange
		RegistroVehiculoTestDataBuilder registroVehiculoTestDataBuilder = new RegistroVehiculoTestDataBuilder().conEntrada(null);
		
		//Act-Assert		
		registroVehiculoTestDataBuilder.build();
	}
	
}
