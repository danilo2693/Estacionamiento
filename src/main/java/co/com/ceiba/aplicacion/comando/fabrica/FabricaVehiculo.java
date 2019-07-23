package co.com.ceiba.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.com.ceiba.aplicacion.comando.ComandoVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;

@Component
public class FabricaVehiculo {
	public Vehiculo crear(ComandoVehiculo comandoVehiculo) {
		return new Vehiculo(comandoVehiculo.getPlacaComando(), comandoVehiculo.getTipoIdComando(), 
				comandoVehiculo.getTipoComando(), comandoVehiculo.getCilindrajeComando());
	}
}
