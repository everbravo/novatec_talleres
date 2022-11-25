/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.ejercicioscapacitaciontest;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ever.bravo
 */
public class MegaNovatecMallTest {
    
    public MegaNovatecMallTest() {
        testMain();
        testCalcularValorPagar();
    }

    @Test
    public void testMain() {
        System.out.println("Test main method");
        String[] args = {"300"};
        MegaNovatecMall.main(args);
    }

    @Test
    public void testCalcularValorPagar() {
        System.out.println("Test función calcularValorPagar()");
        double valor = 300;
        MegaNovatecMall.calcularValorPagar(valor);
    }
    
}
