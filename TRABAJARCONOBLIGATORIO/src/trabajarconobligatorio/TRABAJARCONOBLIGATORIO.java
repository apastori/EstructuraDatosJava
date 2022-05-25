package trabajarconobligatorio;

import java.util.Date;
import java.time.LocalDate;

import trabajarconobligatorio.Genericos.Prueba;
import trabajarconobligatorio.Genericos.Retorno;

/**
 *
 * @author Rafael
 */
public class TRABAJARCONOBLIGATORIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Obligatorio obl = new Obligatorio();
        Prueba p = new Prueba();
        juegodeprueba1(obl, p); // juego de prueba ejemplo
    }

    public static void juegodeprueba1(Obligatorio obl, Prueba p) {
        // escriba su juego de prueba aqui
        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK,
                "Se creara sistma para 3 palabras por linea");
        p.ver(obl.agregarContacto(1, "Juan Perez").resultado, Retorno.Resultado.OK,
                "se agrega contacto Juan Perez al sistema");
        p.ver(obl.agregarContacto(2, "Pedro Leal").resultado, Retorno.Resultado.OK,
                "se agrega contacto Pedro Leal al sistema");
        p.ver(obl.agregarMensaje(1, 2, new Date()).resultado, Retorno.Resultado.OK,
                "se agrega mensaje de contacto 1 para contacto 2 en el sistema");
        p.ver(obl.agregarMensaje(2, 1, new Date()).resultado, Retorno.Resultado.OK,
                "se agrega mensaje de contacto 2 para contacto 1 en el sistema");
        // p.ver(obl.agregarContacto(1, "Juan Perez").resultado,
        // Retorno.Resultado.ERROR,
        // "se intenta agregar contacto Juan Perez que ya existe");
        // p.ver(obl.eliminarContacto(1).resultado, Retorno.Resultado.OK, "se elimina
        // contacto Juan Perez del sistema");
        p.ver(obl.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, " sistema eliminado");
        p.imprimirResultadosPrueba();
    }
}
