package co.com.ceiba.aplicacion.comando;

import java.util.Date;

public class ComandoRegistroVehiculo {
	private ComandoVehiculo vehiculo;
	private Date entrada;
	private Date salida;
	private int total;
	
	public ComandoRegistroVehiculo(){}

	public ComandoRegistroVehiculo(ComandoVehiculo vehiculo, Date entrada, Date salida, int total) {
		super();
		this.vehiculo = vehiculo;
		this.entrada = entrada;
		this.salida = salida;
		this.total = total;
	}
	
	public ComandoVehiculo getVehiculo() {
		return vehiculo;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSalida() {
		return salida;
	}

	public int getTotal() {
		return total;
	}
	
	
	
}

