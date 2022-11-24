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
public class DineroTotal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double dineroErnesto;

        try {
            System.out.println("Ingrese la cantidad de dinero que posee Ernesto: ");
            dineroErnesto = Double.valueOf(sc.nextLine());
            calcularCantidad(dineroErnesto);
        } catch (NumberFormatException e) {
            System.out.println("Uyyyy, Algo salio mal!");
            System.exit(0);
        }
        
    }
    
    public static void calcularCantidad(double ernesto){
        double juan = ernesto / 2;
        double lucas = (juan + ernesto) / 2;
        double total = ernesto + juan + lucas;
        
        System.out.println("Dinero total: "+total);
    }
}
