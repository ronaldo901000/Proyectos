/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Constructor;

import com.mycompany.proyectouno.Nave.Odisea;

/**
 *
 * @author ronaldo
 */
public class Ingeniero extends Constructor{

    public Ingeniero() {
        this.tiempoConstruccion=1;
        this.costoCompra=250;
        this.costoVenta=200;
        this.tipoNave= new Odisea();
    }
    
    
}
