package com.mycompany.treasurehunter.mapas;

import com.mycompany.treasurehunter.Jugador;
import com.mycompany.treasurehunter.Menu;
import com.mycompany.treasurehunter.adicionales.Color;
import com.mycompany.treasurehunter.mapas.casilla.Casilla;
import com.mycompany.treasurehunter.mapas.casilla.CasillaEnemigo;
import com.mycompany.treasurehunter.mapas.casilla.CasillaEnergia;
import com.mycompany.treasurehunter.mapas.casilla.CasillaMuro;
import com.mycompany.treasurehunter.mapas.casilla.CasillaNormal;
import com.mycompany.treasurehunter.mapas.casilla.CasillaPista;
import com.mycompany.treasurehunter.mapas.casilla.CasillaTeletransporte;
import com.mycompany.treasurehunter.mapas.casilla.CasillaTesoro;
import com.mycompany.treasurehunter.mapas.casilla.CasillaTrampa;

/**
 *
 * @author ronaldo
 */
public class Mapa {

    private boolean [] []posicionesDeRegresoYTeletransporte;
    private Jugador jugador;
    private String nombre;
    private int filas;
    private int columnas;
    private int[] coordenadasX;///////////////////////////////////////////////////
    private int[] coordenadasY;///////////////////////////////////////////////
    private int[] posicionInicialDelJugador;
    private int[] posicionTesoro;
    private String[][] mapaVisual;
    private Casilla[][] casillas;
    private Color colores;

    public Mapa(Jugador jugador, String nombre, int filas, int columnas, int[] posicionInicialJugador, int[] posicionTesoro) {
        this.jugador = jugador;
        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
        this.posicionInicialDelJugador = posicionInicialJugador;
        this.posicionTesoro = posicionTesoro;
        casillas = new Casilla[filas][columnas];
        mapaVisual = new String[filas][columnas];
        posicionesDeRegresoYTeletransporte= new boolean[filas][columnas];
        colores = new Color();
        inicializarMapa();
        crearCasillasDelMapa();
        inicializarMatrizBooleanaDePosicionesJugadores();
    }

    public void crearCasillasDelMapa() {
        //Se crean las casillas del jugador y la del tesoro
        crearCasillasDeJugadorYTesoro();
        // Se crean el resto de casillas del mapa
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Verifica si la casilla actual no es la del jugador ni la del tesoro
                if (!((i == jugador.getPosicion()[0] && j == jugador.getPosicion()[1]) || (i == posicionTesoro[0] && j == posicionTesoro[1]))) {
                    //imprimiendo la posicion donde toca crear la casilla
                    System.out.println(colores.FONDO_GRIS + colores.LETRAS_VERDES + "Posicion: " + (i + 1) + ", " + (j + 1) + colores.REINICIAR_COLOR);
                    //se crea la casilla
                    casillas[i][j] = crearLasDemasCasillas(i,j);
                    //se elige la accion que va a realizar la casilla, la casilla se encarga de eso
                    casillas[i][j].crearAccionCasilla();
                    System.out.println("Casilla Creada Exitosamente");
                    //se crea en mapa visual la casilla con su color
                    mapaVisual[i][j] = casillas[i][j].pintarCasilla();
                    imprimirMapa();
                }
            }
        }
        // se muestra el mapa con todas las casillas del mapa creadas
        
    }
    public void agregarJugadorALaMatrizBooleanaDePosicionesDeJugador(int posicionX, int posicionY){
        posicionesDeRegresoYTeletransporte[posicionX][posicionY]=true;
    }

    public void actualizarMapa(int[] posicionAnterior, int[] nuevaPosicionJugador) {
        //limpia la casilla donde estaba el jugador, mediante el parametro
        int filaAnterio = posicionAnterior[0];
        int columnaAnterior = posicionAnterior[1];
        mapaVisual[filaAnterio][columnaAnterior] = casillas[filaAnterio][columnaAnterior].pintarCasilla();
        // Actualizar la nueva posición del jugador
        int filaNueva = nuevaPosicionJugador[0];
        int columnaNueva = nuevaPosicionJugador[1];
        mapaVisual[filaNueva][columnaNueva] = casillas[filaNueva][columnaNueva].pintarCasilla();
    }
    

    public void limpiarMapaVisual(){
        for(int i=0; i<filas; i++){
            for(int j=0; j<columnas; j++){
                mapaVisual[i][j]=casillas[i][j].limpiarCasillaVisual();
            }
        }
    }

    public void crearCasillasDeJugadorYTesoro() {
        //Se crea la casilla donde el jugador comenzara, de tipo casillaNormal
        Casilla casillaJugador = new CasillaNormal(posicionInicialDelJugador,jugador);
        casillas[posicionInicialDelJugador[0]][posicionInicialDelJugador[1]] = casillaJugador;
        mapaVisual[posicionInicialDelJugador[0]][posicionInicialDelJugador[1]] = casillaJugador.pintarCasilla();
        //Se crea la casilla donde estará ubicado el tesoro
        Casilla casillaTesoro = new CasillaTesoro(posicionTesoro,jugador);
        casillas[posicionTesoro[0]][posicionTesoro[1]] = casillaTesoro;
        casillaTesoro.pintarCasilla();
        mapaVisual[posicionTesoro[0]][posicionTesoro[1]] = casillaTesoro.pintarCasilla();
    }

    /**
     *
     * @param coordenadaX
     * @param coordenadaY
     * @return retorna una casilla
     */
    //Se crean las casillas restantes
    public Casilla crearLasDemasCasillas(int coordenadaX, int coordenadaY) {
        int [] posicionDeLaCasilla= new int[2];
        posicionDeLaCasilla[0]=coordenadaX;
        posicionDeLaCasilla[1]=coordenadaY;
        int opcion;
        Menu menu = new Menu();
        Casilla casilla = null; 
        //empieza a crear las casillas de toda la matriz excepto donde ya esten las casillas de jugador y tesoro

        opcion = menu.menuCasillaNormal();
        if (opcion == 1) {
            casilla = new CasillaNormal(posicionDeLaCasilla,jugador);
        } else if (opcion == 2) {
            casilla = new CasillaTrampa(jugador,posicionDeLaCasilla);
        } else if (opcion == 3) {
            casilla = new CasillaPista(posicionDeLaCasilla, posicionTesoro,jugador);
        } else if (opcion == 4) {
            casilla = new CasillaTeletransporte(posicionDeLaCasilla,jugador,this);
        } else if (opcion == 5) {
            casilla = new CasillaMuro(posicionDeLaCasilla,jugador);
        } else if (opcion == 6) {
            casilla = new CasillaEnergia(posicionDeLaCasilla,jugador);
        } else if (opcion == 7) {
            casilla = new CasillaEnemigo(posicionDeLaCasilla,this, jugador);
        }
        return casilla;
    }

    public void inicializarMapa() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                mapaVisual[i][j] = "     ";
            }
        }
    }
    //metodo que actualiza del jugador falso al jugador real en la partida
    public void actualizarJugadorACasillas(Jugador jugador) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                    casillas[i][j].setJugador(jugador);
            }
        }
    }

    public void imprimirMapa() {
        System.out.println(colores.FONDO_AZUL + colores.LETRAS_NEGRAS_B + "|--------MAPA----------|" + colores.REINICIAR_COLOR);
        System.out.print("     ");
        for (int i = 0; i < columnas; i++) {
            System.out.print((char) ('A' + i) + "     ");
        }
        System.out.println("");
        for (int i = 0; i < filas; i++) {
            System.out.print((i + 1) + " |");
            for (int j = 0; j < columnas; j++) {
                System.out.print(mapaVisual[i][j] + "|");
            }
            System.out.println();

        }
    }
    public void inicializarMatrizBooleanaDePosicionesJugadores() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                posicionesDeRegresoYTeletransporte[i][j] = false;
            }
        }
    }
    public void realizarLaAccionDeLaCasilla() {
        System.out.println("Realizando Accion");
        int fila = jugador.getPosicion()[0];
        int columna = jugador.getPosicion()[1];
        casillas[fila][columna].realizarAccion();
        
    }
    public boolean verificarSiJugadorEstaEnLaCasilla(int[] posicionJugador, int posicionCasillaX, int posicionCasillaY) {
        boolean siEsta = false;
        if (posicionJugador[0] == posicionCasillaX && posicionJugador[1] == posicionCasillaY) {
            siEsta = true;
        }
        return siEsta;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int[] getPosicionInicialJugador() {
        return posicionInicialDelJugador;
    }

    public void setPosicionInicialJugador(int[] posicionInicialJugador) {
        this.posicionInicialDelJugador = posicionInicialJugador;
    }

    public int[] getPosicionTesoro() {
        return posicionTesoro;
    }

    public void setPosicionTesoro(int[] posicionTesoro) {
        this.posicionTesoro = posicionTesoro;
    }

    public String[][] getMapaVisual() {
        return mapaVisual;
    }

    public void setMapaVisual(String[][] mapaVisual) {
        this.mapaVisual = mapaVisual;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

}
