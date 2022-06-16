
package trabajarconobligatorio.Interfaces;
import java.util.Date;

import trabajarconobligatorio.Genericos.Retorno;
/**
 *
 * @author Rafael
 */
public interface IObligatorio {
    
    //pre: MAX_CANT_PALABRAS_X_LINEA > 0
    //pos: Crea una nueva instancia de Sistema dentro de la instancia de Obligatorio con el valor del parámetro.
    Retorno crearSistemaMensajes(int MAX_CANT_PALABRAS_X_LINEA);
    
    //pre: NA
    //pos: Se destruye la estructura del sistema de mensajes y se libera la memoria utilizada.      
    Retorno destruirSistemaMensajes();
    
    //pre: El número de contacto no debe haber sido agregado anteriormente.
    //pos: Agrega el contacto a la lista de contactos del Sistema.
    Retorno agregarContacto(int numContacto, String nomContacto);
    
    //pre: El número de contacto debe existir en el sistema.
    //pos: Elimina el contacto del sistema y libera la memoria de su estructura.
    Retorno eliminarContacto(int numContacto);
    
    //pre: numContactoOrigen y numContactoDestino deben existir en el sistema.
    //pos: El mensaje se agrega a los mensajes del contacto origen con la referencia al contacto destino.
    //pos: El mensaje recibe un id en base 
    Retorno agregarMensaje(int numContactoOrigen, int numContactoDestino, Date fecha);
    
    //pre: numContactoOrigen debe existir en el sistema.
    //pre: numMensaje debe existir dentro de los mensajes del Contacto indicado.
    //pos: Elimina el mensaje vinculado y libera la memoria.
    Retorno eliminarMensaje(int numContactoOrigen, int numMensaje);
    
    //pre: numContactoOrigen debe existir en el sistema.
    //pre: numMensaje debe existir dentro de los mensajes del Contacto indicado.    
    //pos: Muestra todas las lineas del mensaje numeradas, con sus respectivas palabras.
    //pos: Si el mensaje no tiene líneas muestra "Texto vacío".
    Retorno imprimirTexto(int numContactoOrigen, int numMensaje);
    
    //pre:
    //pos:
    Retorno insertarLinea(int numContactoOrigen, int numMensaje);
    //pre:
    //pos:
    Retorno insertarLineaEnPosicion(int numContactoOrigen, int numMensaje, int posicionLinea);
    //pre:
    //pos:
    Retorno borrarLinea(int numContactoOrigen, int numMensaje, int posicionLinea);
    //pre:
    //pos:
    Retorno borrarTodo(int numContactoOrigen, int numMensaje);
    //pre:
    //pos:
    Retorno borrarOcurrenciasPalabraEnTexto(int numContactoOrigen, int numMensaje, String palabraABorrar);
    //pre:
    //pos:
    Retorno insertarPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar);
    //pre:
    //pos:
    Retorno insertarPalabraYDesplazar(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar);
    //pre:
    //pos:
    Retorno borrarPalabra(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra);
    //pre:
    //pos:
    Retorno borrarOcurrenciasPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea , String palabraABorrar);
    //pre:
    //pos:
    Retorno imprimirLinea(int numContactoOrigen, int numMensaje, int posicionLinea);
    //pre:
    //pos:
    Retorno ingresarPalabraDiccionario(String palabraAIngresar);
    //pre:
    //pos:
    Retorno borrarPalabraDiccionario(String palabraABorrar);
    //pre:
    //pos:
    Retorno imprimirDiccionario();
    //pre:
    //pos:
    Retorno ImprimirTextoIncorrecto();
    //pre:
    //pos:
    Retorno cantidadDeMensajes(int numContactoOrigen);
}
