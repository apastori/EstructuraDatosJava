package trabajarconobligatorio.Genericos.Listas;

public class ListaConTope<T extends Comparable<T>> extends ListaSinTope<T> {
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

    @Override
    public boolean agregarEnPosicion(T n, int pos){
        if (!esLlena()) {
            return super.agregarEnPosicion(n, pos);
        }
        
        System.out.println("Esta Llena");
        return false;
    }

    public boolean insertarYDesplazar(int pos, T dato) {
        if(esLlena()){
         super.borrarFin();   
        }
        return super.agregarEnPosicion(dato, pos);
    }
}
