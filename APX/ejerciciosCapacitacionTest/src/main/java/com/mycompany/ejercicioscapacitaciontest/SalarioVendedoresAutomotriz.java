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
public class SalarioVendedoresAutomotriz {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int COMISION = 150;
        final double SALARIOVENDEDOR = 1000;
        Double sueldoRecibir = 0D;
        Integer cantAutos = 0;

        try {
            System.out.println("Ingrese la cantidad de autos vendidos por el agente de venta: ");
            cantAutos = Integer.parseInt(sc.nextLine());
            
            sueldoRecibir = SALARIOVENDEDOR + (COMISION * cantAutos);
            System.out.println("El salario para el emplead@ es de: $ ".concat(sueldoRecibir.toString()));
        } catch (NumberFormatException e) {
            System.out.println("Uyyyy, Algo salio mal!");
            System.exit(0);
        }
        
    }
    
}
