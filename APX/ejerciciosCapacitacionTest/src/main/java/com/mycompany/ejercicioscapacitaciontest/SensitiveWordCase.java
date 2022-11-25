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
public class SensitiveWordCase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una letra: ");
        String letra = sc.nextLine();
        String res = (letra.toUpperCase().equals(letra)) ? "letra en MAYUS" : "letra en MINUS";
        System.out.println(res);

    }

}
