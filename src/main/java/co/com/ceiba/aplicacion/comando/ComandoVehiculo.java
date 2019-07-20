package co.com.ceiba.aplicacion.comando;

public class ComandoVehiculo {
	private String placa;
	private long tipoId;
	private String tipo;
	private int cilindraje;
	
	
	public ComandoVehiculo(){}
	
	public ComandoVehiculo(String placa, long tipoId, String tipo, int cilindraje) {
		this.placa = placa;
		this.tipoId = tipoId;
		this.tipo = tipo;
		this.cilindraje = cilindraje;
	}
	public String getPlaca() {
		return placa;
	}
	public long getTipoId() {
		return tipoId;
	}
	public String getTipo() {
		return tipo;
	}
	public int getCilindraje() {
		return cilindraje;
	}
	
}

