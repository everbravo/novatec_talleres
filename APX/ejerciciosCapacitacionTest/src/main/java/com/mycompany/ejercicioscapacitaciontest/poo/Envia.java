/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioscapacitaciontest.poo;

/**
 *
 * @author ever.bravo
 */
public class Envia {
    public static void main(String[] args) {
        Paquete p1 = new Paquete(200000D, Prioridad.EXPRESS, "12345678", 3D, new Sucursal(1, "crra 58A - sur 23 - Autopista Yuju", Ciudad.CARTAGENA));
        System.out.println(p1);
        System.out.println("El costo de envio es de: "+p1.getPrecioEnvio());
    }
}
