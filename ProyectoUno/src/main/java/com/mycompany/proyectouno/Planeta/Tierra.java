
package com.mycompany.proyectouno.Planeta;

import com.mycompany.proyectouno.Guerrero.Guerrero;
import com.mycompany.proyectouno.Guerrero.Terradiente;
import com.mycompany.proyectouno.Jugador;
import java.util.Random;

/**
 *
 * @author ronaldo
 */
public class Tierra extends Planeta {


    // Constructor de la subclase Agua
    public Tierra(String nombre, Jugador dueño, double probabilidadDistribucion) {
        super(nombre, dueño);
    }

    @Override
    protected Guerrero[] generarGuerrerosAleatorios() {
        int minimo = 13;  // Valor mínimo de guerreros
        int maximo = 25;  // Valor máximo de guerreros

        // Generar cantidad aleatoria de guerreros
        int cantidad = new Random().nextInt((maximo - minimo) + 1) + minimo;
        Guerrero[] guerrerosGenerados = new Guerrero[cantidad];

        // Inicializar guerreros con el tipo específico Aquaris
        for (int i = 0; i < cantidad; i++) {
            guerrerosGenerados[i] = new Terradiente();  // Guerrero de tipo Aquaris
        }
        return guerrerosGenerados;
    }

    @Override
    public Guerrero crearGuerrero() {
        return new Terradiente();  // Crear un guerrero de tipo Aquaris
    }

    
    // Método para generar estelares por turno y sumar a la cantidad existente
    public void generarEstelaresPorTurno() {
        int cantidadGenerada = new Random().nextInt(51) + 50;  // Genera entre 60 y 120 estelares
        this.estelares += cantidadGenerada;  // Suma a la cantidad existente
    }
}
