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
	public static final String PLACA_EXISTENTE = "XXJ65C";
		
	@Autowired
	private  MockMvc mvc;
	
	private static final String JSON_REGISTRO_VEHICULO = "{ \"cilindrajeComando\": 200, \"entradaComando\": \"2019-07-30T02:04:49.267Z\", \"placaComando\": \"LLL44D\", \"salidaComando\": null, \"tipoIdComando\": 1, \"totalComando\": 0}";
	
	@Test
	public void crearRegistroVehiculoTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/estacionamiento/")
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
	
	@Test
	public void mostrarRegistrosVehiculosTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/estacionamiento/")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
