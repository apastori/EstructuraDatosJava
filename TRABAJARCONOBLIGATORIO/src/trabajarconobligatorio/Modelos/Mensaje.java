package trabajarconobligatorio.Modelos;

import java.util.Date;

public class Mensaje {

    private int numContactoOrigen;
    private int numContactoDestino;
    private Date fecha;
    private int identifador;
    // agregar lista de lineas

    public Mensaje(int elOrigen, int elDestino, Date laFecha) {
        this.setNumContactoOrigen(elOrigen);
        this.setNumContactoDestino(elDestino);
        this.setFecha(laFecha);
        identifador++;
    }

    public int getNumContactoOrigen() {
        return numContactoOrigen;
    }

    public void setNumContactoOrigen(int numero) {
        this.numContactoOrigen = numero;
    }

    public int getNumContactoDestino() {
        return numContactoDestino;
    }

    public void setNumContactoDestino(int numero) {
        this.numContactoDestino = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    // public boolean equals(Object o){
    // return this.getNombre().equalsIgnoreCase(((Contacto)o).getNombre());
    // }

    // @Override
    // public int compareTo(Contacto o) {
    // return this.getNombre().compareTo(o.getNombre());
    // }

    public String toString() {
        return "Numero Origen: " + this.getNumContactoOrigen() + " Numero Destino: " + this.getNumContactoDestino()
                + " Fecha: " + this.getFecha();
    }
}
