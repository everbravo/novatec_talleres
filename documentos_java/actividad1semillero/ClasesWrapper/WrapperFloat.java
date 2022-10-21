/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1semillero.ClasesWrapper;

/**
 *
 * @author everbravovergara
 */
public class WrapperFloat {
    
    protected float f = Float.MAX_VALUE;
    protected float f2 = Float.POSITIVE_INFINITY;
    protected float f3 = Float.NEGATIVE_INFINITY;

    public WrapperFloat() {
        
        Float g = 23.0F;
    
        // Verificar si esta vacio
        boolean bol = Float.isNaN(f);
        System.out.println(bol);
        
        // verificar si es finito
        boolean bol2 = Float.isFinite(f);
        System.out.println(bol2);
        
        // verificar si es un conjunto infinito
        boolean bol3 = Float.isInfinite(f2);
        System.out.println(bol3);
        
        // obtener el codigo hash
        int i = Float.hashCode(f3);
        System.out.println(i);
        
        // verificar si g es igual a f3
        boolean b = g.equals(f3);
        System.out.println(b);
        
        // convertir datos con parsefloat
        float ff = Float.parseFloat("434");
        System.out.println(ff);
        
        // convertir de float a string
        String f4 = Float.toString(f);
        System.out.println(f4);
    }
    
    
    
}
