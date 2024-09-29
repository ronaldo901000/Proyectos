/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Nave;

/**
 *
 * @author ronaldo
 */
public class Nebulon extends Nave {
    public Nebulon() {
        super("Nebulon", 58, 87, 3, 4, 70, 1.5);
    }

    @Override
    public void efectoTasaSupervivencia(double tasaSupervivencia, int cantidadGuerreros) {
        if (tasaSupervivencia >= 30) {
            int guerrerosSobreviven = (int) (cantidadGuerreros * (tasaSupervivencia / 100));
            System.out.println("Nebulon llega con " + guerrerosSobreviven + " de " + cantidadGuerreros + " guerreros.");
        } else {
            System.out.println("Probabilidad alta de que la Nebulon se pierda en el espacio.");
        }
    }
}
