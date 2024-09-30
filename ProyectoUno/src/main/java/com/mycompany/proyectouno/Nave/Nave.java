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
public abstract class Nave {
    protected String nombre;
    protected int capacidad;
    protected double tasaBase;
    protected double factorDistancia;
    protected double factorRecursos;
    protected int costoProduccion;
    protected double velocidad;

    public Nave(String nombre, int capacidad, double tasaBase, double factorDistancia, double factorRecursos, int costoProduccion, double velocidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tasaBase = tasaBase;
        this.factorDistancia = factorDistancia;
        this.factorRecursos = factorRecursos;
        this.costoProduccion = costoProduccion;
        this.velocidad = velocidad;
    }


    // Métodos Getters
    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public double getTasaBase() {
        return tasaBase;
    }

    public double getFactorDistancia() {
        return factorDistancia;
    }

    public double getFactorRecursos() {
        return factorRecursos;
    }

    public int getCostoProduccion() {
        return costoProduccion;
    }

    public double getVelocidad() {
        return velocidad;
    }

   public abstract double calcularTasaSupervivencia(double distancia, double recursosAdicionales);

}
