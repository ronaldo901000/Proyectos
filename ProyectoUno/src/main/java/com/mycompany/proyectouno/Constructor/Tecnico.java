/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Constructor;

import com.mycompany.proyectouno.Nave.Nebulon;

/**
 *
 * @author ronaldo
 */
public class Tecnico extends Constructor {
        public Tecnico() {
        this.tiempoConstruccion = 1;
        this.costoCompra = 250;
        this.costoVenta = 175;
        this.tipoNave = new Nebulon();
    }
    
    
}