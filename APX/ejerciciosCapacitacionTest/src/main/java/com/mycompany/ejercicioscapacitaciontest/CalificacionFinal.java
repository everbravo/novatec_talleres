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
public class CalificacionFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Double> ponderaciones = Arrays.asList(0.10, 0.25, 0.25, 0.40);
        List<String> concepto = Arrays.asList("Participación", "Primer Examen", "Segundo Examen", "Examen Final");
        Double notaFinal = 0D;

        if (args.length > 0) {
            for (int i = 0; i < concepto.size(); i++) {
                System.out.println("Ingrese la calificacion po concepto de '".concat(concepto.get(i)).concat("'"));
                String valor = args[i];
                System.out.println(valor);
                try {
                    notaFinal += Double.valueOf(valor) * ponderaciones.get(i);
                } catch (NumberFormatException e) {
                    System.out.println("Uyyyy, Algo salio mal!");
                    System.exit(0);
                }
            }
        } else {
            for (int i = 0; i < concepto.size(); i++) {
                System.out.println("Ingrese la calificacion po concepto de '".concat(concepto.get(i)).concat("'"));
                String valor = sc.nextLine();
                try {
                    notaFinal += Double.valueOf(valor) * ponderaciones.get(i);
                } catch (NumberFormatException e) {
                    System.out.println("Uyyyy, Algo salio mal!");
                    System.exit(0);
                }
            }
        }

        System.out.println("La nota final es: " + notaFinal);

    }
}
