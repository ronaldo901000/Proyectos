/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno;

import com.mycompany.proyectouno.Planeta.Planeta;
import java.util.Random;

/**
 *
 * @author ronaldo
 */
import java.util.Random;

public class Mapa {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";   // Color para Jugador 1
    public static final String ANSI_BLUE = "\u001B[34m";  // Color para Jugador 2
    public static final String LETRAS_VERDES = "\033[32m"; // Color para Neutral

    public static final String FONDO_NEGRO = "\u001B[40m";
    public static final String FONDO_ROJO = "\u001B[41m";   // Fondo para Jugador 1
    public static final String FONDO_AZUL = "\u001B[44m";   // Fondo para Jugador 2
    public static final String FONDO_VERDE = "\u001B[42m";  // Fondo para Neutral

    private Planeta[][] planetas;
    private int filas;
    private int columnas;
    private String nombre;
    private Random random;
    private Jugador jugador1;  // Atributo para el jugador 1
    private Jugador jugador2;  // Atributo para el jugador 2

    public Mapa(int filas, int columnas, String nombre, Jugador jugador1, Jugador jugador2) {
        this.filas = filas;
        this.columnas = columnas;
        this.nombre = nombre;
        this.jugador1 = jugador1;  // Inicializa el jugador 1
        this.jugador2 = jugador2;  // Inicializa el jugador 2
        planetas = new Planeta[filas][columnas];
        random = new Random();
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public String getNombre() {
        return nombre;
    }

    public Planeta[][] getPlanetas() {
        return planetas;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    // Agrega un planeta en una posición aleatoria disponible
    public void agregarPlaneta(Planeta planeta) {
        int fila;
        int columna;

        // Busca una casilla disponible de manera aleatoria
        do {
            fila = random.nextInt(filas);  // Genera una fila aleatoria
            columna = random.nextInt(columnas);  // Genera una columna aleatoria
        } while (!estaDisponible(fila, columna));  // Verifica si está disponible

        planetas[fila][columna] = planeta;  // Coloca el planeta en la casilla disponible
    }

    // Verifica si una casilla está disponible
    public boolean estaDisponible(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return planetas[fila][columna] == null;
        }
        return false;
    }

    // Retorna un planeta en una posición específica
    public Planeta obtenerPlaneta(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return planetas[fila][columna];
        }
        return null;
    }

    // Método para mostrar el mapa con fondo de colores
    public void mostrarMapa() {
        // Mostrar las letras para identificar las columnas
        System.out.print("     ");
        for (int columna = 0; columna < columnas; columna++) {
            String nombreColumna = generarNombreColumna(columna);
            System.out.print(ANSI_RED + FONDO_VERDE + "|    " + nombreColumna + "    " + ANSI_RESET);
        }
        System.out.println("|");

        // Mostrar el contenido del mapa fila por fila
        for (int i = 0; i < filas; i++) {
            // Mostrar el número de fila
            if (i <= 8) {
                System.out.print(ANSI_RED + FONDO_VERDE + " " + (i + 1) + "   " + ANSI_RESET);

            } else {
                System.out.print(ANSI_RED + FONDO_VERDE + " " + (i + 1) + "  " + ANSI_RESET);
            }
            // Mostrar el nombre del planeta o un punto si no hay planeta
            for (int j = 0; j < columnas; j++) {
                System.out.print("| ");  // Empieza la celda
                if (planetas[i][j] != null) {
                    // Obtener el nombre del planeta
                    String nombrePlaneta = planetas[i][j].getNombre();
                    // Limitar el nombre del planeta a 7 caracteres
                    if (nombrePlaneta.length() > 7) {
                        nombrePlaneta = nombrePlaneta.substring(0, 7);
                    } else {
                        while (nombrePlaneta.length() < 7) {
                            nombrePlaneta += " ";
                        }
                    }
                    // Obtener color de texto y fondo según el dueño
                    String colorFondo = obtenerFondoDueño(planetas[i][j].getDueño());
                    String colorTexto = obtenerColorDueño(planetas[i][j].getDueño());

                    // Mostrar el nombre del planeta con fondo y texto correspondiente
                    System.out.print(colorFondo + colorTexto + nombrePlaneta + " " + ANSI_RESET);
                } else {
                    // Si la casilla está vacía, mostrar un fondo negro y un punto
                    System.out.print(FONDO_NEGRO + "    .   " + ANSI_RESET);
                }
            }
            System.out.println("|");

            // Mostrar el dueño del planeta (o un punto si está vacío)
            System.out.print("     ");
            for (int j = 0; j < columnas; j++) {
                System.out.print("| ");
                if (planetas[i][j] != null) {
                    // Obtener el nombre del dueño
                    String nombreDueño;
                    if (planetas[i][j].getDueño() != null) {
                        nombreDueño = planetas[i][j].getDueño().getNombre();
                    } else {
                        nombreDueño = "Neutral";
                    }

                    // Limitar el nombre del dueño a 7 caracteres
                    if (nombreDueño.length() > 7) {
                        nombreDueño = nombreDueño.substring(0, 7);
                    } else {
                        while (nombreDueño.length() < 7) {
                            nombreDueño += " ";
                        }
                    }

                    // Obtener color de fondo y texto según el dueño
                    String colorFondo = obtenerFondoDueño(planetas[i][j].getDueño());
                    String colorTexto = obtenerColorDueño(planetas[i][j].getDueño());

                    // Mostrar el nombre del dueño con el color de fondo y texto correspondiente
                    System.out.print(colorFondo + colorTexto + nombreDueño + " " + ANSI_RESET);
                } else {
                    // Mostrar un fondo negro y un punto si la casilla está vacía
                    System.out.print(FONDO_NEGRO + "    .   " + ANSI_RESET);
                }
            }
            System.out.println("|");

            // Separador de filas
            System.out.print("     ");
            for (int j = 0; j < columnas; j++) {
                System.out.print("-----------");
            }
            System.out.println();
        }
    }

    // Método para obtener el color de texto del dueño
    private String obtenerColorDueño(Jugador dueño) {
        if (dueño == null) {
            return ANSI_BLUE;  // Neutral
        } else if (dueño.getNombre().equals(jugador1.getNombre())) {
            return LETRAS_VERDES;    // Jugador 1
        } else if (dueño.getNombre().equals(jugador2.getNombre())) {
            return LETRAS_VERDES;   // Jugador 2
        }
        return ANSI_RESET;      // Por defecto
    }

    // Método para obtener el color de fondo según el dueño
    private String obtenerFondoDueño(Jugador dueño) {
        if (dueño == null) {
            return FONDO_VERDE;  // Neutral
        } else if (dueño.getNombre().equals(jugador1.getNombre())) {
            return FONDO_ROJO;   // Jugador 1
        } else if (dueño.getNombre().equals(jugador2.getNombre())) {
            return FONDO_AZUL;   // Jugador 2
        }
        return FONDO_NEGRO;      // Fondo negro por defecto
    }

    // Método para generar nombres de columna como A, B, ..., Z, AA, AB...
    private String generarNombreColumna(int index) {
        String nombreColumna = "";
        while (index >= 0) {
            char letra = (char) ('A' + (index % 26));
            nombreColumna = letra + nombreColumna;
            index = (index / 26) - 1;
        }
        return nombreColumna;
    }
}


