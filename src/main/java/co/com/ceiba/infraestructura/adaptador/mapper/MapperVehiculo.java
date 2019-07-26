package co.com.ceiba.infraestructura.adaptador.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.VehiculoEntity;

@Component
public class MapperVehiculo {
	
	public Vehiculo mapperEntityToDominio(VehiculoEntity vehiculoEntity) {
		Vehiculo objeto;
		objeto = (vehiculoEntity == null) ? null :  new Vehiculo(
				vehiculoEntity.getId(),
				vehiculoEntity.getPlaca(), 
				vehiculoEntity.getTipoId(),
				vehiculoEntity.getTipo(), 
				vehiculoEntity.getCilindraje());
		return objeto;
	}
	
	public VehiculoEntity mapperDominioToEntity(Vehiculo vehiculo) {
		VehiculoEntity objeto;
		objeto = (vehiculo == null) ? null : new VehiculoEntity(
				vehiculo.getId(),
				vehiculo.getPlaca(), 
				vehiculo.getTipoId(),
				vehiculo.getTipo(), 
				vehiculo.getCilindraje());
		return objeto;
	}
}
