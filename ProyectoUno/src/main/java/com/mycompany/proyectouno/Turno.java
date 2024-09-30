/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno;

import java.util.Scanner;

/**
 *
 * @author ronaldo
 */
public class Turno {
    private int numeroTurno;

    public int getNumeroTurno() {
        return numeroTurno;
    }

    public Turno(int numeroTurno) {
        this.numeroTurno = numeroTurno;
    }

    public String[] ejecutarTurno(int jugador, Mapa mapa, MotorJuego motorJuego){
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        String[] acciones = new String[2];

        while (true) {
            mapa.mostrarMapa();
            System.out.println("TURNO NUMERO: " + numeroTurno);
            menu.mostrarMenuTurno(jugador, motorJuego);
            String opcion = MotorJuego.scanner.nextLine();
            switch (opcion) {
                case "1" -> {
                    System.out.println("Medición de distancia");
                    System.out.println("Ingresa las coordenadas de dos planetas, ejemplo: A1, C7");
                    String parametros = scanner.nextLine();
                    Accion accion = new Accion(parametros, mapa, jugador);
                    accion.medirDistancia();
                    System.out.println("Presiona enter para continuar");
                    scanner.nextLine();
                }
                case "2" -> {
                    System.out.println("Ver planeta");
                    System.out.println("Ingresa las coordenadas del planeta ejemplo A3");
                    String parametros = MotorJuego.scanner.nextLine();
                    Accion accion = new Accion(parametros, mapa, jugador);
                    accion.verPlaneta();
                    System.out.println("Presiona enter para continuar");
                    scanner.nextLine();
                }
                case "4" -> {

                    System.out.println("Envio de flota");
                    System.out.println("Ingrese el planeta origen, cantidad de guerreros, tipo de guerreros, "
                            + "tipo de nave, planeta destino, dinero destinado a recursos");
                    System.out.println("Ejemplo: A1,21,Ignis,Galaxia Prime,G4, 80");
                    
                    String parametros = MotorJuego.scanner.nextLine();
                    acciones[0]= parametros;
                    Accion accion = new Accion(parametros, mapa, jugador);
                    accion.enviarFlota();
                }
                case "8" -> { // No se empila
                    if (jugador == 1) {
                        System.out.println(motorJuego.getJugador1().getNombre() + " ha terminado su turno");
                    } else {
                        System.out.println(motorJuego.getJugador2().getNombre() + " ha terminado su turno");
                    }
                    return acciones;
                }
            }
        }
    }
}

