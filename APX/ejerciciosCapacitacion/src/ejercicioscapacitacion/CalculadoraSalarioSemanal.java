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
public class CalculadoraSalarioSemanal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Integer cantHoras = 0;
        Double salarioHora = 0D;

        try {
            System.out.println("Ingrese la cantidad de horas laboradas: ");
            cantHoras = Integer.parseInt(sc.nextLine());
            System.out.println("Ingrese el valor por hora laborada: ");
            salarioHora = Double.valueOf(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Uyyyy, Algo salio mal!");
        }
        
        Double resultado = calcularSalario(cantHoras, salarioHora);
        System.out.println("El salario total del trabajador por semana laborada es de: " + resultado);
        
    }
    
    public static Double calcularSalario(int cantHoras, double salarioHora){
        Double resultado = cantHoras * salarioHora;
        return resultado;
    }
    
}
