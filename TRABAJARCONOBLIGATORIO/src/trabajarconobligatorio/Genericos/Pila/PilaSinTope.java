package trabajarconobligatorio.Genericos.Pila;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Interfaces.IPila;

public class PilaSinTope<T extends Comparable<T>> implements IPila<T> {
    private Nodo<T> inicio;
    private int cantidadElementos;

    // Constructor
    public PilaSinTope() {
        cantidadElementos=0;
    }

    @Override
    public void apilar(T dato) {
        Nodo<T> nuevo = new Nodo(dato);
        if (esVacia()) {
            inicio = nuevo;
        } else {
            nuevo.setSiguiente(getInicio());
            inicio = nuevo;
        }
        cantidadElementos++;
    }

    @Override
    public void desapilar() {
        if (!this.esVacia()) {
            if (cantidadElementos == 1) {
                inicio = null;
            }
            Nodo<T> aux = inicio;
            inicio = getInicio().getSiguiente();
            inicio.setAnterior(null);
            aux.setSiguiente(null);
            cantidadElementos--;
        } else {
            System.out.println("Esta vacia");
        }
    }

    @Override
    public boolean esVacia() {
        return cantidadElementos == 0;
    }

    @Override
    public boolean esllena() {
        return false;
    }

    @Override
    public Nodo cima() {
        return inicio;
    }

    @Override
    public int elementos() {
        return cantidadElementos;
    }

    @Override
    public void mostrarPila() {
        Nodo mostrar = getInicio();
        while (mostrar != null) {
            System.out.println(mostrar.getDato());
            mostrar = mostrar.getSiguiente();
        }

        System.out.println("");
    }

    public Nodo getInicio() {
        return inicio;
    }
}
