/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1semillero.ClasesWrapper;

/**
 *
 * @author everbravovergara
 */
public class WrapperLong {
    
    // valor maximo de un tipo de dato long
    private long numero = Long.MAX_VALUE;

    public WrapperLong() {
    
        System.out.println(numero);
        
        // convertir a string un long
        String test2 = Long.toString( numero );
        System.out.println(test2);
        
        // convertir de string a long
        long test4 = Long.parseLong( "32421" );
        System.out.println(test4);
        
        // convertir a long
        Long test6 = Long.valueOf( "23" );
        System.out.println(test6);
        
        // obtener el codigo hash
        int test12 = Long.hashCode(numero);
        System.out.println(test12);
        
        // retorna un argumento string en base 16
        System.out.println(Long.toHexString(23));
        
        // Comparar dos long (0 -> son iguales, -1 -> si a < b, 1 -> si a > b)
        System.out.println(Long.compareUnsigned(0, 0));
        
        // retorna el restante sin signo de la division
        System.out.println(Long.remainderUnsigned(23, 2));
        
        // retornar el valor obtenido de invertir los bits correspondientes al valor dado
        System.out.println(Long.reverse(3));
  
        // retorna -1 si es negativo, 0 si el valor ingresado es cero, 1 si es positivo
        System.out.println(Long.signum(-1));
        
        // Obtener el valor maximo
        System.out.println(Long.max(45632, numero));
        
        // obtener la suma de los dos valores
        System.out.println(Long.sum(89, 43));
        
    }
    
    
    
    
}
