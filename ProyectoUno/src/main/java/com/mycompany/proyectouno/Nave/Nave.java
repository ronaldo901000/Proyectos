/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Nave;

/**
 *
 * @author ronaldo
 */
public abstract class Nave {
    private String nombre;
    private int capacidad;
    private double tasaBase;
    private double factorDistancia;
    private double factorRecursos;
    private int costoProduccion;
    private double velocidad;

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

    // Método para calcular la Tasa de Supervivencia
    public double calcularTasaSupervivencia(double distancia, double recursosAdicionales) {
        double tasaSupervivencia = tasaBase - (distancia * factorDistancia) + (recursosAdicionales / 10) * factorRecursos;
        return Math.max(0, Math.min(tasaSupervivencia, 100));  // Asegura que la tasa esté entre 0 y 100
    }

    // Método abstracto para el efecto de la Tasa de Supervivencia
    public abstract void efectoTasaSupervivencia(double tasaSupervivencia, int cantidadGuerreros);
}
