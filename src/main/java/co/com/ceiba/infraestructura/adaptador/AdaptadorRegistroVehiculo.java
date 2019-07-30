package co.com.ceiba.infraestructura.adaptador;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.RegistroVehiculoEntity;
import co.com.ceiba.infraestructura.adaptador.mapper.MapperRegistroVehiculo;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioRegistroVehiculoJPA;
import net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Reifying;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;

@Repository
public class AdaptadorRegistroVehiculo implements RepositorioRegistroVehiculo {
	private RepositorioRegistroVehiculoJPA repositorioRegistroVehiculo;
	private MapperRegistroVehiculo mapperRegistroVehiculo;
	
	public AdaptadorRegistroVehiculo(RepositorioRegistroVehiculoJPA repositorioRegistroVehiculo,
			MapperRegistroVehiculo mapperRegistroVehiculo) {
		this.repositorioRegistroVehiculo = repositorioRegistroVehiculo;
		this.mapperRegistroVehiculo = mapperRegistroVehiculo;
	}
	
	@Override
	public RegistroVehiculo crear(RegistroVehiculo registroVehiculo) {
		RegistroVehiculoEntity registroVehiculoEntity = mapperRegistroVehiculo.mapperDominioToEntity(registroVehiculo);
		repositorioRegistroVehiculo.save(registroVehiculoEntity);
		return mapperRegistroVehiculo.mapperEntityToDominio(registroVehiculoEntity);
	}
	
	@Override
	public RegistroVehiculo actualizar(RegistroVehiculo registroVehiculo) {
		RegistroVehiculoEntity registroVehiculoEntity2 = null;
		registroVehiculoEntity2 = repositorioRegistroVehiculo.findById(registroVehiculo.getId()).orElse(null);
		
		if(registroVehiculoEntity2 != null) {
			registroVehiculoEntity2.setSalida(registroVehiculo.getSalida());
			registroVehiculoEntity2.setTotal(registroVehiculo.getTotal());
			repositorioRegistroVehiculo.save(registroVehiculoEntity2);
		}
		return mapperRegistroVehiculo.mapperEntityToDominio(registroVehiculoEntity2);
	}
	
	@Override
	public boolean existe(String placa, int tipoId) {
		return this.repositorioRegistroVehiculo.existe(placa, tipoId);
	}
	
	@Override
	public RegistroVehiculo obtenerRegistroVehiculoPorPlaca(String placa) {	
		RegistroVehiculoEntity registroVehiculoEntity = this.repositorioRegistroVehiculo.obtenerRegistroVehiculoPorPlaca(placa);
		return mapperRegistroVehiculo.mapperEntityToDominio(registroVehiculoEntity);
	}
	
	@Override
	public int validarCuposPorTipoVehiculo(int tipo) {
		return this.repositorioRegistroVehiculo.validarCuposPorTipoVehiculo(tipo);
	}
	
	@Override
	public List<RegistroVehiculo> mostrar() {
		return mapperRegistroVehiculo.mapperEntityListToDominioList(this.repositorioRegistroVehiculo.mostrar());
	}
	
}
