/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Editor;

import com.mycompany.proyectouno.Constructor.Constructor;
import com.mycompany.proyectouno.Constructor.Obrero;
import com.mycompany.proyectouno.Guerrero.Guerrero;
import com.mycompany.proyectouno.Jugador;
import com.mycompany.proyectouno.Nave.Helios;
import com.mycompany.proyectouno.Nave.Nave;
import com.mycompany.proyectouno.Planeta.Agua;
import com.mycompany.proyectouno.Planeta.Biotara;
import com.mycompany.proyectouno.Planeta.Fuego;
import com.mycompany.proyectouno.Planeta.Planeta;
import com.mycompany.proyectouno.Planeta.Radioactivo;
import com.mycompany.proyectouno.Planeta.Tierra;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ronaldo
 */
public class EditorPlaneta {

    // Método para generar una probabilidad de distribución aleatoria
    private double generarPorcentajeMuerte() {
        Random random = new Random();
        return 0.1 + (0.9999 - 0.1) * random.nextDouble();
    }

    // Método para seleccionar un planeta aleatorio basado en probabilidades
    public Planeta seleccionarPlanetaAleatorio(String nombrePlaneta, Jugador jugador) {
        Random random = new Random();
        int probabilidad = random.nextInt(100) + 1;  // Número entre 1 y 100

        if (probabilidad <= 35) {
            // Planeta Tierra 35%
            return new Tierra(nombrePlaneta, jugador, generarPorcentajeMuerte());
        } else if (probabilidad <= 25) {
            // Planeta Agua 25%
            return new Agua(nombrePlaneta, jugador, generarPorcentajeMuerte());
        } else if (probabilidad <= 15) {
            // Planeta Fuego 15%
            return new Fuego(nombrePlaneta, jugador, generarPorcentajeMuerte());
        } else if (probabilidad <= 15) {
            // Planeta Biotara 15%
            return new Biotara(nombrePlaneta, jugador, generarPorcentajeMuerte());
        } else {
            // Planeta Radioactivo 10%
            return new Radioactivo(nombrePlaneta, jugador, generarPorcentajeMuerte());
        }
    }

    //METODO QUE GENERA LOS NOMBRES DE LOS PLANETAS DE MANERA SECUENCIAL
    public String generarNombreSecuencial() {
        char letra = (char) ('A' + new Random().nextInt(26));
        return "" + letra;
    }

    // Método para mostrar las condiciones iniciales del planeta
public void mostrarCondicionesIniciales(Planeta planeta) {
    System.out.println("\nCondiciones iniciales del planeta:");
    System.out.println("Nombre del planeta: " + planeta.getNombre());

    // Verifica si el planeta tiene un dueño
    if (planeta.getDueño() != null) {
        System.out.println("Dueño del planeta: " + planeta.getDueño().getNombre());
    } else {
        System.out.println("Dueño del planeta: Neutral ");
    }

    System.out.println("Tipo de planeta: " + planeta.getClass().getSimpleName());
    planeta.mostrarDetallesPlaneta();
}


    // Método para permitir la edición de los atributos del planeta
    public void editarPlaneta(Planeta planeta) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Deseas editar los atributos del planeta? (si =1/ no=2)");
        int respuesta = scanner.nextInt();

        if (respuesta == 1) {
            // Editar estelares
            System.out.print("Ingresa la  cantidad de estelares (150 - 500): ");
            int estelares = scanner.nextInt();
            planeta.setEstelares(estelares);

            // Editar porcentaje de muerte
            System.out.print("Ingresa el  porcentaje de muerte (0.1 - 0.9999): ");
            double porcentajeMuerte = scanner.nextDouble();
            planeta.setPorcentajeDeMuerte(porcentajeMuerte);

            // Editar cantidad de constructores
            System.out.print("Ingresa la  cantidad de constructores: ");
            int cantidadConstructores = scanner.nextInt();
            Constructor[] nuevosConstructores = new Constructor[cantidadConstructores];
            for (int i = 0; i < cantidadConstructores; i++) {
                nuevosConstructores[i] = new Obrero();  // Aquí puedes personalizar el tipo de constructor
            }
            planeta.setConstructores(nuevosConstructores);

            // Editar cantidad de naves
            System.out.print("Ingresa la  cantidad de naves: ");
            int cantidadNaves = scanner.nextInt();
            Nave[] nuevasNaves = new Nave[cantidadNaves];
            for (int i = 0; i < cantidadNaves; i++) {
                nuevasNaves[i] = new Helios();  // Aquí puedes personalizar el tipo de nave
            }
            planeta.setNaves(nuevasNaves);

            // Editar cantidad de guerreros
            System.out.print("Ingresa la nueva cantidad de guerreros: ");
            int cantidadGuerreros = scanner.nextInt();
            Guerrero[] nuevosGuerreros = new Guerrero[cantidadGuerreros];
            for (int i = 0; i < cantidadGuerreros; i++) {
                nuevosGuerreros[i] = planeta.crearGuerrero();  // Aquí se usa el método abstracto para crear el tipo de guerrero adecuado

                planeta.setGuerreros(nuevosGuerreros);
            }
        }
    }

}
