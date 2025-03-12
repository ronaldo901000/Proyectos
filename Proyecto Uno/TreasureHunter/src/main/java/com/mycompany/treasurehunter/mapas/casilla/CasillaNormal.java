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
public class CasillaNormal extends Casilla {

    public CasillaNormal(int[] posicion, Jugador jugador) {
        super(posicion, jugador);
    }

    @Override
    public void crearAccionCasilla() {

    }

    @Override
    public String pintarCasilla() {
        verificarSiJugadorEstaEnLaCasilla();
        String casillaPintada;
        String simboloPersonaje = "X";

        if (estaElJugadorAqui) {
            casillaPintada = color.FONDO_NEGRO + "  " + simboloPersonaje + "  " + color.REINICIAR_COLOR;
        } else {
            casillaPintada = color.FONDO_NEGRO + "     " + color.REINICIAR_COLOR;
        }

        return casillaPintada;
    }

}
