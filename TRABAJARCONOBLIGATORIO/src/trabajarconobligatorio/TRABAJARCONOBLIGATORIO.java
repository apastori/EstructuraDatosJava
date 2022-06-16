package trabajarconobligatorio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
        Obligatorio obl = new Obligatorio();
        Prueba p = new Prueba();
        //juegodeprueba1(obl, p); 
        //juegodeprueba3(obl, p);
        pruebasMatriz(obl, p);
    }

    public static void juegodeprueba1(Obligatorio obl, Prueba p) throws ParseException {
        // escriba su juego de prueba aqui
        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK,
                "Se creara sistma para 3 palabras por linea");
        
        p.ver(obl.agregarContacto(1, "Alfonso Pastori").resultado, Retorno.Resultado.OK,
                "se agrega contacto Alfonso al sistema");
               
        obl.agregarContacto(2, "Rafael Suárez");
        obl.agregarContacto(3, "Nicolás Urrutia");
        
        p.ver(obl.agregarContacto(1, "Alfonso Pastori").resultado, Retorno.Resultado.ERROR,
                "NO se agrega contacto Alfonso Pastori al sistema");

        // definimos una fecha        
        Date fecha=new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
  
       //-------------------------------
        fecha=formato.parse("23/03/2022");
       //--------------------------------
     
        p.ver(obl.agregarMensaje(1, 2, fecha).resultado, Retorno.Resultado.OK,
                "se agrega mensaje de contacto 1 para contacto 2 en el sistema");
         
        p.ver(obl.agregarMensaje(2, 1, fecha).resultado, Retorno.Resultado.OK,
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
        p.ver(obl.insertarPalabraYDesplazar(2, 99, 99, 1, "DESP ERROR").resultado, Retorno.Resultado.ERROR,
        "Insertar y desplazar Palabra: ERROR linea no existe");
        p.ver(obl.insertarPalabraYDesplazar(2, 1, 2, 99, "DESP ERROR").resultado, Retorno.Resultado.ERROR,
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
        p.ver(obl.insertarPalabraYDesplazar(2, 1, 1, 1, "DESP 5").resultado, Retorno.Resultado.OK,
        "Insertar y desplazar Palabra: Insertar al principio");
        p.ver(obl.insertarPalabraYDesplazar(2, 1, 1, 1, "DESP 5").resultado, Retorno.Resultado.OK,
        "Insertar y desplazar Palabra: Insertar al principio");
        p.ver(obl.insertarPalabraYDesplazar(2, 1, 1, 1, "DESP 6").resultado, Retorno.Resultado.OK,
        "Insertar y desplazar Palabra: Insertar al principio");
        p.ver(obl.insertarPalabraYDesplazar(2, 1, 1, 1, "DESP 7").resultado, Retorno.Resultado.OK,
        "Insertar y desplazar Palabra: Insertar al principio");

        p.ver(obl.borrarOcurrenciasPalabraEnTexto(100, 1, "DESP 5").resultado, Retorno.Resultado.ERROR,
        "Tiene como resultado Error porque el contacto 100 no existe");
        p.ver(obl.borrarOcurrenciasPalabraEnTexto(2, 500, "DESP 5").resultado, Retorno.Resultado.ERROR,
        "Tiene como resultado Error porque el mensaje 500 no existe");
        
        p.ver(obl.imprimirTexto(2, 1).resultado, Retorno.Resultado.OK, 
        "mostrar mensaje contacto 2 a contacto 1");


        p.ver(obl.borrarOcurrenciasPalabraEnTexto(2, 1, "DESP 5").resultado, Retorno.Resultado.OK,
        "Borrar Palabra DESP 5");
        
        p.ver(obl.imprimirTexto(2, 1).resultado, Retorno.Resultado.OK, 
        "mostrar mensaje contacto 2 a contacto 1");
        
        p.ver(obl.borrarOcurrenciasPalabraEnLinea(100, 1, 1, "DESP 5").resultado, Retorno.Resultado.ERROR,
        "Tiene como resultado Error porque el contacto 100 no existe");
        p.ver(obl.borrarOcurrenciasPalabraEnLinea(2, 500, 1, "DESP 5").resultado, Retorno.Resultado.ERROR,
        "Tiene como resultado Error porque el mensaje 500 no existe");
        p.ver(obl.borrarOcurrenciasPalabraEnLinea(2, 1, 1, "DESP 7").resultado, Retorno.Resultado.OK,
        "Borrar Palabra DESP 5");
        p.ver(obl.imprimirTexto(2, 1).resultado, Retorno.Resultado.OK, 
        "mostrar mensaje contacto 2 a contacto 1");
        
        p.ver(obl.borrarPalabra(2, 1, 1, 1).resultado, Retorno.Resultado.OK, 
        "Borrar palabra: Se borra palabra de posicion 1 de linea 1");  
        p.ver(obl.borrarPalabra(2, 1, 3, 2).resultado, Retorno.Resultado.OK, 
        "Borrar palabra: Se borra palabra de posicion 1 de linea 3");
        p.ver(obl.borrarPalabra(99, 1, 5, 1).resultado, Retorno.Resultado.ERROR, 
        "Borrar palabra: Error al borrar palabra no se enceuntra contacto 99");
        p.ver(obl.borrarPalabra(2, 99, 5, 1).resultado, Retorno.Resultado.ERROR, 
        "Borrar palabra: Error al borrar palabra no se enceuntra mensaje 99");
        
        p.ver(obl.imprimirTexto(2, 1).resultado, Retorno.Resultado.OK, 
        "mostrar mensaje contacto 2 a contacto 1"); 
        p.ver(obl.borrarPalabra(2, 1, 99, 1).resultado, Retorno.Resultado.ERROR, 
        "Borrar palabra: Error al borrar palabra de posicion 1 de linea 99");

        p.ver(obl.borrarPalabra(2, 1, 1, 3).resultado, Retorno.Resultado.ERROR, 
        "Borrar palabra: Error al borrar palabra de posicion 3 de linea 1");

        p.ver(obl.imprimirTexto(2, 1).resultado, Retorno.Resultado.OK, 
        "mostrar mensaje contacto 2 a contacto 1"); 

        p.ver(obl.imprimirLinea(2, 1, 1).resultado, Retorno.Resultado.OK, 
        "Imprimir Linea: Se imprime linea de posicion 1");
        p.ver(obl.imprimirLinea(2, 1, 2).resultado, Retorno.Resultado.OK, 
        "Imprimir Linea: Se imprime linea de posicion 2");        
        p.ver(obl.imprimirLinea(99, 1, 2).resultado, Retorno.Resultado.ERROR, 
        "Imprimir Linea: Error al imprimir linea, no existe contacto 99");
        p.ver(obl.imprimirLinea(2, 99, 2).resultado, Retorno.Resultado.ERROR, 
        "Imprimir Linea: Error al imprimir linea, no existe mensaje 99");
        p.ver(obl.imprimirLinea(2, 1, 99).resultado, Retorno.Resultado.ERROR, 
        "Imprimir Linea: Error al imprimir linea, no existe linea 99");
        
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
        p.ver(obl.imprimirTexto(2, 1).resultado, Retorno.Resultado.OK, 
        "mostrar mensaje contacto 2 a contacto 1"); 
        
        p.ver(obl.borrarTodo(1, 1).resultado, Retorno.Resultado.ERROR,
        "Borrar todo: Contacto inexistente");
        p.ver(obl.borrarTodo(2, 99).resultado, Retorno.Resultado.ERROR,
        "Borrar todo: Mensaje inexistente");


        p.ver(obl.imprimirDiccionario().resultado, Retorno.Resultado.OK,
        "Diccionario: Imprimir VACIO");
        p.ver(obl.ingresarPalabraDiccionario("Arbol").resultado, Retorno.Resultado.OK,
        "Diccionario: Ingresar palabra OK");
        p.ver(obl.ingresarPalabraDiccionario("Arbol").resultado, Retorno.Resultado.ERROR,
        "Diccionario: ERROR palabra ya existe ");
        obl.ingresarPalabraDiccionario("Bufalo");
        obl.ingresarPalabraDiccionario("Barco");
        obl.ingresarPalabraDiccionario("Carretilla");
        obl.ingresarPalabraDiccionario("Bolsa");
        obl.ingresarPalabraDiccionario("Cuero");
        obl.ingresarPalabraDiccionario("Desodorante");
        obl.ingresarPalabraDiccionario("Elefante");
        obl.ingresarPalabraDiccionario("Zorro");
        obl.ingresarPalabraDiccionario("Puerta");
        obl.ingresarPalabraDiccionario("Avion");
        p.ver(obl.imprimirDiccionario().resultado, Retorno.Resultado.OK,
        "Diccionario: Imprimir Ordenado");
        
        p.ver(obl.borrarPalabraDiccionario("Arbol").resultado, Retorno.Resultado.OK,
        "Diccionario: Palabra borrada ");
        p.ver(obl.borrarPalabraDiccionario("Arbol").resultado, Retorno.Resultado.ERROR,
        "Diccionario: ERROR palabra no existe ");
        obl.borrarPalabraDiccionario("Puerta");
        p.ver(obl.imprimirDiccionario().resultado, Retorno.Resultado.OK,
        "Diccionario: Imprimir sin ARBOL ni PUERTA");
        
        
        p.ver(obl.ImprimirTextoIncorrecto().resultado, Retorno.Resultado.OK,
        "Diccionario: Texto incorrecto - TEXTO VACIO");
        obl.insertarLinea(2, 1);
        obl.insertarLinea(2, 1);
        obl.insertarLinea(2, 1);
        obl.insertarPalabraYDesplazar(2, 1, 1, 1, "Hola");
        obl.insertarPalabraYDesplazar(2, 1, 2, 1, "Como");
        obl.insertarPalabraYDesplazar(2, 1,3, 1, "Estas");
        obl.ingresarPalabraDiccionario("Hola");
        p.ver(obl.ImprimirTextoIncorrecto().resultado, Retorno.Resultado.OK,
        "Diccionario: Texto incorrecto - No se muestra HOLA");


        p.ver(obl.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, " sistema eliminado");
        p.imprimirResultadosPrueba();
    }
    public static void pruebasMatriz (Obligatorio obl, Prueba p) throws ParseException {
        obl.crearSistemaMensajes(3);
        obl.agregarContacto(1, "Alfo");
        obl.agregarContacto(2, "Nico");
        obl.agregarContacto(3, "Rafa");
        obl.agregarContacto(4, "Seba");

        Date fecha=new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
  
       //-------------------------------
        fecha=formato.parse("23/03/2022");
       //--------------------------------
        obl.agregarMensaje(1, 4, fecha);
        obl.agregarMensaje(1, 4, fecha);
        obl.agregarMensaje(1, 4, fecha);
        obl.agregarMensaje(1, 4, fecha);
        obl.agregarMensaje(1, 4, fecha);

        obl.agregarMensaje(1, 2, fecha);

        
        fecha=formato.parse("30/05/2022");
        obl.agregarMensaje(1, 4, fecha);

        obl.agregarMensaje(1, 3, fecha);

        obl.agregarMensaje(1, 2, fecha);
        obl.agregarMensaje(1, 2, fecha);

        
        fecha=formato.parse("01/04/2022");

        obl.agregarMensaje(1, 3, fecha);

        obl.agregarMensaje(1, 2, fecha);

        obl.eliminarContacto(3);

        obl.cantidadDeMensajes(1);

    }
    public static void juegodeprueba3(Obligatorio obl, Prueba p) throws ParseException{
        
        p.ver(obl.crearSistemaMensajes(3).resultado, Retorno.Resultado.OK, "Se creara sistema para 3 palabras por linea");
        p.ver(obl.agregarContacto(1, "Carlos Perez").resultado, Retorno.Resultado.OK, "se agrega contacto Carlos Perez al sistema");
        p.ver(obl.agregarContacto(1, "Carlos Perez").resultado, Retorno.Resultado.ERROR, 
        "se intenta agregar contacto Carlos Perez, y ya existe un contacto dicho número");
	p.ver(obl.agregarContacto(1, "Micaela Gutierrez").resultado, Retorno.Resultado.ERROR, 
        "se intenta agregar contacto Micaela Gutierrez, y ya existe un contacto dicho número");
        p.ver(obl.eliminarContacto(1).resultado, Retorno.Resultado.OK, "se elimina contacto Carlos Perez del sistema");
       
        p.ver(obl.agregarContacto(1, "Juan").resultado, Retorno.Resultado.OK, "se agrega contacto Juan al sistema");
        p.ver(obl.agregarContacto(2, "Pedro").resultado, Retorno.Resultado.OK, "se agrega contacto Pedro al sistema");
        p.ver(obl.agregarContacto(3, "Ana").resultado, Retorno.Resultado.OK, "se agrega contacto Ana al sistema");

	p.ver(obl.eliminarContacto(5).resultado, Retorno.Resultado.ERROR, "no existe un contacto con ese número");
        p.ver(obl.agregarContacto(4, "Maria").resultado, Retorno.Resultado.OK, "se agrega contacto María al sistema");
	p.ver(obl.agregarContacto(5, "Romina").resultado, Retorno.Resultado.OK, "se agrega contacto Romina al sistema");

	p.ver(obl.agregarContacto(5, "Felipe").resultado, Retorno.Resultado.ERROR, "ya existe un contacto con ese número");
	p.ver(obl.agregarContacto(6, "Felipe").resultado, Retorno.Resultado.OK, "se agrega contacto Felipe al sistema");
	p.ver(obl.eliminarContacto(6).resultado, Retorno.Resultado.OK, "se elimina contacto Felipe Perez del sistema");
        
        // definimos una fecha        
        Date fecha=new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
  
       //-------------------------------
        fecha=formato.parse("23/03/2022");
       //--------------------------------

        // Agregamos 3 mensajes a contacto Romina que Existe
        p.ver(obl.agregarMensaje(5,2, fecha).resultado, Retorno.Resultado.OK, "Se agrega primer mensaje para Romina ");
        p.ver(obl.agregarMensaje(5,2, fecha).resultado, Retorno.Resultado.OK, "Se agrega segundo mensaje para Romina ");
        p.ver(obl.agregarMensaje(5,4, fecha).resultado, Retorno.Resultado.OK, "Se agrega tercer  mensaje para Romina ");
        
        // Agregamos 3 mensajes a contactos que no existen
        p.ver(obl.agregarMensaje(0,2, fecha).resultado, Retorno.Resultado.ERROR, "Se quiere agregar mensaje a contacto origen inexistente ");
	p.ver(obl.agregarMensaje(5,10, fecha).resultado, Retorno.Resultado.ERROR, "Se quiere agrega mensaje a contacto destino inexistente ");
	p.ver(obl.agregarMensaje(9,10, fecha).resultado, Retorno.Resultado.ERROR, "Se quiere agrega mensaje a contacto origen/destino inexistente ");

	//Se eliminan mensajes
	//p.ver(obl.eliminarMensaje(5,1).resultado, Retorno.Resultado.OK, "Se elimina mensaje 1 de Romina");
	p.ver(obl.eliminarMensaje(5,4).resultado, Retorno.Resultado.ERROR, "Se quiere eliminar mensaje que no existe");
	//p.ver(obl.eliminarMensaje(5,1).resultado, Retorno.Resultado.ERROR, "Se quiere eliminar mensaje que no existe");
	p.ver(obl.eliminarMensaje(3,2).resultado, Retorno.Resultado.ERROR, "Se quiere eliminar mensaje que no existe");

        // Agregamos lineas al mensaje 2 de Romina
        p.ver(obl.insertarLineaEnPosicion(5, 2, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 2 de Pedro");
        p.ver(obl.insertarLineaEnPosicion(5, 2, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 2 en blanco al mensaje 2 de Pedro");
        p.ver(obl.insertarLineaEnPosicion(5, 2, 3).resultado, Retorno.Resultado.OK, "Se agrega linea 3 en blanco al mensaje 2 de Pedro");
        
        // Agregamos palabras al mensaje 2 de Romina en la linea 1
        p.ver(obl.insertarPalabraEnLinea(5,2,1,1,"Hola").resultado, Retorno.Resultado.OK,"Se agrega palabra Hola linea 1 mensaje 2");
        p.ver(obl.insertarPalabraEnLinea(5,2,1,2,"Pedro").resultado, Retorno.Resultado.OK,"Se agrega palabra Pedro linea 1 mensaje 2");
 
        p.ver(obl.insertarPalabraEnLinea(5,2,2,1,"Te").resultado, Retorno.Resultado.OK,"Se agrega palabra Te linea 2 mensaje 2");
        p.ver(obl.insertarPalabraEnLinea(5,2,2,2,"LLamo").resultado, Retorno.Resultado.OK,"Se agrega palabra Te linea 2 mensaje 2");
        p.ver(obl.insertarPalabraEnLinea(5,2,2,3,"En").resultado, Retorno.Resultado.OK,"Se agrega palabra Llamo linea 2 mensaje 2");
        p.ver(obl.insertarPalabraEnLinea(5,2,3,1,"5min").resultado, Retorno.Resultado.OK,"Se agrega palabra 5min linea 3 mensaje 2");
      
        // Imprimimos mensaje 2 de Romina
        p.ver(obl.imprimirTexto(5, 2).resultado, Retorno.Resultado.OK, "Se imprime mensaje 2 de Romina");
        
        p.ver(obl.insertarPalabraYDesplazar(5,2,2,2,"puedo").resultado, Retorno.Resultado.OK,"Se agrega palabra puedo en linea 2 mensaje 2 posicion 2");
        
        // Imprimimos mensaje 2 de romina
        p.ver(obl.imprimirTexto(5, 2).resultado, Retorno.Resultado.OK, "Se imprime mensaje 2 de Romina");
        
        p.ver(obl.borrarPalabra(5,2,2,2).resultado, Retorno.Resultado.OK, "Se elimina palabra pos 2 de mensaje 2 linea 2 de Romina");

        // Imprimimos mensaje 2 de romina
        p.ver(obl.imprimirTexto(5,2).resultado, Retorno.Resultado.OK, "Se imprime mensaje 2 de Romina");
       
       //-------------------------------        
        fecha=formato.parse("24/03/2022");
       //-------------------------------
       
        p.ver(obl.agregarMensaje(5,2,fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje  4 para  Romina en fecha 24/03/2022 ");
        p.ver(obl.agregarMensaje(5,2,fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje 5 para Romina en  fecha 24/03/2022 ");
        
       // Agregamos lineas al mensaje 1 de Romina
        p.ver(obl.insertarLineaEnPosicion(5, 1, 1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 1 de Romina");
        p.ver(obl.insertarLineaEnPosicion(5, 1, 2).resultado, Retorno.Resultado.OK, "Se agrega linea 2 en blanco al mensaje 1 de Romina");
        p.ver(obl.insertarLineaEnPosicion(5, 1, 3).resultado, Retorno.Resultado.OK, "Se agrega linea 3 en blanco al mensaje 1 de Romina");

        // Agregamos palabras al mensaje 1 de romina en la linea 1
        p.ver(obl.insertarPalabraEnLinea(5,1,1,1,"Voy").resultado, Retorno.Resultado.OK,"Se agrega palabra voy linea 1 mensaje 1");
        p.ver(obl.insertarPalabraEnLinea(5,1,1,2,"llegando").resultado, Retorno.Resultado.OK,"Se agrega palabra llegando linea 1 mensaje 1");
         
        p.ver(obl.agregarMensaje(3,1,fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje 1 para Juan en fecha 24/03/2022 ");
        p.ver(obl.agregarMensaje(3,1,fecha).resultado, Retorno.Resultado.OK, "Se agrega  mensaje 2 para Juan en fecha 24/03/2022");
       
       //-------------------------------        
        fecha=formato.parse("25/03/2022");
       //-------------------------------
       
        p.ver(obl.insertarLineaEnPosicion(3,1,1).resultado, Retorno.Resultado.OK, "Se agrega linea 1 en blanco al mensaje 1 de Ana");
        p.ver(obl.insertarPalabraEnLinea(3,1,1,1,"Estoy").resultado, Retorno.Resultado.OK,"Se agrega palabra Estoy linea 1 mensaje 1");
        p.ver(obl.insertarPalabraEnLinea(3,1,1,2,"estacionando").resultado, Retorno.Resultado.OK,"Se agrega palabra estacionando linea 1 mensaje 1");
                        
        p.ver(obl.ingresarPalabraDiccionario("hola").resultado,Retorno.Resultado.OK,"Se agrega palabra al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("estacionando").resultado,Retorno.Resultado.OK,"Se agrega palabra al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("llegando").resultado,Retorno.Resultado.OK,"Se agrega palabra al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("Te").resultado,Retorno.Resultado.OK,"Se agrega palabra al diccionario");
        p.ver(obl.ingresarPalabraDiccionario("Estoy").resultado,Retorno.Resultado.OK,"Se agrega palabra al diccionario");
        
        p.ver(obl.imprimirDiccionario().resultado, Retorno.Resultado.OK, "palabras del diccionario");
        p.ver(obl.ImprimirTextoIncorrecto().resultado, Retorno.Resultado.OK, "Palabras que no estan en el diccionario");
       
       p.ver(obl.cantidadDeMensajes(5).resultado, Retorno.Resultado.OK, "Mensajes de Romina"); 
       p.ver(obl.cantidadDeMensajes(3).resultado, Retorno.Resultado.OK, "Mensajes de Ana"); 

       p.ver(obl.destruirSistemaMensajes().resultado, Retorno.Resultado.OK, "sistema eliminado");

       p.imprimirResultadosPrueba();
    }

}
