/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter;

import com.mycompany.treasurehunter.adicionales.Color;
import com.mycompany.treasurehunter.adicionales.LectorEnteros;

/**
 *
 * @author ronaldo
 */
public class Menu {

    Color color;

    public Menu() {
        color = new Color();
    }

    public void mostrarTituloJuego() {
        System.out.println(color.FONDO_GRIS + color.LETRAS_VERDES + "TREASURE HUNTER" + color.REINICIAR_COLOR);
        System.out.println("");
    }

    public void mostrarMenuPrincipal() {
        mostrarTituloJuego();
        System.out.println(color.FONDO_GRIS + color.LETRAS_AMARILLAS + "|--------------------MENU--------------------|" + color.REINICIAR_COLOR);
        System.out.println("");
        System.out.println(color.LETRAS_VERDES +"    "+"1. Juego Treasure Hunter" + color.REINICIAR_COLOR);
        System.out.println(color.LETRAS_VERDES +"    " +"2. Reportes" + color.REINICIAR_COLOR);
        System.out.println(color.LETRAS_VERDES +"    " + "3. Salir" + color.REINICIAR_COLOR);
        System.out.println("");
        System.out.print(color.LETRAS_AMARILLAS +"    " + "Selecciona una opción: " + color.REINICIAR_COLOR);

    }

    public void mostrarMenuJuego() {
        System.out.println(color.FONDO_GRIS + color.LETRAS_AMARILLAS + "|---------------MENU TREASURE HUNTER---------------|" + color.REINICIAR_COLOR);
        System.out.println(color.LETRAS_VERDES + "1. Iniciar una partida" + color.REINICIAR_COLOR);
        System.out.println(color.LETRAS_VERDES + "2. Crear un mapa" + color.REINICIAR_COLOR);
        System.out.println(color.LETRAS_VERDES + "3. Editar un mapa" + color.REINICIAR_COLOR);
        System.out.println(color.LETRAS_VERDES + "4. Salir" + color.REINICIAR_COLOR);
        System.out.println("");
        System.out.print(color.LETRAS_AMARILLAS + "Selecciona una opción: " + color.REINICIAR_COLOR);

    }

    public int menuCasillaNormal() {
        int opcion;
        LectorEnteros lector = new LectorEnteros();
        do {
            System.out.println("");
            System.out.println("|----------MENU DE CASILLAS----------|");
            System.out.println("");
            System.out.println("1. Casilla Normal");
            System.out.println("2. Casilla Trampa");
            System.out.println("3. Casilla Pista");
            System.out.println("4. Casilla Teletransporte");
            System.out.println("5. Casilla Muro");
            System.out.println("6. Casiila Energia");
            System.out.println("7. Casilla Enemigos (minijuego)");
            System.out.println("");
            System.out.print("Selecciona una opcion: ");
            System.out.println("-----------------------------------------------");
            opcion = lector.leerNumero();
            if (opcion < 1 || opcion > 7) {
                aviso(1, 7);
            }

        } while (opcion < 1 || opcion > 7);
        return opcion;
    }

    public int menuCasillaSinCasillaMuro() {
        int opcion;
        LectorEnteros excepcion = new LectorEnteros();
        do {
            System.out.println("|----------MENU DE CASILLAS----------|");
            System.out.println("");
            System.out.println("1. Casilla Normal");
            System.out.println("2. Casilla Trampa");
            System.out.println("3. Casilla Pista");
            System.out.println("4. Casilla Teletransporte");
            System.out.println("5. Casilla muro  - no disponible para esta casilla");
            System.out.println("6. Casiila Energia");
            System.out.println("7. Casilla Enemigos (minijuego)");
            System.out.print("Selecciona una opcion: ");
            opcion = excepcion.leerNumero();
            if (opcion < 1 || opcion > 7 || opcion == 5) {
                aviso(1, 7);
                if (opcion == 5) {
                    System.out.println("La casilla muro no esta disponible");
                }
            }

        } while (opcion < 1 || opcion > 7 || opcion == 5);
        return opcion;
    }

    public int menuPartida() {
        int opcion;
         LectorEnteros lector = new LectorEnteros();
        do{
            System.out.println("|--------------ACCIONES DE PARTIDA--------------|");
            System.out.println("");
            System.out.println("1. Moverse");
            System.out.println("2. Ver Pista");
            System.out.println("3. Ver todas las pistas");
            System.out.println("4. Ver estado del jugador");
            System.out.println("5. Guardar Partida");
            System.out.println("6. Salir");
            System.out.println("");
            System.out.print("Selecciona una Accion: ");
            opcion =lector.leerNumero();
            if(opcion<1 || opcion>6){
                aviso(1, 6);
            }
            
        }while(opcion<1 || opcion>6);
        return opcion;
    }

    public void aviso(int valorMinimo, int valoMaximo) {
        System.out.println("Ingresa valores entre " + valorMinimo + " - " + valoMaximo);
    }

}
