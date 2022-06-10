package trabajarconobligatorio.Modelos;

import java.util.Date;
import trabajarconobligatorio.Genericos.Listas.ListaSinTope;
import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Genericos.Pila.Pila;

public class Mensaje implements Comparable<Mensaje> {

    private int numContactoDestino;
    private Date fecha;
    private int id;
    public ListaSinTope<Linea> Lineas;

    public Mensaje(int elDestino, Date laFecha, int id, int MAX_CANT_PALABRAS_X_LINEA) {
        this.numContactoDestino = elDestino;
        this.fecha = laFecha;
        Lineas = new ListaSinTope<Linea>();
        this.id = id;
    }

    public Mensaje( int id){
        this.id = id;
    }

    public int getNumContactoDestino() {
        return numContactoDestino;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getId(){
        return id;
    }

    // public boolean equals(Object o){
    // return this.getNombre().equalsIgnoreCase(((Contacto)o).getNombre());
    // }
    
      public String imprimirMensaje() {
        String textoMensaje = "";
        if (!this.Lineas.esVacia()) {
            Nodo lineaActual = this.Lineas.getInicio();
            int contador = 1;
            while (lineaActual.getSiguiente() != null) {
                textoMensaje += (contador + ": ") + lineaActual.getDato().imprimirLinea();
                lineaActual = lineaActual.getSiguiente();
                contador++;
            }
            
        } else {
            textoMensaje = "Mensaje Vacio";
        }
        return textoMensaje;
    }
      


    @Override
    public int compareTo(Mensaje o) {
        if (this.id == o.id) {
            return 0;
        } else if (this.id > o.id) {
            return 1;
        } else {
            return -1;
        }
    }
    
    @Override
    public String toString() {
        return " Numero Destino: " + this.getNumContactoDestino()
                + " Fecha: " + this.getFecha();
    }
}
