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
	private Integer id;
	
	@Column(name = "placa")
	String placa;
	
	@Column(name = "tipoId")
	long tipoId;
	
	@Column(name = "tipo")
	String tipo;
	
	@Column(name = "cilindraje")
	int cilindraje;
	
	public VehiculoEntity() {}

	public VehiculoEntity(Integer id, String placa, long tipoId, String tipo, int cilindraje) {
		super();
		this.id = id;
		this.placa = placa;
		this.tipoId = tipoId;
		this.tipo = tipo;
		this.cilindraje = cilindraje;
	}

	public Integer getId() {
		return id;
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
