package co.com.ceiba.infraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.infraestructura.adaptador.entidad.RegistroVehiculoEntity;

public interface RepositorioRegistroVehiculoJPA extends CrudRepository<RegistroVehiculoEntity, Integer>{

    @Query("SELECT CASE WHEN COUNT(rv.id) > 0 THEN true ELSE false END FROM RegistroVehiculoEntity rv join rv.vehiculo v WHERE v.placa = :placa AND v.tipoId = :tipoId")
    public boolean existe(@Param("placa") String placa, @Param("tipoId") long tipoId);
    
    @Query("SELECT COUNT(rv.id) FROM RegistroVehiculoEntity rv inner join rv.vehiculo v WHERE v.tipo = :tipo AND rv.salida is null")
    public int validarCuposPorTipoVehiculo(@Param("tipo") String tipo);

    @Query("SELECT rv FROM RegistroVehiculoEntity rv join rv.vehiculo v WHERE v.placa = :placa AND rv.salida is null AND rv.total = 0")
    public RegistroVehiculoEntity obtenerRegistroVehiculoPorPlaca(@Param("placa") String placa);
    
}
