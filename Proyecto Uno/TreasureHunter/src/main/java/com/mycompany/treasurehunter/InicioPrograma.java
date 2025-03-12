/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.treasurehunter;

import com.mycompany.treasurehunter.adicionales.LectorEnteros;
import com.mycompany.treasurehunter.juego.Motor;
import java.util.Scanner;

/**
 *
 * @author ronaldo
 */
public class InicioPrograma {
    private boolean apagado;

    public InicioPrograma() {
        apagado=false;
    }
    
    public void iniciarProgama(){
        Motor motor = new Motor();
        do{
            int opcion= seleccionarOpcion();
            if(opcion==1){
                //Va al juego
               motor.comenzarJuego();
            }
            else if(opcion==2){
                //Va a repotes
                System.out.println("Sin implementar- Reportes");
            }
            else if(opcion==3){
                //Sale
                System.out.println("Saliendo del Programa");
                apagado=true;
            }       
        }while(!apagado);
    }
    
    //selecciona la opcion del menu principal
    private int seleccionarOpcion() {
        Scanner scanner = new Scanner(System.in);
        LectorEnteros lector = new LectorEnteros();
        int opcion;
        Menu menu = new Menu();
        do {
            menu.mostrarMenuPrincipal();
            opcion = lector.leerNumero();
            if(opcion < 1 || opcion > 3){
                System.out.println("Selecciona valores 1-3");
            }
        } while (opcion < 1 || opcion > 3);

        return opcion;
    }

}
