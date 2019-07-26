package co.com.ceiba.dominio.modelo.entidad;

public class Vehiculo {

	public static final int TAMANO_MINIMO_PLACA = 3;
	public static final String LA_PLACA_DEBE_TENER_MINIMO_LETRAS = "La placa debe tener mínimo %s letras.";
	public static final String LA_PLACA_ES_UN_DATO_OBLIGATORIO = "La placa es un dato obligatorio.";
	public static final String EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO = "El tipo de vehiculo es un dato obligatorio.";
	public static final String EL_CILINDRAJE_EN_MOTO_ES_UN_DATO_OBLIGATORIO = "El cilindraje en una moto es un dato obligatorio.";
	
	private int idV;
	private String placaE;
	private long tipoIdE;
	private String tipoE;
	private int cilindrajeE;
	
	public Vehiculo(int id, String placa, long tipoId, String tipo, int cilindraje) {
		ValidarArgumento.validarObligatorio(placa, LA_PLACA_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarObligatorio(tipoId, EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarObligatorio(tipo, EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarLongitud(placa, TAMANO_MINIMO_PLACA, String.format(LA_PLACA_DEBE_TENER_MINIMO_LETRAS,TAMANO_MINIMO_PLACA));
		this.idV = id;
		this.placaE = placa;
		this.tipoIdE = tipoId;
		this.tipoE = tipo;
		this.cilindrajeE = cilindraje;
	}

	public int getId() {
		return idV;
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
