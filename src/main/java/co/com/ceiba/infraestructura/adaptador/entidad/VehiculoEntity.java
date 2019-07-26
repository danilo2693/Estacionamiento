package co.com.ceiba.infraestructura.adaptador.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class VehiculoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idE;
	
	@Column(name = "placa")
	String placaE;
	
	@Column(name = "tipo_id")
	long tipoIdE;
	
	@Column(name = "tipo")
	String tipoE;
	
	@Column(name = "cilindraje")
	int cilindrajeE;
	
	public VehiculoEntity() {}

	public VehiculoEntity(int id, String placa, long tipoId, String tipo, int cilindraje) {
		this.idE = id;
		this.placaE = placa;
		this.tipoIdE = tipoId;
		this.tipoE = tipo;
		this.cilindrajeE = cilindraje;
	}
	
	public int getId() {
		return idE;
	}

	public String getPlaca() {
		return placaE;
	}

	public long getTipoId() {
		return tipoIdE;
	}

	public String getTipo() {
		return tipoE;
	}

	public int getCilindraje() {
		return cilindrajeE;
	}
	
}
