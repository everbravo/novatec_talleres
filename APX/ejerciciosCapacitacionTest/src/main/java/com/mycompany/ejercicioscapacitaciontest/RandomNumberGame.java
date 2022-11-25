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
public class RandomNumberGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int aleat = (int) Math.floor( Math.random() * 100);
        System.out.println("numero "+aleat);
        boolean adivinado = false;
        Integer contador = 0;
        try {
            while (!adivinado) {
                contador += 1;
               
                System.out.print("Numero: ");
                Integer numero = Integer.parseInt(sc.nextLine());
                
                if(numero == aleat){
                    System.out.println("Perfecto, le atinaste al numero con tan solo ".concat(contador.toString()).concat(" intentos"));
                    adivinado = true;
                }else if(numero < aleat){
                    System.out.println("uyy por poco, tu numero fue inferior al establecido");
                }else if(numero > aleat){
                    System.out.println("uyy por poco, tu numero fue superior al establecido");
                }
             
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
