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
	
	@Column(name = "cilindrajee")
	int cilindrajee;

	@Column(name = "entradae")
	Date entradae;
	
	@Column(name = "salidae")
	Date salidae;
	
	@Column(name = "totale")
	double totale;
	
	public RegistroVehiculoEntity() {}

	public RegistroVehiculoEntity(int id, String placa, int tipoId, int cilindraje, Date entrada, Date salida,
			double total) {
		this.id = id;
		this.placa = placa;
		this.tipoid = tipoId;
		this.cilindrajee = cilindraje;
		this.entradae = entrada;
		this.salidae = salida;
		this.totale = total;
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
		return cilindrajee;
	}

	public Date getEntrada() {
		return entradae;
	}

	public Date getSalida() {
		return salidae;
	}

	public double getTotal() {
		return totale;
	}

	public void setSalida(Date salida) {
		this.salidae = salida;
	}

	public void setTotal(double total) {
		this.totale = total;
	}
	
}
