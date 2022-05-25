package trabajarconobligatorio.Modelos;

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

    public boolean agregarContacto(Contacto nuevoContacto) {
        if (listaContactos.obtenerElemento(nuevoContacto) == null) {
            listaContactos.agregarInicio(nuevoContacto);
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

    public boolean agregarMensaje(Contacto contactoOrigen, Contacto contactoDestino, Mensaje nuevoMensaje) {
        if (listaContactos.obtenerElemento(contactoOrigen) != null
                && listaContactos.obtenerElemento(contactoDestino) != null) {
            pilaMensajes.apilar(nuevoMensaje);
            return true;
        } else {
            return false;
        }
    }
}
