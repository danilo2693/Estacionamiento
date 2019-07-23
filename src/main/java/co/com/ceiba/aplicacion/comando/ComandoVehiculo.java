package co.com.ceiba.aplicacion.comando;

public class ComandoVehiculo {
	private String placaComando;
	private long tipoIdComando;
	private String tipoComando;
	private int cilindrajeComando;
	
	public ComandoVehiculo(String placa, long tipoId, String tipo, int cilindraje) {
		this.placaComando = placa;
		this.tipoIdComando = tipoId;
		this.tipoComando = tipo;
		this.cilindrajeComando = cilindraje;
	}

	public String getPlacaComando() {
		return placaComando;
	}

	public long getTipoIdComando() {
		return tipoIdComando;
	}

	public String getTipoComando() {
		return tipoComando;
	}

	public int getCilindrajeComando() {
		return cilindrajeComando;
	}
}

