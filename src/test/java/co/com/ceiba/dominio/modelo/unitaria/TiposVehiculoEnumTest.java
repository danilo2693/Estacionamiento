package co.com.ceiba.dominio.modelo.unitaria;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import co.com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.TiposVehiculoEnum;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearRegistroVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoRegistroTestDataBuilder;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class TiposVehiculoEnumTest {
	
	private static final String TIPO_MOTO = "MOTO";
	private static final String TIPO_CARRO = "CARRO";  

	private TiposVehiculoEnum tiposVehiculoEnum;
	

	@Test()
	public void verificarTiposVehiculoTest() throws ParseException {
		//Arrange	
		
		//Act
		
		//Assert
		assertEquals(TIPO_MOTO, TiposVehiculoEnum.MOTO.name());
		assertEquals(TIPO_CARRO, TiposVehiculoEnum.CARRO.name());
	}
	
}
