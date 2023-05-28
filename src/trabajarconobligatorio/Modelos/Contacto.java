package trabajarconobligatorio.Modelos;

import java.text.SimpleDateFormat;
import java.util.Date;

import trabajarconobligatorio.Genericos.Nodo;
import trabajarconobligatorio.Genericos.Listas.ListaSinTope;

public class Contacto implements Comparable<Contacto> {
    private Integer numero;
    private String nombre;
    private ListaSinTope<Mensaje> Mensajes;
    private Integer ultimoId = 0;
    private Integer MAX_CANT_PALABRAS_X_LINEA;

    public Contacto(int elNumero, String elNombre, int MAX_CANT_PALABRAS_X_LINEA) {
        this.setNumero(elNumero);
        this.setNombre(elNombre);
        this.MAX_CANT_PALABRAS_X_LINEA = MAX_CANT_PALABRAS_X_LINEA;
        Mensajes = new ListaSinTope<Mensaje>();
    }

    public Contacto(int elNumero) {
        this.setNumero(elNumero);
    }
    public Contacto(int elNumero, String elNombre) {
        this.setNumero(elNumero);
        this.setNombre(elNombre);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ListaSinTope<Mensaje> getMensajesPorDestinatario(int numero){
        ListaSinTope<Mensaje> ret = new ListaSinTope<Mensaje>();

        Nodo<Mensaje> aux = Mensajes.getInicio();
        while( aux != null) {
            var mensaje = aux.getDato(); 
            if(mensaje.getNumContactoDestino() == numero){
                ret.agregarFinal(mensaje);
            }
            aux = aux.getSiguiente();
        }
        return ret;
    }

    public void agregarMensaje(int numContactoDestino, Date fecha){
        ultimoId++;
        int nuevoId = ultimoId;
        Mensaje nuevoMensaje = new Mensaje(numContactoDestino, fecha, nuevoId, MAX_CANT_PALABRAS_X_LINEA);
        Mensajes.agregarFinal(nuevoMensaje);
    }

    
    public boolean eliminarMensaje(int numMensaje) {
        Nodo<Mensaje> mensajeAEliminar = Mensajes.busquedaBinaria(Mensajes.getInicio(), new Mensaje(numMensaje));

        if(mensajeAEliminar == null){
            return false;
        }

        Nodo<Mensaje> anterior = mensajeAEliminar.getAnterior();
        Nodo<Mensaje> siguiente = mensajeAEliminar.getSiguiente();
        
        anterior.setSiguiente(siguiente);
        siguiente.setAnterior(anterior);

        mensajeAEliminar.setAnterior(null);
        mensajeAEliminar.setSiguiente(null);
        mensajeAEliminar.getDato().destruir();
        return true;
    }
    
    public Mensaje getMensajePorId(int numMensaje) {
        Mensaje mensaje = null;
        Nodo<Mensaje> nodoMensaje = Mensajes.busquedaBinaria(Mensajes.getInicio(), new Mensaje(numMensaje));
        if (nodoMensaje != null) {
            mensaje = nodoMensaje.getDato();
        }
        return mensaje;
    }

    public Mensaje getMensajePorNumero(int numMensaje) {
        Nodo<Mensaje> mensaje = Mensajes.busquedaBinaria(Mensajes.getInicio(), new Mensaje(numMensaje));
        if(mensaje != null){
            return mensaje.getDato();
        }
        return null;
    }
    

    public boolean insertarLineaEnPosicion(int numMensaje, int posicionLinea) {
        Mensaje mensaje = getMensajePorNumero(numMensaje);

        if(mensaje != null){
            return mensaje.insertarLineaEnPosicion(posicionLinea);
        }
        return false;
    }

    public boolean encontrarMensaje(int numMensaje) {
        Nodo<Mensaje> mensajeBuscado = Mensajes.busquedaBinaria(Mensajes.getInicio(), new Mensaje(numMensaje));
        if (mensajeBuscado == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean borrarTodo(int numMensaje) {
        Mensaje mensaje = getMensajePorNumero(numMensaje);

        if(mensaje != null){
            mensaje.Lineas.vaciarRecursivo(mensaje.Lineas.getFin());
            return true;
        }
        return false;    
    }
    
    public boolean borrarLineaEnPosicion(int numMensaje, int posicionLinea){
        Mensaje mensaje = getMensajePorNumero(numMensaje);
        if(mensaje != null){
            return mensaje.borrarLineaEnPosicion(posicionLinea);
        }else{
            return false;
        }
    }

    public boolean borrarPalabraEnPosicion(int numMensaje, int posicionLinea, int posicionPalabra){
        Mensaje mensaje = getMensajePorNumero(numMensaje);
        if(mensaje != null){
            return mensaje.borrarPalabraEnPosicion(posicionLinea,posicionPalabra);
        }else{
            return false;
        }
    }

    // public boolean equals(Object o) {
    // return this.getNombre().equalsIgnoreCase(((Contacto) o).getNombre());
    // }
    public boolean equals(Object o) {
        if (this.getNumero() == ((Contacto) o).getNumero()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    // public int compareTo(Contacto o) {
    // return this.getNombre().compareTo(o.getNombre());
    // }
    public int compareTo(Contacto o) {
        if (this.numero == o.numero) {
            return 0;
        } else if (this.numero > o.numero){
            return 1;
        } else {
            return -1;
        }
    }

    public String toString() {
        return "Nº: " + this.getNumero() + " Nombre: " + this.getNombre();
    }

    public boolean insertarPalabraYDesplazar(int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Mensaje mensaje = getMensajePorNumero(numMensaje);

        if(mensaje != null){
            return mensaje.insertarPalabraYDesplazar(posicionLinea, posicionPalabra, palabraAIngresar);
        }
        return false; 
    }

    public boolean insertarPalabraEnLinea(int numMensaje, int posicionLinea, int posicionPalabra, String palabraAIngresar) {
        Mensaje mensaje = getMensajePorNumero(numMensaje);

        if(mensaje != null){
            return mensaje.insertarPalabraEnLinea(posicionLinea, posicionPalabra, palabraAIngresar);
        }
        return false; 
    }

    public void ImprimirTextoIncorrecto(ListaSinTope<String> palabrasCorrectas) {
        Nodo<Mensaje> nMensaje = Mensajes.getInicio();

        while(nMensaje != null){
            nMensaje.getDato().ImprimirTextoIncorrecto(palabrasCorrectas);
            nMensaje = nMensaje.getSiguiente();
        }
    }

    public void cantidadDeMensajes(ListaSinTope<Contacto> listaContactos) {

        // Variables que corresponde a los ejes de la Matriz.
        ListaSinTope<Date> fechasDeEnvio = new ListaSinTope<Date>();
        ListaSinTope<Contacto> destinos = new ListaSinTope<Contacto>();

        // Iteramos sobre cada mensaje para popular los ejes de la matriz.
        Nodo<Mensaje> mensajeActual = Mensajes.getInicio();
        while (mensajeActual != null) {
            
            // EJE DE FECHAS
            Date fechaMensaje =  mensajeActual.getDato().getFecha();
            Nodo<Date> primeraFecha = fechasDeEnvio.getInicio();

            if(fechasDeEnvio.busquedaBinaria(primeraFecha, fechaMensaje) == null){
                fechasDeEnvio.agregarOrd(fechaMensaje);
            }


            // EJE DE CONTACTOS
            // listaContactos refiere a los que están actualmente en el sistema y podemos acceder a su nombre.
            Nodo<Contacto> primerContacto = listaContactos.getInicio(); 
            // destinos refiere a aquellos contactos (actualmente en el sistema o eliminado) a los que el origen envió un mensaje.
            Nodo<Contacto> primerDestino = destinos.getInicio();

            int numDestino = mensajeActual.getDato().getNumContactoDestino();

            // El contacto YA existe en el sistema. Ergo, agregarlo con su nombre correspondiente.
            Nodo<Contacto> contactoPreexistente = listaContactos.busquedaBinaria(primerContacto, new Contacto(numDestino));
            if(contactoPreexistente != null) {
                if(destinos.busquedaBinaria(primerDestino, contactoPreexistente.getDato()) == null){
                    // Si el contacto no está entre los destinos, agregarlo.
                    destinos.agregarOrd(contactoPreexistente.getDato());
                }
            // El contacto ya NO existe en el sistema porque fue eliminado.
            } else {
                Contacto aux = new Contacto(numDestino, "Eliminado");
                if(destinos.busquedaBinaria(primerDestino, aux) == null){
                    // Si el contacto no está entre los destinos, agregarlo.
                    destinos.agregarOrd(aux);
                }
            }
            mensajeActual = mensajeActual.getSiguiente();
        }
        
        int Filas = destinos.getCantidadElementos()+1;
        int Columnas = destinos.getCantidadElementos()+1;
        String[][] mat = new String[Filas][Columnas];

        mat = llenarMatriz(mat, destinos, fechasDeEnvio);

        mostrarMatriz(mat);
    }

    private String[][] llenarMatriz(String[][] mat, ListaSinTope<Contacto> destinos, ListaSinTope<Date> fechasDeEnvio) {
        mat[0][0] = "Destinos \\ Fechas \t\t\t|";
        
        // Las filas (menos la 0) representan los destinos.
        for(int fila=0; fila<mat.length; fila++){

            Contacto destino = null;
            ListaSinTope<Mensaje> mensajes = null;

            // Si no estoy en la fila 0, obtengo el destino y sus mensajes.
            if(fila>0){
                destino = destinos.getNodoPorPos(fila).getDato();
                mensajes = getMensajesPorDestinatario(destino.getNumero());
            }

            // Las columnas (menos la 0) representan las fechas en las que se envió un mensaje.
            for(int col=0; col<mat[fila].length; col++){

                Date fecha = null;
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                // Si no estoy en la columna 0, obtengo la fecha
                if (col > 0){
                    fecha = fechasDeEnvio.getNodoPorPos(col).getDato();
                }

                // Llenar fila FECHAS
                if(fila == 0 && col > 0){
                    mat[fila][col] = formato.format(fecha) + "\t\t|";
                }
                // Llenar columna Contactos
                if(fila > 0 && col == 0){
                    mat[fila][col] = destino.toString()+ "\t\t\t|";
                }
                // Llenar celdas con datos
                if(fila > 0 && col > 0){
                    mat[fila][col] = getCantMensajesFecha(mensajes, fecha).toString()+ "\t\t\t|";
                }
            }
        }

        return mat;
    }

    private Integer getCantMensajesFecha(ListaSinTope<Mensaje> listaMensajes, Date fecha) {
        int contador = 0;

        Nodo<Mensaje> mActual = listaMensajes.getInicio();
        while (mActual != null){
            if(mActual.getDato().getFecha().equals(fecha)){
                contador++;
            }
            mActual = mActual.getSiguiente();
        }
        return contador;
    }

    private void mostrarMatriz(String[][] mat) {
        String matriz = "";
        
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[i].length; j++){
                matriz += mat[i][j] + " ";
            }
            
            matriz += "\n";
        }
    
        System.out.println(matriz);
    }

    public void destruir() {
        numero = null;
        nombre = null;
        MAX_CANT_PALABRAS_X_LINEA = null;
        if(Mensajes != null){
            Nodo<Mensaje> mActual = Mensajes.getInicio();
            while (mActual != null){
                mActual.getDato().destruir();
                mActual = mActual.getSiguiente();
            }
            Mensajes.vaciar();
        }
    }


}
