/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
// Clase Accion
public class Accion {

    private String parametros;
    private Mapa mapa;
    private int numeroJugador;

    public Accion(String parametros, Mapa mapa, int numeroJugador) {
        this.parametros = parametros;
        this.mapa = mapa;
        this.numeroJugador = numeroJugador;
    }

    public void enviarFlota() {
        // Parámetros: planeta origen, cantidad de guerreros, tipo de guerreros, tipo de nave, planeta destino, cantidad de estelares
        String[] params = parametros.split(",");
        int[] coordenadasOrigen = convertirCordenadas(params[0].trim());
        int cantidadGuerreros = Integer.valueOf(params[1].trim());
        String tipoGuerrero = params[2].trim();
        String tipoNave = params[3].trim();
        int[] coordenadasDestino = convertirCordenadas(params[4].trim());
        int cantidadEstelares = Integer.valueOf(params[5].trim());

        Flota flota = new Flota(mapa, numeroJugador, coordenadasOrigen, cantidadGuerreros, tipoGuerrero, tipoNave, coordenadasDestino, cantidadEstelares);
        flota.enviar();
    }

    public void medirDistancia() {
        int[] coordenadaPlaneta1 = convertirCordenadas(parametros.split(",")[0].trim());
        int[] coordenadaPlaneta2 = convertirCordenadas(parametros.split(",")[1].trim());

        int deltaX = coordenadaPlaneta2[0] - coordenadaPlaneta1[0];
        int deltaY = coordenadaPlaneta2[1] - coordenadaPlaneta1[1];

        double valor = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        double distancia = valor * 3; //cada casilla equivale a 3 años luz

        System.out.println("La distancia es de: " + distancia + " años luz.");
    }

    public void verPlaneta() {
        int[] coordenadas = convertirCordenadas(parametros.trim());

        if (coordenadas[1] - 1 >= 0 && coordenadas[1] - 1 < mapa.getFilas()
                && coordenadas[0] - 1 >= 0 && coordenadas[0] - 1 < mapa.getColumnas()) {

            Planeta planeta = mapa.obtenerPlaneta(coordenadas[1] - 1, coordenadas[0] - 1);

            if (planeta != null) {
                if (numeroJugador == 1) {
                    if (planeta.getDueño() == null || planeta.getDueño().getNombre().equals(mapa.getJugador1().getNombre())) {
                        System.out.println("Descripción del planeta:");
                        System.out.println("Nombre: " + planeta.getNombre());
                        System.out.println("Tipo de planeta: " + planeta.getClass().getSimpleName());
                        System.out.println("Dueño: " + (planeta.getDueño() != null ? planeta.getDueño().getNombre() : "Neutral"));
                        System.out.println("Cantidad de guerreros: " +planeta.getGuerreros().length);
                        System.out.println("Porcentaje de muerte: " + planeta.getPorcentajeDeMuerte());
                    } else {
                        System.out.println("No puedes ver este planeta ya que pertenece al jugador rival.");
                    }
                } else if (numeroJugador == 2) {
                    if (planeta.getDueño() == null || planeta.getDueño().getNombre().equals(mapa.getJugador2().getNombre())) {
                        System.out.println("Descripción del planeta:");
                        System.out.println("Nombre: " + planeta.getNombre());
                        System.out.println("Tipo de planeta: " + planeta.getClass().getSimpleName());
                        System.out.println("Dueño: " + (planeta.getDueño() != null ? planeta.getDueño().getNombre() : "Neutral"));
                        System.out.println("Porcentaje de muerte: " + planeta.getPorcentajeDeMuerte());
                    } else {
                        System.out.println("No puedes ver este planeta ya que pertenece al jugador rival.");
                    }
                }
            } else {
                System.out.println("No hay ningún planeta en las coordenadas especificadas.");
            }
        } else {
            System.out.println("Coordenadas fuera de los límites del mapa.");
        }
    }

    private int[] convertirCordenadas(String parametro) {
        int[] resultado = new int[2]; 
        int indiceNumero = 0;

        parametro = parametro.toUpperCase();

        for (int i = 0; i < parametro.length(); i++) {
            if (Character.isDigit(parametro.charAt(i))) {
                indiceNumero = i;
                break;
            }
        }

        String parteLetra = parametro.substring(0, indiceNumero);
        int numeroLetra = 0;
        for (int i = 0; i < parteLetra.length(); i++) {
            numeroLetra = numeroLetra * 26 + (parteLetra.charAt(i) - 'A' + 1);
        }

        String parteNumero = parametro.substring(indiceNumero);
        int numero = Integer.parseInt(parteNumero);

        resultado[0] = numeroLetra; 
        resultado[1] = numero;      

        return resultado;
    }

}

