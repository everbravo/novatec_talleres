/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioscapacitaciontest;

import org.junit.Test;

/**
 *
 * @author ever.bravo
 */
public class RunAllTest {
    
    @Test
    public void testAll0(){
        System.out.println("...Suit de test - 0");
        new AllNumberCeroToOneHundredTest();
    }
    
    @Test
    public void testAll1(){
        System.out.println("...Suit de test - 1");
        new CalculadoraSalarioSemanalTest();
    }
    
    @Test
    public void testAll2(){
        System.out.println("...Suit de test - 2");
        new CalificacionFinalTest();
    }
    
    @Test
    public void testAll3(){
        System.out.println("...Suit de test - 3");
        new DineroTotalTest();
    }
    
    @Test
    public void testAll4(){
        System.out.println("...Suit de test - 4");
        new MegaNovatecMallTest();
    }
    
    @Test
    public void testAll5(){
        System.out.println("...Suit de test - 5");
        new MultiplosDiezTest();
    }
    
    @Test
    public void testAll6(){
        System.out.println("...Suit de test - 6");
        new NotaCeroDiezTest();
    }
    
    @Test
    public void testAll7(){
        System.out.println("...Suit de test - 7");
        new SumaTresCalificacionesTest();
    }
    
    @Test
    public void testAll8(){
        System.out.println("...Suit de test - 8");
        new ValidadorFechaTest();
    }
}
