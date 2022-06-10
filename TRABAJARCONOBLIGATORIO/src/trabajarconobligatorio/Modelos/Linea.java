package trabajarconobligatorio.Modelos;

import trabajarconobligatorio.Genericos.Pila.Pila;

public class Linea implements Comparable<Linea> {
    private Pila<String> Palabras;

    public Linea(int MAX_CANT_PALABRAS_X_LINEA){
        Palabras = new Pila<String>(MAX_CANT_PALABRAS_X_LINEA);
    }

    @Override
    public int compareTo(Linea o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
