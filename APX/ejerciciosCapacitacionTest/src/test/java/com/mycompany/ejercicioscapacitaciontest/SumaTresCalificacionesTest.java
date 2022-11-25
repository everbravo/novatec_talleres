/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.ejercicioscapacitaciontest;

import java.util.List;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ever.bravo
 */
public class SumaTresCalificacionesTest {
    
    public SumaTresCalificacionesTest() {
        testMain();
        testSumaCalificaciones();
    }

    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = {"2", "3", "5"};
        SumaTresCalificaciones.main(args);
    }

    @Test
    public void testSumaCalificaciones() {
        System.out.println("Test de función sumaCalificaciones()");
        List<Double> notas = Arrays.asList(2.0, 3.0, 5.0);
        Double expResult = 3.3;
        Double result = SumaTresCalificaciones.sumaCalificaciones(notas);
        assertEquals(expResult, result, 0.1);
    }
    
}
