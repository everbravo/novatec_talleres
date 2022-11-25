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
public class PrioridadTest {
    
    public PrioridadTest() {
    }

    @Test
    public void testValues() {
        System.out.println("values");
        Prioridad[] expResult = {Prioridad.NORMAL, Prioridad.ALTA, Prioridad.EXPRESS};
        Prioridad[] result = Prioridad.values();
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String string = "";
        Prioridad expResult = Prioridad.EXPRESS;
        Prioridad result = Prioridad.valueOf("EXPRESS");
        assertEquals(expResult, result);
    }
    
}
