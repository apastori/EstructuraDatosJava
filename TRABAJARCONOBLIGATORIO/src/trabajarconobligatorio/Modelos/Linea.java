package trabajarconobligatorio.Modelos;

import trabajarconobligatorio.Genericos.Listas.ListaCompleta;
import trabajarconobligatorio.Genericos.Pila.Pila;

public class Linea implements Comparable<Linea> {
    private Pila<String> Palabras;

    public Linea(){
        Palabras = new Pila<String>();
    }

    @Override
    public int compareTo(Linea o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
