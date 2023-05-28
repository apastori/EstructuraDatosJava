package trabajarconobligatorio.Modelos;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Genericos.Listas.ListaConTope;
import trabajarconobligatorio.Genericos.Listas.ListaSinTope;

public class Linea implements Comparable<Linea> {
    private ListaConTope<String> Palabras;


    public Linea(int cantidadMaxima) {
        Palabras = new ListaConTope<String>(cantidadMaxima);
    }

    public ListaConTope<String> Palabras(){
        return Palabras;
    }
    public String imprimirLinea() {
        String textoLinea = "";
        if (!this.Palabras.esVacia()) {
            Nodo<String> actual = Palabras.getInicio();
            do {
                textoLinea += actual.getDato() + "  ";
                actual = actual.getSiguiente();
            }
            while (actual != null);
               
        } else {
            textoLinea += "Linea Vacia";
        }
        return textoLinea;
    }
    

    public boolean insertarPalabra(int posicionPalabra, String palabraAIngresar) {
        return Palabras.agregarEnPosicion(palabraAIngresar, posicionPalabra);
    }
    
    void borrarOcurrenciaPalabra(String palabraABorrar) {
        borrarOcurrenciaPalabraRecursivo(this.Palabras.getInicio(), palabraABorrar);
    }
    
    void borrarOcurrenciaPalabraRecursivo(Nodo<String> inicio, String palabraABorrar) {
        if (inicio == null) {
            return;
        }
        
        Nodo<String> anterior = inicio.getAnterior();
        Nodo<String> siguiente = inicio.getSiguiente();

        if (inicio.getDato().equals(palabraABorrar)) {
            if (anterior == null) {
                this.Palabras.borrarInicio();
            } else if (siguiente == null) {
                this.Palabras.borrarFin();
            } else {
                anterior.setSiguiente(siguiente);
                siguiente.setAnterior(anterior);
            }
        }
        borrarOcurrenciaPalabraRecursivo(siguiente, palabraABorrar);
    }

    @Override
    public int compareTo(Linea o) {
        return 0;
    }

    public String ImprimirTextoIncorrecto(ListaSinTope<String> palabrasCorrectas) {
        String palabrasIncorrectas = "";

        var palabraActual = Palabras.getInicio();
        while (palabraActual != null){

            if(palabrasCorrectas.busquedaBinaria(palabrasCorrectas.getInicio(), palabraActual.getDato()) == null){
                palabrasIncorrectas += palabraActual.getDato() + " ";
            }
            palabraActual = palabraActual.getSiguiente();
        }


        return palabrasIncorrectas;
    }

    public void destruir() {
        Palabras.vaciar();
    }
}
