package co.com.ceiba.dominio.servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import co.com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioCrearVehiculoTest {
	
	private static final String PLACA = "ABC123";
	private static final long TIPO_MOTO_ID = 1;
	
	@Spy
	@InjectMocks
	private ServicioCrearVehiculo servicioCrearVehiculo;
	
	@Mock
	private RepositorioVehiculo repositorioVehiculo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void crearRegistroVehiculoTest() {
		//Arrange		
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
		
		//Act	
		Vehiculo vehiculo = vehiculoTestDataBuilder.build();
		this.servicioCrearVehiculo.ejecutar(vehiculo);
	}
	
	@Test
	public void validarExistenciaPreviaTest() {
		//Arrange		
		Vehiculo vehiculo = new VehiculoTestDataBuilder().conPlaca(PLACA).build();
		when(repositorioVehiculo.existe(PLACA, TIPO_MOTO_ID)).thenReturn(true);
		
		//Act	
		try {
			this.servicioCrearVehiculo.validarExistenciaPrevia(vehiculo);
			fail();
		} catch (ExcepcionDuplicidad e) {
			assertEquals(ServicioCrearVehiculo.EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA, e.getMessage());
		}
		
		
	}
	
}
