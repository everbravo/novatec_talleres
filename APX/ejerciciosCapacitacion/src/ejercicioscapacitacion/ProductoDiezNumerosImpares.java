/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioscapacitacion;

import java.util.Scanner;

/**
 *
 * @author ever.bravo
 */
public class ProductoDiezNumerosImpares {

    public static void main(String[] args) {

        int cont = 1;
        double total = 0;

        for (int i = 1; i < Integer.MAX_VALUE; i++) {

            if (i % 2 == 0) {
                if (cont == 1) {
                    total += i;
                }else if(cont == 10){
                    System.out.println("Producto total = " + total);
                    break;
                }
                total *= i;
                cont += 1;
            }

        }

        

    }

}
