package co.com.ceiba.infraestructura.adaptador.repositorio;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.infraestructura.adaptador.entidad.VehiculoEntity;

public interface RepositorioVehiculoJPA extends CrudRepository<VehiculoEntity, Integer>{

	public VehiculoEntity findById(int idTipoVehiculo);
	
}
