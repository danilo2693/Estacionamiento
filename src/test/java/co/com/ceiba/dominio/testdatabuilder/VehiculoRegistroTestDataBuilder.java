package co.com.ceiba.dominio.testdatabuilder;

import java.util.Date;

import co.com.ceiba.dominio.modelo.entidad.RegistroVehiculo;
import co.com.ceiba.dominio.modelo.entidad.Vehiculo;

public class VehiculoRegistroTestDataBuilder {
	
	private Vehiculo vehiculo;
	private Date entrada;
	private Date salida;
	private double total;
	
	public VehiculoRegistroTestDataBuilder() {
		this.vehiculo = new VehiculoTestDataBuilder().build();
		this.entrada = new Date();
		this.salida =  new Date();
		this.total = 1000;
	}
	
	public VehiculoRegistroTestDataBuilder conVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}
	
	public VehiculoRegistroTestDataBuilder conEntrada(Date entrada) {
		this.entrada = entrada;
		return this;
	}
	
	public VehiculoRegistroTestDataBuilder conSalida(Date salida) {
		this.salida = salida;
		return this;
	}
	
	public VehiculoRegistroTestDataBuilder conTotal(double total) {
		this.total = total;
		return this;
	}
	
	public RegistroVehiculo build() {
		return new RegistroVehiculo(vehiculo, entrada, salida, total);
	}
}
