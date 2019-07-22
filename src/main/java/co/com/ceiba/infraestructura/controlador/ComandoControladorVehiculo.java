package co.com.ceiba.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorCrearVehiculo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/estacionamiento")
@Api(tags = {"Controlador de vehiculo"})
public class ComandoControladorVehiculo {

	private final ManejadorCrearVehiculo manejadorCrearVehiculo;

	@Autowired
	public ComandoControladorVehiculo(ManejadorCrearVehiculo manejadorCrearVehiculo) {
		this.manejadorCrearVehiculo = manejadorCrearVehiculo;
	}
	
	@PostMapping
	@ApiOperation("crear")
	public void crear(@RequestBody ComandoVehiculo comandoVehiculo) {
		this.manejadorCrearVehiculo.ejecutar(comandoVehiculo);
	}
	
	
}
