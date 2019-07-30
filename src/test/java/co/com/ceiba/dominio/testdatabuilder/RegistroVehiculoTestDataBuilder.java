package co.com.ceiba.dominio.testdatabuilder;

import java.util.Date;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;

public class RegistroVehiculoTestDataBuilder {
	
	private int id;
	private String placa;
	private int tipoId;
	private int cilindraje;
	private Date entrada;
	private Date salida;
	private double total;
	
	public RegistroVehiculoTestDataBuilder() {
		this.placa = "JLA21C";
		this.tipoId = 0;
		this.cilindraje = 200;
		this.entrada = new Date();
		this.salida =  new Date();
		this.total = 1000;
	}
	
	public RegistroVehiculoTestDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public RegistroVehiculoTestDataBuilder conTipoId(int tipoId) {
		this.tipoId = tipoId;
		return this;
	}
	
	public RegistroVehiculoTestDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public RegistroVehiculoTestDataBuilder conEntrada(Date entrada) {
		this.entrada = entrada;
		return this;
	}
	
	public RegistroVehiculoTestDataBuilder conSalida(Date salida) {
		this.salida = salida;
		return this;
	}
	
	public RegistroVehiculoTestDataBuilder conTotal(double total) {
		this.total = total;
		return this;
	}
	
	public RegistroVehiculo build() {
		return new RegistroVehiculo(id, placa, tipoId, cilindraje, entrada, salida, total);
	}
}
