package co.com.ceiba.dominio.modelo.entidad;

import java.util.Date;

public class RegistroVehiculo {

	public static final String DEBE_REGISTRAR_UN_VEHICULO = "Debe registrar la placa de un vehiculo";
	public static final String DEBE_REGISTRAR_UNA_FECHA_INGRESO = "Debe registrar el ingreso del vehiculo";
	public static final int TAMANO_MINIMO_PLACA = 3;
	public static final String LA_PLACA_DEBE_TENER_MINIMO_LETRAS = "La placa debe tener mínimo %s letras.";
	public static final String LA_PLACA_ES_UN_DATO_OBLIGATORIO = "La placa es un dato obligatorio.";
	public static final String EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO = "El tipo de vehiculo es un dato obligatorio.";
	public static final String EL_CILINDRAJE_EN_MOTO_ES_UN_DATO_OBLIGATORIO = "El cilindraje en una moto es un dato obligatorio.";
	
	private int id;
	private String placa;
	private int tipoId;
	private int cilindraje;
	private Date entrada;
	private Date salida;
	private double total;
	
	public RegistroVehiculo(int id, String placa, int tipoId, int cilindraje, Date entrada, Date salida,
			double total) {
		ValidarArgumento.validarObligatorio(placa, LA_PLACA_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarTipoObligatorio(tipoId, EL_TIPO_VEHICULO_ES_UN_DATO_OBLIGATORIO);
		ValidarArgumento.validarLongitud(placa, TAMANO_MINIMO_PLACA, String.format(LA_PLACA_DEBE_TENER_MINIMO_LETRAS,TAMANO_MINIMO_PLACA));
		ValidarArgumento.validarObligatorio(entrada, DEBE_REGISTRAR_UNA_FECHA_INGRESO);	
		this.id = id;
		this.placa = placa;
		this.tipoId = tipoId;
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
		return tipoId;
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
