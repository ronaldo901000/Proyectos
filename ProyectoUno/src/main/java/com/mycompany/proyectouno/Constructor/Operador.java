/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Constructor;

import com.mycompany.proyectouno.Nave.GalaxiaPrime;

/**
 *
 * @author ronaldo
 */
public class Operador extends Constructor {
    public Operador() {
        this.tiempoConstruccion = 2;
        this.costoCompra = 100;
        this.costoVenta = 70;
        this.tipoNave = new GalaxiaPrime();
    }
}
