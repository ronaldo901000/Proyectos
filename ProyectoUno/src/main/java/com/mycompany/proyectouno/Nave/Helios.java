/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Nave;

/**
 *
 * @author ronaldo
 */
public class Helios extends Nave {
    public Helios() {
        super("Helios", 25, 97, 6, 1.5, 40, 1.0);
    }

    @Override
    public void efectoTasaSupervivencia(double tasaSupervivencia, int cantidadGuerreros) {
        if (tasaSupervivencia >= 30) {
            int guerrerosSobreviven = (int) (cantidadGuerreros * (tasaSupervivencia / 100));
            System.out.println("Helios llega con " + guerrerosSobreviven + " de " + cantidadGuerreros + " guerreros.");
        } else {
            System.out.println("Probabilidad alta de que la Helios se pierda en el espacio.");
        }
    }
}
