package co.com.ceiba.aplicacion.comando;

import java.util.Date;

public class ComandoRegistroVehiculo {
	private int id;
	private ComandoVehiculo vehiculoComando;
	private Date entradaComando;
	private Date salidaComando;
	private int totalComando;

	public ComandoRegistroVehiculo() {}
	
	public ComandoRegistroVehiculo(ComandoVehiculo vehiculoComando, Date entradaComando, Date salidaComando,
			int totalComando) {
		this.vehiculoComando = vehiculoComando;
		this.entradaComando = entradaComando;
		this.salidaComando = salidaComando;
		this.totalComando = totalComando;
	}
	
	public int getId() {
		return id;
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

