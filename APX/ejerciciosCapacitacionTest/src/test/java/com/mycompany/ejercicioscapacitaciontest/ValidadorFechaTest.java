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
public class ValidadorFechaTest {
    
    public ValidadorFechaTest() {
        testMain();
        testVerificarAnio();
        testVerificarDia();
        testVerificarMes();
    }
    
    @Test
    public void testVerificarAnio() {
        System.out.println("Test de función verificarAnio()");
        Integer anio = 2020;
        boolean expResult = true;
        boolean result = ValidadorFecha.verificarAnio(anio);
        assertEquals(expResult, result);
    }

    @Test
    public void testVerificarMes() {
        System.out.println("Test de función verificarMes()");
        Integer mes = 13;
        boolean expResult = false;
        boolean result = ValidadorFecha.verificarMes(mes);
        assertEquals(expResult, result);
    }

    @Test
    public void testVerificarDia() {
        System.out.println("Test de función verificarDia()");
        Integer dia = 23;
        boolean expResult = true;
        boolean result = ValidadorFecha.verificarDia(dia);
        assertEquals(expResult, result);
    }

    @Test
    public void testMain() {
        System.out.println("Test de main method");
        String[] args = {"01", "12", "2020"};
        ValidadorFecha.main(args);
    }
    
}
