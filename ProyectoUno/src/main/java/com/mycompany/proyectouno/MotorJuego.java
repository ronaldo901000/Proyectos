/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno;

import com.mycompany.proyectouno.Editor.EditorMapa;
import com.mycompany.proyectouno.Planeta.Planeta;
import java.util.Scanner;

/**
 *
 * @author ronaldo
 */
public class MotorJuego {

    private Mapa mapa;
    private Jugador jugador1;
    private Jugador jugador2;
    private Mapa[] mapas;
    //private EditorMapa editorMapa; // Instancia de EditorMapa
    public static Scanner scanner = new Scanner(System.in);

    public void iniciarJuego() {
        // Delegar la inicialización del juego a EditorMapa
        System.out.println("KONQUEST");
        Menu menuInicio = new Menu();
        int opcion;

        menuInicio.mostrarMenuInicio();
        opcion = scanner.nextInt();

        limpiarConsola();
        if (opcion == 1) {
            EditorMapa editorMapa = new EditorMapa();
            Mapa nuevoMapa = editorMapa.inicializarJuego(this);
            agregarMapa(nuevoMapa);
            iniciarJuego();

            mapa.mostrarMapa();
        } else if (opcion == 2) {

            System.out.println("Entrando a la partida");
            iniciarPartida();
        }

    }

    private void iniciarPartida() {
        if (mapas == null) {
            System.out.println("No hay mapas disponibles.");
            System.out.println("Crea un mapa y luego vuelve");
            System.out.println("Presiona enter para regresar");
            scanner.nextLine();
            iniciarJuego();
        } else {
            System.out.println("Seleccione el mapa.");
            for (int i = 0; i < mapas.length; i++) {
                Mapa mapa = mapas[i];
                System.out.println((i + 1) + ") " + mapa.getNombre());
            }
            int opcionMapa = scanner.nextInt();
            iniciarTurnos(mapas[opcionMapa-1]);
        }
    }

private void iniciarTurnos(Mapa mapa) {

    boolean partidaEnProgreso = true;
    int numTurno = 1;

    while (partidaEnProgreso) {

        limpiarConsola();

        // Jugador 1 toma su turno
        Turno turnoJugador1 = new Turno(numTurno);
        String[] accionesj1 = turnoJugador1.ejecutarTurno(1, mapa, this);

        // Jugador 2 toma su turno
        Turno turnoJugador2 = new Turno(numTurno);
        String[] accionesj2 = turnoJugador2.ejecutarTurno(2, mapa, this);

        // Ejecuta las acciones de ambos jugadores
        // ejecutarAccionesEmpiladas(accionesj1, accionesj2, mapa);

        
        System.out.println("Presione cualquier tecla para continuar");
        MotorJuego.scanner.nextLine();

        // Incrementar el número de turno después de que ambos jugadores hayan terminado su turno
        numTurno++;

        // Si la partida ha terminado, salir del bucle
        // if(partidaTerminada(mapa)){
        //     partidaEnProgreso = false;
        // }
    }

}


    private void agregarMapa(Mapa nuevoMapa) {
        if (mapas == null) {
            mapas = new Mapa[1];
            mapas[0] = nuevoMapa;
        } else {
            Mapa[] nuevosMapas = new Mapa[mapas.length + 1];

            for (int i = 0; i < mapas.length; i++) {
                nuevosMapas[i] = mapas[i];
            }

            nuevosMapas[mapas.length] = nuevoMapa;

            mapas = nuevosMapas;
        }
    }

    // Métodos para acceder y modificar los jugadores y el mapa
    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void limpiarConsola() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}

