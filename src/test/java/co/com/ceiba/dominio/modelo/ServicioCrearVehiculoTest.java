package co.com.ceiba.dominio.modelo;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;
import co.com.ceiba.dominio.servicio.ServicioCrearVehiculo;
import co.com.ceiba.dominio.testdatabuilder.VehiculoTestDataBuilder;

public class ServicioCrearVehiculoTest {

	private VehiculoTestDataBuilder vehiculoTestDataBuilder;

		@Mock
	private RepositorioVehiculo repositorioVehiculo;
	
	@InjectMocks
	ServicioCrearVehiculo servicioCrearVehiculo;
	
	@Before
	public void setup() {
		VehiculoTestDataBuilder vehiculoTestDataBuilder = new VehiculoTestDataBuilder();
	}
	
	@Test
	public void validarExistenciaPrevia() {
		//Arrange
		//vehiculoTestDataBuilder.conPlaca(placa)
	}
}
