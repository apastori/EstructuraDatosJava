package trabajarconobligatorio.Modelos;

import java.util.Date;

import trabajarconobligatorio.Genericos.Listas.ListaConTope;
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
                textoMensaje += (contador + ": ") + lineaActual.getDato().imprimirLinea() + "\n";
                lineaActual = lineaActual.getSiguiente();
                contador++;
            }            
        } else {
            textoMensaje = "Mensaje Vacio";
        }
        return textoMensaje;
    }

    public String getTextoLinea(int posicionLinea){
        String textoLinea = null;
        if (!this.Lineas.esVacia()){
            Nodo<Linea> nLineaActual = Lineas.getNodoPorPos(posicionLinea);
            if(nLineaActual!=null){
                textoLinea = posicionLinea+": "+nLineaActual.getDato().imprimirLinea() + "\n";
            }
        }
        else {
            textoLinea = "Linea Vacia";
        }
        return textoLinea;
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
        this.borrarOcurrenciaPalabraMensajeRecursivo(actual, palabraABorrar);
    }
    
    public void borrarOcurrenciaPalabraMensajeRecursivo(Nodo<Linea> inicio, String palabraABorrar) {
        if (inicio == null) {
            return;
        }
        inicio.getDato().borrarOcurrenciaPalabra(palabraABorrar);
        borrarOcurrenciaPalabraMensajeRecursivo(inicio.getSiguiente(), palabraABorrar);
    }

    public void borrarOcurrenciasPalabraLinea(int posicionLinea, String palabraABorrar) {
        Nodo<Linea> lineaPos = this.Lineas.getNodoPorPos(posicionLinea);
        if (lineaPos != null) {
            lineaPos.getDato().borrarOcurrenciaPalabra(palabraABorrar);
        }
    }
    
    public boolean borrarLineaEnPosicion(int posicionLinea) {       
        return Lineas.borrarEnPosicion(posicionLinea);
    }

    public boolean insertarPalabraEnLinea(int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Nodo<Linea> nLineaActual = Lineas.getNodoPorPos(posicionLinea);
        
        if(nLineaActual != null ) {
            return nLineaActual.getDato().insertarPalabra(posicionPalabra, palabraAIngresar);
        }
        return false;

    }

    public boolean insertarPalabraYDesplazar(int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Nodo<Linea> nLineaActual = Lineas.getNodoPorPos(posicionLinea);
        
        if(nLineaActual == null ) {
            return false;
        }
        return insertarPalabraYDesplazarRecursivo(nLineaActual, posicionPalabra, palabraAIngresar);
    }

    public boolean insertarPalabraYDesplazarRecursivo(Nodo<Linea> nLinea, int posicionPalabra, String palabraAIngresar) {
        ListaConTope<String> Palabras = nLinea.getDato().Palabras();
        Nodo<Linea> nLineaSiguiente = nLinea.getSiguiente();

        String aux = null;
        if(Palabras.esLlena()){
            aux = Palabras.getFin().getDato();
        }
        Palabras.insertarYDesplazar(posicionPalabra, palabraAIngresar);
        if( nLineaSiguiente == null){
            insertarLineaFinal();
        }

        if(aux != null) {
            return insertarPalabraYDesplazarRecursivo(nLineaSiguiente, 1, aux);
        }
        return true;
    }

    public boolean borrarPalabraEnPosicion(int posicionLinea, int posicionPalabra) {  
        Nodo<Linea> nLineaActual = Lineas.getNodoPorPos(posicionLinea);
        if(nLineaActual!=null){
            ListaConTope<String> Palabras = nLineaActual.getDato().Palabras();           
            return Palabras.borrarEnPosicion(posicionPalabra);
        }
        return false;
    }
}
