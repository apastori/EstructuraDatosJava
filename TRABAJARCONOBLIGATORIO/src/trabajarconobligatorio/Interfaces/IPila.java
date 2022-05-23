package trabajarconobligatorio.Interfaces;

import trabajarconobligatorio.Genericos.Nodo;

public interface IPila<T extends Comparable<T>> {
    // pre: recibe un generico
    // post: agrega el dato a la pila
    public void apilar(T dato);

    // pre:
    // post: elimina el dato a la pila
    public void desapilar();

    // pre:
    // post: verifica si la pila es vacia
    public boolean esVacia();

    // pre:
    // post: verifica si la pila esta llena
    public boolean esllena();

    // pre:
    // post: devuelve el inicio de la pila
    public Nodo<T> cima();

    // pre:
    // post: devuelve la cantidad de elementos
    public int elementos();

    // pre:
    // post: muestra los elementos de la pila
    public void mostrarPila();

    public Nodo<T> getInicio();
}
