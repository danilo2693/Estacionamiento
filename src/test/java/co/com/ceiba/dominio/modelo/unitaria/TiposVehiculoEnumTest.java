package co.com.ceiba.dominio.modelo.unitaria;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import org.junit.Test;

import co.com.ceiba.dominio.modelo.entidad.TiposVehiculoEnum;

public class TiposVehiculoEnumTest {
	
	private static final String TIPO_MOTO = "MOTO";
	private static final String TIPO_CARRO = "CARRO";  

	@Test()
	public void verificarTiposVehiculoTest() throws ParseException {
		//Arrange	
		
		//Act
		
		//Assert
		assertEquals(TIPO_MOTO, TiposVehiculoEnum.MOTO.name());
		assertEquals(TIPO_CARRO, TiposVehiculoEnum.CARRO.name());
	}
	
}
