/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1semillero.ClasesWrapper;

/**
 *
 * @author everbravovergara
 */
public class WrapperDouble {
    // valor maximo de un tipo de dato double
    private double numero = Double.MAX_VALUE;

    public WrapperDouble() {
    
        System.out.println(numero);
        
        // convertir a string un double
        String test2 = Double.toString( numero );
        System.out.println(test2);
        
        // convertir de string a double
        double test4 = Double.parseDouble("32421");
        System.out.println(test4);
        
        // convertir a double
        double test6 = Double.valueOf( "23" );
        System.out.println(test6);
        
        // obtener el codigo hash
        int test12 = Double.hashCode(numero);
        System.out.println(test12);
        
        // retorna un argumento string en base 16
        System.out.println(Double.toHexString(23));
        
        // Comparar dos double (0 -> son iguales, -1 -> si a < b, 1 -> si a > b)
        System.out.println(Double.compare(test6, test4));
        
        // Obtener el valor maximo
        System.out.println(Double.max(45632, numero));
        
        // obtener la suma de los dos valores
        System.out.println(Double.sum(89, 43));
        
    }
}
