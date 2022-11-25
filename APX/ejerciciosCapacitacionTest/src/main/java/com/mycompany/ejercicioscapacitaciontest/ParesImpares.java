/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioscapacitaciontest;

import java.util.Scanner;

/**
 *
 * @author ever.bravo
 */
public class ParesImpares {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese un numero: ");
            Integer numero = Integer.parseInt(sc.nextLine());
            
            System.out.print("Ingrese un segundo numero: ");
            Integer numero2 = Integer.parseInt(sc.nextLine());
            
            if((numero % 2) == 0 && (numero2 % 2) == 0){
                System.out.println("Pares");
            }else{
                System.out.println("Impares");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Uyyyy, Algo salio mal!");
        }
        
    }

}
