package trabajarconobligatorio.Genericos.Listas;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Interfaces.Listas.ILista;

public class ListaConTope<T extends Comparable<T>> extends ListaSinTope<T> implements ILista<T> {
    private int tope;

    // Constructor
    public ListaConTope(int topeMax) {
        inicio = null;
        fin = null;
        cantidad = 0;
        tope = topeMax;
    }

    public boolean esLlena() {
        return cantidad == tope;
    }

    @Override
    public void agregarInicio(T n) {
        if (!esLlena()) {
            super.agregarInicio(n);
        }else {
            System.out.println("Esta Llena");
        }
    }

    @Override
    public void agregarFinal(T n) {
        if (!esLlena()) {
            super.agregarFinal(n);
        }else {
            System.out.println("Esta Llena");
        } 
    }

    @Override
    public void agregarOrd(T n) {
        if (!esLlena()) {
            super.agregarOrd(n);
        }else {
            System.out.println("Esta Llena");
        } 
    }

    public void insertarYDesplazar(int posicionPalabra, T palabraAIngresar) {
        if(esLlena()){
         super.borrarFin();   
        }
        super.agregarEnPosicion(palabraAIngresar, posicionPalabra);
    }
}
