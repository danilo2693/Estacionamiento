package co.com.ceiba.dominio.excepcion;

public class ExcepcionCupos extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionCupos(String mensaje) {
        super(mensaje);
    }
}
