/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad1semillero.ClasesWrapper;

/**
 *
 * @author everbravovergara
 */
public class WrapperByte {

    public WrapperByte() {
        
        byte b = 3;
        byte c = 5;
        
        // convertir a byte
        byte test0 = Byte.valueOf("127");
        System.out.println(test0);
        
        // obtener el codigo hash
        int test1 = Byte.hashCode(b);
        System.out.println(test1);
        
        // comparar dos datos byte (0 si b = c, si a es mayor que b retorna un valor positivo, de lo contrario retorna un valor negativo)
        int test2 = Byte.compare(b, c);
        System.out.println(test2);
        
        // convertir a string un dato byte
        String test3 = Byte.toString(b);
        System.out.println(test3);
        
        // decodificacion de un string a byte
        byte test4 = Byte.decode("100");
        System.out.println(test4);
        
        //convertir a long sin signo
        long test5 = Byte.toUnsignedLong(c);
        System.out.println(test5);
        
    }
    
}
