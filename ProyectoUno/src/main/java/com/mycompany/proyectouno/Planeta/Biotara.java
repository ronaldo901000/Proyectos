/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Planeta;

import com.mycompany.proyectouno.Guerrero.Guerrero;
import com.mycompany.proyectouno.Guerrero.Rooters;
import com.mycompany.proyectouno.Jugador;
import java.util.Random;

/**
 *
 * @author ronaldo
 */
public class Biotara extends Planeta {

    // Constructor de la subclase Agua
    public Biotara(String nombre, Jugador dueño, double probabilidadDistribucion) {
        super(nombre, dueño);
    }

    /**
     *
     * @return
     */
    @Override
    protected Guerrero[] generarGuerrerosAleatorios() {
        int minimo = 5;  // Valor mínimo de guerreros
        int maximo = 15;  // Valor máximo de guerreros

        // Generar cantidad aleatoria de guerreros
        int cantidad = new Random().nextInt((maximo - minimo) + 1) + minimo;
        Guerrero[] guerrerosGenerados = new Guerrero[cantidad];

        // Inicializar guerreros con el tipo específico Aquaris
        for (int i = 0; i < cantidad; i++) {
            guerrerosGenerados[i] = new Rooters();  // Guerrero de tipo Aquaris
        }
        return guerrerosGenerados;
    }

    @Override
    public Guerrero crearGuerrero() {
        return new Rooters();  // Crear un guerrero de tipo Aquaris
    }


    
    // Método para generar estelares por turno y sumar a la cantidad existente
    public void generarEstelaresPorTurno() {
        int cantidadGenerada = new Random().nextInt(81) + 80;  // Genera entre 60 y 120 estelares
        this.estelares += cantidadGenerada;  // Suma a la cantidad existente
    }
    
}
