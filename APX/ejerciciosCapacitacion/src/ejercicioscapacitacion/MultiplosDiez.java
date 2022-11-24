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
public class MultiplosDiez {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer numero;

        try {
            System.out.print("Ingrese un numero entero: ");
            numero = Integer.parseInt(sc.nextLine());
            
            if((numero % 10) == 0){
                System.out.println("Multiplo de 10");
            }else{
                System.out.println("No es multiplo del 10");
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Uyyyy, Algo salio mal!");
        }
        
    }

}
