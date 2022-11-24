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
public class NumeroMayor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Ingrese el primer numero: ");
            Integer numero1 = Integer.parseInt(sc.nextLine());
            
            System.out.print("Ingrese el segundo numero: ");
            Integer numero2 = Integer.parseInt(sc.nextLine());
            
            if(numero1 == numero2){
                System.out.println("Los numeros son semejantes");
            }else if(numero1 > numero2){
                System.out.println("El numero "+numero1+" es mayor a "+numero2);
            }else{
                System.out.println("El numero "+numero2+" es mayor a "+numero1);
            }
            
        } catch (NumberFormatException e) {
            System.out.println("Uyyyy, Algo salio mal!");
        }
        
    }

}
