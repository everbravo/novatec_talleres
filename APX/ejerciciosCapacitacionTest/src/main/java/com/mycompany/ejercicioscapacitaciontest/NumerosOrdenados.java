/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ejercicioscapacitaciontest;

import java.util.*;
import java.util.Scanner;
import java.util.stream.DoubleStream;

/**
 *
 * @author ever.bravo
 */
public class NumerosOrdenados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List<Integer> numeros = Arrays.asList(new Integer[3]);
        
        for(int i = 0; i < numeros.size(); i++){
            System.out.println("Ingrese el valor # " +(i+1));
            String valor = sc.nextLine();
            try {
                numeros.set(i, Integer.parseInt(valor));
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar todos los valores requeridos");
            }
        }
        
        numeros.stream().sorted((a,b) -> b.compareTo(a)).forEach(System.out::println);
        
    }
    
}
