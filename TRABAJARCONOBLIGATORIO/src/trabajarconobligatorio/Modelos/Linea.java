package trabajarconobligatorio.Modelos;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Genericos.Pila.Pila;

public class Linea implements Comparable<Linea> {
    private Pila<String> Palabras;


    public Linea(int cantidadMaxima) {
        Palabras = new Pila<String>(cantidadMaxima);

    }

    public String imprimirLinea() {
        String textoLinea = "";
        if (!this.Palabras.esVacia()) {
            int contador = 1;
            Nodo<String> actual = Palabras.getInicio();
            while (actual.getSiguiente() != null) {
                textoLinea += actual.getDato() + (contador + "  ");
                actual = actual.getSiguiente();
                contador++;
            }
        } else {
            textoLinea += "Linea Vacia";
        }
        return textoLinea;
    }
    
    
    @Override
    public int compareTo(Linea o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
