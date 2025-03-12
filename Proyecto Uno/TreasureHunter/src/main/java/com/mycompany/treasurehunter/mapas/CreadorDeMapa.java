/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.mapas;

import com.mycompany.treasurehunter.Jugador;
import com.mycompany.treasurehunter.adicionales.LectorEnteros;
import java.util.Scanner;

/**
 *
 * @author ronaldo
 */
public class CreadorDeMapa {
    private LectorEnteros lector;

    public CreadorDeMapa() {
        lector= new LectorEnteros();
    }
   
    
    /**
     * 
     * @return  retorna un nuevo mapa
     */
    public Mapa crearMapa() {
        //Varibales sirven como parametro del los metodos encargados de definir fila y columna
        String nombreFila = "Filas";
        String nombreColumna = "Columnas";
        //Definiendo el tamaño de mapa
        String nombreMapa =definirNombreDelMapa();
        //filas
        int filas = definirDimensionMapa(nombreFila) ;
        //columnas
        int columnas = definirDimensionMapa(nombreColumna) ;
        //definiendo la posicion inicial de Jugador guardada en el arreglo posicionInicial
        System.out.println("Posicion Inicial Del Jugador");
        System.out.println("");
        int[] posicionInicialJugador = definirCoordenadasInicialesJugador(filas, columnas);
        System.out.println("");
        //definiendo la posicion del tesoro, guardado en el arreglo posicionTesoro
        System.out.println("Posicion del del tesoro");
        System.out.println("");
        int posicionTesoro[] = definirCoordenadasTesoro(filas, columnas, posicionInicialJugador);
        
        //Se crea un jugador falso en la creacion del mapa, en la partida se reemplazara por un jugador real
        Jugador jugadorFalso =new Jugador("", posicionInicialJugador);
        //Jugador jugador = null;
        //teniendo todo lo anterior se crea el mapa
        Mapa mapa = new Mapa(jugadorFalso,nombreMapa,filas, columnas, posicionInicialJugador, posicionTesoro);
        //teniendo el mapa el siguiente paso es crearle sus casillas
       // mapa.crearCasillasDelMapa(); /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        return mapa;

    }

    /**
     * 
     * @param dimension
     * @return  retorna la cantidad de filas o columnas
     */
    public int definirDimensionMapa(String dimension) {
        int tamaño;
        do {
            System.out.print("Selecciona la cantidad de " + dimension + " del mapa: ");
            tamaño = lector.leerNumero();
            if (tamaño < 1) {
                System.out.println("Debes seleccionar Valores mayores a 0");
            }
        } while (tamaño < 1);
        System.out.println("");
        return tamaño;
    }

    /**
     * 
     * @param filas
     * @param columnas
     * @return retorna las coordenadasInicialesDelJugador
     */
    public int[] definirCoordenadasInicialesJugador(int filas, int columnas) {
        int[] coordenadas = new int[2];

        do {
            System.out.print("Selecciona la fila 1-" +filas+": ");
            coordenadas[0] = lector.leerNumero() - 1;

            if (coordenadas[0] < 0 || coordenadas[0] >= filas) {
                System.out.println("Posición fuera del tablero. Ingresa un valor entre 1 y " + filas);
            }
        } while (coordenadas[0] < 0 || coordenadas[0] >= filas);

        do {
            System.out.print("Selecciona la columna 1-"+columnas+": ");
            coordenadas[1] = lector.leerNumero() - 1;

            if (coordenadas[1] < 0 || coordenadas[1] >= columnas) {
                System.out.println("Posición fuera del tablero. Ingresa un valor entre 1 y " + columnas);
            }
        } while (coordenadas[1] < 0 || coordenadas[1] >= columnas);

        return coordenadas;
    }

    /**
     * 
     * @param filas
     * @param columnas
     * @param coordenadasDelJugador
     * @return retorna las coordenadas de la casilla tesoro
     */
    public int[] definirCoordenadasTesoro(int filas, int columnas, int[] coordenadasDelJugador) {
        int[] coordenadasTesoro = new int[2];
        boolean estaDisponible;

        do {
            System.out.print("Selecciona la fila (1-" + filas + "): ");
            coordenadasTesoro[0] = lector.leerNumero() - 1;

            System.out.print("Selecciona la columna (1-" + columnas + "): ");
            coordenadasTesoro[1] = lector.leerNumero() - 1;

            estaDisponible = verificarCasillaLibre(coordenadasDelJugador, coordenadasTesoro);

            if (coordenadasTesoro[0] < 0 || coordenadasTesoro[0] >= filas
                    || coordenadasTesoro[1] < 0 || coordenadasTesoro[1] >= columnas) {
                System.out.println("Coordenadas fuera de los límites. Deben estar entre (1,1) y (" + filas + "," + columnas + ").");
            } else if (!estaDisponible) {
                System.out.println(" Casilla ocupada por el jugador. Selecciona otra.");
            }

        } while (coordenadasTesoro[0] < 0 || coordenadasTesoro[0] >= filas
                || coordenadasTesoro[1] < 0 || coordenadasTesoro[1] >= columnas
                || !estaDisponible);

        return coordenadasTesoro;
    }

    /**
     * 
     * @param coordenadaJugador
     * @param coordenadaTesoro
     * @return 
     */
    public boolean verificarCasillaLibre(int[] coordenadaJugador, int[] coordenadaTesoro) {
        if (coordenadaTesoro[0] == coordenadaJugador[0] && coordenadaTesoro[1] == coordenadaJugador[1]) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 
     * @return retorna el nombre del mapa
     */
    public String definirNombreDelMapa(){
         Scanner scanner = new Scanner(System.in);
        String nombreMapa;
        System.out.print("Ingresa el nombre del Mapa: ");
         nombreMapa=String.valueOf(scanner.nextLine());
        System.out.println("");
       
        return nombreMapa;
    }
    
    public void limpiarPantalla(int tiempoEnMilisegundos){
        try {
            Thread.sleep(tiempoEnMilisegundos);
        } catch (InterruptedException ex) {
            System.out.println("\033c");
            System.out.flush();
        }
    }

}
