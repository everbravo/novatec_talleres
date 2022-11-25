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
public class NumeroAlCuadrado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
               
                System.out.print("Numero: ");
                Double numero = Double.parseDouble(sc.nextLine());
                
                if(numero < 0){
                    throw new RuntimeException("Finalizando el loop");
                }else{
                    System.out.println("El cuadrado del numero ingresado es de: "+ (Math.pow(numero,2)));
                }
             
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
