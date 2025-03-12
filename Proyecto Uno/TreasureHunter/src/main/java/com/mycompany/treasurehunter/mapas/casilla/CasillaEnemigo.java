/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.mapas.casilla;

import com.mycompany.treasurehunter.Jugador;
import com.mycompany.treasurehunter.mapas.Mapa;
import java.util.Scanner;

/**
 *
 * @author ronaldo
 */
public class CasillaEnemigo extends Casilla {

    private Mapa mapa;
    private boolean sePuedeEscapar;
    private int tipoDePenalizacion;
    private int cantidadDePenalizacion;
    private int[] nuevaPosionDelJugador;

    public CasillaEnemigo(int [] posicion,Mapa mapa, Jugador jugador) {
        super(posicion, jugador);
        this.mapa = mapa;
        this.nuevaPosionDelJugador = new int[2];
        sePuedeEscapar=false;
    }

    @Override
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    @Override
    public void crearAccionCasilla() {
        seleccionarSiSePuedeEscaparEnLaBatalla();
        seleccionarLaPosicionDelJugadorDespuesDeLaBatalla();
        seleleccionarTipoDePenalizacion();
        seleccionarCantidadDePenalizacion();
    }

    public void seleccionarSiSePuedeEscaparEnLaBatalla() {
        int opcion;
        do {
            System.out.println("Selecciona si quieres que se pueda escapar de esta batalla");
            System.out.println("1. Si");
            System.out.println("2. No");
            opcion = lector.leerNumero();
            if (opcion < 1 || opcion > 2) {
                System.out.println("Selecciona valores entre 1-2");
            }
        } while (opcion < 1 || opcion > 2);

        if (opcion == 1) {
            sePuedeEscapar = true;
        }
    }

    public void seleccionarLaPosicionDelJugadorDespuesDeLaBatalla() {
        int opcion;
        int fila = 0;
        int columna = 0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("¿Quieres definir la posición del jugador si pierde la batalla?");
            System.out.println("1. Sí");
            System.out.println("2. No");
            opcion = lector.leerNumero();

            if (opcion < 1 || opcion > 2) {
                System.out.println("Selecciona valores entre 1-2.");
            }
        } while (opcion < 1 || opcion > 2);

        if (opcion == 1) {
            boolean coordenadasValidas = false;
            while (!coordenadasValidas) {
                // Muestra el mapa
                mapa.imprimirMapa();

                // Selecciona la fila
                System.out.println("Selecciona la nueva posición del jugador después de perder una batalla.");
                System.out.println("Seleccione la fila (ejemplo: 1, 3, 5):");
                fila = lector.leerNumero() - 1; // Restar 1 para convertir a índice base 0

                // Selecciona la columna
                System.out.println("Seleccione la columna (ejemplo: A, B, C, D):");
                String letra = scanner.nextLine().toUpperCase();
                columna = convertirLetraANumero(letra);

                // Verifica si la coordenada está dentro de los límites
                if (fila < 0 || fila >= mapa.getFilas() || columna < 0 || columna >= mapa.getColumnas()) {
                    System.out.println("Coordenadas fuera del límite.");
                } else if (!verificarQueNoHayaCasillaMuroEnLaPosicionDeRegresoDelJugador(fila, columna)) {
                    System.out.println("Posición ocupada por una casilla muro.");
                } else {
                    coordenadasValidas = true;
                }
            }
            
            nuevaPosionDelJugador[0] = fila;
            nuevaPosionDelJugador[1] = columna;
        }
    }

    public void seleleccionarTipoDePenalizacion() {
        do {
            System.out.println("Selecciona el tipo de penalizacion");
            System.out.println("1. Descontar puntos de vida HP");
            System.out.println("2. Descontar puntos de mana MP");
            tipoDePenalizacion = lector.leerNumero();
            if (tipoDePenalizacion < 1 || tipoDePenalizacion > 2) {
                System.out.println("Selecciona valores entre 1-2");
            }
        } while (tipoDePenalizacion < 1 || tipoDePenalizacion > 2);
    }

    public void seleccionarCantidadDePenalizacion() {
        do {
            System.out.println("Selecciona la cantidad de penalizacion 0(sin penalizacion)-15");
            cantidadDePenalizacion = lector.leerNumero();
            if (cantidadDePenalizacion < 0 || cantidadDePenalizacion > 15) {
                System.out.println("Selecciona valores entre 0-15");
            }
        } while (cantidadDePenalizacion < 0 || cantidadDePenalizacion > 15);
    }

    @Override
    public void realizarAccion() {
        //Pendiente ejecutarAccion
    }

    public boolean verificarQueNoHayaCasillaMuroEnLaPosicionDeRegresoDelJugador(int fila, int columna) {
        return !(mapa.getCasillas()[fila][columna] instanceof CasillaMuro);
    }

    public int convertirLetraANumero(String letra) {
        char letraMayuscula = letra.toUpperCase().charAt(0);

        int numero = letraMayuscula - 'A';
        return numero;
    }

    @Override
    public String pintarCasilla() {
       verificarSiJugadorEstaEnLaCasilla();
        String casillaPintada;
        String simboloPersonaje = "X";

        if (estaElJugadorAqui) {
            casillaPintada = color.FONDO_ROJO+ "  " + simboloPersonaje + "  " + color.REINICIAR_COLOR;
        } else {
            casillaPintada = color.FONDO_ROJO + "     " + color.REINICIAR_COLOR;
        }

        return casillaPintada;
    }
    
    
    
    public int[] getNuevaPosionDelJugador() {
        return nuevaPosionDelJugador;
    }
}
