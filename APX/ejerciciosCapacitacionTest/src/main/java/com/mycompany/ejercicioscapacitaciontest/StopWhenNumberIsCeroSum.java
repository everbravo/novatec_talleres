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
public class StopWhenNumberIsCeroSum {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Double total = 0D;

        try {
            while (true) {
               
                System.out.print("Numero: ");
                Double numero = Double.parseDouble(sc.nextLine());
                
                if(numero == 0){
                    System.out.println("Total ingresado: "+total);
                    throw new RuntimeException("Finalizando el loop");
                }
                
                total += numero;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
