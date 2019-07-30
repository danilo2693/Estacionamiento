package co.com.ceiba.infraestructura.adaptador;


import java.util.List;
import org.springframework.stereotype.Repository;

import co.com.ceiba.dominio.excepcion.ExcepcionEstacionamiento;
import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.infraestructura.adaptador.entidad.RegistroVehiculoEntity;
import co.com.ceiba.infraestructura.adaptador.mapper.MapperRegistroVehiculo;
import co.com.ceiba.infraestructura.adaptador.repositorio.RepositorioRegistroVehiculoJPA;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioRegistroVehiculo;
import co.com.ceiba.dominio.servicio.ServicioActualizarRegistroVehiculo;

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
		registroVehiculoEntity2 = repositorioRegistroVehiculo.findById(registroVehiculo.getId()).orElseThrow(() -> new ExcepcionEstacionamiento(ServicioActualizarRegistroVehiculo.EL_VEHICULO_NO_ESTA_PARQUEADO));
		registroVehiculoEntity2.setSalida(registroVehiculo.getSalida());
		registroVehiculoEntity2.setTotal(registroVehiculo.getTotal());
		repositorioRegistroVehiculo.save(registroVehiculoEntity2);
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
