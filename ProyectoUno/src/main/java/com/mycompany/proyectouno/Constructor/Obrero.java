/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Constructor;

import com.mycompany.proyectouno.Nave.Helios;

/**
 *
 * @author ronaldo
 */
public class Obrero extends Constructor {
    
    public Obrero() {
        this.tiempoConstruccion = 3;
        this.costoCompra = 50;
        this.costoVenta = 40;
        this.tipoNave = new Helios();
    }
    
}
