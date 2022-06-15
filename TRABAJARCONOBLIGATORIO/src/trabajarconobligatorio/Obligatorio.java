package trabajarconobligatorio;

import java.util.Date;

import trabajarconobligatorio.Genericos.Retorno;
import trabajarconobligatorio.Interfaces.IObligatorio;
import trabajarconobligatorio.Modelos.Sistema;

/**
 *
 * @author Rafael
 */
public class Obligatorio implements IObligatorio {

    private Sistema Sistema;
    // lista diccionario

    public Obligatorio() {
        Sistema = new Sistema(Integer.MAX_VALUE);
    }

    @Override
    public Retorno crearSistemaMensajes(int MAX_CANT_PALABRAS_X_LINEA) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Sistema = new Sistema(MAX_CANT_PALABRAS_X_LINEA);
        return ret;
    }

    @Override
    public Retorno destruirSistemaMensajes() {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        Sistema.destruir();
        Sistema = null;
        return ret;
    }

    @Override
    public Retorno agregarContacto(int numContacto, String nomContacto) {
        Retorno ret = new Retorno(Retorno.Resultado.OK);
        if (Sistema.agregarContacto(numContacto, nomContacto)) {
            ret.resultado = Retorno.Resultado.OK;
        } else {
            ret.resultado = Retorno.Resultado.ERROR;
        }
        return ret;
    }

    @Override
    public Retorno eliminarContacto(int numContacto) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);    

        if (Sistema.eliminarContacto(numContacto)) {            
            ret.resultado = Retorno.Resultado.OK;
        } 

        return ret;
    }

    @Override
    public Retorno agregarMensaje(int numContactoOrigen, int numContactoDestino, Date fecha) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        
        if(Sistema.agregarMensaje(numContactoOrigen, numContactoDestino, fecha)){
            ret.resultado = Retorno.Resultado.OK;
        }

        return ret;
    }

    @Override
    public Retorno eliminarMensaje(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        if(Sistema.eliminarMensaje(numContactoOrigen, numMensaje)){
            ret.resultado = Retorno.Resultado.OK;
        }
        return ret;
    }

    @Override
    public Retorno imprimirTexto(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);

        if(Sistema.imprimirTexto(numContactoOrigen, numMensaje)){
            ret.resultado = Retorno.Resultado.OK;
        }
        return ret;
    }

    @Override
    public Retorno insertarLinea(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        if(Sistema.insertarLinea(numContactoOrigen, numMensaje)){
            ret.resultado = Retorno.Resultado.OK;
        }
        return ret;
    }

    @Override
    public Retorno insertarLineaEnPosicion(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        
        if(Sistema.insertarLineaEnPosicion(numContactoOrigen, numMensaje, posicionLinea)){
            ret.resultado = Retorno.Resultado.OK;
        }

        return ret;
    }

    @Override
    public Retorno borrarLinea(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        if (Sistema.borrarLinea(numContactoOrigen, numMensaje, posicionLinea)) {
            ret.resultado = Retorno.Resultado.OK;
        }
        return ret;
    }

    @Override
    public Retorno borrarTodo(int numContactoOrigen, int numMensaje) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        
        if(Sistema.borrarTodo(numContactoOrigen, numMensaje)){
            ret.resultado = Retorno.Resultado.OK;
        }

        return ret;
    }

    @Override
    public Retorno borrarOcurrenciasPalabraEnTexto(int numContactoOrigen, int numMensaje, String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno insertarPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra,
            String palabraAIngresar) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        if(Sistema.insertarPalabraEnLinea(numContactoOrigen, numMensaje, posicionLinea, posicionPalabra, palabraAIngresar)){
            ret.resultado = Retorno.Resultado.OK;
        }
        return ret;
    }

    @Override
    public Retorno insertarPalabraYDesplazar(int numContactoOrigen, int numMensaje, int posicionLinea,
            int posicionPalabra, String palabraAIngresar) {
            
            Retorno ret = new Retorno(Retorno.Resultado.ERROR);

            if(Sistema.insertarPalabraYDesplazar(numContactoOrigen, numMensaje, posicionLinea, posicionPalabra, palabraAIngresar)){
                ret.resultado = Retorno.Resultado.OK;
            }

            return ret;
    }

    @Override
    public Retorno borrarPalabra(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra) {        
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        if (Sistema.borrarPalabra(numContactoOrigen, numMensaje, posicionLinea, posicionPalabra)) {
            ret.resultado = Retorno.Resultado.OK;
        }
        return ret;        
    }

    @Override
    public Retorno borrarOcurrenciasPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea,
            String palabraABorrar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno imprimirLinea(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Retorno ret = new Retorno(Retorno.Resultado.ERROR);
        if(Sistema.imprimirLinea(numContactoOrigen, numMensaje,posicionLinea)){
            ret.resultado = Retorno.Resultado.OK;
        }
        return ret;
    }

    @Override
    public Retorno ingresarPalabraDiccionario(String palabraAIngresar) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno imprimirDiccionario() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno ImprimirTextoIncorrecto() {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

    @Override
    public Retorno cantidadDeMensajes(int numContactoOrigen) {
        Retorno ret = new Retorno(Retorno.Resultado.NO_IMPLEMENTADA);
        return ret;
    }

}
