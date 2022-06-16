
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
    
    //pre: numContactoOrigen debe existir en el sistema.
    //pre: numMensaje debe existir dentro de los mensajes del Contacto indicado.
    //pos: Agrega una linea vacia al final del mensaje del contacto dado.  
    Retorno insertarLinea(int numContactoOrigen, int numMensaje);

    //pre: numContactoOrigen debe existir en el sistema.
    //pre: numMensaje debe existir dentro de los mensajes del Contacto indicado.
    //pre: posicionLinea debe ser un entero mayor a 0
    //pos: Agrega una linea vacia en una posicion especificada y modifica el orden de las lineas
    Retorno insertarLineaEnPosicion(int numContactoOrigen, int numMensaje, int posicionLinea);

    //pre: numContactoOrigen debe existir en el sistema.
    //pre: numMensaje debe existir dentro de los mensajes del Contacto indicado.
    //pre: posicionLinea debe ser un entero mayor a 0 y debe existir en las lineas
    //pos: Borra linea indicada por posicion
    Retorno borrarLinea(int numContactoOrigen, int numMensaje, int posicionLinea);

    //pre: numContactoOrigen debe existir en el sistema.
    //pre: numMensaje debe existir dentro de los mensajes del Contacto indicado.
    //pos: Elimina todas las lineas del mensaje correspondiente.
    Retorno borrarTodo(int numContactoOrigen, int numMensaje);

    //pre: numContactoOrigen debe existir en el sistema.
    //pre: numMensaje debe existir dentro de los mensajes del Contacto indicado.    
    //pos: Borra a todas las ocurrencias de la palabra indicada en el mensaje y modifica las posiciones en las lineas correspondientes.
    Retorno borrarOcurrenciasPalabraEnTexto(int numContactoOrigen, int numMensaje, String palabraABorrar);

    //pre: numContactoOrigen debe existir en el sistema.
    //pre: numMensaje debe existir dentro de los mensajes del Contacto indicado.    
    //pre: posicionLinea y posicionPalabra son enteros mayores 0.
    //pos: agrega una palabra a la linea con pocision indicada, modifica las posiciones de las palabras si es necesario.
    Retorno insertarPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar);

    //pre: numContactoOrigen debe existir en el sistema.
    //pre: numMensaje debe existir dentro de los mensajes del Contacto indicado.
    //pre: posicionLinea y posicionPalabra son enteros mayores 0.
    //pos: agrega una palabra a la linea con pocision indicada, modifica las posiciones de las palabras y lineas si es necesario.
    Retorno insertarPalabraYDesplazar(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar);

    //pre: numContactoOrigen debe existir en el sistema.
    //pre: numMensaje debe existir dentro de los mensajes del Contacto indicado.
    //pre: posicionLinea y posicionPalabra son enteros mayores 0.
    //pos: borra la palabra con la posicion indicada.
    Retorno borrarPalabra(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra);

    //pre: numContactoOrigen debe existir en el sistema.
    //pre: numMensaje debe existir dentro de los mensajes del Contacto indicado.
    //pre: posicionLinea es un entero mayores 0.
    //pos: borra todas las ocurrencias de la palabra en la linea con posicion indicada.
    Retorno borrarOcurrenciasPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea , String palabraABorrar);

    //pre: numContactoOrigen debe existir en el sistema.
    //pre: numMensaje debe existir dentro de los mensajes del Contacto indicado.
    //pre: posicionLinea es un entero mayores 0.
    //pos: Imprime la linea indicada con todas sus palabras.
    Retorno imprimirLinea(int numContactoOrigen, int numMensaje, int posicionLinea);

    //pre: NA
    //pos: Agrega una palabra al diccionario, si esta repetida no se agrega al mismo.
    Retorno ingresarPalabraDiccionario(String palabraAIngresar);

    //pre: NA
    //pos: Borra la palabra dada si existe dentro del diccionario.
    Retorno borrarPalabraDiccionario(String palabraABorrar);

    //pre: debe existir un diccionario creado en sistema.
    //pos: Imprime todas las palabras del diccionario ordenadas alfabéticamente
    //pos: Si diccionario esta vacio se muestra en pantalla
    Retorno imprimirDiccionario();

    //pre: Debe existir un diccionario y mensajes creados en el sistema.
    //pos: Muestra todas las palabras de los mensajes que no se encuentre incluidas dentro  
    Retorno ImprimirTextoIncorrecto();

    //pre: numContactoOrigen debe existir en el sistema.
    //pre: deben existir mensajes vinculados al contacto
    //pos: Muestra una matriz con la cantidad de mensajes que fueron enviados por fecha de un contacto
    //pos: si el contacto fue eliminado se mostrara como contacto eliminado
    Retorno cantidadDeMensajes(int numContactoOrigen);
}
