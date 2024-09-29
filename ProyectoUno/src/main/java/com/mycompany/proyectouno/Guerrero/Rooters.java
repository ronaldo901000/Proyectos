/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Guerrero;

/**
 *
 * @author ronaldo
 */
public class Rooters extends Guerrero {
    public Rooters() {
        super("Rooters", 1.85, 3);
    }

    @Override
    public String ataqueEspecial() {
        return "Toca el suelo y tiene enredaderas trampa.";
    }
}
