package trabajarconobligatorio;

public class Nodo<T extends Comparable<T>> {
    // Atributos
    private T dato;
    private Nodo siguiente;
    private Nodo anterior;

    // Constructor
    public Nodo(T elDato) {
        this.setDato(elDato);
        this.setSiguiente(null);
        this.setAnterior(null);
    }

    // set y get
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}
