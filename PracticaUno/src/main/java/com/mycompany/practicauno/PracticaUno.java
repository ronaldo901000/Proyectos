package com.mycompany.practicauno;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ronaldo
 */
public class PracticaUno {
  static Scanner scanner = new Scanner (System.in);
     static  Random rand = new Random();


       //VARIABLES QUE ALMACENARAN TODO LO QUE EL REPORTE NECESITARA MAS ADELANTE EN EL DESARROLLO DEL JUEGO

    public static int[] juegoIniciado = new int[3]; // ARREGLO QUE ALMACENARA LA CANTIDAD DE VECES QUE SE HA INICIADO CADA JUEGO 0=Carrera de caballos, 1=anagramas en consola, 2=BattleShip
    public static int perderCarreraCaballos;
    public static int ganarCarreraCaballos;
    public static int caballoMasGanador;
    public static int ganarIaBattleship;
    public static int [] barcosDestruidos = new int [5];
    
       // COLORES para imprimir  en pantalla
    public static final String REINICIAR_COLOR = "\033[0m";
    public static final String LETRAS_ROJAS = "\033[91m";
    public static final String LETRAS_VERDES = "\033[32m";
    public static final String LETRAS_AMARILLAS = "\033[33m";
    public static final String LETRAS_MORADAS = "\033[35m";
    public static final String LETRAS_CELESTES = "\033[96m";
    public static final String LETRAS_BLANCAS_B = "\033[1;37m";
    public static final String LETRAS_NEGRAS_B = "\033[1;30m";
    public static final String LETRAS_VERDES_BR = "\033[92m";
    public static final String LETRAS_AMARILLAS_BR = "\033[93m";
    public static final String FONDO_NEGRO = "\033[40m";
    public static final String FONDO_ROJO = "\033[41m";
    public static final String FONDO_VERDE = "\033[42m";
    public static final String FONDO_AMARILLO = "\033[43m";
    public static final String FONDO_AZUL = "\033[44m";
    public static final String FONDO_MORADO = "\033[45m";
    public static final String FONDO_GRIS = "\033[100m";
    public static final String FONDO_ROJO_BR = "\033[101m";
    public static final String FONDO_VERDE_BR = "\033[102m";
    public static final String FONDO_AMARILLO_BR = "\033[103m";
    public static final String FONDO_AZUL_BR = "\033[104m";
    public static final String FONDO_MORADO_BR = "\033[105m";
    public static final String FONDO_CELESTE_BR = "\033[106m";

    //METODO MAIN SERVIRA PARA INICIALIZAR CADA JUEGO
    public static void main(String[] args) {
           int opcionSeleccionada;
           //Si no hay nada ingresado en el parametro de entrada
        if (args.length == 0) {
            opcionSeleccionada = 0;
        } else {
            opcionSeleccionada = parametroEntrada(args[0]);
        }
        if (opcionSeleccionada == 0) {
            //Mostrar el menu principal y guardar la opcion elegida
            opcionSeleccionada = menuPrincipal();
        }
        //INICIARA EL JUEGO SEGUN EL NUMERO QUE LE MANDE EL MENU PRINCIPAL
        if(opcionSeleccionada==1){
            
            juegoIniciado[0]++;
            carreraDeCaballos();
            menuFinJuego(opcionSeleccionada);
        }
        else if(opcionSeleccionada==2){
        
            juegoIniciado[1]++;
            anagramasEnConsola();
            menuFinJuego(opcionSeleccionada);
        }
        else if (opcionSeleccionada==3){
        juegoIniciado[2]++;
        battleship();
            menuFinJuego(opcionSeleccionada);
        }
        else if(opcionSeleccionada==4){
        reportes();
            menuFinJuego(opcionSeleccionada);
        }
    }
    
    //SUBPROGRAMA ENCARGADO DE MOSTRAR EL MENU PRINCIPAL (3 JUEGOS Y EL REPORTE)
    static int menuPrincipal() {
        int opcionElegida;
        
        System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO + "|                                          |"+REINICIAR_COLOR);
        System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO + "|------------- Menu Principal -------------|"+REINICIAR_COLOR);
        System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO + "|                                          |"+REINICIAR_COLOR);
        espacio();
        System.out.println("    " + LETRAS_AMARILLAS_BR + FONDO_NEGRO + "--------- Seleccione un juego (1-4)---------"+REINICIAR_COLOR);
        espacio();
        System.out.println(" ✔ 1 : Carrera de Caballos en el hipodromo");
        System.out.println(" ✔ 2:  Anagrama en Consola");
        System.out.println(" ✔ 3 : Battleship");
        System.out.println(" ✔ 4 : Reportes");
        System.out.println("");
        System.out.println("Ingrese cualquier otro numero para salir:");
        opcionElegida = leerNumero();
        limpiar(0);
        return opcionElegida;
    }
        
    //SUBPROGRAMA ENCARGADO DE MOSTRAR UN MENU AL FINAL DE CADA JUEGO PARA QUE EL JUGADOR DECIDA QUE HACER
        static void menuFinJuego(int numeroJuego) {
        String[] parametroInicio = new String[1];
        parametroInicio[0] = "0";
        int opcionElegida;
        System.out.println("");
        System.out.println( "    " + LETRAS_VERDES_BR + FONDO_NEGRO +"<<<<<<<Fin del juego>>>>>>"+REINICIAR_COLOR);
        System.out.println(LETRAS_AMARILLAS+"Ingresa"+REINICIAR_COLOR);
        System.out.println(LETRAS_VERDES+" ✔ 1 para volver a jugar            "+REINICIAR_COLOR);
        System.out.println(LETRAS_VERDES+" ✔ 2 para volver al menu principal  "+REINICIAR_COLOR);
        espacio();
        System.out.print(LETRAS_AMARILLAS+"Ingresa cualquier otro numero para salir del programa: "+REINICIAR_COLOR);
        
        opcionElegida = leerNumero();
        if (opcionElegida == 1) {
            System.out.print( "Volviendo al juego");
            limpiar(0);
            for (int i = 0; i < 5; i++) {
                System.out.print(" .");
              
            }
              delay(400);
                espacio();

            parametroInicio[0] = String.valueOf(numeroJuego);
            // Volver a ejecutar el programa con el parametro de entrada del juego seleccionado
            main(parametroInicio);
        } else if (opcionElegida == 2) {
            System.out.print( "Volviendo al menu principal");
            for (int i = 0; i < 3; i++) {
                System.out.print("    " + LETRAS_AMARILLAS+" .");
                limpiar(0);
                delay(600);
            }
            System.out.println();
            // Volver a ejecutar el programa con el parametro de entrada 0
            main(parametroInicio);
        }
        else{
        
            System.out.println(LETRAS_ROJAS+"PROGRAMA CERRADO");
        }
    }

               
        static void reportes(){
            
            System.out.println("    " + LETRAS_AMARILLAS_BR + FONDO_NEGRO + "|                                                        |"+REINICIAR_COLOR);         
            System.out.println("    " + LETRAS_AMARILLAS_BR + FONDO_NEGRO + "|----------------------- REPORTES -----------------------|"+REINICIAR_COLOR);
            System.out.println("    " + LETRAS_AMARILLAS_BR + FONDO_NEGRO + "|                                                        |"+REINICIAR_COLOR + "\n");
            System.out.println("         "+LETRAS_VERDES_BR+ FONDO_NEGRO+ " CANTIDAD DE VECES QUE SE HAN INICIADO LOS JUEGOS "+REINICIAR_COLOR+"\n");
            System.out.print("           "+LETRAS_VERDES+FONDO_NEGRO+"CARRERA DE CABALLOS: "+juegoIniciado[0]+REINICIAR_COLOR);
            System.out.print("       "+LETRAS_AMARILLAS+FONDO_NEGRO+"ANAGRAMAS EN CONSOLA: "+juegoIniciado[1]+REINICIAR_COLOR);
            System.out.print("        "+LETRAS_CELESTES+FONDO_NEGRO+"BATTLESHIP EN CONSOLA: "+juegoIniciado[2]+REINICIAR_COLOR + "\n");
            espacio();
            System.out.println("    " + LETRAS_VERDES + FONDO_NEGRO + "|------------------------ CARRERA DE CABALLOS ------------------------|"+REINICIAR_COLOR+"\n");
            System.out.println("    "+LETRAS_VERDES+FONDO_NEGRO+"Cantidad de partidas que se han ganado: "+ganarCarreraCaballos+REINICIAR_COLOR);
            System.out.println("    "+LETRAS_VERDES+FONDO_NEGRO+"Cantidad de partidas que se han perdido "+perderCarreraCaballos+REINICIAR_COLOR+"\n");
            System.out.println("    " + LETRAS_CELESTES + FONDO_NEGRO + "|------------------------- Battleship -------------------------|"+REINICIAR_COLOR+"\n");          
           espacio();
            System.out.println("  " +LETRAS_CELESTES + FONDO_NEGRO+"Cantidad de veces que el jugador le ha ganado a la IA: "+ganarIaBattleship+REINICIAR_COLOR);
        //System.out.println("    "+LETRAS_CELESTES+FONDO_NEGRO+"Cantidad de partidas que ha ganado: "+ganar2048+REINICIAR_COLOR);
       // System.out.println("    "+LETRAS_CELESTES+FONDO_NEGRO+"Cantidad de veces que ha salido del juego sin ganar: "+salir2048+REINICIAR_COLOR);
        
        String[] parametroInicio = new String[1];
        parametroInicio[0] = "0";
        int opcionElegida;
        System.out.println("");
        System.out.println("    " + LETRAS_VERDES + FONDO_NEGRO + "|                                                        |"+REINICIAR_COLOR);
        System.out.println("    " + LETRAS_VERDES + FONDO_NEGRO + "|------------------ FIN REPORTES -----------------------|"+REINICIAR_COLOR);
        System.out.println("    " + LETRAS_VERDES + FONDO_NEGRO + "|                                                        |"+REINICIAR_COLOR);
        System.out.println("");
        System.out.println("    ✔ Ingrese 1 para volver al menu principal");
        System.out.println("");
        System.out.println("   ✔ Ingrese cualquier otra tecla para salir");
        opcionElegida = leerNumero();
        if (opcionElegida == 1) {
            System.out.print(LETRAS_CELESTES + "Volviendo al menu principal");
            for (int i = 0; i < 3; i++) { //simulacion de que esta cargando (. . .)
                System.out.print(" .");
                delay(400);
                limpiar(0);
            }
            System.out.println(REINICIAR_COLOR);

            // Volver al menu principal
            main(parametroInicio);
        }

    }
        
        
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////INICIO CARRERA DE CABALLOS/////////////////////////////////////////////////////////////////////////////7
        //  /////////////SUBPROGRAMA PRINCIPAL <<<<<CARRERA DE CABALLOS>>>>>>>>>>//////////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        static void carreraDeCaballos(){
        
        final int PISTA=100;
        //VARIABLES NECESARIAS PARA EL JUEGO
             int cantidadCaballos=0;
             mostrarTituloInicioCarreraCaballos();
             espacio();
        cantidadCaballos=escogerCantidadCaballos();
       String[] colores = {"Verde", "Azul", "Amarillo", "Naranja", "Blanco", "Negro", "Rojo"};
        String colorCaballoJugador = seleccionarColorCaballo(colores, cantidadCaballos);
        int totalDados = escogerCantidadDados();
            limpiar(0);
        
          int[] sumaPuntajes = new int[cantidadCaballos];
        boolean carreraTerminada = false;
        System.out.println("    " + LETRAS_VERDES+FONDO_NEGRO+"<<<<<<LLEGAMOS AL HIPODROMO>>>>>>>"+REINICIAR_COLOR);
        System.out.println("    " + LETRAS_VERDES+FONDO_NEGRO+"<<<QUE COMIENCE LA CARRERA >>>>>>>>"+REINICIAR_COLOR);
        espacio();
        System.out.println("  "+LETRAS_AMARILLAS+FONDO_GRIS+"INSTRUCCIONES"+REINICIAR_COLOR);
        System.out.println("  "+LETRAS_CELESTES+ "> Si eliges tirar con precaucion la suma de los dados que saques seran las casillas que avances "+REINICIAR_COLOR);
        System.out.println("  "+LETRAS_CELESTES+"> Si eliges tirar arriesgado la suma de los dados tiene que ser un numero primo para que avances el doble de casillas, si no es primo NO avanzas"+REINICIAR_COLOR);
            espacio();
        delay(1000);
        
        
        while (!carreraTerminada) {
            for (int j = 0; j < cantidadCaballos; j++) {
                int sumaJugador = 0;
                int tipoEstrategia;

                if (colores[j].equals(colorCaballoJugador)) {

                    // Turno del jugador
                 

                    do{
                    System.out.println("    " + LETRAS_AMARILLAS+FONDO_NEGRO+"Turno del caballo " + colores[j]+REINICIAR_COLOR);
                    System.out.println(LETRAS_CELESTES+"✔1: Tiro con Precaución"+REINICIAR_COLOR);
                    System.out.println(LETRAS_CELESTES+"✔2: Tiro Arriesgado"+REINICIAR_COLOR);
                     tipoEstrategia= leerNumero();


                    
                    if (tipoEstrategia == 1) {
                        // Tiro con precaución
                        sumaJugador = lanzarDados(totalDados);
                        System.out.println("    " + LETRAS_CELESTES+"Has recorrido " + sumaJugador + " metros."+REINICIAR_COLOR);
                    } 
                    else if (tipoEstrategia == 2) {
                        // Tiro arriesgado
                        sumaJugador = lanzarDadosConRiesgo(totalDados);
                    }
                    } while(tipoEstrategia>2 || tipoEstrategia<1);
                    
  
                } 
                
                else {
                    // Turno del bot
                    System.out.println("Turno del caballo "+ colores[j]);
                    int numero = rand.nextInt(2)+1;
                    int seleccionBot = numero;
                    if(seleccionBot==1){
                        System.out.println("    " + LETRAS_AMARILLAS +"Tira con precausion!!!!!!");
                    sumaJugador = lanzarDados(totalDados);
                    System.out.println("    " + LETRAS_CELESTES+ "El caballo "+colores[j]+" ha recorrido " + sumaJugador + " metros."+REINICIAR_COLOR);
                    
                    }
                    else if(seleccionBot==2) {
                        System.out.println("    " + LETRAS_AMARILLAS +"Arriesgó veamos su suerte!!!!!!"+REINICIAR_COLOR);
                    sumaJugador= lanzarDadosConRiesgo(totalDados);
                    }

                }
                delay(500);
                espacio();

                sumaPuntajes[j] += sumaJugador;
                if (sumaPuntajes[j] >= PISTA) {
                    carreraTerminada = true;
                }

                delay(500); // Pausa entre turnos
            }

            limpiar(0);
             mostrarPosiciones(sumaPuntajes, colores);
             espacio();
            for(int i=0; i<cantidadCaballos; i++){
            
                for(int j=0; j<=sumaPuntajes[i]; j+=2){
                
                  //  System.out.print(sumaPuntajes[i]+"_");      
                    System.out.print("._");
                }
               
                System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO +"𓃗"+ "  "+colores[i]+" "+sumaPuntajes[i]+" metros. "+REINICIAR_COLOR);
            }
          
            espacio();
            
            delay(1000);
        }
        determinarGanador(sumaPuntajes, colorCaballoJugador, colores);

    }
    
             
        static int indiceSeleccionado = -1;
//SUBPROGRAMA ENCARGADO DE PREGUNTAR Y GUARDAR LA CANTIDAD E CABALLOS CON LA QUE SE VA A JUGAR
   
        static int escogerCantidadCaballos() {
            int opcion;
            int cantidadCaballos=0;
            do{
                System.out.println("    " + LETRAS_AMARILLAS + FONDO_AZUL +"QUIERES SELECCIONAR EL NUMERO DE CABALLOS O INICIAR EN MODO AUTOMATICO (7caballos)"+REINICIAR_COLOR);
                System.out.println("✔ 1: ELEGIR NUMERO DE CABALLOS");
                System.out.println("✔ 2: AUTOMATICO");
                opcion=leerNumero();
                if(opcion<1 || opcion>2){
                 
                    System.out.println(LETRAS_ROJAS+"numero incorrecto selecciona (1 o 2)"+REINICIAR_COLOR);
             
                }
         
            }while(opcion<1 || opcion>2);    
            if(opcion==1){
                do{
                    System.out.print("    " + LETRAS_AMARILLAS  +"INGRESA LA CANTIDAD DE CABALLOS (3 A 7): "+REINICIAR_COLOR);
                    opcion= leerNumero(); 
                    if(opcion<1 || opcion<3 || opcion>7){       
                        System.out.println("    " + LETRAS_ROJAS + FONDO_NEGRO +"numero incorrecto vuelve a intentar (3 a 7)"+REINICIAR_COLOR);
                    }
                    else{          
                        cantidadCaballos=opcion;
                    }  
                }while(opcion<3 || opcion>7);
            }
//SELECCION AUTOMATICA DE LOS CABALLOS (5)
            else if(opcion==2){
           
                cantidadCaballos=5;
            }
            return cantidadCaballos;
    
        }
               //SUBPROGRAMA ENCARGADO DE SELECCIONAR LA CANTIDAD DE DADOS CON LA QUE SE VA A JUGAR
 static int escogerCantidadDados() {
      int opcion;
      int opcionDados;
         int cantidadDados=0;
         
         do{
             System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO +"QUIERES SELECCIONAR EL NUMERO DE DADOS O INICIAR EN MODO AUTOMATICO (2 dados)"+REINICIAR_COLOR);
             System.out.println("✔ 1: ELEGIR NUMERO DE DADOS");
             System.out.println("✔ 2: AUTOMATICO");
             opcion=leerNumero();
             
             if(opcion<1 || opcion>2){
                 System.out.println(LETRAS_ROJAS+"numero incorrecto selecciona (1 o 2)"+REINICIAR_COLOR);
             }
        
         }while(opcion<1 || opcion>2);
        
        if(opcion==1){
            do{
            System.out.print("    " + LETRAS_AMARILLAS  +"INGRESA LA CANTIDAD DE DADOS (1 en adelante ):"+REINICIAR_COLOR);
            opcion= leerNumero();
            if(opcion<1){
                System.out.println("    " + LETRAS_ROJAS + FONDO_NEGRO +"numero incorrecto vuelve a intentar(1 en adelante)"+REINICIAR_COLOR);
            }
                       
            else{
                cantidadDados=opcion;
            }
             }while(opcion<1);
        }
//SELECCION AUTOMATICA DE LOS CABALLOS (5)
        else if(opcion==2){
            cantidadDados=2;
        }
        return cantidadDados;
    }
  
           //SUBPROGRAMA ENCARGADO DEL TIRO CON PRECAUCION
static int lanzarDados(int totalDados) {
    int suma = 0;

    for (int i = 0; i < totalDados; i++) {
        int resultadoDado = rand.nextInt(6) + 1;
        suma += resultadoDado;

        System.out.println(LETRAS_AMARILLAS + "Lanza el Dado " + (i + 1) + " sale " + resultadoDado + REINICIAR_COLOR);
        
        delay(500);
    }

    System.out.println(LETRAS_VERDES + "Suma de los dados: " + suma + REINICIAR_COLOR);
    
    return suma;
}

        
        //SUBPROGRAMA ENCARGADO DEL TIRO ARRIESGADO
          static int lanzarDadosConRiesgo(int totalDados) {
        int suma = lanzarDados(totalDados);
        if (esNumeroPrimo(suma)) {
            System.out.println("    " + LETRAS_NEGRAS_B+ FONDO_AMARILLO +"¡Saca numero primo! Avanza el doble de casillas!!  Avanza " + (suma * 2) + " metros."+REINICIAR_COLOR);
            return suma * 2;
        } else {
            System.out.println("    " + LETRAS_CELESTES+"No es número primo, no avanza."+REINICIAR_COLOR);
            return 0;
        }
    }

            

    static void mostrarTituloInicioCarreraCaballos(){
        System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO +"<<<<<CARRERA DE CABALLOS EN EL HIPODROMO>>>>>>>>"+REINICIAR_COLOR);
    }

     //SUBPROGRAMA ENCARGADO DE MOSTRAR Y GUARDAR EL COLOR DE CABALLO ESCOGIDO POR EL USUARIO
    static String seleccionarColorCaballo(String[] colores, int totalCaballos) {
        System.out.println("    " + LETRAS_AMARILLAS + FONDO_AZUL +"Colores disponibles:"+REINICIAR_COLOR);
        for (int i = 0; i < totalCaballos; i++) {
            System.out.println((i + 1) + ": " + colores[i]);
        }

        System.out.print("    " + LETRAS_AMARILLAS +"Selecciona el color de tu caballo: "+REINICIAR_COLOR);
        int seleccion = leerNumero();
        while (seleccion < 1 || seleccion > totalCaballos) {
            System.out.print("    " + LETRAS_ROJAS +"Selección inválida. Intenta de nuevo: "+REINICIAR_COLOR);
            seleccion = leerNumero();
        }

        return colores[seleccion - 1];
    }

//SUBPROGRAMA ENCARGADO DE VERIFICAR SI LA SUMA DE LAS CARAS DEL DADO DAN NUMERO PRIMO
    static boolean esNumeroPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }
    
    //SUBPROGRAMA ENCARGADO DE  IMPRIMIR LA POSICION DE CADA JUGADOR AL FINAL DE CADA TURNO
      static void mostrarPosiciones(int[] posiciones, String[] colores) {
        System.out.println("    " + LETRAS_AMARILLAS + FONDO_NEGRO +"\t<<<Posiciones actuales>>>"+REINICIAR_COLOR);
        for (int i = 0; i < posiciones.length; i++) {
            //System.out.println("Metros para llegar a la meta: " + LETRAS_AMARILLAS+"\t✔ "+colores[i] + ": " + (150-posiciones[i]) +" metros "+REINICIAR_COLOR);
            if(posiciones[i]>100){
                System.out.println(LETRAS_VERDES+"El caballo "+colores[i] + " ha llegado a la meta"+REINICIAR_COLOR);
            }
            else{
                System.out.println("Metros para llegar a la meta: " + LETRAS_AMARILLAS+"\t✔ "+colores[i] + ": " + (100-posiciones[i]) +" metros "+REINICIAR_COLOR);
            
            }
        }
    }
      
      //SUBPROGRAMA ENCARGADO DE EVALUAR SI ALGUNO DE LOS JUGADORES LLEGO A LA META
    static void determinarGanador(int[] posiciones, String colorCaballoJugador, String[] colores) {
    int meta = 0;
    int indiceGanador = 0;
    boolean empate = false;

    // Encontrar la posición máxima
    for (int i = 0; i < posiciones.length; i++) {
        if (posiciones[i] > meta) {
            meta = posiciones[i];
            indiceGanador = i;
            empate = false; 
        } else if (posiciones[i] == meta) {
            empate = true; // Hay empate 
        }
    }

    // Determinar si hay un empate en la meta
    if (empate) {
        System.out.println("    " + LETRAS_CELESTES + FONDO_MORADO + "¡Empate! Más de un caballo ha alcanzado la meta." + REINICIAR_COLOR);
        
    } else if (colores[indiceGanador].equals(colorCaballoJugador)) {
        System.out.println("    " + LETRAS_NEGRAS_B + FONDO_AMARILLO + "¡Felicidades! Tu caballo (" + colorCaballoJugador + ") ha ganado la carrera :)" + REINICIAR_COLOR);
        ganarCarreraCaballos++; // Guarda y acumula las veces que el jugador ganó
    } else {
        System.out.println("    " + LETRAS_CELESTES + FONDO_MORADO + "Lo siento, ha ganado el caballo " + colores[indiceGanador] + ":(" + REINICIAR_COLOR);
        perderCarreraCaballos++; // Guarda y acumula las veces que el jugador perdió
    }
}

    /////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
        //FIN  CARRERA DE CABALLOS
    //////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////
    
        /////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
        //INICIO ANAGRAMA EN CONSOLA
    //////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////
  
    
        //SUBPROGRAMA PRINCIPAL DEL JUEGO 2: ANAGRAMA EN CONSOLA
    static void anagramasEnConsola() {
        
        int INTENTOS = 12; // Límite de intentos
        String[] arregloEncontradas = new String[INTENTOS];
        int palabrasEncontradas = 0;
        
        String [] arregloNoAcertadas = new String [INTENTOS];
        int palabrasNoAcertadas =0;
        
        int longitudPalabraMinima = 3;

       
        String palabraDesordenada = seleccionarIndicePrincipal();
        seleccionarArregloSecundario();

         mostrarTituloAnagramas();
         espacio();
         System.out.println(" "+LETRAS_VERDES+FONDO_NEGRO+"INSTRUCCIONES DE JUEGO"+REINICIAR_COLOR);
         System.out.println(" "+LETRAS_AMARILLAS+"✔ Debes encontrar las 7 palabras escondidas en la siguiente palabra, tienes 12 intentos"+REINICIAR_COLOR);
         System.out.println(" "+LETRAS_AMARILLAS+"✔ Debe ingresar palabras como minimo contengan 3 letras"+REINICIAR_COLOR);
         System.out.println(" "+ LETRAS_AMARILLAS+"✔ Si ingresas numeros o caracteres especiales se contará como un intento");
         espacio();
        System.out.println(" "+LETRAS_CELESTES+FONDO_NEGRO+"COMENCEMOS"+REINICIAR_COLOR);
        espacio();
        delay(1000);
        
        int intentosRestantes = INTENTOS;
        while (intentosRestantes > 0 && palabrasEncontradas< arregloSecundario.length) {
            
            System.out.println(""+LETRAS_AMARILLAS+FONDO_NEGRO+"Palabra desordenada: " + palabraDesordenada+REINICIAR_COLOR);    
            System.out.print("Ingresa una palabra:");     
            String palabraIngresada = scanner.nextLine();      
            palabraIngresada = palabraIngresada.toUpperCase();  
            System.out.println(palabraIngresada);
                    
                    
            // Validar longitud y caracteres permitidos
            if (palabraIngresada.length() < longitudPalabraMinima || !palabraIngresada.matches("[A-ZÑ]*")) {
                System.out.println(LETRAS_ROJAS+"Error: La palabra debe tener al menos " + longitudPalabraMinima + " letras y no contener caracteres especiales."+REINICIAR_COLOR);
                espacio();
            }

            // Validar si la palabra ingresada es válida y no ha sido ingresada antes
            else if (esValida(palabraIngresada, arregloSecundario) && !yaIngresada(palabraIngresada, arregloEncontradas, palabrasEncontradas)) {
                arregloEncontradas[palabrasEncontradas] = palabraIngresada;//Guarda cada palabra encontrada para luego mostrarla en una lista
                palabrasEncontradas++;
                System.out.println(LETRAS_VERDES+FONDO_GRIS+"¡Correcto! Palabras encontradas: " + palabrasEncontradas + "/" + arregloSecundario.length+REINICIAR_COLOR);
                espacio();
            } else {
                System.out.println(LETRAS_AMARILLAS_BR+"Palabra no válida o ya encontrada."+REINICIAR_COLOR);
                espacio();
                arregloNoAcertadas[palabrasNoAcertadas] = palabraIngresada;
                palabrasNoAcertadas++;

            }
            delay(1000);
            limpiar(0);
            
            mostrarTituloAnagramas();
            espacio();
            
            for (int i=0; i<1; i++){
                System.out.println("                    \t"+LETRAS_CELESTES+FONDO_NEGRO+"PALABRAS ACERTADAS:"+REINICIAR_COLOR);
                for(int j=0; j< palabrasEncontradas; j++){
                    System.out.println("                    \t"+LETRAS_CELESTES+FONDO_GRIS+"✔ "+arregloEncontradas[j]+REINICIAR_COLOR);
                    delay(300);
                    
                }
            }
            espacio();

                        for (int i=0; i<1; i++){
                System.out.println("                    \t"+LETRAS_CELESTES+ FONDO_NEGRO+"PALABRAS NO ACERTADAS O REPETIDAS:"+REINICIAR_COLOR);
                for(int j=0; j< palabrasNoAcertadas; j++){
                    System.out.println("                \t"+LETRAS_CELESTES+FONDO_GRIS+"✖ "+arregloNoAcertadas[j]+REINICIAR_COLOR);
                    delay(300);
                    
                }
            }
            espacio();
       
            intentosRestantes--;
            System.out.println(LETRAS_VERDES+"Intentos restantes: " + intentosRestantes);
            espacio();
        }

        // Resultado final
        if (palabrasEncontradas == arregloSecundario.length) {
            System.out.println(LETRAS_AMARILLAS_BR+FONDO_NEGRO+"¡Felicidades! Has encontrado todas las palabras.");
        } else {
            System.out.println(LETRAS_CELESTES+FONDO_MORADO_BR+"Juego terminado. No encontraste todas las palabras."+REINICIAR_COLOR);
            mostrarArregloSecundario(); // Muestra las palabras posibles
        }
    }
    static void mostrarTituloAnagramas() {
        System.out.println(""+LETRAS_CELESTES+FONDO_NEGRO+"|-------------------------------|"+REINICIAR_COLOR);
        System.out.println(""+LETRAS_CELESTES+FONDO_NEGRO+"|<<<<<ANAGRAMAS EN CONSOLA>>>>>>|"+REINICIAR_COLOR);
        System.out.println(""+LETRAS_CELESTES+FONDO_NEGRO+"|_______________________________|"+REINICIAR_COLOR);
                
    }

    static String seleccionarIndicePrincipal() {
        String[] palabraPrincipal = {"CARTONES", "PLANETAS", "REACTIVO", "RENDICION", "RENDIMOS", "CAMINERO", "MADEROS"};
        indiceSeleccionado = rand.nextInt(palabraPrincipal.length);
        return mezclarLetras(palabraPrincipal[indiceSeleccionado]);
    }

    // Método para mezclar las letras de una palabra
    public static String mezclarLetras(String palabra) {
        char[] letras = palabra.toCharArray();
        for (int i = 0; i < letras.length; i++) {
            int aleatorio = rand.nextInt(letras.length);
            char original = letras[i];
            letras[i] = letras[aleatorio];
            letras[aleatorio] = original;
        }
        return new String(letras);
    }

    // Método para seleccionar en la matriz la fila basado en el índice seleccionado 
    static void seleccionarArregloSecundario() {
        String[][] palabras = {
            {"COSTA", "CRANEOS", "CORTES", "TARSON", "CANTO", "CAN", "SER"},//1 numero de fila
            {"PLANTA", "LENTA", "TELA", "SALA", "TAPA", "SALTA", "LATA"},//2
            {"VICTOR", "ACTOR", "RATO", "RICO", "ROCA", "TIRO", "TACO"},//3
            {"CREDO", "CIEN", "ONCE", "DINERO", "CINE", "DON", "RED"},//4
            {"MIRON", "MODER", "DINERO", "SERIO", "RENOS", "DIERON", "NIDO"},
            {"CAMINO", "NACER", "ROMA", "RAMO", "MANO", "MAR", "CINE"},
            {"RAMOS", "SODA", "ROSA", "MODAS", "ROMA", "RAMO", "SERA"}
        };
        arregloSecundario = palabras[indiceSeleccionado];
    }

    // Método para mostrar el arreglo secundario
    static void mostrarArregloSecundario() {
        System.out.println("Las palabras posibles eran:");
        for (int i = 0; i < arregloSecundario.length; i++) {
            System.out.println("✔ "+LETRAS_AMARILLAS+arregloSecundario[i]+REINICIAR_COLOR);
        }
    }
      static String[] arregloSecundario = new String[7];

//SUBPROGRAMA DE VERIFICAR SI LA PALABRA ES VALIDA
    static boolean esValida(String palabra, String[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (palabra.equals(arreglo[i])) {
                return true;
            }
        }
        return false;
    }

    // SUBPROGRAMA ENCARGADO DE VERIFICAR SI UNA PALABRA YA A SIDO ENCONTRADA
    static boolean yaIngresada(String palabra, String[] palabrasEncontradas, int num) {
        for (int i = 0; i < num; i++) {
            if (palabra.equals(palabrasEncontradas[i])) {
                return true;
            }
        }
        return false;
    }
    /////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
        //FIN  ANAGRAMA EN CONSOLA
    //////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////
    
    
    
    /////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
        //INICIO BATTLESHIP EN CONSOLA
    //////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////
    
         
//SUBPROGRAMA PRINCIPAL BATTLESHIP
static void battleship() {
    mostrarTituloBattleship();
    espacio();
    int tamanoTablero = solicitarTamañoTablero();
    espacio();
    int totalBarcos = solicitarTotalBarcos();
    delay(300);
    limpiar(0);

    int opcion;

    char[] tiposBarcos = {'C', 'B', 'R', 'S', 'D'};
    int[] tamaniosBarcos = {5, 4, 3, 2, 1};
    int[] cantidadBarcos = new int[tiposBarcos.length];

    seleccionarBarcos(tiposBarcos, tamaniosBarcos, cantidadBarcos, totalBarcos);

    char[][] tableroJugador1 = inicializarTablero(tamanoTablero);
    char[][] tableroJugador2 = inicializarTablero(tamanoTablero);
    char[][] vistaTableroOponente1 = inicializarTablero(tamanoTablero);
    char[][] vistaTableroOponente2 = inicializarTablero(tamanoTablero);

    do {
        System.out.println(LETRAS_VERDES+FONDO_NEGRO+"|<<<<SELECCIONA EL MODO DE JUEGO>>>>>>>|"+REINICIAR_COLOR);
        System.out.println(LETRAS_CELESTES+"✔ 1. |<<<<<<<JUGADOR - VS - JUGADOR>>>>>>>|"+REINICIAR_COLOR);
        System.out.println(LETRAS_CELESTES+"✔ 2. |<<<<<JUGADOR - VS - COMPUTADORA>>>>|"+REINICIAR_COLOR);
        opcion = leerNumero();
        espacio();
        
        delay(400);
        if (opcion == 1) {
            mostrarTituloBattleship();
            espacio();
            delay(400);
            System.out.println(LETRAS_NEGRAS_B+FONDO_VERDE+"Jugador 1, coloca tus barcos:"+REINICIAR_COLOR);
            pedirPosicionBarco(tableroJugador1, tiposBarcos, tamaniosBarcos, cantidadBarcos, tamanoTablero, scanner);
            delay(400);
            limpiar(0);
            System.out.println(LETRAS_NEGRAS_B+FONDO_VERDE+"Jugador 2, coloca tus barcos:"+REINICIAR_COLOR);
            pedirPosicionBarco(tableroJugador2, tiposBarcos, tamaniosBarcos, cantidadBarcos, tamanoTablero, scanner);
            delay(400);
        } else if (opcion == 2) {
            mostrarTituloBattleship();
            espacio();
            delay(400);
            System.out.println(LETRAS_NEGRAS_B+FONDO_VERDE+"Jugador 1, coloca tus barcos:"+REINICIAR_COLOR);
            pedirPosicionBarco(tableroJugador1, tiposBarcos, tamaniosBarcos, cantidadBarcos, tamanoTablero, scanner);
            
            System.out.println(LETRAS_NEGRAS_B+FONDO_VERDE+"La computadora está colocando sus barcos..."+REINICIAR_COLOR);
            colocarBarcosIA(tableroJugador2, tiposBarcos, tamaniosBarcos, cantidadBarcos, tamanoTablero);
            
            
        }
    } while (opcion > 2 || opcion < 1);
    delay(400);
    limpiar(0);

    boolean turnoJugador1 = true;
    boolean juegoTerminado = false;

    while (!juegoTerminado) {
        char[][] tableroActual;
        char[][] vistaTableroOponente;

        // Determinar el tablero actual y la vista del tablero del oponente
        if (turnoJugador1) {
            tableroActual = tableroJugador2;
            vistaTableroOponente = vistaTableroOponente1;
        } else {
            tableroActual = tableroJugador1;
            vistaTableroOponente = vistaTableroOponente2;
        }

        imprimirTablero(vistaTableroOponente, tamanoTablero);
        delay(400);

        // Determinar el mensaje para el turno
        if (turnoJugador1) {
            System.out.println(LETRAS_VERDES+FONDO_GRIS+"Ataca, Turno del  Jugador 1:"+REINICIAR_COLOR);
        } else {
            if (opcion == 1) {
                System.out.println(LETRAS_VERDES+FONDO_GRIS+"Ataca, Turno del Jugador 2:"+REINICIAR_COLOR);
            } else {
                System.out.println(LETRAS_VERDES+FONDO_GRIS+"Ataca, Turno de la Computadora:"+REINICIAR_COLOR);
                delay(300);
           
                
            }
        }

        int fila = -1, columna = -1; //-1 para tomar en cuenta todas las filas y columnas
        boolean ataqueValido = false;

        // Solicitar fila y columna dependiendo si es el jugador o computadora
        while (!ataqueValido) {
            if (turnoJugador1 || opcion == 1) {
                
                fila = solicitarFila(scanner, tamanoTablero);
                columna = solicitarColumna(tamanoTablero);
            } else {
                Random rand = new Random();
                fila = rand.nextInt(tamanoTablero);
                columna = rand.nextInt(tamanoTablero);
            }

            // Realizar ataque y verificar si el ataque es válido
            
            ataqueValido = atacar(tableroActual, vistaTableroOponente, fila, columna);
            espacio();
            espacio();
            delay(1000);
        }

        limpiar(0);
        // Verificar si el juego ha terminado
      juegoTerminado = verificarJuegoTerminado(tableroActual);
        if (juegoTerminado) {
            if (turnoJugador1) {
                System.out.println(LETRAS_VERDES + "Jugador 1 ha hundido todos los barcos. ¡Ganador!" + REINICIAR_COLOR);
                if (opcion == 2) {
                    ganarIaBattleship++;
                }
            } else {
                if (opcion == 1) {
                    System.out.println(LETRAS_VERDES + "Jugador 2 ha hundido todos los barcos. ¡Ganador!" + REINICIAR_COLOR);
                } else {
                    System.out.println(LETRAS_VERDES + "La Computadora ha hundido todos los barcos. ¡Ganador!" + REINICIAR_COLOR);
                }
            }

        } else {
            turnoJugador1 = !turnoJugador1;
        }
    }
}

static boolean atacar(char[][] tablero, char[][] vistaTablero, int fila, int columna) {
    // Verificar si la fila y columna están dentro del rango
    if (fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[0].length) {
        System.out.println(LETRAS_ROJAS+"Error: Fila o columna fuera del rango permitido. Inténtalo de nuevo."+REINICIAR_COLOR);
        return false; // Ataque inválido
    }

    // Verificar si ya se atacó esa posición
    if (vistaTablero[fila][columna] != '~') {
        System.out.println(LETRAS_VERDES+"Ya has atacado esta posición. Inténtalo de nuevo."+REINICIAR_COLOR);
        return false; // Ataque inválido
    }

    // Procesar el ataque
    if (tablero[fila][columna] == '~') {
        vistaTablero[fila][columna] = 'O';
        System.out.println(LETRAS_VERDES+"Agua."+REINICIAR_COLOR);
        delay(1000);
        espacio();
        espacio();
    } else {
        vistaTablero[fila][columna] = 'X';
        char tipoBarco = tablero[fila][columna];
        tablero[fila][columna] = 'X';
        System.out.println(LETRAS_VERDES+"Tocado."+REINICIAR_COLOR);
        delay(1000);
        espacio();
        espacio();
        
        if (verificarHundimiento(tablero, tipoBarco)) {
            
            System.out.println(LETRAS_AMARILLAS+FONDO_GRIS+"¡Hundiste  " + obtenerNombreBarco(tipoBarco) + "!"+REINICIAR_COLOR);
            
            delay(1000);
            espacio();

        }
    }

    return true; // Ataque válido
}



    
    static void pedirPosicionBarco(char[][] tablero, char[] tiposBarcos, int[] tamañosBarcos, int[] cantidadBarcos, int tamañoTablero, Scanner scanner) {
        for (int i = 0; i < tiposBarcos.length; i++) {
            for (int j = 0; j < cantidadBarcos[i]; j++) {
                boolean barcoColocado = false;
                while (!barcoColocado) {
                    espacio();
                    System.out.println(" "+LETRAS_AMARILLAS+FONDO_NEGRO+"Coloca tu " + obtenerNombreBarco(tiposBarcos[i]) + " (tamaño " + tamañosBarcos[i] + ")"+REINICIAR_COLOR);
                    System.out.println(" "+LETRAS_CELESTES+FONDO_GRIS+"Ingresa la fila y columna inicial"+REINICIAR_COLOR);
                    espacio();
                    imprimirTablero(tablero, tamañoTablero); // Mostrar tablero antes de colocar el barco
                    int filaInicio = solicitarFila(scanner, tamañoTablero);
                    int columnaInicio = solicitarColumna(tamañoTablero);//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    System.out.println(" "+LETRAS_CELESTES+FONDO_GRIS+"Ingresa la fila y columna final"+REINICIAR_COLOR);
                    int filaFin = solicitarFila(scanner, tamañoTablero);
                    int columnaFin = solicitarColumna(tamañoTablero);//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

                    if (verificarColocacionValida(tablero, filaInicio, columnaInicio, filaFin, columnaFin, tamañosBarcos[i])) {
                        colocarBarco(tablero, tiposBarcos[i], filaInicio, columnaInicio, filaFin, columnaFin);
                        barcoColocado = true;
                    } else {
                        System.out.println(LETRAS_ROJAS+FONDO_NEGRO+"No se puede colocar el barco aquí. Intenta de nuevo."+REINICIAR_COLOR);
                    }
                }
            }
        }
    }


    static void colocarBarcosIA(char[][] tablero, char[] tiposBarcos, int[] tamañosBarcos, int[] cantidadBarcos, int tamañoTablero) {
        
        Random rand = new Random();
        for (int i = 0; i < tiposBarcos.length; i++) {
            for (int j = 0; j < cantidadBarcos[i]; j++) {
                boolean barcoColocado = false;
                while (!barcoColocado) {
                    int filaInicio = rand.nextInt(tamañoTablero);
                    int columnaInicio = rand.nextInt(tamañoTablero);
                    int direccion = rand.nextInt(2); // 0 para horizontal, 1 para vertical

                    int filaFin = filaInicio;
                    int columnaFin = columnaInicio;

                    if (direccion == 0) {
                        columnaFin = columnaInicio + tamañosBarcos[i] - 1;
                    } else {
                        filaFin = filaInicio + tamañosBarcos[i] - 1;
                    }

                    if (filaFin < tamañoTablero && columnaFin < tamañoTablero && verificarColocacionValida(tablero, filaInicio, columnaInicio, filaFin, columnaFin, tamañosBarcos[i])) {
                        colocarBarco(tablero, tiposBarcos[i], filaInicio, columnaInicio, filaFin, columnaFin);
                        barcoColocado = true;
                    }
                }
            }
        }
    }




    
    static boolean verificarHundimiento(char[][] tablero, char tipoBarco) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == tipoBarco) {
                    return false; // Aún quedan partes del barco sin hundir
                }
            }
        }
        return true;
    }

    
    static boolean verificarJuegoTerminado(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != '~' && tablero[i][j] != 'X') {
                    return false;
                }
            }
        }
        return true;
    }
    
    static void colocarBarco(char[][] tablero, char tipoBarco, int filaInicio, int columnaInicio, int filaFin, int columnaFin) {
    int filaMinima, filaMaxima, columnaMinima, columnaMaxima;

    // Determinar filaMinima y filaMaxima
    if (filaInicio < filaFin) {
        filaMinima = filaInicio;
        filaMaxima= filaFin;
    } else {
        filaMinima = filaFin;
        filaMaxima = filaInicio;
    }

    // Determinar columnaMinima y columnaMaxima
    if (columnaInicio < columnaFin) {
        columnaMinima = columnaInicio;
        columnaMaxima = columnaFin;
    } else {
        columnaMinima = columnaFin;
        columnaMaxima= columnaInicio;
    }

    // Colocar el barco en el tablero
    for (int fila = filaMinima; fila <= filaMaxima; fila++) {
        for (int columna = columnaMinima; columna <= columnaMaxima; columna++) {
            tablero[fila][columna] = tipoBarco;
        }
    }
}
    
    static boolean verificarColocacionValida(char[][] tablero, int filaInicio, int columnaInicio, int filaFin, int columnaFin, int tamañoBarco) {
        // Verificar si la colocación es diagonal
        if (filaInicio != filaFin && columnaInicio != columnaFin) {
            return false; // No se permite la colocación diagonal
    }

    // Verificar si las filas y columnas están dentro del rango permitido
    if (filaInicio < 0 || filaInicio >= tablero.length || filaFin < 0 || filaFin >= tablero.length ||
        columnaInicio < 0 || columnaInicio >= tablero[0].length || columnaFin < 0 || columnaFin >= tablero[0].length) {
        System.out.println(" "+LETRAS_ROJAS+"Error Selección fuera del tablero Inténtalo de nuevo."+REINICIAR_COLOR);
        return false;
    }

    // Verificar si la longitud coincide con el tamaño del barco
    int diferenciaFilas, diferenciaColumnas;

    if (filaInicio > filaFin) {
        diferenciaFilas = filaInicio - filaFin;
    } else {
        diferenciaFilas = filaFin - filaInicio;
    }

    if (columnaInicio > columnaFin) {
        diferenciaColumnas = columnaInicio - columnaFin;
    } else {
        diferenciaColumnas = columnaFin - columnaInicio;
    }

    if ((diferenciaFilas + 1 != tamañoBarco) && (diferenciaColumnas + 1 != tamañoBarco)) {
        return false; // La longitud no coincide con el tamaño del barco
    }

    // Determinar el mínimo y máximo de filas y columnas
    int filaMinima, filaMaxima, columnaMinima, columnaMaxima;

    if (filaInicio < filaFin) {
        filaMinima = filaInicio;
        filaMaxima = filaFin;
    } else {
        filaMinima = filaFin;
        filaMaxima = filaInicio;
    }

    if (columnaInicio < columnaFin) {
        columnaMinima = columnaInicio;
        columnaMaxima = columnaFin;
    } else {
        columnaMinima = columnaFin;
        columnaMaxima = columnaInicio;
    }

    // Verificar si el espacio está libre en el tablero
    for (int fila = filaMinima; fila <= filaMaxima; fila++) {
        for (int columna = columnaMinima; columna <= columnaMaxima; columna++) {
            if (tablero[fila][columna] != '~') {
                return false; // El espacio ya está ocupado
            }
        }
    }

    return true;
}

    
        static int solicitarTamañoTablero() {
            int tamaño;
        do {
            System.out.println(" "+LETRAS_AMARILLAS_BR+FONDO_NEGRO+" SELECCION DEL TABLERO PARA LA PARTIDA "+REINICIAR_COLOR);
            System.out.print(" "+LETRAS_CELESTES+"Ingresa el tamaño del tablero (mínimo 11x11, máximo 26x26):"+REINICIAR_COLOR);
            tamaño =leerNumero();//guarda el tamaño del tablero para despues imprimirlo 
            if(tamaño<11 || tamaño>26){
                System.out.println(LETRAS_ROJAS+"error!! selecciona en el rango de 11 a 26"+REINICIAR_COLOR);
            
            }
        } while (tamaño < 11 || tamaño > 26);
        return tamaño;
    }

    static int solicitarTotalBarcos() {
        int total;
        do {
            System.out.println(" "+LETRAS_AMARILLAS+FONDO_NEGRO+"SELECCION DE BARCOS PARA LA PARTIDA"+REINICIAR_COLOR);
            System.out.print(" "+LETRAS_CELESTES+"Ingresa el total de barcos para la partida (1-20): "+REINICIAR_COLOR);
            total = leerNumero();
            if(total<1 || total>20){
            
                System.out.println(LETRAS_ROJAS+"error!! selecciona en el rango de 1 a 20"+REINICIAR_COLOR);
            }
        } while (total < 1 || total > 20);
        return total;
    }

    //SUBPROGRAMA ENCARGADO DE GUARDAR LOS BARCOS SELECCIONADOS DEL JUGADOR O LOS JUGADORES
    static void seleccionarBarcos( char[] tiposBarcos, int[] tamañosBarcos, int[] cantidadBarcos, int totalBarcos) {
        int barcosSeleccionados = 0;

        mostrarTituloBattleship();
        for (int i = 0; i < tiposBarcos.length && barcosSeleccionados < totalBarcos; i++) {
            int cantidad;
            do {
                System.out.println(" "+LETRAS_AMARILLAS+"Selecciona la cantidad de " + obtenerNombreBarco(tiposBarcos[i]) + " (Tamaño " + tamañosBarcos[i] +REINICIAR_COLOR+" ) "+LETRAS_ROJAS+ " Te quedan por seleccionar " + (totalBarcos - barcosSeleccionados) + " Barcos"+REINICIAR_COLOR);
                cantidad = leerNumero();
                
            } while (cantidad < 0 || cantidad + barcosSeleccionados > totalBarcos);

            cantidadBarcos[i] = cantidad;
            barcosSeleccionados += cantidad;
        }
    }

    //LLENA EL TABLERO CON EL SIMBOLO "~" 
    static char[][] inicializarTablero(int tamaño) {
        char[][] tablero = new char[tamaño][tamaño];
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                tablero[i][j] = '~';
            }
        }
        return tablero;
    }

    //SUBPROGRAMA ENCARGADO DE IMPRIMIR EN PANTALLA EL TABLERO Y LA SELECCION DEL USUARIO
    static void imprimirTablero(char[][] tablero, int tamaño) {
        System.out.print(" "+LETRAS_AMARILLAS+"  "+REINICIAR_COLOR); //ESPACIO ENTRE NUMERO Y NUMERO EN LAS COLUMNAS
        for (int i = 1; i <= tamaño; i++) {
            System.out.print(" "+LETRAS_AMARILLAS+(i) + " "+REINICIAR_COLOR);
        }
        System.out.println();
        for (int i = 0; i < tamaño; i++) {
            System.out.print(" "+LETRAS_AMARILLAS+(char) ('A' + i) + " "+REINICIAR_COLOR);
            for (int j = 0; j < tamaño; j++) {
                System.out.print(" "+LETRAS_AMARILLAS+tablero[i][j] + " "+REINICIAR_COLOR);
            }
            System.out.println();
        }
    }

    
// PEDIRA LA FILA YA SEA PARA COLOCAR BARCOS O ATACAR 
    static int solicitarFila(Scanner scanner, int tamañoTablero) {
        System.out.print(" "+LETRAS_CELESTES+"Ingresa la fila (A-" + (char) ('A' + tamañoTablero - 1) + "): "+REINICIAR_COLOR);
        int fila = scanner.next().toUpperCase().charAt(0) - 'A';
        return fila;
}
//PEDIRA LA COLUMNA YA SEA PARA PONER BARCOS O ATACAR
    static int solicitarColumna(int tamañoTablero) {
        System.out.print(" "+LETRAS_CELESTES+"Ingresa la columna (1-" + tamañoTablero + "): "+REINICIAR_COLOR);
        int columna =leerNumero()-1;
        return columna;
    }

    //SUBPROGRAMA ENCARGADO DE PROPORCIONAR LOS NOMBRES Y LOS SIMBOLOS DE LOS BARCOS
    static String obtenerNombreBarco(char tipoBarco) {
        switch (tipoBarco) {
            case 'C': return "Portaaviones";
            case 'B': return "Acorazado";
            case 'R': return "Crucero";
            case 'S': return "Submarino";
            case 'D': return "Destructor";
            default: return "Barco";
        }
    }
    
    static void mostrarTituloBattleship(){
        System.out.println(" "+LETRAS_VERDES_BR+FONDO_NEGRO+"|<                   >|"+REINICIAR_COLOR);
        System.out.println(" "+LETRAS_VERDES_BR+FONDO_NEGRO+"|------BATTLESHIP-----|"+REINICIAR_COLOR);
        System.out.println(" "+LETRAS_VERDES_BR+FONDO_NEGRO+"|<                   >|"+REINICIAR_COLOR);
    
    
    }
    
 

       
    /////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////
        //FIN BATTLESHIP EN CONSOLA
    //////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //SUBPROGRAMAS CON FUNCIONALIDADES GENERALES PARA LOS DEMAS JUEGOS y REPORTE ETC
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    static void delay(int tiempoMilisegundos) {
        try {
            Thread.sleep(tiempoMilisegundos);
        } catch (InterruptedException ex) {
        }
    }
            
    
    public static int leerNumero() {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                numero = scanner.nextInt();
                entradaValida = true;  // SI INGRESA UN INTERO SE TOMA COMO VALIDA 
            } catch (InputMismatchException e) {
                System.out.println("    " + LETRAS_ROJAS + FONDO_NEGRO +"Error: Entrada no válida. Debes ingresar un número entero."+REINICIAR_COLOR);
                scanner.next(); //NO TOMA COMO VALIDA EL VALOR NO ENTERO, VUELVE A PEDIR UN ENTERO
            }
        }

        return numero;
    }

    static int parametroEntrada(String entrada) {
        int juegoSeleccionado;
        try {
            //Si el parametro de entrada corresponde a una opcion elegible
            if (entrada.matches("[0-4]*") && entrada.length() == 1) {
                juegoSeleccionado = Integer.parseInt(entrada);
            } //Si el parametro de entrada no es valido
            else {
                error("");
                System.out.println( LETRAS_ROJAS+"\"" + entrada +  " No es un parametro de entrada valido"+REINICIAR_COLOR);
                limpiar(1200);
                juegoSeleccionado = 0;
            }
        } catch (NumberFormatException e) {
            juegoSeleccionado = 0;
        }
        return juegoSeleccionado;
    }
                   
    static void error(String texto) {
        System.out.println(LETRAS_ROJAS+" Error: " + texto+REINICIAR_COLOR );
    }
                         
    static void espacio(){
        System.out.println("");
    }
           
    static void limpiar(int tiempoMilisegundos) {
        try {
            Thread.sleep(tiempoMilisegundos);
        } catch (InterruptedException ex) {
        }
        System.out.print("\033c");
        System.out.flush();
    }
    
}
