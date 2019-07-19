package co.com.ceiba.aplicacion.comando;

public class ComandoVehiculo {
	private String placa;
	private String tipoId;
	private String tipo;
	private int cilindraje;
	
	
	public ComandoVehiculo(){}
	
	public ComandoVehiculo(String placa, String tipoId, String tipo, int cilindraje) {
		this.placa = placa;
		this.tipoId = tipoId;
		this.tipo = tipo;
		this.cilindraje = cilindraje;
	}
	public String getPlaca() {
		return placa;
	}
	public String getTipoId() {
		return tipoId;
	}
	public String getTipo() {
		return tipo;
	}
	public int getCilindraje() {
		return cilindraje;
	}
	
}

