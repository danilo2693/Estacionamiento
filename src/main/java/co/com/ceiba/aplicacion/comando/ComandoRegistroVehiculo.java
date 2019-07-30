package co.com.ceiba.aplicacion.comando;

import java.util.Date;

public class ComandoRegistroVehiculo {
	private int id;
	private String placaComando;
	private int tipoIdComando;
	private int cilindrajeComando;
	private Date entradaComando;
	private Date salidaComando;
	private int totalComando;

	public ComandoRegistroVehiculo() {
		//los comandos llegan construidos a traves del controlador
	}
	
	public int getId() {
		return id;
	}

	public String getPlacaComando() {
		return placaComando;
	}

	public int getTipoIdComando() {
		return tipoIdComando;
	}

	public int getCilindrajeComando() {
		return cilindrajeComando;
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

