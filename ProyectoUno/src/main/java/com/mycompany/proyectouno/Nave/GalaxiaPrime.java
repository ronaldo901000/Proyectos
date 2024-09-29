/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Nave;

/**
 *
 * @author ronaldo
 */
public class GalaxiaPrime extends Nave {
    public GalaxiaPrime() {
        super("Galaxia Prime", 42, 93, 5, 2, 50, 1.25);
    }

    @Override
    public void efectoTasaSupervivencia(double tasaSupervivencia, int cantidadGuerreros) {
        if (tasaSupervivencia >= 30) {
            int guerrerosSobreviven = (int) (cantidadGuerreros * (tasaSupervivencia / 100));
            System.out.println("Galaxia Prime llega con " + guerrerosSobreviven + " de " + cantidadGuerreros + " guerreros.");
        } else {
            System.out.println("Probabilidad alta de que la Galaxia Prime se pierda en el espacio.");
        }
    }
}
