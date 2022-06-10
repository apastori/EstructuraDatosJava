package trabajarconobligatorio.Genericos.Listas;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Interfaces.Listas.ILista;

public class ListaCompleta<T extends Comparable<T>> implements ILista<T> {
    private Nodo<T> inicio;
    private Nodo<T> fin;
    private int cantidad;
    private int tope;

    // Constructor
    public ListaCompleta(int topeMax) {
        inicio = null;
        fin = null;
        cantidad = 0;
        tope = topeMax;
    }

    public ListaCompleta() {
        inicio = null;
        fin = null;
        cantidad = 0;
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
            if (cantidad < tope) {
                nuevo.setSiguiente(getInicio());
                inicio.setAnterior(nuevo);
                inicio = nuevo;
                cantidad++;
            } else {
                System.out.println("Esta Llena");
            }
        }
    }

    @Override
    public void agregarFinal(T n) {
        Nodo<T> nuevo = new Nodo<T>(n);
        if (this.esVacia()) {
            agregarInicio(n);
        } else {
            if (cantidad < tope) {
                fin.setSiguiente(nuevo);
                nuevo.setAnterior(fin);
                fin = nuevo;
                cantidad++;
            } else {
                System.out.println("Esta Llena");
            }
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
            // inicio.getDato() == n
            if (inicio.getDato().compareTo(n) == 0) {
                ret = inicio;
            } else {
                // fin.getDato() == n
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

    @Override
    public int getCantidadElementos() {
        return cantidad;
    }
}
