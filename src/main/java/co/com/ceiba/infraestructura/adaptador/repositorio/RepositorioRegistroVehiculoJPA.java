package co.com.ceiba.infraestructura.adaptador.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.ceiba.infraestructura.adaptador.entidad.RegistroVehiculoEntity;

public interface RepositorioRegistroVehiculoJPA extends CrudRepository<RegistroVehiculoEntity, Integer>{

    @Query("SELECT CASE WHEN COUNT(rv.id) > 0 THEN true ELSE false END FROM RegistroVehiculoEntity rv WHERE rv.placa = :placa AND rv.tipoid = :tipoid AND rv.salida is null")
    public boolean existe(@Param("placa") String placa, @Param("tipoid") int tipoId);
    
    @Query("SELECT COUNT(rv.id) FROM RegistroVehiculoEntity rv WHERE rv.tipoid = :tipo AND rv.salida is null")
    public int validarCuposPorTipoVehiculo(@Param("tipo") int tipo);

    @Query("SELECT rv FROM RegistroVehiculoEntity rv WHERE rv.placa = :placa AND rv.salida is null AND rv.total = 0")
    public RegistroVehiculoEntity obtenerRegistroVehiculoPorPlaca(@Param("placa") String placa);
    
    @Query("SELECT rv FROM RegistroVehiculoEntity rv WHERE rv.salida is null AND rv.total = 0")
    public List<RegistroVehiculoEntity> mostrar();
}
