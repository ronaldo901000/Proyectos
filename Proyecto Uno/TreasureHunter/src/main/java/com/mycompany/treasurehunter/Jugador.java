
package com.mycompany.treasurehunter;

/**
 *
 * @author ronaldo
 */
public class Jugador {
    private String nombre;
    private int hp;
    private int mp;
    private int puntosDefensa;
    private int puntosDeAtaque;
    private boolean estaVivo;
    private int cantidadMovimentos;
    private int [] posicion;
    private String [] pistasRecolectadas;

    public Jugador(String nombre, int[] posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
        definirAtributosIniciales();
        pistasRecolectadas= new String[1];
    }
    
    public void recolectarPista(String pistaRecolectada) {
        pistasRecolectadas[pistasRecolectadas.length - 1] = pistaRecolectada;
        aumentarEspacioParPistas();
    }
    public void definirAtributosIniciales(){
        hp=100;
        mp =15;
        puntosDefensa=20;
        puntosDeAtaque=20;
    }
    public void sumarMovimiento(){
        cantidadMovimentos++;
    }
    public int atacar(){
    return 0;
    }
    public void defender(){ 
    }
    public void curar(){
    }

    public String getNombre() {
        return nombre;
    }
    public void aumentarEspacioParPistas(){
        int tamaño= pistasRecolectadas.length;
        int tamañoNuevo= tamaño+1;
        String [] nuevoArregloDePistas = new String[tamañoNuevo];
        
        for( int i=0; i<pistasRecolectadas.length; i++){
            nuevoArregloDePistas[i]=pistasRecolectadas[i];
        }
        pistasRecolectadas=nuevoArregloDePistas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    public void setPuntosDefensa(int puntosDefensa) {
        this.puntosDefensa = puntosDefensa;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public void setEstaVivo(boolean estaVivo) {
        this.estaVivo = estaVivo;
    }

    public int getCantidadMovimentos() {
        return cantidadMovimentos;
    }

    public void setCantidadMovimentos(int cantidadMovimentos) {
        this.cantidadMovimentos = cantidadMovimentos;
    }

    public int[] getPosicion() {
        return posicion;
    }

    public void setPosicion(int[] posicion) {
        this.posicion = posicion;
    }

    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public String[] getPistasRecolectadas() {
        return pistasRecolectadas;
    }
    
}
