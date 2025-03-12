package com.mycompany.treasurehunter.mapas.casilla;

import com.mycompany.treasurehunter.Jugador;

/**
 *
 * @author ronaldo
 */
public class CasillaPista extends Casilla {
    private final int [] COORDENADAS_DEL_TESORO;
    private int tipoDePista;

    public CasillaPista(int[] posicion,int[] COORDENADAS_DEL_TESORO, Jugador jugador) {
        super(posicion,jugador);
        this.COORDENADAS_DEL_TESORO = COORDENADAS_DEL_TESORO;
    }

    @Override
    public void realizarAccion(){
        darlePistaAlJugador();
    }
    @Override
    public String pintarCasilla() {
        verificarSiJugadorEstaEnLaCasilla();
        String casillaPintada;
        String simboloPersonaje = "X";

        if (estaElJugadorAqui) {
            casillaPintada = color.FONDO_AZUL + "  " + simboloPersonaje + "  " + color.REINICIAR_COLOR;
        } else {
            casillaPintada = color.FONDO_AZUL + "     " + color.REINICIAR_COLOR;
        }

        return casillaPintada;
    }

    public String dandoPistaUbicacion() {
        String pista;
        double distanciaEntrePersonaYPersona = calcularDistancia();

        if (distanciaEntrePersonaYPersona <= 2) {
            pista = " Estas cerca del tesoro";
        } else {
            pista = " Estas Lejos del tesoro";
        }
        return pista;
    }

    @Override
        public void crearAccionCasilla() {
        seleccionarTipoDePista();
        //guardar la pista
        
    }
    // metodo que guarda el ripo de pista que va a tener la casilla
    public void seleccionarTipoDePista() {
        int opcion;
        do {
            System.out.println("Selecciona el tipo de pista");
            System.out.println("1. Pista de ubicacion (Estas cerca, estas lejos)");
            System.out.println("2. Pista direccional (norte,sur,este,oeste)");
            opcion = lector.leerNumero();
        } while (opcion < 1 || opcion > 2);
        tipoDePista = opcion;
    }
    
    public void darlePistaAlJugador() {
        System.out.println("Recolectando la pista");
        String pistaParaElJugador;
        //si en la creacion de casillas se eligieron pistas de ubicacion
        if (tipoDePista == 1) {
            pistaParaElJugador=dandoPistaUbicacion();
            jugador.recolectarPista(pistaParaElJugador);
        } // si no entnces las pistas van a ser direccionales 
        else if (tipoDePista == 2) {
            pistaParaElJugador=darPistaDireccional();
           jugador.recolectarPista(pistaParaElJugador);
        }
    }

    /**
     *
     * @return retorna una pista direccional
     */
    public String darPistaDireccional() {
        String pista="";
        if (jugador.getPosicion()[0] > COORDENADAS_DEL_TESORO[0]) {
            pista = "norte";
        } else if (jugador.getPosicion()[0] == COORDENADAS_DEL_TESORO[0]) {
            if (jugador.getPosicion()[1] > COORDENADAS_DEL_TESORO[1]) {
                pista = " oeste";
            } else if (jugador.getPosicion()[1] < COORDENADAS_DEL_TESORO[1]) {
                pista = "este";
            }
        } else if (jugador.getPosicion()[0] < COORDENADAS_DEL_TESORO[0]) {
            pista = "sur";
        }
        return pista;
    }

    /**
     *
     * @return retorna la distancia que hay entre el jugador y el tesoro
     */
    public double calcularDistancia() {
        double distancia;
        //encontrando la distancia entre los puntos 
        int diferenciaX = COORDENADAS_DEL_TESORO[0] - jugador.getPosicion()[0];
        int diferenciaY = COORDENADAS_DEL_TESORO[1] - jugador.getPosicion()[1];
        //calculando la distancia entre posiciones utilizando la  formula de distancia entre puntos
        distancia = Math.sqrt(diferenciaX * diferenciaX + diferenciaY * diferenciaY);
        return distancia;
    }
    
}
