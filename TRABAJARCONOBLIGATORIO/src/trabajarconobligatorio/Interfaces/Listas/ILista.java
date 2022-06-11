package trabajarconobligatorio.Interfaces.Listas;

import trabajarconobligatorio.Genericos.Nodo;

public interface ILista<T extends Comparable<T>> {

    public int getCantidadElementos();
    //metodos de la interfaz
    //post: Retorna un boolean indicado si la lista es vacía
    public boolean esVacia();

    //pre: El elemento a agregar es un entero
    //post: agrega el elemento al principio de la lista
    public void agregarInicio(T n);

    //pre: n es un entero
    //post: agrega el elemento al final de la lista
    public void agregarFinal(T n);

    //post: se borra el primer elemento de la lista
    public void borrarInicio();

    //post: se elimina el ultimo elemento de la lista
    public void borrarFin();

    //post: se vacia la lista
    public void vaciar();

    //post: se muestran todos los elementos de la lista en orden 
    public void mostrar();

    //pre: n es comparable
    //pre: la lista esta ordenada en forma ascendente
    //post: se interta el elemento n en forma ordenada
    public void agregarOrd(T n);

    //post: inserta el elemento en la posición indicada desplazando a los que le siguen.
    public boolean agregarEnPosicion(T n, int pos);

    //pre: n es un entero
    //post: se elimina la primera ocurrencia de n en la lista
    public void borrarElemento(T n);

    //pre: n es un entero
    //post: retronar el nodo que contiene el dato n
    public Nodo<T> obtenerElemento(T n);

    //pre: (pos >= 1) y (pos <= cantidad de elementos actuales).
    //post: retorna el nodo correspondiente a la posición solicitada
    public Nodo<T> obtenerElementoPosRecursivo(int pos, Nodo<T> inicio, int contador);
}
