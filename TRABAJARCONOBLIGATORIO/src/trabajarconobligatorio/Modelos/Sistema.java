package trabajarconobligatorio.Modelos;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Genericos.Listas.ListaSinTope;
import trabajarconobligatorio.Genericos.Pila.PilaSinTope;

public class Sistema {
    private ListaSinTope<Contacto> listaContactos;
    private PilaSinTope<Mensaje> pilaMensajes;
    private Integer MAX_CANT_PALABRAS_X_LINEA;

    public Sistema(int MAX_CANT_PALABRAS_X_LINEA) {
        listaContactos = new ListaSinTope();
        pilaMensajes = new PilaSinTope();
        this.MAX_CANT_PALABRAS_X_LINEA = Integer.MAX_VALUE;
    }

    public void destruir() {
        MAX_CANT_PALABRAS_X_LINEA = null;
        listaContactos.vaciar();
        pilaMensajes = null;
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

    public boolean eliminarContacto(Contacto contactoBuscado) {
        if (listaContactos.obtenerElemento(contactoBuscado) != null) {
            listaContactos.borrarElemento(contactoBuscado);
            return true;
        } else {
            return false;
        }
    }

    public boolean agregarMensaje(int numContactoOrigen, int numContactoDestino, java.util.Date fecha) {
        Contacto contactoOrigen = getContactoPorNumero(numContactoOrigen);
        Contacto contactoDestino = getContactoPorNumero(numContactoDestino);

        if(contactoOrigen == null || contactoDestino == null){
            return false;
        }

        var nuevoId = contactoOrigen.getMensajesPorDestinatario(numContactoDestino).elementos() + 1;

        Mensaje nuevoMensaje = new Mensaje(numContactoDestino, fecha, nuevoId,MAX_CANT_PALABRAS_X_LINEA);

        pilaMensajes.apilar(nuevoMensaje);
        return true;
    }

    public Contacto getContactoPorNumero( int numero ){
        Nodo<Contacto> contacto = listaContactos.busquedaBinaria(listaContactos.getInicio(), new Contacto(numero));
        if(contacto != null){
            return contacto.getDato();
        }
        return null;
    }

    
}
