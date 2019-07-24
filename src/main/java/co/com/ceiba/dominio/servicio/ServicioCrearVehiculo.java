package co.com.ceiba.dominio.servicio;

import java.util.Calendar;

import co.com.ceiba.dominio.excepcion.ExcepcionCupos;
import co.com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import co.com.ceiba.dominio.excepcion.ExcepcionRestriccionPlaca;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;
import co.com.ceiba.dominio.puerto.repositorio.RepositorioVehiculo;

public class ServicioCrearVehiculo {

	public static final String EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA = "El vehiculo ya existe en el sistema";
	public static final String LO_SENTIMOS_NO_HAY_CUPOS = "Lo sentimos, no hay cupos en el estacionamiento";
	public static final String ESTE_VELICULO_TIENE_RESTRICCION_DE_PLACA = "Lo sentimos, este vehiculo tiene restricción para entrar el día de hoy";
	private static final long CANTIDAD_MAXIMA_CARROS = 20;
	private static final long CANTIDAD_MAXIMA_MOTOS = 10;
	private static final long CARRO = 0;
	private static final long MOTO = 1;
	private static final String RESTRICCION_LETRA_PLACA = "A";
	private static final String DIAS_ESPECIALES = "1,7";
	private RepositorioVehiculo repositorioVehiculo;
	
	public ServicioCrearVehiculo(RepositorioVehiculo repositorioVehiculo) {
		this.repositorioVehiculo = repositorioVehiculo;
	}
	
	public void ejecutar(Vehiculo vehiculo) {
		validarExistenciaPrevia(vehiculo);
		validarCupoLlenoEstacionamiento(vehiculo);
		validarRestriccionEntrada(vehiculo);
		this.repositorioVehiculo.crear(vehiculo);
	}

	public void validarExistenciaPrevia(Vehiculo vehiculo) {
		boolean existe = this.repositorioVehiculo.existe(vehiculo.getPlaca(), vehiculo.getTipoId());
		if(existe) {
			throw new ExcepcionDuplicidad(EL_VEHICULO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
	
	public void validarCupoLlenoEstacionamiento(Vehiculo vehiculo) {
		boolean sinCupo = sinCupoEstacionamiento(vehiculo.getTipo(), vehiculo.getTipoId());
		if(sinCupo) {
			throw new ExcepcionCupos(LO_SENTIMOS_NO_HAY_CUPOS);
		}
	}
	
	public boolean sinCupoEstacionamiento(String tipo, long tipoId) {
		boolean resultado = false;
		long cantidadTipoVehiculo = this.repositorioVehiculo.validarCuposPorTipoVehiculo(tipo);
		if(tipoId == CARRO) {
			resultado = cantidadTipoVehiculo >= CANTIDAD_MAXIMA_CARROS;
		}else if(tipoId == MOTO) {
			resultado = cantidadTipoVehiculo >= CANTIDAD_MAXIMA_MOTOS;
		}
		return resultado;
	}
	
	public void validarRestriccionEntrada(Vehiculo vehiculo){
		Calendar fechaHoy = Calendar.getInstance();
		int diaHoy = fechaHoy.get(Calendar.DAY_OF_WEEK);
		boolean restriccion = validarRestriccionLetraA(vehiculo.getPlaca())
				&& verificarDiasNoPermitidos(diaHoy);
		if(restriccion) {
			throw new ExcepcionRestriccionPlaca(ESTE_VELICULO_TIENE_RESTRICCION_DE_PLACA);
		}
	}
	 
	public boolean validarRestriccionLetraA(String placa) {
		boolean resultado = false;
		if(placa.startsWith(RESTRICCION_LETRA_PLACA)) {
			resultado = true;
		}
		return resultado;
	}
	
	public boolean verificarDiasNoPermitidos(int diaHoy) {
		boolean diaNoPermitido = true;
		String[] dias = DIAS_ESPECIALES.split(","); 
		int cantidadDias = dias.length;
		for (int i = 0; i < cantidadDias; i++) {
			String diaRestriccion = dias[i];
			if(Integer.parseInt(diaRestriccion) == diaHoy){
				diaNoPermitido = false;
			}			
		}    
		return diaNoPermitido;
	}
}
