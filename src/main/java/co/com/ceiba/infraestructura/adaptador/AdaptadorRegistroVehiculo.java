package co.com.ceiba.infraestructura.adaptador;

import org.springframework.stereotype.Repository;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.RegistroVehiculoEntity;
import co.com.ceiba.infraestructura.adaptador.entidad.VehiculoEntity;
import co.com.ceiba.infraestructura.adaptador.mapper.MapperRegistroVehiculo;
import co.com.ceiba.infraestructura.adaptador.mapper.MapperVehiculo;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioRegistroVehiculoJPA;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioVehiculoJPA;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;

@Repository
public class AdaptadorRegistroVehiculo implements RepositorioRegistroVehiculo {
	private RepositorioRegistroVehiculoJPA repositorioRegistroVehiculo;
	private RepositorioVehiculoJPA repositorioVehiculoJPA;
	private MapperRegistroVehiculo mapperRegistroVehiculo;
	private MapperVehiculo mapperVehiculo;
	
	public AdaptadorRegistroVehiculo(RepositorioRegistroVehiculoJPA repositorioRegistroVehiculo,
			RepositorioVehiculoJPA repositorioVehiculoJPA,
			MapperRegistroVehiculo mapperRegistroVehiculo,
			MapperVehiculo mapperVehiculo) {
		this.repositorioRegistroVehiculo = repositorioRegistroVehiculo;
		this.repositorioVehiculoJPA = repositorioVehiculoJPA;
		this.mapperRegistroVehiculo = mapperRegistroVehiculo;
		this.mapperVehiculo = mapperVehiculo;
	}
	
	@Override
	public RegistroVehiculo crear(RegistroVehiculo registroVehiculo) {
		VehiculoEntity vehiculoEntity = repositorioVehiculoJPA.findById(registroVehiculo.getVehiculo().getId()).orElse(null);
		RegistroVehiculoEntity registroVehiculoEntity = mapperRegistroVehiculo.mapperDominioToEntity(registroVehiculo,mapperVehiculo);
		registroVehiculoEntity.setVehiculo(vehiculoEntity);
		repositorioRegistroVehiculo.save(registroVehiculoEntity);
		return mapperRegistroVehiculo.mapperEntityToDominio(registroVehiculoEntity, mapperVehiculo);
	}
	
	@Override
	public RegistroVehiculo actualizar(RegistroVehiculo registroVehiculo) {
		RegistroVehiculoEntity registroVehiculoEntity = mapperRegistroVehiculo.mapperDominioToEntity(registroVehiculo,mapperVehiculo);
		VehiculoEntity vehiculoEntity = repositorioVehiculoJPA.findById(registroVehiculo.getVehiculo().getId()).orElse(null);
		registroVehiculoEntity.setVehiculo(vehiculoEntity);
		repositorioRegistroVehiculo.save(registroVehiculoEntity);
		return mapperRegistroVehiculo.mapperEntityToDominio(registroVehiculoEntity, mapperVehiculo);
	}
	
	@Override
	public boolean existe(String placa, long tipoId) {
		return this.repositorioRegistroVehiculo.existe(placa, tipoId);
	}
	
	@Override
	public RegistroVehiculo obtenerRegistroVehiculoPorPlaca(String placa) {	
		RegistroVehiculoEntity registroVehiculoEntity = this.repositorioRegistroVehiculo.obtenerRegistroVehiculoPorPlaca(placa);
		return mapperRegistroVehiculo.mapperEntityToDominio(registroVehiculoEntity, mapperVehiculo);
	}
	
	@Override
	public int validarCuposPorTipoVehiculo(String tipo) {
		return this.repositorioRegistroVehiculo.validarCuposPorTipoVehiculo(tipo);
	}
	
}
