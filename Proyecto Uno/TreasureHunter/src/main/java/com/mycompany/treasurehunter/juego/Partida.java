/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter.juego;

import com.mycompany.treasurehunter.Jugador;
import com.mycompany.treasurehunter.Menu;
import com.mycompany.treasurehunter.adicionales.LectorEnteros;
import com.mycompany.treasurehunter.mapas.Mapa;
import com.mycompany.treasurehunter.mapas.casilla.CasillaMuro;
import com.mycompany.treasurehunter.mapas.casilla.CasillaPista;
import java.util.Scanner;

/**
 *
 * @author ronaldo
 */
public class Partida {

    private String nombre;
    private Mapa mapa;
    private Jugador jugador;
    private String[] pistas;
    private Motor motor;
    private boolean terminado;
    private boolean hayGanador;

    public Partida(String nombre, Mapa mapa, Jugador jugador, Motor motor) {
        this.nombre = nombre;
        this.mapa = mapa;
        this.jugador = jugador;
        this.motor = motor;
        terminado = false;
        hayGanador = false;
        pistas = new String[1];
    }

    //Metodo encargado de iniciar la partida
    public void iniciarPartida() {
        int opcion;
        LectorEnteros lector = new LectorEnteros();
        Menu menu = new Menu();
        System.out.println("Partida Iniciada");

        do {

            mapa.imprimirMapa();

            // Se muestra el menu de acciones y selecciona alguna de las acciones
            opcion = menu.menuPartida();
            switch (opcion) {
                case 1:
                    moverseEnElMapa();                
                    hayGanador = verificarSiElJugadorLlegoAlTesoro(jugador.getPosicion(), mapa.getPosicionTesoro());
                    break;
                case 2:
                    //ver Pista
                    verUltimaPista();
                    break;
                case 3:
                    //Ver todas las pistas
                    verTodasLasPistas();
                    break;
                case 4:
                   //ver el estado del jugador
                    verEstadoDelJugador();
                    break;
                case 5:
                    guardarPartida();
                    break;
                case 6:
                    //salir del juego
                    System.out.println("Saliendo de la partida");
                    terminado = true;
                    break;
                default:
                    break;
            }

        } while (terminado == false && hayGanador == false);

        if (hayGanador == true) {
            mapa.imprimirMapa();
            System.out.println(" Felicidades has encontrado el tesoro!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("Presiona cualquier numero para regresar");
            opcion = lector.leerNumero();
        } else if (terminado == true) {
            System.out.println("Has salido de la partida");
        }
    }

    public void guardarPartida() {
        motor.guardarPartidaALista(this);
    }

    public void escogerUnaAccion() {

    }

    /*
        Logica de los movimientos
        A: a la coordenada y le resta -1
        D: a la coordenada y se le suma +1
        W: a la coordenada x se le resta -1
        S: a la coordenada x se le suma +1
     */
    public void moverseEnElMapa() {
        int[] nuevaPosicionDelJugador = new int[2];
        Scanner scanner = new Scanner(System.in);
        String tipoDeMovimiento;
        //Se almacena la posicionActual
        int[] posicionAnteriorDelJugador = jugador.getPosicion();

        System.out.println("Presiona A, S, D, W para moverte:");
        tipoDeMovimiento = String.valueOf(scanner.nextLine()).toUpperCase();
        // Obtener la posición actual del jugador
        int posicionActualEnX = jugador.getPosicion()[0];
        int posicionActualEnY = jugador.getPosicion()[1];

        //realizar las operaciones
        switch (tipoDeMovimiento) {
            case "A":
                nuevaPosicionDelJugador[0] = posicionActualEnX;
                nuevaPosicionDelJugador[1] = posicionActualEnY - 1;
                break;
            case "D":
                nuevaPosicionDelJugador[0] = posicionActualEnX;
                nuevaPosicionDelJugador[1] = posicionActualEnY + 1;
                break;
            case "W":
                nuevaPosicionDelJugador[0] = posicionActualEnX - 1;
                nuevaPosicionDelJugador[1] = posicionActualEnY;
                break;
            case "S":
                nuevaPosicionDelJugador[0] = posicionActualEnX + 1;
                nuevaPosicionDelJugador[1] = posicionActualEnY;
                break;
            default:
                System.out.println("Error: Debes ingresar A, S, D, W para moverte ");
                return;
        }

        // Verificar si la nueva posicion esta dentro de los limites del mapa
        if (nuevaPosicionDelJugador[0] >= 0 && nuevaPosicionDelJugador[0] < mapa.getFilas() && nuevaPosicionDelJugador[1] >= 0 && nuevaPosicionDelJugador[1] < mapa.getColumnas()) {
            // Verificar si la nueva posicion no es un muro
            if (!(mapa.getCasillas()[nuevaPosicionDelJugador[0]][nuevaPosicionDelJugador[1]] instanceof CasillaMuro)) {
                // Actualizar la posición del jugador
                jugador.setPosicion(nuevaPosicionDelJugador);
                mapa.actualizarMapa(posicionAnteriorDelJugador, nuevaPosicionDelJugador);
                jugador.sumarMovimiento();
                mapa.realizarLaAccionDeLaCasilla();

            }
            else {
                System.out.println("No puedes moverte a una casilla muro ");
            }
        } else {
            System.out.println("Movimiento fuera del limite");
        }
    }

    public boolean verificarSiElJugadorLlegoAlTesoro(int[] posicionDelJugador, int[] posicionDelTesoro) {
        if (posicionDelJugador[0] == posicionDelTesoro[0] && posicionDelJugador[1] == posicionDelTesoro[1]) {
            return true;
        }
        return false;
    }

    public void verUltimaPista() {
        // se busca la penultima poscicion del arreglo, por que la ultima esta reservada para una nueva pista
        int posicionUltimaPista = jugador.getPistasRecolectadas().length-2;
        System.out.println("Ultima pista: ");
        System.out.println(jugador.getPistasRecolectadas()[posicionUltimaPista]);
    }

    public void verTodasLasPistas() {
        System.out.println("Pistas recolectadas: ");
        for (int i = 0; i < jugador.getPistasRecolectadas().length - 1; i++) {
            System.out.println(jugador.getPistasRecolectadas()[i]);
            System.out.println("");

        }
    }


    public void verEstadoDelJugador() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("|---------------Estado del Personaje---------------|");
        System.out.println("");
        System.out.println("Nombre: "+jugador.getNombre());
        System.out.println("Puntos de vida HP: "+jugador.getHp());
        System.out.println("Puntos de mana MP: "+jugador.getMp());
        System.out.println("Puntos de defensa: "+jugador.getPuntosDefensa());
        System.out.println("Puntos de ataque: "+jugador.getPuntosDeAtaque());
        System.out.println("Cantidad de Movimientos: "+jugador.getCantidadMovimentos());
        System.out.println("");
        System.out.println("Presiona enter para continuar");
        scanner.nextLine();
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean isTerminado() {
        return terminado;
    }

    public void setTerminado(boolean terminado) {
        this.terminado = terminado;
    }

    public boolean isHayGanador() {
        return hayGanador;
    }

    public String getNombre() {
        return nombre;
    }

}
