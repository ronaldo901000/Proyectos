/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practicauno;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ronaldo
 */
public class PracticaUno {

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
    
    //Scanner y aletoriedad para toda el programa principal y los subprogramas
      static Scanner scanner = new Scanner (System.in);
     static  Random rand = new Random();
     
     //Arreglos y variables que serán contadores para el reporte
     public static int [] juegoIniciado  = new int [2];//alamacena las veces que el jugador inicia un juego (indice 0=RPG, indice 1=Carreras)
    public static int jugadorPierdeRPG;
    public static int jugadorEntraBatallaRpg;
    public static int botGanaCarrera;
    public static int jugadorGanaCarrera;
    
    public static void main(String[] args) {
        int opcionSeleccionada;
        
        if(args.length==0){
            opcionSeleccionada=0;
        }else{
            opcionSeleccionada= parametroEntrada(args[0]);
        }
        if (opcionSeleccionada==0){
            opcionSeleccionada=menuPrincipal();
        }
        
        //Inicio del juego o reporte segun el numero que ingrese el usuario desde el menú principal
        
        if(opcionSeleccionada==1){
            juegoIniciado[0]++; // contador de veces iniciadas en el juego
            juegoRpg();
            menuFinJuego(opcionSeleccionada);
        }
        else if(opcionSeleccionada==2){
            juegoIniciado[1]++;
            juegoCarreras();
            menuFinJuego(opcionSeleccionada);
        }
        
    }
    //////////////////////////////INICIO RPG//////////////////////////////////////////////////////////////////////////////////
    //////////////////Subprograma controlador juego RPG////////////////////////////////////////////////
    static void juegoRpg(){
        
    
    
    }
    
    /////////////////////////////FIN RPG/////////////////////////////////////////////////////////////////////////////
    
    
    
    //////////////////////////////INICIO CARRERAS////////////////////////////////////////////////////////////////
    ///////////////////////subprograma controlador juego Carreras///////////////////////////////////////
    static void juegoCarreras(){
        opcionTipoRival();
        
    }
    static int seleccionTamañoPista(){
        int opcion;
        final int PISTA;
        System.out.println("Tamaño de Pista");
        System.out.println("✔1. Pista Corta");
        System.out.println("✔2. Pista Media");
        System.out.println("✔3Pista Larga");
        opcion=leerNumero();
        PISTA=opcioneDePista(opcion);
        
        System.out.println("TAMAÑO DE LA PISTA: "+PISTA);
        
        return PISTA;
    }
    
    static int opcioneDePista(int opcionPista){
         int tamañoPista=0;
         if(opcionPista==1){
             tamañoPista=50;
         }
         else if(opcionPista==2){
             tamañoPista=100;
         }
         else if (opcionPista==3){
             tamañoPista=150;
         }
         return tamañoPista;
    }
    
    static void opcionTipoRival(){
        int opcion=0;
        
        do{
            
            System.out.println("Seleccione contra quien quiere competir");
            System.out.println("✔1: Jugador (tú) VS Jugador");
            System.out.println("✔2: Jugador(tú) VS Bot");
            opcion=leerNumero();
            if(opcion<=0 || opcion>2){
                System.out.println("Seleccione solo valores indicados");
        }
        }while(opcion<=0 || opcion>2);
        if(opcion==1){
            iniciarPartidaJugadorVsJugador();
        }
        else if(opcion==2){
            iniciarPartidaJugadorVsBot();
        }
    }
    
    
    static void iniciarPartidaJugadorVsJugador(){
        final int PISTA = seleccionTamañoPista();
        int cantidadJugadores=2;
        String [] nombreDeJugadores= nombres(cantidadJugadores);
        int [] sumaPuntajes = new int [cantidadJugadores];
        
        for(int i=0; i<cantidadJugadores; i++){
            System.out.println(nombreDeJugadores[i]);
        }

        boolean carreraTerminada =false;
        
         System.out.println("    " + LETRAS_VERDES+FONDO_NEGRO+"<<<<<<LLEGAMOS A LA PISTA>>>>>>>"+REINICIAR_COLOR);
        System.out.println("    " + LETRAS_VERDES+FONDO_NEGRO+"<<<QUE COMIENCE LA CARRERA >>>>>>>>"+REINICIAR_COLOR);
        espacio();
        System.out.println("  "+LETRAS_AMARILLAS+FONDO_GRIS+"INSTRUCCIONES"+REINICIAR_COLOR);
        System.out.println("  "+LETRAS_CELESTES+ "> Lance Dos dados,  suma de los numeros que saque seran los metros que avance "+REINICIAR_COLOR);
        System.out.println("En el camino se encntrará con trampas o ayudas para avanzar"); 
        espacio();
        delay(1000);
        
        while(!carreraTerminada){
            for(int i=0; i<cantidadJugadores; i++){
                int sumaJugador=0;
                    System.out.println("    " + LETRAS_AMARILLAS+FONDO_NEGRO+"Turno del Jugador "  +REINICIAR_COLOR);
                    System.out.println(LETRAS_CELESTES+"✔ Lanza el dado presionando ENTER"+REINICIAR_COLOR);
                    scanner.nextLine();
                    sumaJugador =lanzarDados();
                    sumaPuntajes[i]=sumaPuntajes[i]+sumaJugador;
                    
                    System.out.println("Puntos del jugador: "+i+": "+sumaPuntajes[i]);
                    
                    if(sumaPuntajes[i]>= PISTA){
                        carreraTerminada=true;
                    }
                    delay(250); // Pausa entre turnos
                    
            }
        
        
        }
        
        
    }
    static String [] nombres(int cantidadJugadores){
        String [] nombres= new String[cantidadJugadores];
        for(int i =0; i<cantidadJugadores; i++){
            System.out.println("Jugador "+(i+1)+"Ingresa tu nombre");
            nombres[i]= scanner.nextLine();
        }
    return nombres;
    }
    static void iniciarPartidaJugadorVsBot(){
        final int PISTA = seleccionTamañoPista();
    }
    
    static int lanzarDados(){
    int cantidadDados=2;
    int suma=0;
    
    for(int i=0; i<cantidadDados; i++){
        int resultadoDado = rand.nextInt(6)+1;
        suma +=resultadoDado;
        
        System.out.println("Lanza el dado "+ (i+1)+"sale "+resultadoDado);
        delay(200);
    }
        System.out.println("Avanza "+ suma+"metros");
    return suma;
    }
    ////////////////////////////////FIN CARRERAS//////////////////////////////////////////////////////////////////
        //SUBPROGRAMA ENCARGADO DE MOSTRAR EL MENU PRINCIPAL (3 JUEGOS Y EL REPORTE)
    static int menuPrincipal() {
        int opcionElegida;
        
        System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO + "|                                          |"+REINICIAR_COLOR);
        System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO + "|------------- Menu Principal -------------|"+REINICIAR_COLOR);
        System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO + "|                                          |"+REINICIAR_COLOR);
        espacio();
        System.out.println("    " + LETRAS_AMARILLAS_BR + FONDO_NEGRO + "--------- Seleccione un juego (1-3)---------"+REINICIAR_COLOR);
        espacio();
        System.out.println(" ✔ 1 : RPG");
        System.out.println(" ✔ 2:  CARRERAS");
        System.out.println(" ✔ 3 : REPORTES");
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
    
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    //Subprogramas confuncionamientos para todos los juegos (limpiar pantalla, verificar que lo ingresado sea correcto etc)
       static void limpiar(int tiempoMilisegundos) {
        try {
            Thread.sleep(tiempoMilisegundos);
        } catch (InterruptedException ex) {
        }
        System.out.print("\033c");
        System.out.flush();
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
                System.out.println("    " + LETRAS_ROJAS + FONDO_NEGRO +"Error: Entrada no válida. Debe ingresar un número entero, el que  indique el menú"+REINICIAR_COLOR);
                scanner.next(); //NO TOMA COMO VALIDA EL VALOR NO ENTERO, VUELVE A PEDIR UN ENTERO
            }
        }

        return numero;
    }
        
        static void espacio(){
            System.out.println(" ");
        }
        
            static void delay(int tiempoMilisegundos) {
        try {
            Thread.sleep(tiempoMilisegundos);
        } catch (InterruptedException ex) {
        }
    }
                static int parametroEntrada(String entrada) {
        int juegoSeleccionado;
        try {
            //Si el parametro de entrada corresponde a una opcion elegible
            if (entrada.matches("[0-4]*") && entrada.length() == 1) {
                juegoSeleccionado = Integer.parseInt(entrada);
            } //Si el parametro de entrada no es valido
            else {
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
}
