package co.com.ceiba.aplicacion.comando;

import java.util.Date;

public class ComandoRegistroVehiculo {
	private ComandoVehiculo vehiculoComando;
	private Date entradaComando;
	private Date salidaComando;
	private int totalComando;

	public ComandoRegistroVehiculo(ComandoVehiculo vehiculo, Date entrada, Date salida, int total) {
		super();
		this.vehiculoComando = vehiculo;
		this.entradaComando = entrada;
		this.salidaComando = salida;
		this.totalComando = total;
	}

	public ComandoVehiculo getVehiculoComando() {
		return vehiculoComando;
	}

	public Date getEntradaComando() {
		return entradaComando;
	}

	public Date getSalidaComando() {
		return salidaComando;
	}

	public int getTotalComando() {
		return totalComando;
	}
}

