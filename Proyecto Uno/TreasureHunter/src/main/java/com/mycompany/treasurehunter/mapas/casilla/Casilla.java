/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.mapas.casilla;

import com.mycompany.treasurehunter.Jugador;
import com.mycompany.treasurehunter.adicionales.Color;
import com.mycompany.treasurehunter.adicionales.LectorEnteros;

/**
 *
 * @author ronaldo
 */
public  class Casilla {
    
    protected Color color;
    protected LectorEnteros lector;
    protected Jugador jugador;
    protected int [] posicion;
    protected boolean estaElJugadorAqui;
    
    public Casilla(int []posicion,Jugador jugador) {
        color = new Color();
        lector = new LectorEnteros();
        this.posicion=posicion;
        this.jugador=jugador;
        estaElJugadorAqui=false;
    }
    
    public void crearAccionCasilla() {
        
    }

    public void realizarAccion() {
    }

    public String pintarCasilla() {
        verificarSiJugadorEstaEnLaCasilla();
        String casillaPintada = "";
        return casillaPintada;
    }
        //Se reinicia el mapa para que la siguiente ves que se necesite usar un mapa sea el original
    public String [] [] reiniciarMapaVisual(int filas, int columnas , String [][] mapaVisual ) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == jugador.getPosicion()[0] && j == jugador.getPosicion()[1]) {
                    mapaVisual[i][j] = pintarCasilla();
                } else {
                    mapaVisual[i][j] = pintarCasilla();
                }
            }
        }
        return mapaVisual;
    }
    public String  limpiarCasillaVisual (){
        String casillaVisual;
        verificarSiJugadorEstaEnLaCasilla();
        casillaVisual=pintarCasilla();
       return casillaVisual;
    }
    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
    public void verificarSiJugadorEstaEnLaCasilla() {
        if(posicion[0]==jugador.getPosicion()[0] && posicion[1]==jugador.getPosicion()[1]){
           estaElJugadorAqui=true;
          
        }
        else{
            estaElJugadorAqui=false;
        }
    }
    
}
