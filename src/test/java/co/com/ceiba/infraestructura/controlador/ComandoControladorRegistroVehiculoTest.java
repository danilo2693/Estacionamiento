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
public class ComandoControladorRegistroVehiculoTest {
	
	@Autowired
	private  MockMvc mvc;
	
	private static final String JSON = "{ \"entradaComando\": \"2019-07-23T20:34:54.165Z\", \"salidaComando\": null, \"totalComando\": 0, \"vehiculoComando\": { \"cilindrajeComando\": 400, \"placaComando\": \"XJA30C\", \"tipoComando\": \"MOTO\", \"tipoIdComando\": 1 }}";
	
	@Test
	public void testCrear() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/estacionamiento")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testActualizar() throws Exception {
		mvc.perform(MockMvcRequestBuilders.put("/estacionamiento")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
