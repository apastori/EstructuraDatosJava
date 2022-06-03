package trabajarconobligatorio.Modelos;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Genericos.Pila.PilaSinTope;

public class Contacto implements Comparable<Contacto> {
    private int numero;
    private String nombre;
    private PilaSinTope<Mensaje> Mensajes;
    private int MAX_CANT_PALABRAS_X_LINEA; 

    public Contacto(int elNumero, String elNombre, int MAX_CANT_PALABRAS_X_LINEA) {
        this.setNumero(elNumero);
        this.setNombre(elNombre);
        this.MAX_CANT_PALABRAS_X_LINEA = MAX_CANT_PALABRAS_X_LINEA;
        Mensajes = new PilaSinTope<Mensaje>();
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

    public PilaSinTope<Mensaje> getMensajesPorDestinatario(int numero){
        PilaSinTope<Mensaje> ret = new PilaSinTope<Mensaje>();

        Nodo<Mensaje> aux = Mensajes.getInicio();
        while( aux != null) {
            var mensaje = aux.getDato(); 
            if(mensaje.getNumContactoDestino() == numero){
                ret.apilar(mensaje);
            }
            aux = aux.getSiguiente();
        }
        return ret;
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
}
