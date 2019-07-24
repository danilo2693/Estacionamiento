package co.com.ceiba.dominio.excepcion;

public class ExcepcionEstacionamiento extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionEstacionamiento(String mensaje) {
        super(mensaje);
    }
}
