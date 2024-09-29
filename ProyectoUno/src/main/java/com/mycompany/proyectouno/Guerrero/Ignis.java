/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Guerrero;

/**
 *
 * @author ronaldo
 */
public class Ignis extends Guerrero {
    public Ignis() {
        super("Ignis", 1.75, 2);
    }

    @Override
    public String ataqueEspecial() {
        return "Lanza bolas de lava.";
    }
}
