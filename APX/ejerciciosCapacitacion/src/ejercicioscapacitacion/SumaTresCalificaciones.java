/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioscapacitacion;

import java.util.*;
import java.util.Scanner;
import java.util.stream.DoubleStream;

/**
 *
 * @author ever.bravo
 */
public class SumaTresCalificaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        List<Double> notas = Arrays.asList(new Double[3]);
        
        for(int i = 0; i < notas.size(); i++){
            System.out.println("Ingrese la calificacion numero " +(i+1));
            String valor = sc.nextLine();
            try {
                notas.set(i, Double.valueOf(valor));
            } catch (NumberFormatException e) {
                notas.set(i, 0D);
                System.out.println("Uyyyy, Algo salio mal!");
            }
        }
        
        Double resultado = sumaCalificaciones(notas);
        System.out.println("La sumatoria de calificaciones de: " + resultado);
        
    }
    
    public static Double sumaCalificaciones(List<Double> notas){
        return (notas.stream().flatMapToDouble( v -> DoubleStream.of(v)).sum() / notas.size());
    }
    
}
