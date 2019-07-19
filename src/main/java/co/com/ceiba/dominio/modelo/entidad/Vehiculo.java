package co.com.ceiba.dominio.modelo.entidad;

public class Vehiculo {

	private static final int TAMANO_MINIMO_PLACA = 3;
	private static final String LA_PLACA_DEBE_TENER_MINIMO_LETRAS = "El nombre debe tener mínimo %s letras.";
	private static final String LA_PLACA_ES_UN_DATO_OBLIGATORIO = "La placa es un dato obligatorio.";
	private static final String EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO = "El tipo de vehiculo es un dato obligatorio.";
	
	private String placa;
	private String tipoId;
	private String tipo;
	private int cilindraje;
	
	public Vehiculo() {}
	
	public Vehiculo(String tipoId,String tipo) {
		ValidarArgumento.validarObligatorio(tipoId, EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarObligatorio(tipo, EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO);
		this.tipoId = tipoId;
		this.tipo = tipo;
	}
	
	public Vehiculo(String placa, String tipoId, String tipo, int cilindraje) {
		ValidarArgumento.validarObligatorio(placa, LA_PLACA_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarObligatorio(tipoId, EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarObligatorio(tipo, EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarLongitud(placa, TAMANO_MINIMO_PLACA, String.format(LA_PLACA_DEBE_TENER_MINIMO_LETRAS,TAMANO_MINIMO_PLACA));
		this.placa = placa;
		this.tipoId = tipoId;
		this.tipoId = tipo;
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

	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
		
}
