package co.com.ceiba.dominio.modelo.entidad;

import java.util.Date;

public class RegistroVehiculo {

	public static final String DEBE_REGISTRAR_UN_VEHICULO = "Debe registrar la placa de un vehiculo";
	public static final String DEBE_REGISTRAR_UNA_FECHA_INGRESO = "Debe registrar el ingreso del vehiculo";
	
	private int id;
	private Vehiculo vehiculo;
	private Date entrada;
	private Date salida;
	private double total;

	public RegistroVehiculo(int id, Vehiculo vehiculo, Date entrada, Date salida, double total) {		
		ValidarArgumento.validarObligatorio(vehiculo, DEBE_REGISTRAR_UN_VEHICULO);
		ValidarArgumento.validarObligatorio(entrada, DEBE_REGISTRAR_UNA_FECHA_INGRESO);		
		this.id = id;
		this.vehiculo = vehiculo;
		this.entrada = entrada;
		this.salida = salida;
		this.total = total;
	}
	
	public int getId() {
		return id;
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

	public void setSalida(Date salida) {
		this.salida = salida;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	
}
