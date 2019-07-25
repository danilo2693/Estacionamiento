package co.com.ceiba.infraestructura.adaptador.mapper;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.RegistroVehiculoEntity;

@Component
public class MapperRegistroVehiculo {
	
	public RegistroVehiculo mapperEntityToDominio(RegistroVehiculoEntity registroVehiculoEntity, MapperVehiculo mapperVehiculo) {
		RegistroVehiculo objeto;
		objeto = (registroVehiculoEntity == null) ? null :  new RegistroVehiculo(
				registroVehiculoEntity.getId(), 
				mapperVehiculo.mapperEntityToDominio(registroVehiculoEntity.getVehiculo()),
				registroVehiculoEntity.getEntrada(),
				registroVehiculoEntity.getSalida(), 
				registroVehiculoEntity.getTotal());
		return objeto;
	}
	
	public RegistroVehiculoEntity mapperDominioToEntity(RegistroVehiculo registroVehiculo, MapperVehiculo mapperVehiculo) {
		RegistroVehiculoEntity objeto;
		objeto = (registroVehiculo == null) ? null : new RegistroVehiculoEntity(
				registroVehiculo.getId(),
				mapperVehiculo.mapperDominioToEntity(registroVehiculo.getVehiculo()) ,
				registroVehiculo.getEntrada(), 
				registroVehiculo.getSalida(),
				registroVehiculo.getTotal());
		return objeto;
	}
}
