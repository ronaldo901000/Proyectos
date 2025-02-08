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
    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();

    //Arreglos y variables que serán contadores para el reporte
    public static int[] juegoIniciado = new int[2];//alamacena las veces que el jugador inicia un juego (indice 0=RPG, indice 1=Carreras)
    public static int jugadorPierdeRPG;
    public static int jugadorEntraBatallaRpg;
    public static int botGanaCarrera;
    public static int[] jugadorGanaCarrera = new int[2];

    public static void main(String[] args) {
        int opcionSeleccionada;

        if (args.length == 0) {
            opcionSeleccionada = 0;
        } else {
            opcionSeleccionada = parametroEntrada(args[0]);
        }
        if (opcionSeleccionada == 0) {
            opcionSeleccionada = menuPrincipal();
        }

        //Inicio del juego o reporte segun el numero que ingrese el usuario desde el menú principal
        if (opcionSeleccionada == 1) {
            juegoIniciado[0]++; // contador de veces iniciadas en el juego
            juegoRpg();
            menuFinJuego(opcionSeleccionada);
        } else if (opcionSeleccionada == 2) {
            juegoIniciado[1]++;
            juegoCarreras();
            menuFinJuego(opcionSeleccionada);
        } else if (opcionSeleccionada == 3) {
            reportes();
            menuFinJuego(opcionSeleccionada);
        }

    }

    static void reportes() {

        System.out.println("    " + LETRAS_AMARILLAS_BR + FONDO_NEGRO + "|                                                        |" + REINICIAR_COLOR);
        System.out.println("    " + LETRAS_AMARILLAS_BR + FONDO_NEGRO + "|----------------------- REPORTES -----------------------|" + REINICIAR_COLOR);
        System.out.println("    " + LETRAS_AMARILLAS_BR + FONDO_NEGRO + "|                                                        |" + REINICIAR_COLOR + "\n");
        System.out.println("         " + LETRAS_VERDES_BR + FONDO_NEGRO + " CANTIDAD DE VECES QUE SE HAN INICIADO LOS JUEGOS " + REINICIAR_COLOR + "\n");
        System.out.print("           " + LETRAS_VERDES + FONDO_NEGRO + "RPG: " + juegoIniciado[0] + REINICIAR_COLOR);
        System.out.print("       " + LETRAS_AMARILLAS + FONDO_NEGRO + "CARRERRAS: " + juegoIniciado[1] + REINICIAR_COLOR);
        espacio(1);
        //     System.out.println("    " + LETRAS_VERDES + FONDO_NEGRO + "|------------------------ CARRERA DE CABALLOS ------------------------|"+REINICIAR_COLOR+"\n");
        //  System.out.println("    "+LETRAS_VERDES+FONDO_NEGRO+"Cantidad de partidas que se han ganado: "+ganarCarreraCaballos+REINICIAR_COLOR);
        //System.out.println("    "+LETRAS_VERDES+FONDO_NEGRO+"Cantidad de partidas que se han perdido "+perderCarreraCaballos+REINICIAR_COLOR+"\n");
        System.out.println("    " + LETRAS_CELESTES + FONDO_NEGRO + "|------------------------- CARRERAS -------------------------|" + REINICIAR_COLOR + "\n");
        espacio(1);
        System.out.println("  " + LETRAS_CELESTES + FONDO_NEGRO + "Cantidad de veces que el jugador 1 HA GANADO: " + jugadorGanaCarrera[0] + REINICIAR_COLOR);
        System.out.println("    " + LETRAS_CELESTES + FONDO_NEGRO + "Cantidad de veces que el bot ha ganado: " + jugadorGanaCarrera[1] + REINICIAR_COLOR);

        String[] parametroInicio = new String[1];
        parametroInicio[0] = "0";
        int opcionElegida;
        System.out.println("");
        System.out.println("    " + LETRAS_VERDES + FONDO_NEGRO + "|                                                        |" + REINICIAR_COLOR);
        System.out.println("    " + LETRAS_VERDES + FONDO_NEGRO + "|------------------ FIN REPORTES -----------------------|" + REINICIAR_COLOR);
        System.out.println("    " + LETRAS_VERDES + FONDO_NEGRO + "|                                                        |" + REINICIAR_COLOR);
        System.out.println("");
        System.out.println("    ✔ Ingrese 1 para volver al menu principal");
        System.out.println("");
        System.out.println("   ✔ Ingrese cualquier otro numero  para salir");
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
        } else {
            System.out.println(LETRAS_ROJAS + "PROGRAMA CERRADO");
        }

    }

    //////////////////////////////INICIO RPG//////////////////////////////////////////////////////////////////////////////////
    //////////////////Subprograma controlador juego RPG////////////////////////////////////////////////
    static void menuRPG() {
        System.out.println("<<<<<<<<<<<<<<< RPG>>>>>>>>>>>>>>>>>");
        System.out.println("✔ 1. A la carga!!!!!!! ");
        System.out.println("✔ 2. Tienda");
        System.out.println("✔ 3. zzZzzZzzZ");
        System.out.println("✔ 4. Status");
        System.out.println("✔ 5. Mas Poder!!!!!!!!");
        System.out.println("✔ 6. Salir");
    }

    static void juegoRpg() {
        int cantidadEnemigos =3;
        int cantidadAtributos = 4;
        int[] atributos = new int[cantidadAtributos];
        int cantidadArticulos = 3;// 0: oro, 1: cura: 3:recupera
        int montruosVencidos[] = new int[cantidadEnemigos];  //almacena la cantidad de veces que el personaje vence a cada monstruo y mostrarlo en status
        boolean personajeVaPrimero= rand.nextBoolean();
          int articulos[] = new int[cantidadArticulos];
        int nivelInicial = 0;
        atributos = definirStatusInicial(nivelInicial, cantidadAtributos);
        int indice =seleccionarIndiceEnemigoAleatorio();
        int [] atributosMonstruo = definirValorMontruo(indice);
        String nombreMonstruo = definirNombreMonstruo(indice);

        
        String nombre;
        System.out.println("Jugador ingresa el nombre de tu personaje: ");
        nombre = scanner.nextLine();
        
        if(personajeVaPrimero){  // esta accion se cumple solo si el jugador va primero en cada turno
            System.out.println("El personaje: " +nombre+" va primero en la ronda");
            accionesPersonaje( nombre, indice,atributos,articulos, atributos,nombreMonstruo); 
            espacio(2);
            accionesMonstruo(atributos, atributosMonstruo);
            System.out.println("valor actual de HP: "+atributos[0]);
        }
        else{
             System.out.println("El Monstruo: " +nombreMonstruo+" va primero");
            accionesMonstruo(atributos, atributosMonstruo);
            System.out.println("valor actual de HP: "+atributos[0]);
            espacio(2);
            accionesPersonaje( nombre,indice,atributos,articulos,atributos,nombreMonstruo);
        }
        
    }
        static int accionesMonstruo(int valorHp,int nivel, int factorDeAtaque){
        int minimo= factorDeAtaque+nivel;
        int maximo = factorDeAtaque+nivel+10;
        int daño;
        daño= rand.nextInt(maximo)+minimo;
        valorHp= valorHp-daño;
        
    return valorHp;
    }
    static void accionesPersonaje(String nombre, int indiceMonstruo, int [] atributosPersonaje, int [] articulos, int [] atributosMonstruo, String nombreMonstruo) {
        String nombrePersonaje = nombre;
        int cantidadEnemigos = 3;
        int cantidadAtributos = 4;
        int cantidadArticulos = 3;// 0: oro, 1: cura: 3:recupera
        boolean partidaAcabada = false;
        int montruosVencidos[] = new int[cantidadEnemigos];  //almacena la cantidad de veces que el personaje vence a cada monstruo y mostrarlo en status
        int opcion;
        //atributos = definirStatusInicial(nivelInicial, cantidadAtributos);

        do {
            menuRPG();
            opcion = leerNumero();
            if (opcion < 0 || opcion > 6) {
                System.out.println("Ingresa valores entre 1 y 6");

            }
        } while (opcion < 0 || opcion > 6);

        switch (opcion) {
            case 1:
                System.out.println("Empezando la batalla...");
                accionAlaCarga(nombre, opcion, atributosPersonaje,atributosMonstruo,nombreMonstruo);
                break;
        //Apartado de partida
            case 2:
                //Accion de ir a la tienda
                do {
                    articulos = accionComprarEnTienda(articulos, cantidadArticulos);
                    for (int i = 0; i < cantidadArticulos; i++) {
                        System.out.println(articulos[i]);
                    }
                    System.out.println("Presiona 1 si quieres comprar otro articulo, o cualquier otro numero para regresar");
                    opcion = leerNumero();
                } while (opcion == 1);
                break;
            case 3:
                System.out.println("Durmiendo...");
                atributosPersonaje = accionZZzz(atributosPersonaje);
                System.out.println("Presiona enter para despetar y continuar");
                scanner.nextLine();
                for (int i = 0; i < cantidadAtributos; i++) {
                    System.out.println(atributosPersonaje[i]);
                }   break;
            case 4:
                accionStatus(atributosPersonaje, articulos, montruosVencidos);
                break;
            case 5:
                System.out.println(" nivel antes: " + atributosPersonaje[2]);
                System.out.println("puntos de experiencia antes: " + atributosPersonaje[3]);
                int[] nuevoNivelYExperiencia = accionMasPoder(atributosPersonaje[2], atributosPersonaje[3]);
                atributosPersonaje[2] = nuevoNivelYExperiencia[0];
                atributosPersonaje[3] = nuevoNivelYExperiencia[1];
                System.out.println("subes al nivel: " + atributosPersonaje[2]);
                System.out.println("puntos de experiencia restantes: " + atributosPersonaje[3]);
                break;
            case 6:
                System.out.println("Saliendo del RPG");
                String[] parametroInicio = new String[1];
                parametroInicio[0] = "0";
                main(parametroInicio);
                partidaAcabada = true;
                break;
            default:
                break;
        }

    }
    static void menuBatalla(){
        System.out.println("Acciones en la batalla");
        espacio(1);
        System.out.println("Seleciona una accion: ");
        System.out.println("✔ 1.Atacar");
        System.out.println("✔ 2. Curar");
        System.out.println("✔ 3. Item");
        System.out.println("✔ 4. Tengo Miedo");
        System.out.println("✔ Para regresar presiona culquier otro numero");
    }
    
    static void accionAlaCarga(String nombre, int indice, int [] atributosPersonaje, int [] AtributosMontruo, String nombreDelMonstruo) {
        menuBatalla();
        int opcion;
        opcion=leerNumero();
        if(opcion==1){
            batalla(indice,nombre,atributosPersonaje, AtributosMontruo,nombreDelMonstruo); // el personaje se enfrenta contra un monstruo aleatoriamente
        }
    }
    static void batalla(int indice,String nombre , int [] atributosPersonaje, int [] atributosMonstruo,String nombreMonstruo){
        ataqueDelPersonaje(atributosPersonaje[2], atributosMonstruo[0]);
        System.out.println("El personaje: "+nombre +" ataca a:"+ nombreMonstruo);
        System.out.println("puntos de vida de "+nombreMonstruo+": "+atributosMonstruo[0]);
    }

    static void ataqueDelPersonaje(int nivel, int hpMonstruo){
        int numeroAleatorio = rand.nextInt(20)+10;
        int valorAtaquePersonaje= (nivel+1)*10 +numeroAleatorio;
        hpMonstruo-=valorAtaquePersonaje;
    }
    
    static void accionesMonstruo(int [] atributosJugador,  int [] valorHpYFm  ){
                int minimo= valorHpYFm[1]+atributosJugador[2];
        int maximo = valorHpYFm[1]+atributosJugador[2]+10;
        int daño;
        daño= rand.nextInt(maximo)+minimo;
        atributosJugador[0]-=daño;
        System.out.println("puntos de vida restantes: "+ atributosJugador[0]);
    }
    
    
    
    static int seleccionarIndiceEnemigoAleatorio (){
        int indice= rand.nextInt(2);
        return indice;
    }
    public static String definirNombreMonstruo(int indice){
         int cantidadEnemigos;
        String  nombreMonstruo="";
        if(indice ==0){
        nombreMonstruo="Dark Wolf";
        }
        else if(indice ==1){
        nombreMonstruo="Dragon";}
        else if (indice==2){
        nombreMonstruo="Mighty Golem";
        }
    return nombreMonstruo;
    }
    
    //subprograma encargado de dar los valores de hp y mp al monstruo dependiendo del indice que le den
    public static int [] definirValorMontruo(int indice){
        int [] valorHpYMp= new int [2]; // en la posicion 0 se guada el hp y en la posicion 1 se guarda el factor de muerte
        if(indice ==0){
            valorHpYMp[0]=100;
            valorHpYMp[1]=10;
        }
        else if(indice ==1){
            valorHpYMp[0]=200;
            valorHpYMp[1]=15;
        }
        else if(indice ==2){
            valorHpYMp[0]=350;
            valorHpYMp[1]=25;
        }
    
    return valorHpYMp;
    }
    
    

    public static int[] accionMasPoder(int nivelTotal, int experiencia) {
        int[] nivelYExperiencia = new int[2];
        int nivel;
        if (experiencia >= 100) {
            System.out.println("Nivel actual: " + nivelTotal);
            nivel = experiencia / 100;
            int resto = experiencia % 100;
            nivelTotal = nivelTotal + nivel;
            experiencia = resto;
            nivelYExperiencia[0] = nivelTotal;
            nivelYExperiencia[1] = experiencia;
            System.out.println("subes al nivel: " + nivelYExperiencia[0]);
            System.out.println("puntos de experiencia restantes: " + nivelYExperiencia[1]);
        } else {
            System.out.println("No tienes suficientes puntos de experiencia para subir de nivel");
        }

        return nivelYExperiencia;
    }

    static int[] accionZZzz(int[] atributos) {
        int indiceMaximo = 2;// los atributos HP Y MP llegan al indice n-1 n=2
        int valorHP = 100;
        int valorMP = 10;
        atributos[0] = valorHP;
        atributos[1] = valorMP;

        return atributos;
    }

    static void accionStatus(int[] atributos, int[] articulos, int[] batallas) {
        System.out.println("Estadisticas");
        //Aqui deben ir las estadisticas de victorias

        espacio(2);
        for (int i = 0; i < atributos.length; i++) {
            if (i == 0) {
                System.out.println("Puntos de vida: " + atributos[i]);
            } else if (i == 1) {
                System.out.println("Puntos de mana: " + atributos[i]);
            } else if (i == 2) {
                System.out.println("Nivel: " + atributos[i]);
            } else if (i == 3) {
                System.out.println("Experiencia: " + atributos[i]);
            }
        }
        for (int i = 0; i < articulos.length; i++) {
            if (i == 0) {
                System.out.println("Oro: " + articulos[i]);
            } else if (i == 1) {
                System.out.println("Cura de HP: " + articulos[i]);
            } else if (i == 2) {
                System.out.println("Recuperacion de MP: " + articulos[i]);
            }
        }
    }

    static int[] accionComprarEnTienda(int[] articulos, int cantidadArticulos) {
        int[] compradoEnTienda = tienda(cantidadArticulos);
        for (int i = 0; i < cantidadArticulos; i++) {
            articulos[i] = articulos[i] + compradoEnTienda[i];
        }
        return articulos;
    }

    //Calcula el status ya sea inicial
    static int[] definirStatusInicial(int nivel, int cantidadAtributosl) {
        int[] atributosInciales = new int[cantidadAtributosl];
        int puntosDeVida = 100 * (nivel + 1);
        int puntosDeMana = 10 * (nivel + 1);
        int nivelPersonaje = nivel;
        int experiencia = 0;

        atributosInciales[0] = puntosDeVida;
        atributosInciales[1] = puntosDeMana;
        atributosInciales[2] = nivelPersonaje;
        atributosInciales[3] = experiencia;
        return atributosInciales;
    }

    static int[] tienda(int cantidadArticulos) {
        int opcion;
        int oro;
        int cura;
        int recupera;
        int[] comprasHechas = new int[cantidadArticulos];

        menuTienda();
        opcion = leerNumero();

        if (opcion == 1) {
            oro = 50;
            cura = 25;
            comprasHechas[0] = oro;
            comprasHechas[1] = cura;

        } else if (opcion == 2) {
            oro = 100;
            cura = 75;
            comprasHechas[0] = oro;
            comprasHechas[1] = cura;
        } else {
            oro = 75;
            recupera = 10;
            comprasHechas[0] = oro;
            comprasHechas[2] = recupera;
        }
        return comprasHechas;
    }

    static void menuTienda() {
        System.out.println("<<<<<<<TIENDA>>>>>>>");
        System.out.println("Selecciona el articulo que quieres comprar.");
        System.out.println("✔ 1. Potion (50 oro y 25 cura de HP)");
        System.out.println("✔ 2. Hi-Potion (100 oro y cura 75 HP)");
        System.out.println("✔ 3. M-Potion (75 oro, y recupera 10 MP)");
        espacio(1);
        System.out.println("Presiona cualquier otro numero para regresar");
        espacio(1);

    }

    static void puntosDeMana(int nivel) {

    }

    /////////////////////////////FIN RPG/////////////////////////////////////////////////////////////////////////////
    //////////////////////////////INICIO CARRERAS////////////////////////////////////////////////////////////////
    ///////////////////////subprograma controlador juego Carreras///////////////////////////////////////
    static void juegoCarreras() {
        opcionTipoRival();

    }

    static int seleccionTamañoPista() {
        int opcion;
        final int PISTA;
        do {
            System.out.println("Tamaño de Pista");
            System.out.println("✔1. Pista Corta");
            System.out.println("✔2. Pista Media");
            System.out.println("✔3. Pista Larga");
            opcion = leerNumero();
            if (opcion > 0 || opcion < 4) {
                System.out.println("Ingresa valores entre 1-3");
            }
        } while (opcion < 0 || opcion > 4);
        PISTA = opcioneDePista(opcion);

        System.out.println("TAMAÑO DE LA PISTA: " + PISTA);

        return PISTA;
    }

    static int opcioneDePista(int opcionPista) {
        int tamañoPista = 0;
        if (opcionPista == 1) {
            tamañoPista = 50;
        } else if (opcionPista == 2) {
            tamañoPista = 100;
        } else if (opcionPista == 3) {
            tamañoPista = 150;
        }
        return tamañoPista;
    }

    static void opcionTipoRival() {
        int opcion = 0;

        do {

            System.out.println("Seleccione contra quien quiere competir");
            System.out.println("✔1: Jugador (tú) VS Jugador");
            System.out.println("✔2: Jugador(tú) VS Bot");
            opcion = leerNumero();
            if (opcion <= 0 || opcion > 2) {
                System.out.println("Seleccione solo valores indicados");
            }
        } while (opcion <= 0 || opcion > 2);
        if (opcion == 1) {
            iniciarPartidaJugadorVsJugador();
        } else if (opcion == 2) {
            iniciarPartidaJugadorVsBot();
        }
    }

    static void tituloCarreras() {

        System.out.println("    " + LETRAS_VERDES + FONDO_NEGRO + "<<<<<<LLEGAMOS A LA PISTA>>>>>>>" + REINICIAR_COLOR);
        System.out.println("    " + LETRAS_VERDES + FONDO_NEGRO + "<<<QUE COMIENCE LA CARRERA >>>>>>>>" + REINICIAR_COLOR);
        espacio(1);
        System.out.println("  " + LETRAS_AMARILLAS + FONDO_GRIS + "INSTRUCCIONES" + REINICIAR_COLOR);
        System.out.println("  " + LETRAS_CELESTES + "> Lance Dos dados,  suma de los numeros que saque seran los metros que avance " + REINICIAR_COLOR);
        System.out.println("En el camino se encntrará con trampas o ayudas para avanzar");
        espacio(1);
        delay(1000);
    }

    static void tituloPuntajesCarrera(String[] nombreDeJugadores, int[] sumaPuntajes) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<PUNTAJES>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
// Imprimir nombres de los jugadores en una línea
        for (String nombre : nombreDeJugadores) {
            System.out.print("                " + nombre + "             ");
        }
        System.out.println(); // Salto de línea
// Imprimir puntajes de los jugadores en una línea
        for (int puntaje : sumaPuntajes) {
            System.out.print("                 " + puntaje + "                  ");
        }
        espacio(1);
    }

    static void iniciarPartida(boolean esContraBot) {
        final int PISTA = seleccionTamañoPista();
        int cantidadJugadores = 2;
        String[] nombreDeJugadores = nombres(cantidadJugadores, esContraBot);
        int[] sumaPuntajes = new int[cantidadJugadores];
        boolean carreraTerminada = false;
        tituloCarreras();

        while (!carreraTerminada) {
            limpiar(200);
            tituloPuntajesCarrera(nombreDeJugadores, sumaPuntajes);
            espacio(2);

            for (int i = 0; i < cantidadJugadores; i++) {

                for (int j = 0; j <= sumaPuntajes[i]; j += 2) {

                    //  System.out.print(sumaPuntajes[i]+"_");      
                    System.out.print("._");
                }

                System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO + "🚗 🚙🏎️" + "  " + nombreDeJugadores[i] + " " + sumaPuntajes[i] + " metros. " + REINICIAR_COLOR);
            }
            for (int i = 0; i < cantidadJugadores; i++) {
                boolean esBot = esContraBot && (i == 1);
                jugarTurno(i, nombreDeJugadores, sumaPuntajes, esBot);

                if (sumaPuntajes[i] >= PISTA) {
                    carreraTerminada = true;
                    System.out.println("🎉 ¡¡¡¡¡¡¡¡¡¡¡El ganador es: " + nombreDeJugadores[i] + " !!!!!!!!!! 🎉");
                    jugadorGanaCarrera[i]++;
                    break;
                }

                delay(250); // Pausa entre turnos
            }

        }
    }

    static void jugarTurno(int i, String[] nombreDeJugadores, int[] sumaPuntajes, boolean esBot) {
        espacio(1);
        System.out.println("Turno de " + nombreDeJugadores[i].toUpperCase());
        if (!esBot) {
            System.out.println("✔ Lanza el dado presionando ENTER");
            scanner.nextLine();
        } else {
            System.out.println("🤖 El bot está jugando ...");
            delay(1000);
        }

        int sumaJugador = lanzarDados();
        sumaPuntajes[i] += sumaJugador;

        boolean desafioEnTurno = rand.nextBoolean(); // Determina si hay desafío
        int valorDesafio = definirValorSorpresa(sumaJugador);

        if (desafioEnTurno) {
            System.out.println("¡Tienes un desafío!");

            boolean saberDesafio;
            if (!esBot) {
                System.out.println("Presiona ENTER para descubrirlo...");
                scanner.nextLine();
                saberDesafio = rand.nextBoolean();
            } else {
                saberDesafio = rand.nextBoolean();
                delay(1000);

            }

            if (saberDesafio) { // Recibe ayuda
                System.out.println("¡Tienes suerte! Te encontraste con un booster.");
                sumaPuntajes[i] += valorDesafio;
            } else { // Es una trampa
                System.out.println("Lamentablemente te encontraste con una trampa");
                sumaPuntajes[i] -= valorDesafio;
            }
            System.out.println("Tu nuevo avance es: " + sumaPuntajes[i] + " metros.");
        }

        System.out.println("Puntos del auto de " + nombreDeJugadores[i] + " : " + sumaPuntajes[i]);
    }

// Métodos para iniciar cada tipo de partida
    static void iniciarPartidaJugadorVsJugador() {
        iniciarPartida(false);
    }

    static void iniciarPartidaJugadorVsBot() {
        iniciarPartida(true);
    }

    static int definirValorSorpresa(int avance) {
        int valorDesafio;
        valorDesafio = avance / 2;

        return valorDesafio;
    }

    static String[] nombres(int cantidadJugadores, boolean esContraBot) {
        String[] nombres = new String[cantidadJugadores];
        if (esContraBot == false) {
            for (int i = 0; i < cantidadJugadores; i++) {
                System.out.println("Jugador " + (i + 1) + " ingresa tu nombre: ");
                nombres[i] = scanner.nextLine().toUpperCase();
            }
        } else {
            System.out.println("Jugador 1 ingresa tu nombre:");
            nombres[0] = scanner.nextLine();
            nombres[1] = "BOT";
        }
        return nombres;
    }

    static int lanzarDados() {
        int cantidadDados = 2;
        int suma = 0;

        for (int i = 0; i < cantidadDados; i++) {
            int resultadoDado = rand.nextInt(6) + 1;
            suma += resultadoDado;

            System.out.println("Lanza el dado " + (i + 1) + "sale " + resultadoDado);
            delay(200);
        }
        System.out.println("Avanza " + suma + "metros");
        return suma;
    }
    ////////////////////////////////FIN CARRERAS//////////////////////////////////////////////////////////////////
    //SUBPROGRAMA ENCARGADO DE MOSTRAR EL MENU PRINCIPAL (3 JUEGOS Y EL REPORTE)
    static int menuPrincipal() {
        int opcionElegida;

        System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO + "|                                          |" + REINICIAR_COLOR);
        System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO + "|------------- Menu Principal -------------|" + REINICIAR_COLOR);
        System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO + "|                                          |" + REINICIAR_COLOR);
        espacio(1);
        System.out.println("    " + LETRAS_AMARILLAS_BR + FONDO_NEGRO + "--------- Seleccione un juego (1-3)---------" + REINICIAR_COLOR);
        espacio(1);
        System.out.println(" ✔ 1 : RPG");
        System.out.println(" ✔ 2:  CARRERAS");
        System.out.println(" ✔ 3 : REPORTES");
        System.out.println("");
        System.out.println("Ingrese cualquier otro numero para salir:");
        opcionElegida = leerNumero();
        return opcionElegida;
    }

    //SUBPROGRAMA ENCARGADO DE MOSTRAR UN MENU AL FINAL DE CADA JUEGO PARA QUE EL JUGADOR DECIDA QUE HACER
    static void menuFinJuego(int numeroJuego) {
        String[] parametroInicio = new String[1];
        parametroInicio[0] = "0";
        int opcionElegida;
        System.out.println("");
        System.out.println("    " + LETRAS_VERDES_BR + FONDO_NEGRO + "<<<<<<<Fin del juego>>>>>>" + REINICIAR_COLOR);
        System.out.println(LETRAS_AMARILLAS + "Ingresa" + REINICIAR_COLOR);
        System.out.println(LETRAS_VERDES + " ✔ 1 para volver a jugar            " + REINICIAR_COLOR);
        System.out.println(LETRAS_VERDES + " ✔ 2 para volver al menu principal  " + REINICIAR_COLOR);
        espacio(2);
        System.out.print(LETRAS_AMARILLAS + "Ingresa cualquier otro numero para salir del programa: " + REINICIAR_COLOR);

        opcionElegida = leerNumero();
        if (opcionElegida == 1) {
            System.out.print("Volviendo al juego");
            limpiar(0);
            for (int i = 0; i < 5; i++) {
                System.out.print(" .");

            }
            delay(400);
            espacio(2);

            parametroInicio[0] = String.valueOf(numeroJuego);
            // Volver a ejecutar el programa con el parametro de entrada del juego seleccionado
            main(parametroInicio);
        } else if (opcionElegida == 2) {
            System.out.print("Volviendo al menu principal");
            for (int i = 0; i < 3; i++) {
                System.out.print("    " + LETRAS_AMARILLAS + " .");
                limpiar(0);
                delay(600);
            }
            System.out.println();
            // Volver a ejecutar el programa con el parametro de entrada 0
            main(parametroInicio);
        } else {

            System.out.println(LETRAS_ROJAS + "PROGRAMA CERRADO");
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
                System.out.println("    " + LETRAS_ROJAS + FONDO_NEGRO + "Error: Entrada no válida. Debe ingresar un número entero, el que  indique el menú" + REINICIAR_COLOR);
                scanner.next(); //NO TOMA COMO VALIDA EL VALOR NO ENTERO, VUELVE A PEDIR UN ENTERO
            }
        }

        return numero;
    }

    static void espacio(int cantidadDeLineas) {
        for (int i = 0; i < cantidadDeLineas; i++) {
            System.out.println("");
        }

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
                System.out.println(LETRAS_ROJAS + "\"" + entrada + " No es un parametro de entrada valido" + REINICIAR_COLOR);
                limpiar(1200);
                juegoSeleccionado = 0;
            }
        } catch (NumberFormatException e) {
            juegoSeleccionado = 0;
        }
        return juegoSeleccionado;
    }

    static void error(String texto) {
        System.out.println(LETRAS_ROJAS + " Error: " + texto + REINICIAR_COLOR);
    }
}
