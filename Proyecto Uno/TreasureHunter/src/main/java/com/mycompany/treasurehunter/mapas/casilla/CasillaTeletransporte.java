package com.mycompany.treasurehunter.mapas.casilla;

import com.mycompany.treasurehunter.Jugador;
import com.mycompany.treasurehunter.mapas.Mapa;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ronaldo
 */
public class CasillaTeletransporte extends Casilla {

    private int[] nuevaPosicionDelJugador;
    private boolean tieneAletoriedad;
    private Mapa mapa;
    
    public CasillaTeletransporte(int[] posicion, Jugador jugador, Mapa mapa) {
        super(posicion, jugador);
        this.mapa=mapa;
        nuevaPosicionDelJugador = new int[2];
    }

    @Override
    public void realizarAccion() {
        Scanner scanner = new Scanner(System.in);
        jugador.setPosicion(nuevaPosicionDelJugador);
        mapa.limpiarMapaVisual();
        System.out.println("La casilla te mueve a la posicion: "+(jugador.getPosicion()[0]+1) +", "+jugador.getPosicion()[1]+1);
        System.out.println("");
        System.out.println("Presiona enter para continuar");
        scanner.nextLine();
    }

    @Override
    public void crearAccionCasilla() {
        preguntarSiLaPosicionEsAleatoriaOno();
        guardarLaNuevaPosicionDelJugador();
    }
    public void preguntarSiLaPosicionEsAleatoriaOno() {
        int opcion;
        do {
            System.out.println("Quieres mover la posicion del jugador aleatoriamente o no");
            System.out.println("1. Si");
            System.out.println("2. No");
            opcion = lector.leerNumero();
            if (opcion < 1 || opcion > 2) {
                System.out.println("Selecciona valores entre 1-2");
            }
        } while (opcion < 1 || opcion > 2);
        if (opcion == 1) {
            tieneAletoriedad = true;
        } else if (opcion == 2) {
            tieneAletoriedad = false;
        }

    }
    public void guardarLaNuevaPosicionDelJugador(){
        if(!tieneAletoriedad){
            definirLaNuevaPosicionDelJugadorManual();
        }
        else{
            definirLaNuevaPosicionDelJugadorAleatorio();
        }
    }
    
    public int convertirLetraANumero(String letra) {
        char letraMayuscula = letra.toUpperCase().charAt(0);

        int numero = letraMayuscula - 'A';
        return numero;
    }
    public void definirLaNuevaPosicionDelJugadorAleatorio(){
        boolean coordenadaCorrecta = false;
        int posicionNuevaEnX;
        int posicionNuevaEnY;
        Random random = new Random();
        do{
            posicionNuevaEnX = random.nextInt(mapa.getFilas()) - 1;
            posicionNuevaEnY = random.nextInt(mapa.getColumnas() - 1);
            if (!(posicionNuevaEnX < 0 || posicionNuevaEnX >= mapa.getFilas() || posicionNuevaEnY < 0 || posicionNuevaEnY >= mapa.getColumnas())) {
                if (!(mapa.getCasillas()[posicionNuevaEnX][posicionNuevaEnY] instanceof CasillaMuro)) {
                    nuevaPosicionDelJugador[0] = posicionNuevaEnX;
                    nuevaPosicionDelJugador[1] = posicionNuevaEnY;
                    System.out.println("Posicion creada correctamente");
                    coordenadaCorrecta = true;
            }
        }
        }while(!coordenadaCorrecta);

    }
    public void definirLaNuevaPosicionDelJugadorManual() {
        int posicionNuevaEnX;
        int posicionNuevaEnY;
        boolean coordenadaCorrecta=false;
        do {
            mapa.imprimirMapa();
            System.out.println("");
            System.out.print("Selecciona la fila 1-" + mapa.getFilas());
            posicionNuevaEnX = lector.leerNumero() - 1;

            System.out.print("Selecciona una columna:");
            posicionNuevaEnY = lector.leerNumero() - 1;
            if(!(posicionNuevaEnX < 0 || posicionNuevaEnX >= mapa.getFilas()|| posicionNuevaEnY < 0 || posicionNuevaEnY >= mapa.getColumnas())){
                if(!(mapa.getCasillas()[posicionNuevaEnX][posicionNuevaEnY] instanceof CasillaMuro)){
                    nuevaPosicionDelJugador[0] = posicionNuevaEnX;
                    nuevaPosicionDelJugador[1] = posicionNuevaEnY;
                    System.out.println("Posicion guardada correctamente");
                    coordenadaCorrecta=true;
                }
                else{
                    System.out.println("No se puede mover al jugador en esta posicion, por que ahi hay una casilla muro");
                }
            }
            else{
                System.out.println("Posicion fuera del limite");
            }
        } while (!coordenadaCorrecta);

    }

    @Override
    public String pintarCasilla() {
        String casillaPintada;
        String simboloPersonaje = "X";
        verificarSiJugadorEstaEnLaCasilla();
        if (estaElJugadorAqui) {
            casillaPintada = color.FONDO_AMARILLO + "  " + simboloPersonaje + "  " + color.REINICIAR_COLOR;
        } else {
            casillaPintada = color.FONDO_AMARILLO + "     " + color.REINICIAR_COLOR;
        }

        return casillaPintada;
    }
}
