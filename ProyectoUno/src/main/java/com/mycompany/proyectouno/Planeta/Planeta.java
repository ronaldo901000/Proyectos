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


    public Planeta(String nombre, Jugador dueño) {
        this.nombre = nombre != null ? nombre : generarNombreSecuencial();
        this.porcentajeDeMuerte = generarPorcentajeDeMuerteAleatorio();
        this.estelares = generarCantidadEstelaresAleatorio();
        this.constructores = new Constructor[] { new Obrero() };  
        this.naves = generarNavesAleatorias(1, 3);
        this.guerreros = generarGuerrerosAleatorios();
        this.dueño = dueño;
    }

   
    public String generarNombreSecuencial() {
        char letra = (char) ('A' + new Random().nextInt(26)); 
        return " "+ letra;
    }

    private double generarPorcentajeDeMuerteAleatorio() {
        Random random = new Random();
        return 0.1 + (0.9999 - 0.1) * random.nextDouble();
    }

    protected int generarCantidadEstelaresAleatorio() {
        Random random = new Random();
        return random.nextInt(351) + 150;
    }


    private Nave[] generarNavesAleatorias(int minimo, int maximo) {
        int cantidad = new Random().nextInt((maximo - minimo) + 1) + minimo;
        Nave[] navesGeneradas = new Nave[cantidad];
        for (int i = 0; i < cantidad; i++) {
            navesGeneradas[i] = new Helios(); 
        }
        return navesGeneradas;
    }

    public void setDueño(Jugador dueño) {
        this.dueño = dueño;
    }

    protected Guerrero[] generarGuerrerosAleatorios() {
        int minimo = 5;  
        int maximo = 20;
     
        int cantidad = new Random().nextInt((maximo - minimo) + 1) + minimo;
        Guerrero[] guerrerosGenerados = new Guerrero[cantidad];

     
        for (int i = 0; i < cantidad; i++) {
            guerrerosGenerados[i] = crearGuerrero(); 
        }
        return guerrerosGenerados;
    }

    public abstract Guerrero crearGuerrero();
    
    public abstract void generarEstelaresPorTurno();

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
            System.out.println("ingresa un valor entre 0.1 y 0.9999");
        }
    }

    public void setEstelares(int estelares) {
        if (estelares >= 150 && estelares <= 500) {
            this.estelares = estelares;
        } else {
            System.out.println("Ingresa un valor entre 150 y 500 estelares");
        }
    }

    public void setConstructores(Constructor[] constructores) {
        if (constructores != null && constructores.length > 0) {
            this.constructores = constructores;
        } else {
            System.out.println("ingresa un valor mayor a cero");
        }
    }

    public void setNaves(Nave[] naves) {
        if (naves != null && naves.length >= 1) {
            this.naves = naves;
        } else {
            System.out.println("ingresa un valor mayor a cero");
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
        System.out.println("Constructor de tipo: " + constructores[0].getClass().getSimpleName());
        System.out.println("Nave de tipo: " + naves[0].getClass().getSimpleName());
        System.out.println("Guerrero de tipo: " + guerreros[0].getClass().getSimpleName());

    }
}
