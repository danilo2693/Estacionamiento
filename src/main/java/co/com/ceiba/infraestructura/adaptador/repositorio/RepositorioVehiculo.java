package co.com.ceiba.infraestructura.adaptador.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import co.com.ceiba.infraestructura.adaptador.entidad.VehiculoEntity;

public interface RepositorioVehiculo extends JpaRepository<VehiculoEntity, Integer>{

}
