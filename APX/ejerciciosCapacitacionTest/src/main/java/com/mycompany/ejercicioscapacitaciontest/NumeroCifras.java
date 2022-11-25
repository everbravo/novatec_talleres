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
public class NumeroCifras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero en rango (0 - 99999)");
        String valor = sc.nextLine();
        try {
            Integer numero = Integer.parseInt(valor);
            
            if ( numero >= 0 && numero <= 99999) {
                System.out.println("Tiene ".concat(numero.toString().length() + " cifras"));
            }else{
                throw new RuntimeException ("rango fuera del establecido");
            }
            
        } catch (Exception e) {
            System.out.println("Algo inesperado ha ocurrido! "+ e.getMessage());
        }
    }

}
