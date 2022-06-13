package trabajarconobligatorio.Modelos;

import java.util.Date;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Genericos.Listas.ListaSinTope;

public class Contacto implements Comparable<Contacto> {
    private int numero;
    private String nombre;
    private ListaSinTope<Mensaje> Mensajes;
    private int MAX_CANT_PALABRAS_X_LINEA;

    public Contacto(int elNumero, String elNombre, int MAX_CANT_PALABRAS_X_LINEA) {
        this.setNumero(elNumero);
        this.setNombre(elNombre);
        this.MAX_CANT_PALABRAS_X_LINEA = MAX_CANT_PALABRAS_X_LINEA;
        Mensajes = new ListaSinTope<Mensaje>();
    }

    public Contacto(int elNumero) {
        this.setNumero(elNumero);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // TODO: Revisar si se usa al final
    public ListaSinTope<Mensaje> getMensajesPorDestinatario(int numero){
        ListaSinTope<Mensaje> ret = new ListaSinTope<Mensaje>();

        Nodo<Mensaje> aux = Mensajes.getInicio();
        while( aux != null) {
            var mensaje = aux.getDato(); 
            if(mensaje.getNumContactoDestino() == numero){
                ret.agregarFinal(mensaje);
            }
            aux = aux.getSiguiente();
        }
        return ret;
    }

    public void agregarMensaje(int numContactoDestino, Date fecha){
        int nuevoId = Mensajes.getCantidadElementos() + 1;
        Mensaje nuevoMensaje = new Mensaje(numContactoDestino, fecha, nuevoId, MAX_CANT_PALABRAS_X_LINEA);
        Mensajes.agregarFinal(nuevoMensaje);
    }

    
    public boolean eliminarMensaje(int numMensaje) {
        Nodo<Mensaje> mensajeAEliminar = Mensajes.busquedaBinaria(Mensajes.getInicio(), new Mensaje(numMensaje));

        if(mensajeAEliminar == null){
            return false;
        }

        Nodo<Mensaje> anterior = mensajeAEliminar.getAnterior();
        Nodo<Mensaje> siguiente = mensajeAEliminar.getSiguiente();
        
        anterior.setSiguiente(siguiente);
        siguiente.setAnterior(anterior);

        mensajeAEliminar.setAnterior(null);
        mensajeAEliminar.setSiguiente(null);
        return true;
    }
    
    public Mensaje getMensajePorId(int numMensaje) {
        Mensaje mensaje = null;
        Nodo<Mensaje> nodoMensaje = Mensajes.busquedaBinaria(Mensajes.getInicio(), new Mensaje(numMensaje));
        if (nodoMensaje != null) {
            mensaje = nodoMensaje.getDato();
        }
        return mensaje;
    }

    public Mensaje getMensajePorNumero(int numMensaje) {
        Nodo<Mensaje> mensaje = Mensajes.busquedaBinaria(Mensajes.getInicio(), new Mensaje(numMensaje));
        if(mensaje != null){
            return mensaje.getDato();
        }
        return null;
    }
    

    public boolean insertarLineaEnPosicion(int numMensaje, int posicionLinea) {
        Mensaje mensaje = getMensajePorNumero(numMensaje);

        if(mensaje != null){
            return mensaje.insertarLineaEnPosicion(posicionLinea);
        }
        return false;
    }

    public boolean encontrarMensaje(int numMensaje) {
        Nodo<Mensaje> mensajeBuscado = Mensajes.busquedaBinaria(Mensajes.getInicio(), new Mensaje(numMensaje));
        if (mensajeBuscado == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean borrarTodo(int numMensaje) {
        Mensaje mensaje = getMensajePorNumero(numMensaje);

        if(mensaje != null){
            mensaje.Lineas.vaciarRecursivo(mensaje.Lineas.getFin());
            return true;
        }
        return false;    
    }
    
    public boolean borrarLineaEnPosicion(int numMensaje, int posicionLinea){
        Mensaje mensaje = getMensajePorNumero(numMensaje);
        if(mensaje != null){
            return mensaje.borrarLineaEnPosicion(posicionLinea);
        }else{
            return false;
        }
    }


    // public boolean equals(Object o) {
    // return this.getNombre().equalsIgnoreCase(((Contacto) o).getNombre());
    // }
    public boolean equals(Object o) {
        if (this.getNumero() == ((Contacto) o).getNumero()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    // public int compareTo(Contacto o) {
    // return this.getNombre().compareTo(o.getNombre());
    // }
    public int compareTo(Contacto o) {
        if (this.numero == o.numero) {
            return 0;
        } else if (this.numero > o.numero){
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return "Numero: " + this.getNumero() + " Nombre: " + this.getNombre();
    }

    public boolean insertarPalabraYDesplazar(int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Mensaje mensaje = getMensajePorNumero(numMensaje);

        if(mensaje != null){
            return mensaje.insertarPalabraYDesplazar(posicionLinea, posicionPalabra, palabraAIngresar);
        }
        return false; 
    }

    public boolean insertarPalabraEnLinea(int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Mensaje mensaje = getMensajePorNumero(numMensaje);

        if(mensaje != null){
            return mensaje.insertarPalabraEnLinea(posicionLinea, posicionPalabra, palabraAIngresar);
        }
        return false; 
    }

}
