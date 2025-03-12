package com.mycompany.treasurehunter.juego;

import com.mycompany.treasurehunter.Jugador;
import com.mycompany.treasurehunter.Menu;
import com.mycompany.treasurehunter.adicionales.Color;
import com.mycompany.treasurehunter.adicionales.LectorEnteros;
import com.mycompany.treasurehunter.mapas.CreadorDeMapa;
import com.mycompany.treasurehunter.mapas.Mapa;
import java.util.Scanner;

/**
 *
 * @author ronaldo
 */
public class Motor {

    private Mapa[] mapas;
    private Partida[] partidas;
    private CreadorDeMapa creador;
    private boolean apagado;

    public Motor() {
        apagado = false;
        creador = new CreadorDeMapa();
        mapas = new Mapa[1];
        partidas = new Partida[1];
    }

    public void comenzarJuego() {
        int opcion;

        do {
            opcion = seleccionarAccionDeJuego();
            switch (opcion) {
                //Inicia una partida
                case 1:
                    iniciarUnaPartida();
                    break;
                case 2:
                    //Crea un mapa
                    crearMapa();
                    break;
                case 3:
                    //edita un mapa
                    break;
                case 4:
                    //sale del juego
                    apagado = true;
                    break;
                default:
                    break;
            }
        } while (!apagado);

    }

    public int seleccionarTipoDePartida() {
        int opcion;
        LectorEnteros lector = new LectorEnteros();

        do {
            System.out.println("|---------------TIPO DE PARTIDA---------------|");
            System.out.println("");
            System.out.println("1. Iniciar una nueva partida");
            System.out.println("2. Cargar una partida guardada");
            opcion = lector.leerNumero();
            if (opcion < 1 || opcion > 2) {
                System.out.println("Selecciona valores entre 1-2");
            }
        } while (opcion < 1 || opcion > 2);
        return opcion;
    }
    
    public void iniciarUnaPartida() {
         LectorEnteros lector = new LectorEnteros();
         
        int opcion=seleccionarTipoDePartida();
        if (opcion == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingresa el nombre de la partida: ");
            String nombreDeLaPartida = String.valueOf(scanner.nextLine());
            Mapa mapa = elegirUnMapaParaLaPartida();

            System.out.print("Ingresa el nombre de tu personaje: ");
            String nombre = String.valueOf(scanner.nextLine());
            //Se crea un jugador, pasandole su nombre y posicion inicial
            int []posicionInicial=mapa.getPosicionInicialJugador();
            Jugador jugador = new Jugador(nombre, posicionInicial);
            //Se cambia el jugador  por un jugador real
            mapa.setJugador(jugador);
            mapa.actualizarJugadorACasillas(jugador);
            mapa.limpiarMapaVisual();

            //Se crea la partida, pasandole el mismo motor para poder guardar la partida
            Partida partidaNueva = new Partida(nombreDeLaPartida, mapa, jugador, this);
            partidaNueva.iniciarPartida();
        }
        else if (opcion == 2) {
            int partidaSeleccionada;
            System.out.println("|---------------PARTIDAS GUARDADAS----------------|");
            System.out.println("");
            if (partidas.length > 1) {
                for (int i = 0; i < partidas.length - 1; i++) {
                    System.out.println((i + 1) + ". " + partidas[i].getNombre());
                }
                do {
                    System.out.print("Selecciona una Partida: ");
                    partidaSeleccionada = lector.leerNumero()-1;
                    
                } while (partidaSeleccionada < 0 || partidaSeleccionada > partidas.length - 1);
                

                //Si no hay ganador se declara el atributo terminado como falso
                if (partidas[partidaSeleccionada].isHayGanador() == false) {
                    partidas[partidaSeleccionada].setTerminado(false);
                    partidas[partidaSeleccionada].iniciarPartida();
                }

            } else {
                System.out.println("Sin partidas guardadas");
                System.out.println("Presiona cualquier numero y enter  para regresar");
                opcion = lector.leerNumero();
            }
        }

    }
    
    public int seleccionarAccionDeJuego() {
        Menu menu = new Menu();
        LectorEnteros lector = new LectorEnteros();
        Color color = new Color();
        int opcion;
        do {
            menu.mostrarMenuJuego();
            opcion = lector.leerNumero();
            if (opcion < 1 || opcion > 4) {
                System.out.println("Debes seleccionar entre 1-4");
            }
        } while (opcion < 1 || opcion > 4);

        return opcion;
    }

    public Mapa elegirUnMapaParaLaPartida() {
        int opcion;
        Mapa mapaElegido;
        LectorEnteros lector = new LectorEnteros();
        System.out.println("|---------------Mapas Disponibles---------------| ");
        System.out.println("");
        for (int i = 0; i < mapas.length - 1; i++) {
            System.out.println((i + 1) + ". " + mapas[i].getNombre());
        }
        do {
            System.out.print("Selecciona el mapa para tu partida: ");
            opcion = lector.leerNumero();
            if (opcion < 1 || opcion > mapas.length - 1) {
                System.out.println("Selecciona valores entre 1-" + (mapas.length - 1));
            }
        } while (opcion < 1 || opcion > mapas.length - 1);

        mapaElegido = mapas[opcion - 1];
        return mapaElegido;
    }

    //subprograma que controla al Creador de Mapas
    public void crearMapa() {
        System.out.println("|---------------CREADOR DE MAPAS---------------|");
        System.out.println("");
        Mapa mapa;
        // se crea un nuevo mapa
        mapa = creador.crearMapa();
        //se guarda al arreglo de mapas
        guardarMapaALista(mapa);
        // se aumenta 1 espacio del arreglo para un futuro nuevo mapa
        aumentarTamañoArregloDeMapas();
        System.out.println("Creacion FInalizada");
    }

    public void aumentarTamañoArregloDeMapas() {
        int tamaño = mapas.length;
        int nuevoTamaño = tamaño + 1;
        Mapa[] nuevoMapas = new Mapa[nuevoTamaño];

        for (int i = 0; i < mapas.length; i++) {
            nuevoMapas[i] = mapas[i];
        }
        mapas = nuevoMapas;
    }

    public void guardarMapaALista(Mapa mapa) {
        mapas[mapas.length - 1] = mapa;
    }

    public void guardarPartidaALista(Partida partida) {
        partidas[partidas.length - 1] = partida;
        aumentarTamañoDeArregloDePartidas();
    }

    public void aumentarTamañoDeArregloDePartidas() {
        int tamaño = partidas.length;
        int nuevoTamaño = tamaño + 1;
        Partida[] nuevaListaPartidas = new Partida[nuevoTamaño];

        for (int i = 0; i < partidas.length; i++) {
            nuevaListaPartidas[i] = partidas[i];
        }
        partidas = nuevaListaPartidas;
    }
}
