/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Nave;

import com.mycompany.proyectouno.Guerrero.Guerrero;

/**
 *
 * @author ronaldo
 */
public class Nebulon extends Nave {
    public Nebulon() {
        super("Nebulon", 58, 87, 3, 4, 70, 1.5);
    }

 public double calcularTasaSupervivencia(double distancia, double recursosAdicionales) {
        // Cálculo de la Tasa de Supervivencia
        double tasaSupervivencia = tasaBase - (distancia * factorDistancia) + (recursosAdicionales / 10) * factorRecursos;

        // Limitar la tasa de supervivencia entre 0 y 100
        double tasaFinal;
        if (tasaSupervivencia < 0) {
            tasaFinal = 0;
        } else if (tasaSupervivencia > 100) {
            tasaFinal = 100;
        } else {
            tasaFinal = tasaSupervivencia;
        }

        return tasaFinal;
    }

public void aplicarEfectosSupervivencia(double tasaSupervivencia, Guerrero[] guerreros) {
    if (tasaSupervivencia >= 30) {
        // Si la TS es mayor o igual al 30%, la nave llega al destino, pero no todos los guerreros sobreviven
        int guerrerosSobrevivientes = (int) Math.round((tasaSupervivencia / 100) * guerreros.length);
        System.out.println(guerrerosSobrevivientes + " guerreros han sobrevivido al viaje.");
    } else {
        // Si la TS es inferior al 30%, existe un 50% de probabilidad de perder la nave cada 2 turnos
        double probabilidadPerderNave = Math.random();
        if (probabilidadPerderNave <= 0.5) {
            System.out.println("La nave se ha perdido en el espacio. Todos los guerreros han muerto.");
            // Se pierden todos los guerreros
            guerreros = new Guerrero[0];
        } else {
            System.out.println("La nave ha llegado a su destino, pero estuvo cerca de perderse.");
            System.out.println("Todos los guerreros sobreviven como recompensa.");
            // Como recompensa, todos los guerreros sobreviven y el factor de muerte incrementa en +1.99
            for (int i = 0; i < guerreros.length; i++) {
                guerreros[i].incrementarFactorMuerte(1.99);
            }
        }
    }
}
}
