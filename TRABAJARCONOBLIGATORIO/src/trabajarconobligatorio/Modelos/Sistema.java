package trabajarconobligatorio.Modelos;

import java.util.Date;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Genericos.Listas.ListaSinTope;

public class Sistema {
    private ListaSinTope<Contacto> listaContactos;
    private Integer MAX_CANT_PALABRAS_X_LINEA;

    public Sistema(int MAX_CANT_PALABRAS_X_LINEA) {
        listaContactos = new ListaSinTope<Contacto>();
        this.MAX_CANT_PALABRAS_X_LINEA = Integer.MAX_VALUE;
    }

    public void destruir() {
        MAX_CANT_PALABRAS_X_LINEA = null;
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

    public boolean insertarLineaEnPosicion(int numContactoOrigen, int numMensaje, int posicionLinea) {
        Contacto contactoOrigen = getContactoPorNumero(numContactoOrigen);
        if(contactoOrigen != null ){
            return contactoOrigen.insertarLineaEnPosicion(numMensaje, posicionLinea);
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
    
}
