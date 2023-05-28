package trabajarconobligatorio.Modelos;

import java.util.Date;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Genericos.Listas.ListaSinTope;

public class Sistema {
    private ListaSinTope<Contacto> listaContactos;
    private Integer MAX_CANT_PALABRAS_X_LINEA;
    private Diccionario diccionario;

    public Sistema(int MAX_CANT_PALABRAS_X_LINEA) {
        listaContactos = new ListaSinTope<Contacto>();
        this.MAX_CANT_PALABRAS_X_LINEA = MAX_CANT_PALABRAS_X_LINEA;
        diccionario = new Diccionario();
    }

    public void destruir() {
        MAX_CANT_PALABRAS_X_LINEA = null;
        Nodo<Contacto> contactoActual = listaContactos.getInicio();
        while(contactoActual != null){
            contactoActual.getDato().destruir();
            contactoActual = contactoActual.getSiguiente();
        }
        listaContactos.vaciar();
    }

    public boolean agregarContacto(int numContacto, String nomContacto) {
        Contacto nuevoContacto = new Contacto(numContacto, nomContacto, this.MAX_CANT_PALABRAS_X_LINEA);
        if (listaContactos.obtenerElemento(nuevoContacto) == null) {
            listaContactos.agregarOrd(nuevoContacto);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarContacto(int numContacto) {
        Contacto contactoBuscado = new Contacto(numContacto);  
        if (listaContactos.busquedaBinaria(listaContactos.getInicio(), contactoBuscado) != null) {
            listaContactos.borrarElemento(contactoBuscado);
            contactoBuscado.destruir();
            return true;
        } else {
            return false;
        }
    }

    public boolean agregarMensaje(int numContactoOrigen, int numContactoDestino, Date fecha) {
        Contacto contactoOrigen = getContactoPorNumero(numContactoOrigen);
        Contacto contactoDestino = getContactoPorNumero(numContactoDestino);

        if(contactoOrigen == null || contactoDestino == null){
            return false;
        }

        contactoOrigen.agregarMensaje(numContactoDestino, fecha);
        return true;
    }

    public boolean eliminarMensaje(int numContactoOrigen, int numMensaje) {
        Contacto contactoOrigen = getContactoPorNumero(numContactoOrigen);
        if(contactoOrigen != null){
            return contactoOrigen.eliminarMensaje(numMensaje);
        }
        return false;
    }

    
    public boolean imprimirTexto(int numContactoOrigen, int numMensaje) {
        Contacto contactoOrigen = getContactoPorNumero(numContactoOrigen);

        if(contactoOrigen != null ){
            Mensaje mensaje =contactoOrigen.getMensajePorNumero(numMensaje);

            if(mensaje != null ){
                System.out.println(mensaje.getTextoMensaje());
                return true;
            }
        }
        return false;
    }

    public Contacto getContactoPorNumero( int numero ){
        Nodo<Contacto> contacto = listaContactos.busquedaBinaria(listaContactos.getInicio(), new Contacto(numero));
        if(contacto != null){
            return contacto.getDato();
        }
        return null;
    }

    public boolean insertarLinea(int numContactoOrigen, int numMensaje) {
        boolean lineaInsertada = false;
        Contacto contacto = getContactoPorNumero(numContactoOrigen);
        if (contacto != null) {
            Mensaje mensaje = contacto.getMensajePorId(numMensaje);
            if (mensaje != null) {
                mensaje.insertarLineaFinal();
                lineaInsertada = true;
            }
        }
        return lineaInsertada;
    }

    public boolean insertarLineaEnPosicion(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Contacto contactoOrigen = getContactoPorNumero(numContactoOrigen);
        if(contactoOrigen != null ){
            return contactoOrigen.insertarLineaEnPosicion(numMensaje, posicionLinea);
        }

        return false;
    }

    public boolean borrarOcurrenciasPalabraEnTexto(int numContactoOrigen, int numMensaje, String palabraABorrar) {
        boolean borrarOcurrenciasPalabraTexto = false;
        Contacto contacto = getContactoPorNumero(numContactoOrigen);
        if (contacto != null) {
            Mensaje mensaje = contacto.getMensajePorId(numMensaje);
            if (mensaje != null) {
                mensaje.borrarOcurrenciasPalabraEnMensaje(palabraABorrar);
                borrarOcurrenciasPalabraTexto = true;
            }
        }
        return borrarOcurrenciasPalabraTexto;
    }

    public boolean borrarOcurrenciasPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, String palabraABorrar) {
        boolean borrarOcurrenciasPalabraLinea = false;
        Contacto contacto = getContactoPorNumero(numContactoOrigen);
        if (contacto != null) {
            Mensaje mensaje = contacto.getMensajePorId(numMensaje);
            if (mensaje != null) {
                mensaje.borrarOcurrenciasPalabraLinea(posicionLinea, palabraABorrar);
                borrarOcurrenciasPalabraLinea = true;
            }
        }
        return borrarOcurrenciasPalabraLinea;
    }

    public boolean borrarTodo(int numContactoOrigen, int numMensaje) {
        Contacto contactoOrigen = getContactoPorNumero(numContactoOrigen);
        if(contactoOrigen != null ){
            return contactoOrigen.borrarTodo(numMensaje);
        }
        return false;
    }

    public boolean borrarLinea(int numContactoOrigen, int numMensaje, int posicionLinea){
        Contacto contactoOrigen = getContactoPorNumero(numContactoOrigen);
        if(contactoOrigen != null ){
            if(contactoOrigen.encontrarMensaje(numMensaje)){
                return contactoOrigen.borrarLineaEnPosicion(numMensaje,posicionLinea);
            }else{
                //mensaje no existe
                return false;
            }
        }
        //contacto no existe
        return false;
    }

    public boolean insertarPalabraYDesplazar(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        
        Contacto contactoOrigen = getContactoPorNumero(numContactoOrigen);
        if(contactoOrigen != null ){
            return contactoOrigen.insertarPalabraYDesplazar(numMensaje, posicionLinea, posicionPalabra, palabraAIngresar);
        }
        return false;
    }

    public boolean insertarPalabraEnLinea(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Contacto contactoOrigen = getContactoPorNumero(numContactoOrigen);
        if(contactoOrigen != null ){
            return contactoOrigen.insertarPalabraEnLinea(numMensaje, posicionLinea, posicionPalabra, palabraAIngresar);
        }
        return false;
    }

    public boolean borrarPalabra(int numContactoOrigen, int numMensaje, int posicionLinea, int posicionPalabra){
        Contacto contactoOrigen = getContactoPorNumero(numContactoOrigen);
        if(contactoOrigen != null ){
            if(contactoOrigen.encontrarMensaje(numMensaje)){
                return contactoOrigen.borrarPalabraEnPosicion(numMensaje,posicionLinea,posicionPalabra);
            }else{
                //mensaje no existe
                return false;
            }
        }
        //contacto no existe
        return false;
    }
    
    public boolean imprimirLinea(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Contacto contactoOrigen = getContactoPorNumero(numContactoOrigen);
        if(contactoOrigen != null ){
            Mensaje mensaje =contactoOrigen.getMensajePorNumero(numMensaje);
            if(mensaje != null ){
                String texto =mensaje.getTextoLinea(posicionLinea);
                if(texto != null) { // Si el texto es Null, la línea no existe.
                    System.out.println(texto);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean ingresarPalabraDiccionario(String palabraAIngresar) {
        return diccionario.ingresarPalabra(palabraAIngresar);
    }

    public boolean borrarPalabraDiccionario(String palabraABorrar) {
        return diccionario.borrarPalabra(palabraABorrar);
    }

    public void imprimirDiccionario() {
        diccionario.imprimirDiccionario();
    }

    public void ImprimirTextoIncorrecto() {
        Nodo<Contacto> nContacto = listaContactos.getInicio();

        while(nContacto != null){
            System.out.println("--- Mensajes de: " + nContacto.getDato().getNombre() + " nº: " + nContacto.getDato().getNumero() + " ---");
            nContacto.getDato().ImprimirTextoIncorrecto(diccionario.getPalabras());

            nContacto = nContacto.getSiguiente();
        }
    }

    public boolean cantidadDeMensajes(int numContactoOrigen) {
        Contacto contactoOrigen = getContactoPorNumero(numContactoOrigen);
        if(contactoOrigen != null){
            contactoOrigen.cantidadDeMensajes(listaContactos);
            return true;
        }
        return false;
    }
}
