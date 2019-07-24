package co.com.ceiba.dominio.servicio;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import co.com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoRegistroTestDataBuilder;

public class ServicioCrearRegistroVehiculoTest {
	
	private static final String PLACA = "ABC123";
	private static final long TIPO_MOTO_ID = 1;
	private static final String TIPO_MOTO = "MOTO";
	private static final long MOTOS_PARQUEADAS_10 = 10;
	private static final long MOTOS_PARQUEADAS_8 = 8;
	private static final String FECHA_MARTES = "2019-07-23";
	
	@Spy
	@InjectMocks
	private ServicioCrearRegistroVehiculo servicioCrearRegistroVehiculo;

	@Mock
	private ServicioCrearVehiculo servicioCrearVehiculo;
	
	@Mock
	private RepositorioRegistroVehiculo repositorioVehiculo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void crearRegistroVehiculoTest() {
		//Arrange		
		VehiculoRegistroTestDataBuilder registroVehiculoTestDataBuilder = new VehiculoRegistroTestDataBuilder();
		
		//Act	
		RegistroVehiculo registroVehiculo = registroVehiculoTestDataBuilder.build();
		this.servicioCrearRegistroVehiculo.ejecutar(registroVehiculo);
	}
	
}
