package co.com.ceiba.infraestructura.adaptador;

import org.springframework.stereotype.Repository;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.RegistroVehiculoEntity;
import co.com.ceiba.infraestructura.adaptador.mapper.MapperRegistroVehiculo;
import co.com.ceiba.infraestructura.adaptador.mapper.MapperVehiculo;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioRegistroVehiculoJPA;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;

@Repository
public class AdaptadorRegistroVehiculo implements RepositorioRegistroVehiculo {
	private RepositorioRegistroVehiculoJPA repositorioRegistroVehiculo;
	private MapperRegistroVehiculo mapperRegistroVehiculo;
	private MapperVehiculo mapperVehiculo;
	
	public AdaptadorRegistroVehiculo(RepositorioRegistroVehiculoJPA repositorioRegistroVehiculo, MapperRegistroVehiculo mapperRegistroVehiculo, MapperVehiculo mapperVehiculo) {
		this.repositorioRegistroVehiculo = repositorioRegistroVehiculo;
		this.mapperRegistroVehiculo = mapperRegistroVehiculo;
		this.mapperVehiculo = mapperVehiculo;
	}
	
	@Override
	public RegistroVehiculo crear(RegistroVehiculo registroVehiculo) {
		RegistroVehiculoEntity registroVehiculoEntity = repositorioRegistroVehiculo.save(mapperRegistroVehiculo.mapperDominioToEntity(registroVehiculo,mapperVehiculo));
		return mapperRegistroVehiculo.mapperEntityToDominio(registroVehiculoEntity, mapperVehiculo);
	}
	@Override
	public boolean existe(String placa, long tipoId) {
		return this.repositorioRegistroVehiculo.existe(placa, tipoId);
	}
	
	@Override
	public long validarCuposPorTipoVehiculo(String tipo) {
		return this.repositorioRegistroVehiculo.validarCuposPorTipoVehiculo(tipo);
	}
	
}
