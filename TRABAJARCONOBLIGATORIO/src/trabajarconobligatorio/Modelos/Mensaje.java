package trabajarconobligatorio.Modelos;

import java.util.Date;
import trabajarconobligatorio.Genericos.Listas.ListaSinTope;

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

    public String toString() {
        return " Numero Destino: " + this.getNumContactoDestino()
                + " Fecha: " + this.getFecha();
    }
}
