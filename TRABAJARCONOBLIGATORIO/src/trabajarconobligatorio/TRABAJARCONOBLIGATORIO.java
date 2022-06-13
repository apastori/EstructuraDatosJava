package trabajarconobligatorio;

import java.util.Date;

import trabajarconobligatorio.Genericos.Prueba;
import trabajarconobligatorio.Genericos.Retorno;

/**
 * 
 * @author Alfonso Pastori 252422
 *  @author Nicolás Urrutia 172321
 * @author Rafael Suárez 250827
 */
public class TRABAJARCONOBLIGATORIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Obligatorio obl = new Obligatorio();
        Prueba p = new Prueba();
        juegodeprueba1(obl, p); // juego de prueba ejemplo
    }

    public static void juegodeprueba1(Obligatorio obl, Prueba p) {
        // escriba su juego de prueba aqui
        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK,
                "Se creara sistma para 3 palabras por linea");
        
        p.ver(obl.agregarContacto(1, "Alfonso Pastori").resultado, Retorno.Resultado.OK,
                "se agrega contacto Alfonso al sistema");
               
        obl.agregarContacto(2, "Rafael Suárez");
        obl.agregarContacto(3, "Nicolás Urrutia");
        
        p.ver(obl.agregarContacto(1, "Alfonso Pastori").resultado, Retorno.Resultado.ERROR,
                "NO se agrega contacto Alfonso Pastori al sistema");
     
        p.ver(obl.agregarMensaje(1, 2, new Date()).resultado, Retorno.Resultado.OK,
                "se agrega mensaje de contacto 1 para contacto 2 en el sistema");
         
        p.ver(obl.agregarMensaje(2, 1, new Date()).resultado, Retorno.Resultado.OK,
                "se agrega mensaje de contacto 2 para contacto 1 en el sistema");
         
        p.ver(obl.eliminarContacto(1).resultado, Retorno.Resultado.OK, 
                "se elimina contacto Juan Perez del sistema");
              
        p.ver(obl.imprimirTexto(1, 1).resultado, Retorno.Resultado.ERROR, 
                "no se muestra mensaje por contacto eliminado");
           
        p.ver(obl.imprimirTexto(2, 10000).resultado, Retorno.Resultado.ERROR, 
        "no se muestra mensaje por mensaje inexistente");   
           
        p.ver(obl.imprimirTexto(2, 1).resultado, Retorno.Resultado.OK, 
        "mostrar mensaje contacto 2 a contacto 1");        
        
        p.ver(obl.insertarLineaEnPosicion(2, 1, 99).resultado, Retorno.Resultado.ERROR,
        "Insertar Linea: Posicion de linea demasiado alta");
        p.ver(obl.insertarLineaEnPosicion(99, 1, 1).resultado, Retorno.Resultado.ERROR,
        "Insertar Linea: Contacto inexistente");
        p.ver(obl.insertarLineaEnPosicion(2, 99, 1).resultado, Retorno.Resultado.ERROR,
        "Insertar Linea: Mensaje inexistente");
        p.ver(obl.insertarLineaEnPosicion(2, 1, 1).resultado, Retorno.Resultado.OK,
        "Insertar Linea: Insertar al principio");
        p.ver(obl.insertarLineaEnPosicion(2, 1, 2).resultado, Retorno.Resultado.OK,
        "Insertar Linea: Insertar al final");
        
        p.ver(obl.insertarLineaEnPosicion(2, 1, 3).resultado, Retorno.Resultado.OK,
        "Insertar Linea: Insertar al final");
        p.ver(obl.insertarLineaEnPosicion(2, 1, 2).resultado, Retorno.Resultado.OK,
        "Insertar Linea: Insertar al final");

        p.ver(obl.insertarPalabraEnLinea(2, 1, 1, 1, "Hola").resultado, Retorno.Resultado.OK,
        "Insertar Palabra: Insertar al principio");
        p.ver(obl.insertarPalabraEnLinea(2, 1, 1, 2, "Mundo").resultado, Retorno.Resultado.OK,
        "Insertar Palabra: Insertar al final");
        p.ver(obl.insertarPalabraEnLinea(2, 1, 1, 1, "PC SAYS:").resultado, Retorno.Resultado.OK,
        "Insertar Palabra: Insertar al principio");
        
        p.ver(obl.insertarPalabraEnLinea(99, 1, 1, 1, "ERROR").resultado, Retorno.Resultado.ERROR,
        "Insertar Palabra: ERROR contacto no existe ");
        p.ver(obl.insertarPalabraEnLinea(2, 99, 1, 1, "ERROR").resultado, Retorno.Resultado.ERROR,
        "Insertar Palabra: ERROR mensaje no existe");
        p.ver(obl.insertarPalabraEnLinea(2, 1, 2, 2, "ERROR").resultado, Retorno.Resultado.ERROR,
        "Insertar Palabra: ERROR posición palabra incorrecta");
        p.ver(obl.insertarPalabraEnLinea(2, 1, 1, 1, "ERROR").resultado, Retorno.Resultado.ERROR,
        "Insertar Palabra: ERROR Linea llena");
        p.ver(obl.imprimirTexto(2, 1).resultado, Retorno.Resultado.OK, 
        "mostrar mensaje contacto 2 a contacto 1"); 


        p.ver(obl.insertarPalabraYDesplazar(99, 1, 1, 1, "DESP ERROR").resultado, Retorno.Resultado.ERROR,
        "Insertar y desplazar Palabra: ERROR contacto no existe ");
        p.ver(obl.insertarPalabraYDesplazar(2, 99, 1, 1, "DESP ERROR").resultado, Retorno.Resultado.ERROR,
        "Insertar y desplazar Palabra: ERROR mensaje no existe");
        p.ver(obl.insertarPalabraYDesplazar(2, 1, 2, 2, "DESP ERROR").resultado, Retorno.Resultado.ERROR,
        "Insertar y desplazar Palabra: ERROR posición palabra incorrecta");
        
        p.ver(obl.insertarPalabraYDesplazar(2, 1, 1, 1, "DESP 1").resultado, Retorno.Resultado.OK,
        "Insertar y desplazar Palabra: Insertar al principio");
        p.ver(obl.insertarPalabraYDesplazar(2, 1, 1, 1, "DESP 2").resultado, Retorno.Resultado.OK,
        "Insertar y desplazar Palabra: Insertar al principio");
        p.ver(obl.insertarPalabraYDesplazar(2, 1, 1, 1, "DESP 3").resultado, Retorno.Resultado.OK,
        "Insertar y desplazar Palabra: Insertar al principio");
        p.ver(obl.insertarPalabraYDesplazar(2, 1, 1, 3, "DESP 4").resultado, Retorno.Resultado.OK,
        "Insertar y desplazar Palabra: Insertar al final");
        p.ver(obl.insertarPalabraYDesplazar(2, 1, 1, 1, "DESP 5").resultado, Retorno.Resultado.OK,
        "Insertar y desplazar Palabra: Insertar al principio");
        p.ver(obl.insertarPalabraYDesplazar(2, 1, 1, 1, "DESP 6").resultado, Retorno.Resultado.OK,
        "Insertar y desplazar Palabra: Insertar al principio");
        p.ver(obl.insertarPalabraYDesplazar(2, 1, 1, 1, "DESP 7").resultado, Retorno.Resultado.OK,
        "Insertar y desplazar Palabra: Insertar al principio");
        
        p.ver(obl.imprimirTexto(2, 1).resultado, Retorno.Resultado.OK, 
        "mostrar mensaje contacto 2 a contacto 1"); 

        p.ver(obl.borrarPalabra(2, 1, 1, 1).resultado, Retorno.Resultado.OK, 
        "Borrar palabra: Se borra palabra de posicion 1");  
        p.ver(obl.borrarPalabra(2, 1, 3, 2).resultado, Retorno.Resultado.OK, 
        "Borrar palabra: Se borra palabra de posicion 1");
        p.ver(obl.borrarPalabra(2, 1, 5, 1).resultado, Retorno.Resultado.ERROR, 
        "Borrar palabra: Se borra palabra de posicion 1");
        p.ver(obl.borrarPalabra(2, 1, 1, 2).resultado, Retorno.Resultado.ERROR, 
        "Borrar palabra: Error al borrar palabra de posicion 2");

        p.ver(obl.imprimirTexto(2, 1).resultado, Retorno.Resultado.OK, 
        "mostrar mensaje contacto 2 a contacto 1"); 
        
        p.ver(obl.borrarLinea(99, 1, 2).resultado, Retorno.Resultado.ERROR, 
        "Borrar Linea: Contacto no existe");
        p.ver(obl.borrarLinea(2, 99, 2).resultado, Retorno.Resultado.ERROR, 
        "Borrar Linea: Mensaje no existe");
        p.ver(obl.borrarLinea(2, 1, 2).resultado, Retorno.Resultado.OK, 
        "Borrar Linea: Se borra linea de posicion 2");
        p.ver(obl.borrarLinea(2, 1, 1).resultado, Retorno.Resultado.OK, 
        "Borrar Linea: Se borra linea del inicio");


        p.ver(obl.borrarTodo(2, 1).resultado, Retorno.Resultado.OK,
        "Borrar todo: Ok");
        
        p.ver(obl.borrarTodo(1, 1).resultado, Retorno.Resultado.ERROR,
        "Borrar todo: Contacto inexistente");
        
        p.ver(obl.borrarTodo(2, 99).resultado, Retorno.Resultado.ERROR,
        "Borrar todo: Mensaje inexistente");
        p.ver(obl.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, 
                " sistema eliminado");
        
                
   
        p.imprimirResultadosPrueba();
    }
}
