/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.mapas.casilla;

import com.mycompany.treasurehunter.Jugador;
/**
 *
 * @author ronaldo
 */
public class CasillaTrampa extends Casilla {

    private int cantidadPenalizacion;
    private int tipoPenalizacion;

    public CasillaTrampa(Jugador jugador, int[] posicion) {
        super(posicion, jugador);
    }

    
    @Override
    public String pintarCasilla() {
        String casillaPintada;
        String simboloPersonaje = "X";
        verificarSiJugadorEstaEnLaCasilla();
        if (estaElJugadorAqui) {
            casillaPintada = color.FONDO_ROJO_BR + "  " + simboloPersonaje + "  " + color.REINICIAR_COLOR;
        } else {
            casillaPintada = color.FONDO_ROJO_BR + "     " + color.REINICIAR_COLOR;
        }
        return casillaPintada;
    }

    @Override
    public void crearAccionCasilla() {
        //Se selecciona el tipo de trampa que es un atributo de la clase
        seleccionarTipoDeTrampa();
        int cantidad;
        do {
            System.out.println("Selecciona la cantidad de puntos a restar entre 1 y 10 ");
            cantidad = lector.leerNumero();
            if (cantidad < 1 || cantidad > 10) {
                System.out.println("Por favor ingresa valores entre 1 y 10");
            }
        } while (cantidad < 1 || cantidad > 10);
        cantidadPenalizacion = cantidad;

    }

    @Override
    public void realizarAccion() {
        System.out.println("Has caido en una casilla trampa");
        System.out.println();
        if (tipoPenalizacion == 1) {
            System.out.println("Tipo de trampa descuento de Hp");
            int cantidadHpActual = jugador.getHp();
            jugador.setHp(cantidadHpActual - cantidadPenalizacion);
            System.out.println("Puntos de HP actuales: " + jugador.getHp());
        } else if (tipoPenalizacion == 2) {
            System.out.println("Tipo de trampa descuento de Mp");
            int cantidadMpActual = jugador.getMp();
            jugador.setHp(cantidadMpActual - cantidadPenalizacion);
            System.out.println("Puntos de MP acutales: " + jugador.getMp());
        }
    }

    public void seleccionarTipoDeTrampa() {

        int tipo;
        do {
            System.out.println("Selecciona el tipo de trampa");
            System.out.println("1. Restar puntos de vida (HP)");
            System.out.println("2. Restar puntos de mana (MP)");
            tipo = lector.leerNumero();
            if (tipo < 1 || tipo > 2) {
                System.out.println("Selecciona la opcion entre 1-2");
            }
        } while (tipo < 1 || tipo > 2);
        tipoPenalizacion = tipo;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

}
