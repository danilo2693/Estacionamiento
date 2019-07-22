package co.com.ceiba.infraestructura.adaptador;

import org.springframework.stereotype.Repository;

import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.VehiculoEntity;
import co.com.ceiba.infraestructura.adaptador.mapper.MapperVehiculo;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioVehiculoJPA;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;

@Repository
public class AdaptadorVehiculo implements RepositorioVehiculo {
	private RepositorioVehiculoJPA repositorioVehiculo;
	private MapperVehiculo mapperVehiculo;
	
	public AdaptadorVehiculo(RepositorioVehiculoJPA repositorioVehiculo, MapperVehiculo mapperVehiculo) {
		super();
		this.repositorioVehiculo = repositorioVehiculo;
		this.mapperVehiculo = mapperVehiculo;
	}
	
	@Override
	public Vehiculo crear(Vehiculo vehiculo) {
		VehiculoEntity vehiculoEntity = repositorioVehiculo.save(mapperVehiculo.mapperDominioToEntity(vehiculo));
		return mapperVehiculo.mapperEntityToDominio(vehiculoEntity);
	}

	@Override
	public boolean existe(String placa, long tipoId) {
		return this.repositorioVehiculo.existe(placa, tipoId);
	}
	
}
