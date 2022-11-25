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
public class MegaNovatecMall {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double totalCompra;

        try {
            System.out.print("Ingrese el valor total de la compra: ");
            totalCompra = (args.length > 0) ? Double.valueOf(args[0]) : Double.valueOf(sc.nextLine());
            calcularValorPagar(totalCompra);
        } catch (NumberFormatException e) {
            System.out.println("Uyyyy, Algo salio mal!");
        }
        
    }
    
    public static void calcularValorPagar(double valor){
        double total = valor;
        boolean derechoDescuento = (valor >= 300)? true : false;
        
        if(derechoDescuento){
            total -= valor * 0.20;
        }
        
        System.out.println("Dinero total a pagar: "+total);
    }
}
