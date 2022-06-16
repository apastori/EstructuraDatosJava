package trabajarconobligatorio.Modelos;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Genericos.Listas.ListaSinTope;

public class Diccionario {
    private ListaSinTope<String> Palabras;

    public Diccionario(){
        Palabras = new ListaSinTope<String>();
    }

    public ListaSinTope<String> getPalabras(){
        return Palabras;
    }

    public boolean ingresarPalabra(String palabraAIngresar) {

        if(Palabras.obtenerElemento(palabraAIngresar) != null ){
            return false;
        }
        Palabras.agregarOrd(palabraAIngresar);
        return true;
    }

    public boolean borrarPalabra(String palabraABorrar) {
        if(Palabras.busquedaBinaria(Palabras.getInicio(), palabraABorrar) == null ){
            return false;
        }
        Palabras.borrarElemento(palabraABorrar);
        return true;
    }

    public void imprimirDiccionario(){
        
        if(Palabras.esVacia()){
            System.out.println("Diccionario vacio");
        } else {
            Nodo<String> nPalabra = Palabras.getInicio();
            while (nPalabra != null){
                System.out.println(nPalabra.getDato());
                nPalabra = nPalabra.getSiguiente();
            }
        }
    }
}
