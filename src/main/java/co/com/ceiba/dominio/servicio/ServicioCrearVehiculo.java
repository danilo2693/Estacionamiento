package co.com.ceiba.dominio.servicio;

import java.util.Calendar;

import co.com.ceiba.dominio.excepcion.ExcepcionCupos;
import co.com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import co.com.ceiba.dominio.excepcion.ExcepcionRestriccionPlaca;
import co.com.ceiba.dominio.modelo.entidad.TiposVehiculoEnum;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;

public class ServicioCrearVehiculo {

	private static final String EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA = "El vehiculo ya existe en el sistema";
	private static final String LO_SENTIMOS_NO_HAY_CUPOS = "Lo sentimos, no hay cupos en el estacionamiento";
	private static final String ESTE_VELICULO_TIENE_RESTRICCION_DE_PLACA = "Lo sentimos, este vehiculo tiene restricción para entrar el día de hoy";
	private static final int CANTIDAD_MAXIMA_CARROS = 20;
	private static final int CANTIDAD_MAXIMA_MOTOS = 10;
	private static final String RESTRICCION_LETRA_PLACA = "A";
	private static final String DIAS_ESPECIALES = "1,7";
	private RepositorioVehiculo repositorioVehiculo;
	
	public ServicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}
	
	public void ejecutar(Vehiculo vehiculo) {
		validarExistenciaPrevia(vehiculo);
		validarCupoEstacionamiento(vehiculo);
		validarRestriccionEntrada(vehiculo);
		this.repositorioVehiculo.crear(vehiculo);
	}

	public void validarExistenciaPrevia(Vehiculo vehiculo) {
		boolean existe = this.repositorioVehiculo.existe(vehiculo.getPlaca(), vehiculo.getTipoId());
		if(existe) {
			throw new ExcepcionDuplicidad(EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
	
	public void validarCupoEstacionamiento(Vehiculo vehiculo) {
		int cantidad = (TiposVehiculoEnum.CARRO.ordinal() == vehiculo.getTipoId()) ? CANTIDAD_MAXIMA_CARROS : CANTIDAD_MAXIMA_MOTOS;
		boolean cuposTipoVehiculo = this.repositorioVehiculo.validarCuposPorTipoVehiculo(vehiculo.getTipo(), cantidad);
		if(!cuposTipoVehiculo) {
			throw new ExcepcionCupos(LO_SENTIMOS_NO_HAY_CUPOS);
		}
	}
	
	public void validarRestriccionEntrada(Vehiculo vehiculo){
		Calendar fechaHoy = Calendar.getInstance();
		int diaHoy = fechaHoy.get(Calendar.DAY_OF_WEEK);
		if((vehiculo.getPlaca().startsWith(RESTRICCION_LETRA_PLACA) || vehiculo.getPlaca().startsWith(RESTRICCION_LETRA_PLACA.toLowerCase())) && verificarDiasNoPermitidos(diaHoy)) {
			throw new ExcepcionRestriccionPlaca(ESTE_VELICULO_TIENE_RESTRICCION_DE_PLACA);
		}
	}
	
	public boolean verificarDiasNoPermitidos(int diaHoy) {
		boolean diaPermitido = false;
		String[] dias = DIAS_ESPECIALES.split(","); 
		int cantidadDias = dias.length;
		for (int i = 0; i < cantidadDias; i++) {
			String diaRestriccion = dias[i];
			if(Integer.parseInt(diaRestriccion) == diaHoy){
				diaPermitido = true;
			}			
		}    
		return diaPermitido;
	}
}
