package co.com.ceiba.dominio.excepcion;

public class ExcepcionRestriccionPlaca extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionRestriccionPlaca(String mensaje) {
        super(mensaje);
    }
}
