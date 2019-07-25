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
	
	@Autowired
	private  MockMvc mvc;
	
	private static final String JSON_VEHICULO = "{ \"cilindrajeComando\": 510, \"id\": 1, \"placaComando\": \"XXJ65C\", \"tipoComando\": \"MOTO\", \"tipoIdComando\": 1}";
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
		//crearVehiculoTest();
		mvc.perform(MockMvcRequestBuilders.post("/estacionamiento")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JSON_REGISTRO_VEHICULO))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
//	@Test
//	public void actualizarRegistroVehiculoTest() throws Exception {
//		mvc.perform(MockMvcRequestBuilders.put("/estacionamiento")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(JSON))
//				.andExpect(MockMvcResultMatchers.status().isOk());
//	}
}
