/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1semillero.ClasesWrapper;

/**
 *
 * @author everbravovergara
 */
public class WrapperBoolean {

    public WrapperBoolean() {
    
        // 0 si x == y, menor que 0 si x = true && y = false, mayor que 0 si x = true && y = false
        System.out.println(Boolean.compare(true, false));
        
        // obtener el hashcode
        System.out.println(Boolean.hashCode(false));
        
        // compuerta logica and
        System.out.println(Boolean.logicalAnd(true, true));
        
        // compuerta logica or
        System.out.println(Boolean.logicalOr(false, true));
        
        // compuerta logica xor
        System.out.println(Boolean.logicalXor(true, true));
        
        // convertir de string a boolean
        System.out.println(Boolean.parseBoolean("False"));
        
        // convertir a boolean
        System.out.println(Boolean.valueOf("ff"));
        
    }
    
    
    
}
