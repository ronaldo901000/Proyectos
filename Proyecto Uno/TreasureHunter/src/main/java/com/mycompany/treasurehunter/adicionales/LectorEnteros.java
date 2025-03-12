/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.adicionales;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ronaldo
 */
public class LectorEnteros {

    Scanner scanner;
    public static final String LETRAS_ROJAS = "\033[91m";
    public static final String FONDO_NEGRO = "\033[40m";
    public static final String REINICIAR_COLOR = "\033[0m";

    public int leerNumero() {
        scanner = new Scanner(System.in);
        int numero = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                numero = scanner.nextInt();
                entradaValida = true;  // SI INGRESA UN INTERO SE TOMA COMO VALIDA 
            } catch (InputMismatchException e) {
                System.out.println("    " + LETRAS_ROJAS + FONDO_NEGRO + "Error: Entrada no válida. Debe ingresar un número entero, el que  indique el menú" + REINICIAR_COLOR);
                scanner.next();
            }
        }
        scanner.nextLine();
        return numero;
    }

    
}
