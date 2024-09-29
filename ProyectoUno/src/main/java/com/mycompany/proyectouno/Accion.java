/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectouno;

import com.mycompany.proyectouno.Guerrero.Guerrero;
import com.mycompany.proyectouno.Guerrero.Rdonix;
import com.mycompany.proyectouno.Planeta.Planeta;

/**
 *
 * @author ronaldo
 */
public class Accion {

    private String parametros;
    private Mapa mapa;
    private int numeroJugador;

    public Accion(String parametros, Mapa mapa, int numeroJugador) {
        this.parametros = parametros;
        this.mapa = mapa;
        this.numeroJugador = numeroJugador;
    }

    public void enviarFlota() { // planeta origen, cantidad de guerreros, tipo de guerreros, tipo de nave y planeta destino
        String[] params = parametros.split(",");
        int[] coordenadasOrigen = convertirCordenadas(params[0].trim());
        int cantidadGuerreros = Integer.valueOf(params[1].trim());
        String tipoGuerrero = params[2].trim();
        String tipoNave = params[3].trim();
        int[] coordenadasDestino = convertirCordenadas(params[4].trim());

        Guerrero[] guerrerosOrigen = new Guerrero[cantidadGuerreros];

        for (int i = 0; i < guerrerosOrigen.length; i++) {
            guerrerosOrigen[i] = new Rdonix(); // Por simplicidad se pone al guerrero mas fuerte
        }

        Planeta destino = mapa.getPlanetas()[coordenadasDestino[0] - 1][coordenadasDestino[1] - 1];

        Guerrero[] guerrerosDestino = destino.getGuerreros();

        Jugador atacante = null;

        if (numeroJugador == 1) {
            atacante = mapa.getJugador1();
        } else {
            atacante = mapa.getJugador2();
        }

        enfrentarGuerreros(guerrerosOrigen, guerrerosDestino, destino, atacante);

    }

    private void enfrentarGuerreros(Guerrero[] guerrerosOrigen, Guerrero[] guerrerosDestino, Planeta planetaDestino, Jugador atacante) {
        int victoriasOrigen = 0;
        int victoriasDestino = 0;

        // Iterar sobre los guerreros de ambos bandos
        int minTropas = Math.min(guerrerosOrigen.length, guerrerosDestino.length);

        for (int i = 0; i < minTropas; i++) {
            if (guerrerosDestino[i] != null) {
                // Comparar los valores de muerte de cada guerrero
                if (guerrerosOrigen[i].getFactorMuerte() > guerrerosDestino[i].getFactorMuerte()) {
                    victoriasOrigen++;
                } else {
                    victoriasDestino++;
                }
            }

        }

        // Por simplicidad, si hay guerreros adicionales en un bando, contarlos como victorias automaticas
        if (guerrerosOrigen.length > minTropas) {
            victoriasOrigen += (guerrerosOrigen.length - minTropas);
        } else if (guerrerosDestino.length > minTropas) {
            victoriasDestino += (guerrerosDestino.length - minTropas);
        }

        // Determinar el bando ganador
        if (victoriasOrigen > victoriasDestino) {
            System.out.println("El bando atacante ha ganado con " + victoriasOrigen + " victorias.");
            planetaDestino.setDueño(atacante);
        } else if (victoriasDestino > victoriasOrigen) {
            System.out.println("El bando defensor ha ganado con " + victoriasDestino + " victorias.");
        } else {
            System.out.println("El enfrentamiento ha terminado en empate.");
        }
    }

    public void medirDistancia() {
        int[] coordenadaPlaneta1 = convertirCordenadas(parametros.split(",")[0].trim());
        int[] coordenadaPlaneta2 = convertirCordenadas(parametros.split(",")[1].trim());

        int deltaX = coordenadaPlaneta2[0] - coordenadaPlaneta1[0];
        int deltaY = coordenadaPlaneta2[1] - coordenadaPlaneta1[1];

        // Formula de la magnitud
        double valor = Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        double distancia = valor*5; //cada casilla equivalda a 5 años luz

        System.out.println("La distancia es de: " + distancia + " años luz.");

    }

    public void verPlaneta() {
        int[] coordenadas = convertirCordenadas(parametros.trim());
        // Verificacion de las coordenadas estén dentro de los límites del mapa
        if (coordenadas[0] - 1 >= 0 && coordenadas[0] - 1 < mapa.getFilas()
                && coordenadas[1] - 1 >= 0 && coordenadas[1] - 1 < mapa.getColumnas()) {

            Planeta planeta = mapa.obtenerPlaneta(coordenadas[0] - 1, coordenadas[1] - 1);

            if (planeta != null) {
                // Verificamos si el jugador es el Jugador 1
                if (numeroJugador == 1) {
                    // Si el planeta es neutral o pertenece al Jugador 1
                    if (planeta.getDueño() == null || planeta.getDueño().getNombre().equals(mapa.getJugador1().getNombre())) {
                        System.out.println("Descripción del planeta:");
                        System.out.println("Nombre: " + planeta.getNombre());
                        System.out.println("Dueño: " + (planeta.getDueño() != null ? planeta.getDueño().getNombre() : "Neutral"));
                        System.out.println("Porcentaje de muerte: " + planeta.getPorcentajeDeMuerte());
                    } else {
                        // Si el planeta pertenece al Jugador 2, bloquear la información
                        System.out.println("No puedes ver este planeta ya que pertenece al jugador rival.");
                    }
                } // Verificamos si el jugador es el Jugador 2
                else if (numeroJugador == 2) {
                    // Si el planeta es neutral o pertenece al Jugador 2
                    if (planeta.getDueño() == null || planeta.getDueño().getNombre().equals(mapa.getJugador2().getNombre())) {
                        System.out.println("Descripción del planeta:");
                        System.out.println("Nombre: " + planeta.getNombre());
                        System.out.println("Dueño: " + (planeta.getDueño() != null ? planeta.getDueño().getNombre() : "Neutral"));
                        System.out.println("Porcentaje de muerte: " + planeta.getPorcentajeDeMuerte());
                    } else {
                        // Si el planeta pertenece al Jugador 1, bloquear la información
                        System.out.println("No puedes ver este planeta ya que pertenece al jugador rival.");
                    }
                }
            } else {
                // Mensaje en caso de que no haya planeta en las coordenadas indicadas
                System.out.println("No hay ningún planeta en las coordenadas especificadas.");
            }
        } else {
            // Mensaje si las coordenadas están fuera de los límites del mapa
            System.out.println("Coordenadas fuera de los límites del mapa.");
        }
    }

    private int[] convertirCordenadas(String parametro) {
        int[] resultado = new int[2]; // Array para almacenar los dos elementos
        int indiceNumero = 0;

        //primero convierto las letras a mayusculas
        parametro = parametro.toUpperCase();

        // despues se encuentra el índice del primer número en la cadena
        for (int i = 0; i < parametro.length(); i++) {
            if (Character.isDigit(parametro.charAt(i))) {
                indiceNumero = i;
                break;
            }
        }

        // Parte de las letras (columna)
        String parteLetra = parametro.substring(0, indiceNumero);
        int numeroLetra = 0;
        for (int i = 0; i < parteLetra.length(); i++) {
            // Multiplicamos por 26 (ya que es base 26) y sumamos el valor de la letra
            numeroLetra = numeroLetra * 26 + (parteLetra.charAt(i) - 'A' + 1);
        }

        // Parte numérica (fila)
        String parteNumero = parametro.substring(indiceNumero);
        int numero = Integer.parseInt(parteNumero);

        // Ajustar el resultado
        resultado[0] = numeroLetra; // Número de columna (transformado desde letras)
        resultado[1] = numero;      // Número de fila (int)

        return resultado;
    }

}
