package co.com.ceiba.aplicacion.comando.fabrica;

import org.springframework.stereotype.Component;

import co.com.ceiba.aplicacion.comando.ComandoRegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;

@Component
public class FabricaRegistroVehiculo {
	public RegistroVehiculo crear(ComandoRegistroVehiculo comandoRegistroVehiculo, Vehiculo vehiculo) {
		return new RegistroVehiculo(comandoRegistroVehiculo.getId(), vehiculo, 
				comandoRegistroVehiculo.getEntradaComando(),
				comandoRegistroVehiculo.getSalidaComando(), 
				comandoRegistroVehiculo.getTotalComando());
	}
}