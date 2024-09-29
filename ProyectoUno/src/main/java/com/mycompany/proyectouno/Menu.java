/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno;

/**
 *
 * @author ronaldo
 */
public class Menu {

    public void mostrarMenuInicio(){
        System.out.println("Seleccione una opción (1-3)");
        System.out.println("1) Crear Mapa");
        System.out.println("2) Iniciar Partida");
        System.out.println("3) Salir");
    }

    public void mostrarMenuTurno(int numeroJugador, MotorJuego motorJuego){
        String nombreJugador;
        
        if (numeroJugador == 1) {
            nombreJugador = motorJuego.getJugador1().getNombre();
        } else {
            nombreJugador = motorJuego.getJugador2().getNombre();
        }

        System.out.println("Turno del jugador: " + nombreJugador);
        System.out.println("Seleccione una opción (1-9):");
        System.out.println("1) Medir distancia");
        System.out.println("2) Ver planeta");
        System.out.println("3) Consultar flota");
        System.out.println("4) Enviar flota");
        System.out.println("5) Simular envío de flota");
        System.out.println("6) Construir nave");
        System.out.println("7) Tienda");
        System.out.println("8) Terminar turno");
        System.out.println("9) Rendirse");
    }
}

