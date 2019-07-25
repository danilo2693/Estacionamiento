package co.com.ceiba.aplicacion.comando;

public class ComandoVehiculo {
	int id;
	private String placaComando;
	private long tipoIdComando;
	private String tipoComando;
	private int cilindrajeComando;

	public ComandoVehiculo() {}
	
	public ComandoVehiculo(String placaComando, long tipoIdComando, String tipoComando, int cilindrajeComando) {
		this.placaComando = placaComando;
		this.tipoIdComando = tipoIdComando;
		this.tipoComando = tipoComando;
		this.cilindrajeComando = cilindrajeComando;
	}
	
	public int getId() {
		return id;
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

