package co.com.ceiba.aplicacion.comando;

public class ComandoVehiculo {
	int id;
	private String placaComando;
	private long tipoIdComando;
	private String tipoComando;
	private int cilindrajeComando;

	public ComandoVehiculo() {
		//los comandos llegan construidos a traves del controlador
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

