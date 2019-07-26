package co.com.ceiba.infraestructura.controlador;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@AutoConfigureMockMvc
public class ComandoControladoresTest {
	public static final int CILINDRAJE_510 = 510;
	public static final int ID = 1;
	public static final String PLACA_EXISTENTE = "MLM98P";
		
	@Autowired
	private  MockMvc mvc;
	
	private static final String JSON_VEHICULO = "{ \"cilindrajeComando\": 400, \"id\": 1, \"placaComando\": \"BBC10A\", \"tipoComando\": \"CARRO\", \"tipoIdComando\": 0}";
	private static final String JSON_REGISTRO_VEHICULO = "{ \"entradaComando\": \"2019-07-25T21:05:09.423Z\", \"id\": 0, \"salidaComando\": null, \"totalComando\": 0, \"vehiculoComando\": { \"cilindrajeComando\": 510, \"id\": 1, \"placaComando\": \"XXJ65C\", \"tipoComando\": \"MOTO\", \"tipoIdComando\": 1}}";
	
	@Test
	public void crearVehiculoTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/vehiculos")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JSON_VEHICULO))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void crearRegistroVehiculoTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/estacionamiento")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JSON_REGISTRO_VEHICULO))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void actualizarRegistroVehiculoTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.put("/estacionamiento/salir/"+PLACA_EXISTENTE)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
