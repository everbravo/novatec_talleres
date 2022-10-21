/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1semillero.ClasesWrapper;

/**
 *
 * @author everbravovergara
 */
public class WrapperInteger {
    
    protected int numero = 56;
    protected String cadena = "345";
    protected char character = '1';
    protected double numDouble = 22.4;
    protected float numFloat = 0.1f;

    public WrapperInteger() {
        
        // retorna la cantidad de unos en la representacion de bits para el numero
        System.out.println(Integer.toBinaryString(numero));
        int test1 = Integer.bitCount(numero);
        System.out.println(test1);
        
        // convierte una cadena al tipo de dato Integer
        int test2 = Integer.decode(cadena);
        System.out.println(test2);
        
        // Retorna el codigo hash
        int test3 = Integer.hashCode(numero);
        System.out.println(test3);
        
        // Comparar dos enteros (0 -> son iguales, -1 -> si a < b, 1 -> si a > b)
        int test4 = Integer.compareUnsigned(0, 0);
        System.out.println(test4);
        
        // retorna el valor del bit mayor en un dato determinado
        int test5 = Integer.highestOneBit(test2);
        System.out.println(test5);
        
        // retorna el valor del bit mas bajo en un dato determinado
        int test6 = Integer.lowestOneBit(test2);
        System.out.println(test6);
        
        // retorna el mayor y menor en ambos acasos
        int test7 = Integer.max(test6, test2);
        int test8 = Integer.min(test6, test2);
        System.out.println(test7 + " - " +test8);
        
        // convertir de cadena a entero
        int test9 = Integer.parseInt("321");
        System.out.println(test9);
        
        // convertir de cadena a entero sin signo
        int test10 = Integer.parseInt("-32423");
        System.out.println(test10);
        
    }
    
}
