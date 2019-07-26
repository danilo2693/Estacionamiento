package co.com.ceiba.infraestructura.adaptador.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.RegistroVehiculoEntity;

@Component
public class MapperRegistroVehiculo {
	
	public RegistroVehiculo mapperEntityToDominio(RegistroVehiculoEntity registroVehiculoEntity, MapperVehiculo mapperVehiculo) {
		RegistroVehiculo objeto = null;
		objeto = new RegistroVehiculo(
				registroVehiculoEntity.getId(), 
				mapperVehiculo.mapperEntityToDominio(registroVehiculoEntity.getVehiculo()),
				registroVehiculoEntity.getEntrada(),
				registroVehiculoEntity.getSalida(), 
				registroVehiculoEntity.getTotal());
		return objeto;
	}
	
	public RegistroVehiculoEntity mapperDominioToEntity(RegistroVehiculo registroVehiculo, MapperVehiculo mapperVehiculo) {
		RegistroVehiculoEntity objeto = null;
		objeto = new RegistroVehiculoEntity(
				registroVehiculo.getId(),
				mapperVehiculo.mapperDominioToEntity(registroVehiculo.getVehiculo()) ,
				registroVehiculo.getEntrada(), 
				registroVehiculo.getSalida(),
				registroVehiculo.getTotal());
		return objeto;
	}
	
	public List<RegistroVehiculo> mapperEntityListToDominioList(List<RegistroVehiculoEntity> listRegistroVehiculoEntities, MapperVehiculo mapperVehiculo) {
		List<RegistroVehiculo> listaObjetos = new ArrayList<>();
		
		for(RegistroVehiculoEntity entidad :listRegistroVehiculoEntities) {
			listaObjetos.add(new RegistroVehiculo(
					entidad.getId(), 
					mapperVehiculo.mapperEntityToDominio(entidad.getVehiculo()), 
					entidad.getEntrada(), 
					entidad.getSalida(), 
					entidad.getTotal()));
		}
		return listaObjetos;
	}
}
