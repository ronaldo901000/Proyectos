package com.mycompany.proyectouno.Planeta;

import com.mycompany.proyectouno.Constructor.Constructor;
import com.mycompany.proyectouno.Constructor.Obrero;
import com.mycompany.proyectouno.Guerrero.Guerrero;
import com.mycompany.proyectouno.Jugador;
import com.mycompany.proyectouno.Nave.Helios;
import com.mycompany.proyectouno.Nave.Nave;
import java.util.Random;


public abstract class Planeta {
    protected String nombre; 
    protected double porcentajeDeMuerte;  
    protected int estelares; 
    protected Constructor[] constructores;  
    protected Nave[] naves;  
    protected Guerrero[] guerreros; 
    protected Jugador dueño; 


    // Constructor que permite la generación automática de valores
    public Planeta(String nombre, Jugador dueño) {
        this.nombre = nombre != null ? nombre : generarNombreSecuencial();
        this.porcentajeDeMuerte = generarPorcentajeDeMuerteAleatorio();
        this.estelares = generarCantidadEstelaresAleatorio();
        this.constructores = new Constructor[] { new Obrero() };  // 1 Obrero inicial
        this.naves = generarNavesAleatorias(1, 3);
        this.guerreros = generarGuerrerosAleatorios();  // Generado aleatoriamente
        this.dueño = dueño;
    }

    // Genera un nombre secuencial basado en las letras del alfabeto
    public String generarNombreSecuencial() {
        char letra = (char) ('A' + new Random().nextInt(26));  // Genera una letra de A a Z
        return " "+ letra;
    }

    // Genera un porcentaje de muerte aleatorio entre 0.1 y 0.9999
    private double generarPorcentajeDeMuerteAleatorio() {
        Random random = new Random();
        return 0.1 + (0.9999 - 0.1) * random.nextDouble();
    }

    // Método para generar una cantidad aleatoria de dinero (estelares) entre 150 y 500
    protected int generarCantidadEstelaresAleatorio() {
        Random random = new Random();
        return random.nextInt(351) + 150;  // Genera entre 150 y 500 estelares
    }

    // Genera una cantidad aleatoria de naves de tipo Helio
    private Nave[] generarNavesAleatorias(int minimo, int maximo) {
        int cantidad = new Random().nextInt((maximo - minimo) + 1) + minimo;
        Nave[] navesGeneradas = new Nave[cantidad];
        for (int i = 0; i < cantidad; i++) {
            navesGeneradas[i] = new Helios();  // Naves iniciales de tipo Helio
        }
        return navesGeneradas;
    }

    public void setDueño(Jugador dueño) {
        this.dueño = dueño;
    }

    // Método para generar una cantidad aleatoria de guerreros basada en el tipo de planeta
    protected Guerrero[] generarGuerrerosAleatorios() {
        int minimo = 5;  // Valor mínimo de guerreros
        int maximo = 20; // Valor máximo de guerreros
        // Generar cantidad aleatoria de guerreros
        int cantidad = new Random().nextInt((maximo - minimo) + 1) + minimo;
        Guerrero[] guerrerosGenerados = new Guerrero[cantidad];

        // Inicializar guerreros con un tipo específico según la subclase del planeta
        for (int i = 0; i < cantidad; i++) {
            guerrerosGenerados[i] = crearGuerrero();  // Método abstracto para crear guerrero
        }
        return guerrerosGenerados;
    }

    // Método abstracto que las subclases deben implementar para crear el tipo específico de guerrero
    public abstract Guerrero crearGuerrero();

    // Getters
    public String getNombre() {
        return nombre;
    }

    public Jugador getDueño() {
        return dueño;
    }

    public int getEstelares() {
        return estelares;
    }

    public Constructor[] getConstructores() {
        return constructores;
    }

    public Nave[] getNaves() {
        return naves;
    }

    public Guerrero[] getGuerreros() {
        return guerreros;
    }

    public double getPorcentajeDeMuerte() {
        return porcentajeDeMuerte;
    }

    // Setters para modificar los atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPorcentajeDeMuerte(double porcentajeDeMuerte) {
        if (porcentajeDeMuerte >= 0.1 && porcentajeDeMuerte <= 0.9999) {
            this.porcentajeDeMuerte = porcentajeDeMuerte;
        } else {
            throw new IllegalArgumentException("Porcentaje de muerte debe estar entre 0.1 y 0.9999");
        }
    }

    public void setEstelares(int estelares) {
        if (estelares >= 150 && estelares <= 500) {
            this.estelares = estelares;
        } else {
            throw new IllegalArgumentException("Los estelares deben estar entre 150 y 500");
        }
    }

    public void setConstructores(Constructor[] constructores) {
        if (constructores != null && constructores.length > 0) {
            this.constructores = constructores;
        } else {
            throw new IllegalArgumentException("Debe haber al menos un constructor");
        }
    }

    public void setNaves(Nave[] naves) {
        if (naves != null && naves.length >= 1) {
            this.naves = naves;
        } else {
            throw new IllegalArgumentException("Debe haber al menos una nave");
        }
    }

    public void setGuerreros(Guerrero[] guerreros) {
        
            this.guerreros = guerreros;
        
    }

    public void mostrarDetallesPlaneta() {
        System.out.println("Estelares: " + estelares);
        System.out.println("Porcentaje de Muerte: " + porcentajeDeMuerte);
        System.out.println("Constructores: " + constructores.length);
        System.out.println("Naves: " + naves.length);
        System.out.println("Guerreros: " + guerreros.length);
        for (int i = 0; i < constructores.length; i++) {
            System.out.println("Constructor " + (i + 1) + ": " + constructores[i].getClass().getSimpleName());
        }
        for (int i = 0; i < naves.length; i++) {
            System.out.println("Nave " + (i + 1) + ": " + naves[i].getClass().getSimpleName());
        }
        for (int i = 0; i < 1; i++) {
            System.out.println("Guerrero " + (i + 1) + ": " + guerreros[i].getClass().getSimpleName());
        }
    }
}
