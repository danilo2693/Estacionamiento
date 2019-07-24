package co.com.ceiba.dominio.modelo.unitaria;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearRegistroVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoRegistroTestDataBuilder;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class RegistroVehiculoTest {
	
	private static final Vehiculo VEHICULO = new VehiculoTestDataBuilder().build();
	private static final String ENTRADA = "2019-07-23";  
	private static final String SALIDA = "2019-07-24"; 
	private static final double TOTAL = 10203;

	private RepositorioRegistroVehiculo repositorioRegistroVehiculo;
	private ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo;
	
	@Before
	public void setup() {
		servicioCrearRegistroVehiculo = new ServicioCrearRegistroVehiculo(repositorioRegistroVehiculo);
	}

	@Test()
	public void crearRegistroVehiculoTest() throws ParseException {
		//Arrange
		Date entrada = new SimpleDateFormat("yyyy-MM-dd").parse(ENTRADA);
		Date salida = new SimpleDateFormat("yyyy-MM-dd").parse(SALIDA);
		VehiculoRegistroTestDataBuilder vehiculoRegistroTestDataBuilder = new VehiculoRegistroTestDataBuilder().
				conVehiculo(VEHICULO).
				conEntrada(entrada).
				conSalida(salida).
				conTotal(TOTAL);
		
		//Act
		RegistroVehiculo registroVehiculo = vehiculoRegistroTestDataBuilder.build();
		
		//Assert
		assertEquals(VEHICULO, registroVehiculo.getVehiculo());
		assertEquals(entrada, registroVehiculo.getEntrada());
		assertEquals(salida, registroVehiculo.getSalida());
		assertEquals(TOTAL, registroVehiculo.getTotal(),0);
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarVehiculoObligatorio() {
		//Arrange
		VehiculoRegistroTestDataBuilder vehiculoRegistroTestDataBuilder = new VehiculoRegistroTestDataBuilder().conVehiculo(null);
		
		//Act	
		RegistroVehiculo registroVehiculo = vehiculoRegistroTestDataBuilder.build();
		servicioCrearRegistroVehiculo.ejecutar(registroVehiculo);
	}
	
	@Test(expected = ExcepcionValorObligatorio.class)
	public void validarEntradaObligatoria() {
		//Arrange
		VehiculoRegistroTestDataBuilder vehiculoRegistroTestDataBuilder = new VehiculoRegistroTestDataBuilder().conEntrada(null);
		
		//Act	
		RegistroVehiculo registroVehiculo = vehiculoRegistroTestDataBuilder.build();
		servicioCrearRegistroVehiculo.ejecutar(registroVehiculo);
	}
	
}
