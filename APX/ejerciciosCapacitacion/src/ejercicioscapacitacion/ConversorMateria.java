/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioscapacitacion;

import java.util.*;
import java.util.Scanner;

/**
 *
 * @author ever.bravo
 */
public class ConversorMateria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        final Double tcGramos = 1000D;
        final Double tcMiliGramos = 1000000D;
        final Double tcLibra = 2.20462262;

        try {
            while (true) {
                System.out.println("Conversor Kg - Menú principal\n 1 - A Gramos\n 2 - A MiliGramos\n 3 - A Libras \n 4 - Salir");
                System.out.print("Ingrese una Opcion: ");
                String valor = sc.nextLine();
                
                if(valor.equals("4")){
                    System.out.println("Buena suerte!");
                    System.exit(0);
                }
                
                System.out.print("Cantidad: ");
                Double numero = Double.parseDouble(sc.nextLine());
                
                switch (valor) {
                    case "1":
                        System.out.println(String.format("%,.2f Kg es equivalente a %,.2f Gramos", numero, numero * tcGramos));
                        break;
                    case "2":
                        System.out.println(String.format("%,.2f Kg es equivalente a %,.2f MiliGramos", numero, numero * tcMiliGramos));
                        break;
                    case "3":
                        System.out.println(String.format("%,.2f Kg es equivalente a %,.2f Libras", numero, numero * tcLibra));
                        break;
                  
                    default:
                        System.out.println("No se reconoce el comando");
                }
             
            }
        } catch (Exception e) {
            System.out.println("Algo inesperado ha ocurrido! " + e.getMessage());
        }
    }

}
