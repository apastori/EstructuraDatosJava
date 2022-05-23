package trabajarconobligatorio.Modelos;

import trabajarconobligatorio.Genericos.Listas.ListaSinTope;

public class Sistema {
    private ListaSinTope<Contacto> listaContactos;
    private Integer MAX_CANT_PALABRAS_X_LINEA;

    public Sistema(int MAX_CANT_PALABRAS_X_LINEA){
        listaContactos = new ListaSinTope();
        this.MAX_CANT_PALABRAS_X_LINEA = Integer.MAX_VALUE;
    }

    public void destruir(){
        MAX_CANT_PALABRAS_X_LINEA = null;
        listaContactos.vaciar();
    }

    public boolean agregarContacto(Contacto nuevoContacto) {
        if (listaContactos.obtenerElemento(nuevoContacto) == null) {
            listaContactos.agregarInicio(nuevoContacto);
            return true;
        } else {
            return false;
        }
    }

    public boolean eliminarContacto(Contacto contactoBuscado) {
        if (listaContactos.obtenerElemento(contactoBuscado) != null) {            
            listaContactos.borrarElemento(contactoBuscado);
            return true;
        } else {
            return false;
        }    
    }
}
