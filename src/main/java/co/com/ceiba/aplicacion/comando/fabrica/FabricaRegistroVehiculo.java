package co.com.ceiba.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.com.ceiba.aplicacion.comando.ComandoRegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;

@Component
public class FabricaRegistroVehiculo {
	public RegistroVehiculo crear(ComandoRegistroVehiculo comandoRegistroVehiculo) {
		return new RegistroVehiculo(new Vehiculo(comandoRegistroVehiculo.getVehiculo().getPlaca(),
				comandoRegistroVehiculo.getVehiculo().getTipoId(), comandoRegistroVehiculo.getVehiculo().getTipo(),
				comandoRegistroVehiculo.getVehiculo().getCilindraje()), comandoRegistroVehiculo.getEntrada(),
				comandoRegistroVehiculo.getSalida(), comandoRegistroVehiculo.getTotal());
	}
}
