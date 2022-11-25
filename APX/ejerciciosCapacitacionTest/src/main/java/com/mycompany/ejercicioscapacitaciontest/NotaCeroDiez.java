/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ejercicioscapacitaciontest;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author ever.bravo
 */
public class NotaCeroDiez {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese una nota en rango (0 - 10)");
        try {
            Integer numero = (args.length > 0 && args != null) ? Integer.parseInt(args[0]) :Integer.parseInt(sc.nextLine());
            
            if ( numero >= 0 && numero <= 10) {
                if ( numero <= 2) {
                    System.out.println("Insuficiente");
                }else if(numero > 2 && numero <= 4){
                    System.out.println("Suficiente");
                }else if(numero > 4 && numero <= 6){
                    System.out.println("Bien");
                }else if(numero > 6 && numero <= 8){
                    System.out.println("Notable");
                }else{
                    System.out.println("Sobresaliente");
                }
            }else{
                throw new RuntimeException ("rango fuera del establecido");
            }
            
        } catch (Exception e) {
            System.out.println("Algo inesperado ha ocurrido! "+ e.getMessage());
        }
    }

}
