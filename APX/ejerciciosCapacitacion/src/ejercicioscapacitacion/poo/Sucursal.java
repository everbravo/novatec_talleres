/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioscapacitacion.poo;

/**
 *
 * @author ever.bravo
 */
public class Sucursal {
    
    private int numeroSucursal;
    
    private String direccion;
    
    private Ciudad ciudad;

    public Sucursal() {
    }

    public Sucursal(int numeroSucursal, String direccion, Ciudad ciudad) {
        this.numeroSucursal = numeroSucursal;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    public int getNumeroSucursal() {
        return numeroSucursal;
    }

    public void setNumeroSucursal(int numeroSucursal) {
        this.numeroSucursal = numeroSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "numeroSucursal=" + numeroSucursal + ", direccion=" + direccion + ", ciudad=" + ciudad + '}';
    }
    
    
}
