/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Guerrero;

/**
 *
 * @author ronaldo
 */
public abstract class Guerrero {
    private String nombre;
    private double factorMuerte;
    private int espacioNave;

    public Guerrero(String nombre, double factorMuerte, int espacioNave) {
        this.nombre = nombre;
        this.factorMuerte = factorMuerte;
        this.espacioNave = espacioNave;
    }

    public String getNombre() {
        return nombre;
    }

    public double getFactorMuerte() {
        return factorMuerte;
    }

    public int getEspacioNave() {
        return espacioNave;
    }

    public abstract String ataqueEspecial(); // Método abstracto para el ataque especial

    
}
