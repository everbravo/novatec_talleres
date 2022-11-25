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
public class PaqueteTest {
    
    public PaqueteTest() {
    }

    @Test
    public void testGetNumeroReferencia() {
        System.out.println("getNumeroReferencia");
        Paquete instance = new Paquete(200000D, Prioridad.EXPRESS, "12345678", 3D, new Sucursal(1, "crra 58A - sur 23 - Autopista Yuju", Ciudad.CARTAGENA));
        String expResult = "456767";
        String result = instance.getNumeroReferencia();
        assertNotEquals(expResult, result);
    }

    @Test
    public void testGetPrecioEnvio() {
        System.out.println("getPrecioEnvio");
        Paquete instance = new Paquete(200000D, Prioridad.EXPRESS, "12345678", 3D, new Sucursal(1, "crra 58A - sur 23 - Autopista Yuju", Ciudad.CARTAGENA));
        Double expResult = 30023D;
        Double result = instance.getPrecioEnvio();
        assertEquals(expResult, result, 0.0001);
    }

    @Test
    public void testCalcularPrecioEnvio() {
        System.out.println("calcularPrecioEnvio");
        Paquete instance = new Paquete(200000D, Prioridad.EXPRESS, "12345678", 3D, new Sucursal(1, "crra 58A - sur 23 - Autopista Yuju", Ciudad.CARTAGENA));
        Double expResult = 30023D;
        Double result = instance.calcularPrecioEnvio();
        assertEquals(expResult, result, 0.0001);
    }
    
}
