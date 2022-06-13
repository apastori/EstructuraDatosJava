package trabajarconobligatorio.Modelos;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Genericos.Listas.ListaConTope;
import trabajarconobligatorio.Genericos.Pila.Pila;

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
