package co.com.ceiba.dominio.testdatabuilder;

import co.com.ceiba.dominio.modelo.entidad.Vehiculo;

public class VehiculoTestDataBuilder {
	
	private String placa;
	private long tipoId;
	private String tipo;
	private int cilindraje;
	
	public VehiculoTestDataBuilder() {
		this.placa = "XXJ65C";
		this.tipoId = 1;
		this.tipo = "MOTO";
		this.cilindraje = 200;
	}
	
	public VehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public VehiculoTestDataBuilder conTipo(long tipoId, String tipo) {
		this.tipoId = tipoId;
		this.tipo = tipo;
		return this;
	}
	
	public VehiculoTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public Vehiculo build() {
		return new Vehiculo(placa, tipoId, tipo, cilindraje);
	}
}
