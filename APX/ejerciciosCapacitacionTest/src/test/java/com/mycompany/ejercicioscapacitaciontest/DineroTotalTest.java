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
public class DineroTotalTest {
    
    public DineroTotalTest() {
        testMain();
        testCalcularCantidad();
    }

    @Test
    public void testMain() {
        System.out.println("Test main method");
        String[] args = {"300"};
        DineroTotal.main(args);
    }

    @Test
    public void testCalcularCantidad() {
        System.out.println("Test Función calcularCantidad()");
        double ernesto = 400;
        DineroTotal.calcularCantidad(ernesto);
    }
    
}
