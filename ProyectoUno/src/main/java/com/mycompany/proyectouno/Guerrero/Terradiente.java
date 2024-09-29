/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Guerrero;

/**
 *
 * @author ronaldo
 */
public class Terradiente extends Guerrero {
    public Terradiente() {
        super("Terradiente", 1.5, 1);
    }

    @Override
    public String ataqueEspecial() {
        return "Entierra a sus víctimas.";
    }
}
