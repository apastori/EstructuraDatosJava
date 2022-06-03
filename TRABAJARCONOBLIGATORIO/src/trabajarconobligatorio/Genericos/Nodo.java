package trabajarconobligatorio.Genericos;

public class Nodo<T extends Comparable<T>> {
    // Atributos
    private T dato;
    private Nodo<T> siguiente;
    private Nodo<T> anterior;

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

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }
}
