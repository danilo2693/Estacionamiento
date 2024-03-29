package co.com.ceiba.dominio.modelo.entidad;

import co.com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import co.com.ceiba.dominio.excepcion.ExcepcionTipoVehiculo;
import co.com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

final class ValidarArgumento {

	private ValidarArgumento() {}

    public static void validarObligatorio(Object valor, String mensaje) {
        if (valor == null) {
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }
    
    public static void validarLongitud(String valor,int longitud,String mensaje){
        if(valor.length() < longitud){
            throw new ExcepcionLongitudValor(mensaje);
        }
    }
    
    public static void validarTipoObligatorio(int tipoId, String mensaje) {
        if ((tipoId < 0) || (tipoId > 1)) {
            throw new ExcepcionTipoVehiculo(mensaje);
        }
    }
}
