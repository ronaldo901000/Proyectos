
package com.mycompany.proyectouno.Editor;
import com.mycompany.proyectouno.Jugador;
import com.mycompany.proyectouno.Mapa;
import com.mycompany.proyectouno.MotorJuego;
import com.mycompany.proyectouno.Planeta.Agua;
import com.mycompany.proyectouno.Planeta.Biotara;
import com.mycompany.proyectouno.Planeta.Fuego;
import com.mycompany.proyectouno.Planeta.Planeta;
import com.mycompany.proyectouno.Planeta.Radioactivo;
import com.mycompany.proyectouno.Planeta.Tierra;
import java.util.Random;
import java.util.Scanner;

public class EditorMapa {

    private EditorPlaneta editorPlaneta = new EditorPlaneta();  // Instancia de EditorPlaneta para delegar las funciones relacionadas con planetas

    // Método para inicializar el juego y retornar el Mapa
    public Mapa inicializarJuego(MotorJuego motorJuego) {
        System.out.println("CREACION DE UN NUEVO MAPA");
        configurarJugadores(motorJuego);  // Configura los jugadores en el motor
        Mapa mapa = inicializarMapa(motorJuego);  // Inicializa el mapa con los jugadores
        definirPlanetasIniciales(motorJuego, mapa);  // Define los planetas iniciales en el mapa
        definirPlanetasNeutrales(motorJuego, mapa);  // Define los planetas neutrales en el mapa
        return mapa;  // Retorna el mapa creado
    }

    // Configura los jugadores
    private void configurarJugadores(MotorJuego motorJuego) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Jugador 1, ingresa tu nombre: ");
        String nombre1 = scanner.nextLine();
        motorJuego.setJugador1(new Jugador(nombre1));

        System.out.print("Jugador 2, ingresa tu nombre: ");
        String nombre2 = scanner.nextLine();
        motorJuego.setJugador2(new Jugador(nombre2));
    }

    // Inicializa el mapa del juego
    private Mapa inicializarMapa(MotorJuego motorJuego) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nombre del mapa:");
        String nombreMapa = scanner.nextLine();
        System.out.println("SELECCIONA el tamaño del mapa (filas x columnas): ");
        System.out.print("Ingresa el número de filas: ");
        int filas = scanner.nextInt();
        System.out.print("Ingresa el número de columnas: ");
        int columnas = scanner.nextInt();

        // Crear el mapa con los jugadores
        Mapa mapa = new Mapa(filas, columnas, nombreMapa, motorJuego.getJugador1(), motorJuego.getJugador2());
        motorJuego.setMapa(mapa);  // Asigna el mapa al motor del juego
        return mapa;
    }

    // Define los planetas iniciales de los jugadores
    private void definirPlanetasIniciales(MotorJuego motorJuego, Mapa mapa) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Es momento de definir los planetas iniciales");
        System.out.println("1. Quieres editar");
        System.out.println("2. No quieres editar");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            agregarPlanetasManual(motorJuego, mapa);
        } else if (opcion == 2) {
            agregarPlanetasAleatorios(motorJuego, mapa);
        }
    }

    // Método encargado de generar y guardar el mapa hecho por los jugadores
    private void agregarPlanetasManual(MotorJuego motorJuego, Mapa mapa) {
        Scanner scanner = new Scanner(System.in);

        // Planeta del Jugador 1
        System.out.println(motorJuego.getJugador1().getNombre() + " ingresa el nombre de tu planeta:");
        String nombrePlaneta1 = scanner.next();
        Planeta planetaJugador1 = editorPlaneta.seleccionarPlanetaAleatorio(nombrePlaneta1, motorJuego.getJugador1());
        mapa.agregarPlaneta(planetaJugador1);
        editorPlaneta.editarPlaneta(planetaJugador1);  // Llamar método para editar el planeta
        editorPlaneta.mostrarCondicionesIniciales(planetaJugador1);

        // Planeta del Jugador 2
        System.out.println(motorJuego.getJugador2().getNombre() + " ingresa el nombre de tu planeta:");
        String nombrePlaneta2 = scanner.next();
        Planeta planetaJugador2 = editorPlaneta.seleccionarPlanetaAleatorio(nombrePlaneta2, motorJuego.getJugador2());
        mapa.agregarPlaneta(planetaJugador2);
        editorPlaneta.editarPlaneta(planetaJugador2);  // Llamar método para editar el planeta
        editorPlaneta.mostrarCondicionesIniciales(planetaJugador2);
    }

    // Método encargado de generar planetas aleatorios que pertenecen a los jugadores
    private void agregarPlanetasAleatorios(MotorJuego motorJuego, Mapa mapa) {
        String nombreAleatorio1 = editorPlaneta.generarNombreSecuencial();
        String nombreAleatorio2 = editorPlaneta.generarNombreSecuencial();
        Planeta planetaAleatorio1 = editorPlaneta.seleccionarPlanetaAleatorio(nombreAleatorio1, motorJuego.getJugador1());
        Planeta planetaAleatorio2 = editorPlaneta.seleccionarPlanetaAleatorio(nombreAleatorio2, motorJuego.getJugador2());
        mapa.agregarPlaneta(planetaAleatorio1);
        mapa.agregarPlaneta(planetaAleatorio2);

        editorPlaneta.mostrarCondicionesIniciales(planetaAleatorio1);
        editorPlaneta.mostrarCondicionesIniciales(planetaAleatorio2);
    }

    // Método encargado de generar los planetas neutrales
// Método encargado de generar los planetas neutrales
private void definirPlanetasNeutrales(MotorJuego motorJuego, Mapa mapa) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingresa la cantidad de planetas neutrales: ");
    int cantidadNeutrales = scanner.nextInt();

    for (int i = 0; i < cantidadNeutrales; i++) {
        String nombreNeutral;

        System.out.println("¿Deseas ingresar el nombre del planeta neutral? (si = 1 / no = 2): ");
        int opcion = scanner.nextInt();

        if (opcion == 1) {
            System.out.print("Ingresa el nombre del planeta neutral: ");
            nombreNeutral = scanner.next();
        } else {
            nombreNeutral = editorPlaneta.generarNombreSecuencial();
        }
        
        // Crear planeta neutral sin dueño
        Planeta planetaNeutral = editorPlaneta.seleccionarPlanetaAleatorio(nombreNeutral, null);
        mapa.agregarPlaneta(planetaNeutral);
        editorPlaneta.editarPlaneta(planetaNeutral);
        editorPlaneta.mostrarCondicionesIniciales(planetaNeutral);
    }
}

}






