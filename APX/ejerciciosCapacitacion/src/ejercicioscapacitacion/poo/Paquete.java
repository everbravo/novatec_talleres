/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioscapacitacion.poo;

/**
 *
 * @author ever.bravo
 */
public class Paquete {
    
    private Double precio;
    
    private Double precioEnvio;
    
    private Prioridad prioridad;
    
    private String numeroReferencia;
    
    private String dniPersona;
    
    private Double peso;
    
    private Sucursal sucursal;

    public Paquete(Double precio, Prioridad prioridad, String dniPersona, Double peso, Sucursal sucursal) {
        this.precio = precio;
        this.prioridad = prioridad;
        this.numeroReferencia = String.valueOf(Math.floor(Math.random()*100000));
        this.dniPersona = dniPersona;
        this.peso = peso;
        this.sucursal = sucursal;
        this.precioEnvio = calcularPrecioEnvio();
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPrecioEnvio() {
        return precioEnvio;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }
    
    public Double calcularPrecioEnvio(){
        double totalPorKilo = peso * 1;
        double totalPorPrioridad = 0D;
        if(prioridad.equals(Prioridad.ALTA)){
            totalPorPrioridad = 10;
        }else if(prioridad.equals(Prioridad.EXPRESS)){
            totalPorPrioridad = 20;
        }
        return (precio * 0.15) + totalPorKilo + totalPorPrioridad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paquete{");
        sb.append("precio=").append(precio);
        sb.append(", precioEnvio=").append(precioEnvio);
        sb.append(", prioridad=").append(prioridad);
        sb.append(", numeroReferencia=").append(numeroReferencia);
        sb.append(", dniPersona=").append(dniPersona);
        sb.append(", peso=").append(peso);
        sb.append(", sucursal=").append(sucursal);
        sb.append('}');
        return sb.toString();
    }

    
    
}
