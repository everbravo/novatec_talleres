/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioscapacitaciontest;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.Arrays;

/**
 *
 * @author ever.bravo
 */
public class CalculadoraSalarioSemanalTest {
    
    public void CalculadoraSalarioSemanalTest(){
        testMain();
        testCalcularSalario();
    }
    
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = {"42", "30000"};
        CalculadoraSalarioSemanal.main(args);
    }
    
    @Test
    public void testCalcularSalario(){
        System.out.println("Test de función calcularSalario()");
        int cantHoras = 42; 
        double salarioHora = 30000;
        double expValue = 1260000;
        double result = CalculadoraSalarioSemanal.calcularSalario(cantHoras, salarioHora);
        assertEquals(expValue, result, 0.00001);
    }
    
    
}
