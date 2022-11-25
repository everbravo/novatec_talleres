/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.ejercicioscapacitaciontest.poo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ever.bravo
 */
public class CiudadTest {
    
    public CiudadTest() {
    }

    @Test
    public void testValues() {
        System.out.println("values");
        Ciudad[] expResult = {Ciudad.BOGOTA, Ciudad.MEDELLIN, Ciudad.CARTAGENA, Ciudad.CALI, Ciudad.MONTERIA, Ciudad.OTRO};
        Ciudad[] result = Ciudad.values();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String string = "BOGOTA";
        Ciudad expResult = Ciudad.MEDELLIN;
        Ciudad result = Ciudad.valueOf(string);
        assertNotEquals(expResult, result);
    }
    
}
