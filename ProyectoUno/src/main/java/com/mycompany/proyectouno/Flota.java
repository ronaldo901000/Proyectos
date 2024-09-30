package com.mycompany.proyectouno;

import com.mycompany.proyectouno.Guerrero.Guerrero;
import com.mycompany.proyectouno.Guerrero.Rdonix;
import com.mycompany.proyectouno.Nave.Helios;
import com.mycompany.proyectouno.Nave.Nave;
import com.mycompany.proyectouno.Planeta.Planeta;

/**
 *
 * @author ronaldo
 */
public class Flota {

    private Mapa mapa;
    private int numeroJugador;
    private int[] coordenadasOrigen;
    private int cantidadGuerreros;
    private String tipoGuerrero;
    private String tipoNave;
    private int[] coordenadasDestino;
    private int cantidadEstelares;

    public Flota(Mapa mapa, int numeroJugador, int[] coordenadasOrigen, int cantidadGuerreros, String tipoGuerrero, String tipoNave, int[] coordenadasDestino, int cantidadEstelares) {
        this.mapa = mapa;
        this.numeroJugador = numeroJugador;
        this.coordenadasOrigen = coordenadasOrigen;
        this.cantidadGuerreros = cantidadGuerreros;
        this.tipoGuerrero = tipoGuerrero;
        this.tipoNave = tipoNave;
        this.coordenadasDestino = coordenadasDestino;
        this.cantidadEstelares = cantidadEstelares;
    }

public void enviar() {
    // Verificar si las coordenadas de destino están dentro del rango del mapa
    if (coordenadasDestino[0] - 1 >= 0 && coordenadasDestino[0] - 1 < mapa.getFilas()
        && coordenadasDestino[1] - 1 >= 0 && coordenadasDestino[1] - 1 < mapa.getColumnas()) {

        // Obtener el planeta destino usando el método obtenerPlaneta
        Planeta destino = mapa.obtenerPlaneta(coordenadasDestino[1] - 1, coordenadasDestino[0] - 1);

        if (destino != null) {
            // Continuar con el proceso de enviar guerreros
            Guerrero[] guerrerosOrigen = new Guerrero[cantidadGuerreros];
            for (int i = 0; i < guerrerosOrigen.length; i++) {
                guerrerosOrigen[i] = new Rdonix(); 
            }

            Guerrero[] guerrerosDestino = destino.getGuerreros();
            Jugador atacante = (numeroJugador == 1) ? mapa.getJugador1() : mapa.getJugador2();
            double distancia = calcularDistancia(coordenadasOrigen, coordenadasDestino);
            Nave nave = obtenerNave(tipoNave);
            double tasaSupervivencia = nave.calcularTasaSupervivencia(distancia, cantidadEstelares);
            aplicarEfectosSupervivencia(tasaSupervivencia, guerrerosOrigen);
            enfrentarGuerreros(guerrerosOrigen, guerrerosDestino, destino, atacante);
        } 
        else {
            System.out.println("No hay un planeta en las coordenadas de destino.");
        }
    }
    else {
        System.out.println("Las coordenadas de destino están fuera de los límites del mapa.");
    }
}


    private double calcularDistancia(int[] origen, int[] destino) {
        int deltaX = destino[0] - origen[0];
        int deltaY = destino[1] - origen[1];
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY) * 5; 
    }

    public void aplicarEfectosSupervivencia(double tasaSupervivencia, Guerrero[] guerreros) {
        if (tasaSupervivencia >= 30) {
            int guerrerosSobrevivientes = (int) Math.round((tasaSupervivencia / 100) * guerreros.length);
            System.out.println(guerrerosSobrevivientes + " guerreros han sobrevivido al viaje.");
            Guerrero[] guerrerosFinal = new Guerrero[guerrerosSobrevivientes];
            System.arraycopy(guerreros, 0, guerrerosFinal, 0, guerrerosSobrevivientes);
            guerreros = guerrerosFinal;
        } else {
            double probabilidadPerderNave = Math.random();
            if (probabilidadPerderNave <= 0.5) {
                System.out.println("La nave se ha perdido en el espacio. Todos los guerreros han muerto.");
                guerreros = new Guerrero[0]; 
            } else {
                System.out.println("La nave ha llegado a su destino, aunque estuvo a punto de perderse.");
                System.out.println("Todos los guerreros sobreviven como recompensa.");
                for (int i = 0; i < guerreros.length; i++) {
                    guerreros[i].incrementarFactorMuerte(1.99); 
                }
            }
        }
    }

    private Nave obtenerNave(String tipoNave) {
        if (tipoNave.equalsIgnoreCase("Helios")) {
            return new Helios(); 
        }
        return null;
    }

    private void enfrentarGuerreros(Guerrero[] guerrerosOrigen, Guerrero[] guerrerosDestino, Planeta planetaDestino, Jugador atacante) {
        int victoriasOrigen = 0;
        int victoriasDestino = 0;

        int minTropas = Math.min(guerrerosOrigen.length, guerrerosDestino.length);

        for (int i = 0; i < minTropas; i++) {
            if (guerrerosDestino[i] != null) {
                if (guerrerosOrigen[i].getFactorMuerte() > guerrerosDestino[i].getFactorMuerte()) {
                    victoriasOrigen++;
                } else {
                    victoriasDestino++;
                }
            }
        }

        if (guerrerosOrigen.length > minTropas) {
            victoriasOrigen += (guerrerosOrigen.length - minTropas);
        } else if (guerrerosDestino.length > minTropas) {
            victoriasDestino += (guerrerosDestino.length - minTropas);
        }

        if (victoriasOrigen > victoriasDestino) {
            System.out.println("El bando atacante ha ganado con " + victoriasOrigen + " victorias.");
            planetaDestino.setDueño(atacante);
        } else if (victoriasDestino > victoriasOrigen) {
            System.out.println("El bando defensor ha ganado con " + victoriasDestino + " victorias.");
        } else {
            System.out.println("El enfrentamiento ha terminado en empate.");
        }
    }
}

