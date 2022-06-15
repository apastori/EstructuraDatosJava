package trabajarconobligatorio.Modelos;

import java.util.Date;
import trabajarconobligatorio.Genericos.Listas.ListaSinTope;
import trabajarconobligatorio.Genericos.Nodo;

public class Mensaje implements Comparable<Mensaje> {

    private int numContactoDestino;
    private Date fecha;
    private int id;
    public ListaSinTope<Linea> Lineas;
    private int MAX_CANT_PALABRAS_X_LINEA;

    public Mensaje(int elDestino, Date laFecha, int id, int MAX_CANT_PALABRAS_X_LINEA) {
        this.numContactoDestino = elDestino;
        this.fecha = laFecha;
        Lineas = new ListaSinTope<Linea>();
        this.id = id;
        this.MAX_CANT_PALABRAS_X_LINEA = MAX_CANT_PALABRAS_X_LINEA;
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
    
      public String getTextoMensaje() {
        String textoMensaje = "";
        if (!this.Lineas.esVacia()) {
            Nodo<Linea> lineaActual = this.Lineas.getInicio();
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
      
    public void insertarLineaFinal() {
        Linea nuevaLinea = new Linea(this.MAX_CANT_PALABRAS_X_LINEA);
        this.Lineas.insertarFinalRecursivo(this.Lineas.getInicio(), nuevaLinea);
    }
      
    @Override
    public int compareTo(Mensaje o) {
        return Integer.compare(id, o.id);
    }
    
    @Override
    public String toString() {
        return " Numero Destino: " + this.getNumContactoDestino()
                + " Fecha: " + this.getFecha();
    }

    @Override
    public boolean equals(Object o){
        if (o == this) {
            return true;
        }
 
        if (!(o instanceof Mensaje)) {
            return false;
        }
         
        Mensaje m = (Mensaje) o;
         
        return id == m.id;
    }

    public boolean insertarLineaEnPosicion(int posicionLinea) {

        Linea n = new Linea(MAX_CANT_PALABRAS_X_LINEA);
        return Lineas.agregarEnPosicion(n, posicionLinea);

    }

    public void borrarOcurrenciasPalabraEnMensaje(String palabraABorrar) {
        Nodo<Linea> actual = this.Lineas.getInicio(); 
        while (actual.getSiguiente() != null) {
            actual.borrarOcurrenciasPalabraEnLinea(actual);
            actual = actual.getSiguiente();
        }
    }

    void borrarOcurrenciasPalabraLinea(int posicionLinea, String palabraABorrar) {
        
    }
    
    
}
