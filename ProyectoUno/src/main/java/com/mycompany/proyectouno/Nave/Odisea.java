/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Nave;

/**
 *
 * @author ronaldo
 */
public class Odisea extends Nave {
    public Odisea() {
        super("Odisea", 80, 75, 6, 7, 100, 1.75);
    }

    @Override
    public void efectoTasaSupervivencia(double tasaSupervivencia, int cantidadGuerreros) {
        if (tasaSupervivencia >= 30) {
            int guerrerosSobreviven = (int) (cantidadGuerreros * (tasaSupervivencia / 100));
            System.out.println("Odisea llega con " + guerrerosSobreviven + " de " + cantidadGuerreros + " guerreros.");
        } else {
            System.out.println("Probabilidad alta de que la Odisea se pierda en el espacio.");
        }
    }
}

