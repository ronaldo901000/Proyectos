/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Planeta;

import com.mycompany.proyectouno.Guerrero.Guerrero;
import com.mycompany.proyectouno.Guerrero.Ignis;
import com.mycompany.proyectouno.Jugador;
import java.util.Random;

/**
 *
 * @author ronaldo
 */
public class Fuego extends Planeta {

    // Constructor de la subclase Agua
    public Fuego(String nombre, Jugador dueño, double probabilidadDistribucion) {
        super(nombre, dueño);
    }

    @Override
    protected Guerrero[] generarGuerrerosAleatorios() {
        int minimo = 10;  // Valor mínimo de guerreros
        int maximo = 20;  // Valor máximo de guerreros

        // Generar cantidad aleatoria de guerreros
        int cantidad = new Random().nextInt((maximo - minimo) + 1) + minimo;
        Guerrero[] guerrerosGenerados = new Guerrero[cantidad];

        // Inicializar guerreros con el tipo específico Aquaris
        for (int i = 0; i < cantidad; i++) {
            guerrerosGenerados[i] = new Ignis();  // Guerrero de tipo Aquaris
        }
        return guerrerosGenerados;
    }

    @Override
    public Guerrero crearGuerrero() {
        return new Ignis();  // Crear un guerrero de tipo Ignis
    }

    
    // Método para generar estelares por turno y sumar a la cantidad existente
    @Override
    public void generarEstelaresPorTurno() {
        int cantidadGenerada = new Random().nextInt(71) + 70;  // Genera entre 60 y 120 estelares
        this.estelares += cantidadGenerada;  // Suma a la cantidad existente
    }
}
