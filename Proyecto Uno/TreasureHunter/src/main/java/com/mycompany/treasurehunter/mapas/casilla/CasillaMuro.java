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
public class CasillaMuro extends Casilla {

    public CasillaMuro(int[] posicion, Jugador jugador) {
        super(posicion, jugador);
    }
    
    

    @Override
    public String pintarCasilla() {
        // Asegura que color está inicializado
        verificarSiJugadorEstaEnLaCasilla();
        String casillaPintada;
        String simboloPersonaje = "X";

        if (estaElJugadorAqui) {
            casillaPintada = color.FONDO_MORADO + "  " + simboloPersonaje + "  " + color.REINICIAR_COLOR;
        } else {
            casillaPintada = color.FONDO_MORADO + "     " + color.REINICIAR_COLOR;
        }

        return casillaPintada;
    }

    @Override
    public void realizarAccion() {
        System.out.println("No puedes pasar hay un muro, rodealo");

    }
}
