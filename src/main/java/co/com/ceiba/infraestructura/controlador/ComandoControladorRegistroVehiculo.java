package co.com.ceiba.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.aplicacion.comando.ComandoRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorCrearRegistroVehiculo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/estacionamiento")
@Api(tags = {"Controlador de vehiculo"})
public class ComandoControladorRegistroVehiculo {

	private final ManejadorCrearRegistroVehiculo manejadorCrearRegistroVehiculo;

	@Autowired
	public ComandoControladorRegistroVehiculo(ManejadorCrearRegistroVehiculo manejadorCrearRegistroVehiculo) {
		this.manejadorCrearRegistroVehiculo = manejadorCrearRegistroVehiculo;
	}
	
	@PostMapping
	@ApiOperation("crear")
	public void crear(@RequestBody ComandoRegistroVehiculo comandoRegistroVehiculo) {
		this.manejadorCrearRegistroVehiculo.ejecutar(comandoRegistroVehiculo);
	}
		
}