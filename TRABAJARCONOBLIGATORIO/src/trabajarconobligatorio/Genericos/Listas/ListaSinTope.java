package trabajarconobligatorio.Genericos.Listas;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Interfaces.Listas.ILista;
import trabajarconobligatorio.Modelos.Linea;

public class ListaSinTope<T extends Comparable<T>> implements ILista<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cantidad;

    // Constructor
    public ListaSinTope() {
        inicio = null;
        fin = null;
        cantidad = 0;
    }
    @Override
    public int getCantidadElementos(){
        return cantidad;
    }

    @Override
    public boolean esVacia() {
        return cantidad == 0;
    }

    @Override
    public void agregarInicio(T n) {
        Nodo<T> nuevo = new Nodo<T>(n);
        if (esVacia()) {
            inicio = nuevo;
            fin = inicio;
            cantidad++;
        } else {
                nuevo.setSiguiente(getInicio());
                inicio.setAnterior(nuevo);
                inicio = nuevo;
                cantidad++;
        }
    }

    @Override
    public void agregarFinal(T n) {
        Nodo<T> nuevo = new Nodo<T>(n);
        if (this.esVacia()) {
            agregarInicio(n);
        } else {
            fin.setSiguiente(nuevo);
            nuevo.setAnterior(fin);
            fin = nuevo;
            cantidad++;
        }
    }

    @Override
    public void borrarInicio() {
        if (!this.esVacia()) {
            if (cantidad == 1) {
                inicio = null;
                fin = null;
            } else {
                Nodo<T> aux = inicio;
                inicio = getInicio().getSiguiente();
                inicio.setAnterior(null);
                aux.setSiguiente(null);
            }
            cantidad--;
        } else {
            System.out.println("Esta vacia");
        }
    }

    @Override
    public void borrarFin() {
        if (!this.esVacia()) {
            // Si tiene un solo elemento
            if (cantidad == 1) {
                inicio = null;
                fin = inicio;
            } else {
                Nodo<T> borrar = fin;
                fin = borrar.getAnterior();
                fin.setSiguiente(null);
                borrar.setAnterior(null);
            }
            cantidad--;
        }
    }

    @Override
    public void mostrar() {
        Nodo<T> mostrar = getInicio();
        while (mostrar != null) {
            System.out.print(mostrar.getDato() + " - ");
            mostrar = mostrar.getSiguiente();
        }
        System.out.println("");
    }

    @Override
    public void vaciar() {
        inicio = null;
        fin = null;
        cantidad = 0;
    }

    @Override
    public void borrarElemento(T n) {
        if (!this.esVacia()) {
            if (inicio.getDato().equals(n)) {
                borrarInicio();
            } else {
                if (fin.getDato().equals(n)) {
                    borrarFin();
                } else {
                    Nodo<T> aux = inicio;
                    while (aux.getSiguiente() != null && !aux.getSiguiente().getDato().equals(n)) {
                        aux = aux.getSiguiente();
                    }
                    if (aux.getSiguiente() != null) {
                        Nodo<T> aBorrar = aux.getSiguiente();
                        aux.setSiguiente(aBorrar.getSiguiente());
                        aux.getSiguiente().setAnterior(aux);
                        aBorrar.setSiguiente(null);
                        aBorrar.setAnterior(null);
                        cantidad--;
                    }
                }
            }
        }
    }

    @Override
    public Nodo<T> obtenerElemento(T n) {
        Nodo<T> ret = null;
        if (!this.esVacia()) {
            if (inicio.getDato().compareTo(n) == 0) {
                ret = inicio;
            } else {
                if (fin.getDato().compareTo(n) == 0) {
                    ret = fin;
                } else {
                    Nodo<T> actual = getInicio();
                    while (actual != null && actual.getDato() != n) {
                        actual = actual.getSiguiente();
                    }
                    if (actual != null) {
                        ret = actual;
                    }
                }
            }
        }
        return ret;
    }

    @Override
    public void agregarOrd(T n) {
        if (esVacia() || inicio.getDato().compareTo(n) > 0) {
            agregarInicio(n);
        } else {
            if (fin.getDato().compareTo(n) < 0) {
                agregarFinal(n);
            } else {
                Nodo<T> aux = inicio;
                while (aux.getSiguiente() != null && aux.getSiguiente().getDato().compareTo(n) < 0) {
                    aux = aux.getSiguiente();
                }
                Nodo<T> nuevo = new Nodo<T>(n);
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
            }

        }
    }

    public Nodo<T> getInicio() {
        return inicio;
    }

    public Nodo<T> NodoMedio(Nodo<T> inicio, Nodo<T> fin)
    {
        if (inicio == null)
            return null;
 
            Nodo<T> lento = inicio;
            Nodo<T> rapido = inicio;
 
        while (rapido != fin)
        {
            rapido = rapido.getSiguiente();
            if (rapido != fin)
            {
                lento = lento.getSiguiente();
                rapido = rapido.getSiguiente();
            }
        }
        return lento;
    }

    public Nodo<T> busquedaBinaria(Nodo<T> head, T obj)
    {
        Nodo<T> inicio = head;
        Nodo<T> fin = null;
 
        do
        {
            Nodo<T> medio = NodoMedio(inicio, fin);
 
            if (medio == null){
                return null;
            }
 
            if (medio.getDato().equals(obj)) {
                    return medio;
            }
            else if (medio.getDato().compareTo(obj) == -1)
            {
                inicio = medio.getSiguiente();
            } else {
                fin = medio;
            }
        } while (fin == null || fin != inicio);
 
        return null;
    }

    public void insertarFinalRecursivo(Nodo<T> inicio, T objeto) {
        Nodo<T> nuevoNodo = new Nodo<T>(objeto);
        if (inicio == null) {
            inicio = nuevoNodo;
            fin = nuevoNodo;
            return;
        }
        if (inicio.getSiguiente() == null) {
            inicio.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(inicio);
            this.cantidad++;
            return;
        }
        insertarFinalRecursivo(inicio.getSiguiente(), objeto); 
    }
 
}
