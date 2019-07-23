package co.com.ceiba.infraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.infraestructura.adaptador.entidad.RegistroVehiculoEntity;

public interface RepositorioRegistroVehiculoJPA extends CrudRepository<RegistroVehiculoEntity, Integer>{

    @Query("SELECT CASE WHEN COUNT(p.id) > 0 THEN true ELSE false END FROM VehiculoEntity p WHERE p.placa = :placa AND p.tipoId = :tipoId")
    public boolean existe(@Param("placa") String placa, @Param("tipoId") long tipoId);
    
    @Query("SELECT CASE WHEN COUNT(p.id) > :cantidad THEN false ELSE true END FROM VehiculoEntity p WHERE p.tipo = :tipo")
    public boolean validarCuposPorTipoVehiculo(@Param("tipo") String tipo, @Param("cantidad") long cantidad);

}
