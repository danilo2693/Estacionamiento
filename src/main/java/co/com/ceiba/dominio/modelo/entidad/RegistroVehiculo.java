package co.com.ceiba.dominio.modelo.entidad;

import java.util.Date;

public class RegistroVehiculo {

	public static final String DEBE_REGISTRAR_UN_VEHICULO = "Debe registrar la placa de un vehiculo";
	public static final String DEBE_REGISTRAR_UNA_FECHA_INGRESO = "Debe registrar el ingreso del vehiculo";
	
	private Integer id;
	private Vehiculo vehiculo;
	private Date entrada;
	private Date salida;
	private double total;

	public RegistroVehiculo(Vehiculo vehiculo, Date entrada, Date salida, double total) {		
		ValidarArgumento.validarObligatorio(vehiculo, DEBE_REGISTRAR_UN_VEHICULO);
		ValidarArgumento.validarObligatorio(entrada, DEBE_REGISTRAR_UNA_FECHA_INGRESO);		
		this.vehiculo = vehiculo;
		this.entrada = entrada;
		this.salida = salida;
		this.total = total;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSalida() {
		return salida;
	}

	public double getTotal() {
		return total;
	}
	
	
}
