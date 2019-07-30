 package co.com.ceiba.infraestructura.adaptador.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registro_vehiculo")
public class RegistroVehiculoEntity {
	@Id 
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "placa")
	String placa;
	
	@Column(name = "tipoid")
	int tipoid;
	
	@Column(name = "cilindraje")
	int cilindraje;

	@Column(name = "entrada")
	Date entrada;
	
	@Column(name = "salida")
	Date salida;
	
	@Column(name = "total")
	double total;
	
	public RegistroVehiculoEntity() {}

	public RegistroVehiculoEntity(int id, String placa, int tipoId, int cilindraje, Date entrada, Date salida,
			double total) {
		this.id = id;
		this.placa = placa;
		this.tipoid = tipoId;
		this.cilindraje = cilindraje;
		this.entrada = entrada;
		this.salida = salida;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public String getPlaca() {
		return placa;
	}

	public int getTipoId() {
		return tipoid;
	}

	public int getCilindraje() {
		return cilindraje;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSalida() {
		return salida;
	}

	public double getTotal() {
		return total;
	}

	public void setSalida(Date salida) {
		this.salida = salida;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
}
