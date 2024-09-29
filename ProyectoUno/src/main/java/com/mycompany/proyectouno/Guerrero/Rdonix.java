package com.mycompany.proyectouno.Guerrero;

public class Rdonix extends Guerrero {
    
    public Rdonix() {
        super("Rdonix", 1.90, 3);
    }

    @Override
    public String ataqueEspecial() {
        return "Lanza un ataque con rayos gamma que derrite al enemigo.";
    }
}
