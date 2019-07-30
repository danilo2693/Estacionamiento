package co.com.ceiba.infraestructura.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.aplicacion.comando.ComandoRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorActualizarRegistroVehiculo;
import co.com.ceiba.aplicacion.comando.manejador.ManejadorCrearRegistroVehiculo;
import co.com.ceiba.aplicacion.consulta.manejador.ManejadorMostrarRegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/estacionamiento")
@Api(tags = {"Controlador de estacionamiento"})
public class ComandoControladorRegistroVehiculo {

	private final ManejadorCrearRegistroVehiculo manejadorCrearRegistroVehiculo;
	private final ManejadorActualizarRegistroVehiculo manejadorActualizarRegistroVehiculo;
	private final ManejadorMostrarRegistroVehiculo manejadorMostrarRegistroVehiculo;

	@Autowired
	public ComandoControladorRegistroVehiculo(ManejadorCrearRegistroVehiculo manejadorCrearRegistroVehiculo,
			ManejadorActualizarRegistroVehiculo manejadorActualizarRegistroVehiculo,
			ManejadorMostrarRegistroVehiculo manejadorMostrarRegistroVehiculo) {
		this.manejadorCrearRegistroVehiculo = manejadorCrearRegistroVehiculo;
		this.manejadorActualizarRegistroVehiculo = manejadorActualizarRegistroVehiculo;
		this.manejadorMostrarRegistroVehiculo = manejadorMostrarRegistroVehiculo;
	}
	
	@PostMapping
	@ApiOperation("ingresar")
	public void crear(@RequestBody ComandoRegistroVehiculo comandoRegistroVehiculo) {
		this.manejadorCrearRegistroVehiculo.ejecutar(comandoRegistroVehiculo);
	}
	
	@PutMapping("salir/{placa}")
	@ApiOperation("retirar")
	public double actualizar(@PathVariable("placa") String placa) {
		return this.manejadorActualizarRegistroVehiculo.ejecutar(placa);
	}
		
	@GetMapping
	@ApiOperation("mostrar")
	public List<RegistroVehiculo> mostrar() {
		return this.manejadorMostrarRegistroVehiculo.ejecutar();
	}
}