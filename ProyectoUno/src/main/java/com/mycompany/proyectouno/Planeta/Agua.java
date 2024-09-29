/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Planeta;

import com.mycompany.proyectouno.Guerrero.Aquaris;
import com.mycompany.proyectouno.Guerrero.Guerrero;
import com.mycompany.proyectouno.Jugador;
import java.util.Random;

/**
 *
 * @author ronaldo
 */
public class Agua extends Planeta {

    // Constructor de la subclase Agua
    public Agua(String nombre, Jugador dueño, double probabilidadDistribucion) {
        super(nombre, dueño);
    }

    @Override
    protected Guerrero[] generarGuerrerosAleatorios() {
        int minimo = 12;  // Valor mínimo de guerreros
        int maximo = 23;  // Valor máximo de guerreros

        // Generar cantidad aleatoria de guerreros
        int cantidad = new Random().nextInt((maximo - minimo) + 1) + minimo;
        Guerrero[] guerrerosGenerados = new Guerrero[cantidad];

        // Inicializar guerreros con el tipo específico Aquaris
        for (int i = 0; i < cantidad; i++) {
            guerrerosGenerados[i] = new Aquaris();  // Guerrero de tipo Aquaris
        }
        return guerrerosGenerados;
    }

    @Override
    public Guerrero crearGuerrero() {
        return new Aquaris();  // Crear un guerrero de tipo Aquaris
    }


    
    // Método para generar estelares por turno y sumar a la cantidad existente
    public void generarEstelaresPorTurno() {
        int cantidadGenerada = new Random().nextInt(61) + 60;  // Genera entre 60 y 120 estelares
        this.estelares += cantidadGenerada;  // Suma a la cantidad existente
    }
}
