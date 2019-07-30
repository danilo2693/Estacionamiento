package co.com.ceiba.infraestructura.adaptador.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.RegistroVehiculoEntity;

@Component
public class MapperRegistroVehiculo {
	
	public RegistroVehiculo mapperEntityToDominio(RegistroVehiculoEntity registroVehiculoEntity) {
		RegistroVehiculo objeto = null;
		objeto = new RegistroVehiculo(
				registroVehiculoEntity.getId(),
				registroVehiculoEntity.getPlaca(),
				registroVehiculoEntity.getTipoId(),
				registroVehiculoEntity.getCilindraje(),
				registroVehiculoEntity.getEntrada(),
				registroVehiculoEntity.getSalida(), 
				registroVehiculoEntity.getTotal());
		return objeto;
	}
	
	public RegistroVehiculoEntity mapperDominioToEntity(RegistroVehiculo registroVehiculo) {
		RegistroVehiculoEntity objeto = null;
		objeto = new RegistroVehiculoEntity(
				registroVehiculo.getId(),
				registroVehiculo.getPlaca(),
				registroVehiculo.getTipoId(),
				registroVehiculo.getCilindraje(),
				registroVehiculo.getEntrada(), 
				registroVehiculo.getSalida(),
				registroVehiculo.getTotal());
		return objeto;
	}
	
	public List<RegistroVehiculo> mapperEntityListToDominioList(List<RegistroVehiculoEntity> listRegistroVehiculoEntities) {
		List<RegistroVehiculo> listaObjetos = new ArrayList<>();
		
		for(RegistroVehiculoEntity entidad :listRegistroVehiculoEntities) {
			listaObjetos.add(new RegistroVehiculo(
					entidad.getId(),
					entidad.getPlaca(),
					entidad.getTipoId(),
					entidad.getCilindraje(),
					entidad.getEntrada(), 
					entidad.getSalida(), 
					entidad.getTotal()));
		}
		return listaObjetos;
	}
}
