 package co.com.ceiba.infraestructura.adaptador.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registro_vehiculo")
public class RegistroVehiculoEntity {
	@Id 
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="vehiculo_id")
	VehiculoEntity vehiculo;

	@Column(name = "entrada")
	Date entrada;
	
	@Column(name = "salida")
	Date salida;
	
	@Column(name = "total")
	double total;
	
	public RegistroVehiculoEntity() {}
	
	public RegistroVehiculoEntity(int id, VehiculoEntity vehiculo, Date entrada, Date salida, double total) {
		this.id = id;
		this.vehiculo = vehiculo;
		this.entrada = entrada;
		this.salida = salida;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public VehiculoEntity getVehiculo() {
		return vehiculo;
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

	public void setVehiculo(VehiculoEntity vehiculo) {
		this.vehiculo = vehiculo;
	}

}
