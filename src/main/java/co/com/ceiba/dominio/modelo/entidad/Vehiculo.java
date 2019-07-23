package co.com.ceiba.dominio.modelo.entidad;

public class Vehiculo {

	public static final int TAMANO_MINIMO_PLACA = 3;
	public static final String LA_PLACA_DEBE_TENER_MINIMO_LETRAS = "El nombre debe tener mínimo %s letras.";
	public static final String LA_PLACA_ES_UN_DATO_OBLIGATORIO = "La placa es un dato obligatorio.";
	public static final String EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO = "El tipo de vehiculo es un dato obligatorio.";
	public static final String EL_CILINDRAJE_EN_MOTO_ES_UN_DATO_OBLIGATORIO = "El cilindraje en una moto es un dato obligatorio.";
	
	private Integer id;
	private String placa;
	private long tipoId;
	private String tipo;
	private int cilindraje;
	
	public Vehiculo(String placa, long tipoId, String tipo, int cilindraje) {
		ValidarArgumento.validarObligatorio(placa, LA_PLACA_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarObligatorio(tipoId, EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarObligatorio(tipo, EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarLongitud(placa, TAMANO_MINIMO_PLACA, String.format(LA_PLACA_DEBE_TENER_MINIMO_LETRAS,TAMANO_MINIMO_PLACA));
		this.placa = placa;
		this.tipoId = tipoId;
		this.tipo = tipo;
		this.cilindraje = cilindraje;
	}
		
	public Vehiculo(Integer id,String placa, long tipoId, String tipo, int cilindraje) {
		ValidarArgumento.validarObligatorio(placa, LA_PLACA_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarObligatorio(tipoId, EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarObligatorio(tipo, EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarLongitud(placa, TAMANO_MINIMO_PLACA, String.format(LA_PLACA_DEBE_TENER_MINIMO_LETRAS,TAMANO_MINIMO_PLACA));
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
