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
public class CajeroAutomatico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Double saldoInicial = 1000D;
        String valor;
        Double numero;

        try {
            while (true) {
                System.out.println("Menú principal\n 1 - ingresar Dinero\n 2 - Retirar dinero \n 3 - Salir");
                System.out.print("Ingrese una Opcion: ");
                valor = sc.nextLine();

                switch (valor) {
                    case "1":
                        System.out.print("La cantidad a ingresar: ");
                        valor = sc.nextLine();
                        numero = Double.parseDouble(valor);
                        saldoInicial += Math.abs(numero);
                        break;
                    case "2":
                        System.out.print("La cantidad a ingresar: ");
                        valor = sc.nextLine();
                        numero = Double.parseDouble(valor);
                        if((saldoInicial - numero) >= 0){
                            saldoInicial -= (numero < 0) ? -numero : numero;
                        }else{
                            System.out.println("Usted no dispone de fondos suficientes");
                        }
                        break;
                    case "3":
                        System.out.println("Hasta la proxima!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("No se reconoce el comando");
                }
                
                System.out.println("Su saldo en cuenta es de: "+saldoInicial);
            }
        } catch (Exception e) {
            System.out.println("Algo inesperado ha ocurrido! " + e.getMessage());
        }
    }

}
