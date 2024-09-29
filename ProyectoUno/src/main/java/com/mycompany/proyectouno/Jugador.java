/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno;

import com.mycompany.proyectouno.Planeta.Planeta;

/**
 *
 * @author ronaldo
 */
public class Jugador {
    private String nombre;
    private int cantidadConquistas;
    private Planeta[] planetasConquistados;


    public Jugador (String nombre) {
        this.nombre = nombre;
        planetasConquistados = new Planeta[cantidadConquistas];  // Ejemplo de tamaño, lo puedes ajustar
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPlaneta(Planeta planeta) {
        for (int i = 0; i < planetasConquistados.length; i++) {
            if (planetasConquistados[i] == null) {
                planetasConquistados[i] = planeta;
                break;
            }
        }
    }

    public Planeta[] getPlanetasConquistados() {
        return planetasConquistados;
    }
    
    
}
