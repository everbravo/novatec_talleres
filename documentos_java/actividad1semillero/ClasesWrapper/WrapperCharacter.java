/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1semillero.ClasesWrapper;

/**
 *
 * @author everbravovergara
 */
public class WrapperCharacter {
    
    protected int numero = 56;
    protected String cadena = "hola";
    protected char character = 'c';
    
    public WrapperCharacter() {
        
        // convertir a char
        char test1 = Character.valueOf(cadena.charAt(1));
        System.out.println(test1);
        
        // aplicar formato de titulo al char
        char test2 = Character.toTitleCase(test1);
        System.out.println(test2);
        
        // verificar si es una letra
        boolean test3 = Character.isLetter(character);
        System.out.println(test3);
        
        // convertir de unicode a char
        char test4 = Character.reverseBytes('\u4d00');
        System.out.println(test4);
        
        // verificar si hay espacios en blanco
        boolean test5 = Character.isWhitespace(character);
        System.out.println(test5);
        
        // verificar si es un digito
        boolean test6 = Character.isDigit(character);
        System.out.println(test6);
        
        // convertir a string
        String test7 = Character.toString(character);
        System.out.println(test7);
        
        // convertir a mayuscula
        char test8 = Character.toUpperCase(character);
        System.out.println(test8);
        
        // verificar si el caracter está en minusculas
        boolean test9 = Character.isLowerCase(character);
        System.out.println(test9);
        
        
        
        
    }
    
    
}
