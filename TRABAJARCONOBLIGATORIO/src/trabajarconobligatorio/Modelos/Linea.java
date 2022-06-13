package trabajarconobligatorio.Modelos;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Genericos.Listas.ListaConTope;

public class Linea implements Comparable<Linea> {
    private ListaConTope<String> Palabras;


    public Linea(int cantidadMaxima) {
        Palabras = new ListaConTope<String>(cantidadMaxima);
    }

    public ListaConTope<String> Palabras(){
        return Palabras;
    }
    public String imprimirLinea() {
        String textoLinea = "";
        if (!this.Palabras.esVacia()) {
            Nodo<String> actual = Palabras.getInicio();
            do {
                textoLinea += actual.getDato() + "  ";
                actual = actual.getSiguiente();
            }
            while (actual != null);
               
        } else {
            textoLinea += "Linea Vacia";
        }
        return textoLinea;
    }
    

    public boolean insertarPalabra(int posicionPalabra, String palabraAIngresar) {
        return Palabras.agregarEnPosicion(palabraAIngresar, posicionPalabra);
    }
    
    @Override
    public int compareTo(Linea o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
