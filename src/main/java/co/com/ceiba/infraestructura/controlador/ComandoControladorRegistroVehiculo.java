package co.com.ceiba.infraestructura.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.aplicacion.comando.ComandoRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorActualizarRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorCrearRegistroVehiculo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/estacionamiento")
@Api(tags = {"Controlador de estacionamiento"})
public class ComandoControladorRegistroVehiculo {

	private final ManejadorCrearRegistroVehiculo manejadorCrearRegistroVehiculo;
	private final ManejadorActualizarRegistroVehiculo manejadorActualizarRegistroVehiculo;

	@Autowired
	public ComandoControladorRegistroVehiculo(ManejadorCrearRegistroVehiculo manejadorCrearRegistroVehiculo,
			ManejadorActualizarRegistroVehiculo manejadorActualizarRegistroVehiculo) {
		this.manejadorCrearRegistroVehiculo = manejadorCrearRegistroVehiculo;
		this.manejadorActualizarRegistroVehiculo = manejadorActualizarRegistroVehiculo;
	}
	
	@PostMapping
	@ApiOperation("ingresar")
	public void crear(@RequestBody ComandoRegistroVehiculo comandoRegistroVehiculo) {
		this.manejadorCrearRegistroVehiculo.ejecutar(comandoRegistroVehiculo);
	}
	
	@PutMapping("salir/{placa}")
	@ApiOperation("retirar")
	public boolean actualizar(@PathVariable("placa") String placa) {
		return this.manejadorActualizarRegistroVehiculo.ejecutar(placa);
	}
		
}