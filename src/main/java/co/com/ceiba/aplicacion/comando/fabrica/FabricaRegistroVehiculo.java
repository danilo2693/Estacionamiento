package co.com.ceiba.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.com.ceiba.aplicacion.comando.ComandoRegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;

@Component
public class FabricaRegistroVehiculo {
	public RegistroVehiculo crear(ComandoRegistroVehiculo comandoRegistroVehiculo) {
		return new RegistroVehiculo(new Vehiculo(comandoRegistroVehiculo.getVehiculoComando().getPlacaComando(),
				comandoRegistroVehiculo.getVehiculoComando().getTipoIdComando(), comandoRegistroVehiculo.getVehiculoComando().getTipoComando(),
				comandoRegistroVehiculo.getVehiculoComando().getCilindrajeComando()), comandoRegistroVehiculo.getEntradaComando(),
				comandoRegistroVehiculo.getSalidaComando(), comandoRegistroVehiculo.getTotalComando());
	}
}