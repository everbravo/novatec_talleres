/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1semillero.ClasesWrapper;

/**
 *
 * @author everbravovergara
 */
public class WrapperShort {
    protected short s;

    public WrapperShort() {
        
        s = Short.MAX_VALUE;
        System.out.println(s);
        
        s = Short.decode("4");
        System.out.println(s);
        
        s = Short.parseShort("3453");
        System.out.println(s);
        
        s = Short.reverseBytes((short)342);
        System.out.println(s);
        
        /*
        * la clase Short comparte metodos con las clases de tipo wrapper,
        * de tal modo que solo varian de acuerdo al tipo de dato (la clase String tiene mas metodos que la clase Boolean, etc...)
        
        */
        
        
        
    }
    
}
