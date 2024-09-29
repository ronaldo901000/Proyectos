/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno.Constructor;

import com.mycompany.proyectouno.Nave.Nave;

/**
 *
 * @author ronaldo
 */
public abstract class Constructor {
    protected int tiempoConstruccion;
    protected int costoCompra;
    protected int costoVenta;
    protected Nave tipoNave;

    public int getTiempoConstruccion() {
        return tiempoConstruccion;
    }

    public int getCostoCompra() {
        return costoCompra;
    }

    public int getCostoVenta() {
        return costoVenta;
    }

    public Nave getTipoNave() {
        return tipoNave;
    }

    public void setTiempoConstruccion(int tiempoConstruccion) {
        this.tiempoConstruccion = tiempoConstruccion;
    }

    public void setCostoCompra(int costoCompra) {
        this.costoCompra = costoCompra;
    }

    public void setCostoVenta(int costoVenta) {
        this.costoVenta = costoVenta;
    }

    public void setTipoNave(Nave tipoNave) {
        this.tipoNave = tipoNave;
    }
    
}