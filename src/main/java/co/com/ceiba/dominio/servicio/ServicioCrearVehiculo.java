package co.com.ceiba.dominio.servicio;

import co.com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;

public class ServicioCrearVehiculo {

	private static final String EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA = "El vehiculo ya existe en el sistema";
	
	private RepositorioVehiculo repositorioVehiculo;
	
	public ServicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}
	
	public void ejecutar(Vehiculo vehiculo) {
		System.err.println("Dominio ServicioCrearVehiculo");
		validarExistenciaPrevia(vehiculo);
		this.repositorioVehiculo.crear(vehiculo);
	}

	private void validarExistenciaPrevia(Vehiculo vehiculo) {
		boolean existe = this.repositorioVehiculo.existe(vehiculo.getPlaca(), vehiculo.getTipoId());
		System.out.println("¿Existe?: "+ existe);
		if(existe) {
			throw new ExcepcionDuplicidad(EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}
