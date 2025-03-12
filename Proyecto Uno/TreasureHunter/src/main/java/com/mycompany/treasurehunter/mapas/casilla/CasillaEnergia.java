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
public class CasillaEnergia extends Casilla {
    private int tipoDeEnergia;
    private int cantidadDeEnergia;

    public CasillaEnergia(int [] posicion,Jugador jugador) {
        super(posicion, jugador);
    }

    @Override
    public String pintarCasilla() {
      
        verificarSiJugadorEstaEnLaCasilla();
        String casillaPintada;
        String simboloPersonaje = "X";

        if (estaElJugadorAqui) {
            casillaPintada = color.FONDO_VERDE + "  " + simboloPersonaje + "  " + color.REINICIAR_COLOR;
        } else {
            casillaPintada = color.FONDO_VERDE + "     " + color.REINICIAR_COLOR;
        }

        return casillaPintada;
    }

    @Override
    public void crearAccionCasilla() {
        seleccionarCantidadDeEnergia();
        seleccionarTipoDeEnergia();
    }

    public void seleccionarTipoDeEnergia() {
        do {
            System.out.println("Selecciona el tipo de energia que proporcionará esta casilla al jugador");
            System.out.println("1. Puntos de vida HP");
            System.out.println("2. Puntos de mana");
            tipoDeEnergia = lector.leerNumero();
            if (tipoDeEnergia < 1 || tipoDeEnergia > 2) {
                System.out.println("Selecciona opciones entre 1-2");
            }
        } while (tipoDeEnergia < 1 || tipoDeEnergia > 2);

    }

    @Override
    public void realizarAccion() {
        System.out.println("Entrando a CASILLA Energia");
        if (tipoDeEnergia == 1) {
            int cantidadAnteriorDeHp = jugador.getHp();
            jugador.setHp(cantidadAnteriorDeHp + cantidadDeEnergia);
        } else if (tipoDeEnergia == 2) {
            int cantidadAnteriorDeMp = jugador.getMp();
            jugador.setHp(cantidadAnteriorDeMp + cantidadDeEnergia);
        }

    }

    public void seleccionarCantidadDeEnergia() {
        do {
            System.out.println("Selecciona la cantidad de energia para esta casilla entre 1 y 10");
            cantidadDeEnergia = lector.leerNumero();
            if (cantidadDeEnergia < 1 || cantidadDeEnergia > 10) {
                System.out.println("Selecciona valores entre 1-10");
            }
        } while (cantidadDeEnergia < 1 || cantidadDeEnergia > 10);
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    
}
