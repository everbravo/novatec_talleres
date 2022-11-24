/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioscapacitacion;

import java.util.Scanner;

/**
 *
 * @author ever.bravo
 */
public class ValidadorFechas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el dia");
            Integer dia = Integer.parseInt(sc.nextLine());

            System.out.println("Ingrese el mes");
            Integer mes = Integer.parseInt(sc.nextLine());

            System.out.println("Ingrese el anio");
            Integer anio = Integer.parseInt(sc.nextLine());
            
            String mesIsTrue = (verificarMes(mes)) ? "Valido" : "No Valido";
            String anioIsTrue = (verificarAnio(anio)) ? "Valido" : "No Valido";
            String diaIsTrue = (verificarDia(dia)) ? "Valido" : "No Valido";
            
            StringBuilder resultado = new StringBuilder("La validacion para los campos: ");
            resultado.append("Anio -> ".concat(anioIsTrue));
            resultado.append(", Mes -> ".concat(mesIsTrue));
            resultado.append(", Dia -> ".concat(diaIsTrue));
            
            System.out.println(resultado.toString());
            
        } catch (Exception e) {
            System.out.println("Algo inesperado ha ocurrido! " + e.getMessage());
        }
    }
    
    public static boolean verificarAnio(Integer anio){
        return anio.toString().length() == 4;
    }
    
    public static boolean verificarMes(Integer mes){
        return mes.toString().length()<=2 && mes >= 1 && mes <= 12;
    }
    
    public static boolean verificarDia(Integer dia){
        return dia.toString().length() <= 2 && dia > 0 && dia <= 30;
    }

}
