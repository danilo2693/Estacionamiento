package co.com.ceiba.infraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.infraestructura.adaptador.entidad.VehiculoEntity;

public interface RepositorioVehiculoJPA extends CrudRepository<VehiculoEntity, Integer>{
	
    @Query("SELECT CASE WHEN COUNT(p.id) > 0 THEN true ELSE false END FROM VehiculoEntity p WHERE p.placa = :placa AND p.tipoId = :tipoId")
    public boolean existe(@Param("placa") String placa, @Param("tipoId") long tipoId);
    
    @Query("SELECT COUNT(rv.id) FROM RegistroVehiculoEntity rv inner join rv.vehiculo v WHERE v.tipo = :tipo AND rv.salida is null")
    public long validarCuposPorTipoVehiculo(@Param("tipo") String tipo);

}
