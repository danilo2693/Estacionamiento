package co.com.ceiba.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.com.ceiba.aplicacion.comando.ComandoRegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;

@Component
public class FabricaRegistroVehiculo {
	public RegistroVehiculo crear(ComandoRegistroVehiculo comandoRegistroVehiculo) {
		return new RegistroVehiculo(
				comandoRegistroVehiculo.getId(),
				comandoRegistroVehiculo.getPlacaComando(),
				comandoRegistroVehiculo.getTipoIdComando(),
				comandoRegistroVehiculo.getCilindrajeComando(),
				comandoRegistroVehiculo.getEntradaComando(),
				comandoRegistroVehiculo.getSalidaComando(), 
				comandoRegistroVehiculo.getTotalComando());
	}
}