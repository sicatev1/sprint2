/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author cristian
 */
public class PaquetePorBodegaDTO {
    
    private String numeroBodega;
    private String nombreCliente;
    private String fechaIngreso;
    private String estadoPaquete;
    private String nombresTransportadores;

    public PaquetePorBodegaDTO() {
    }

    public PaquetePorBodegaDTO(String numeroBodega, String nombreCliente, String fechaIngreso, String estadoPaquete, String nombresTransportadores) {
        this.numeroBodega = numeroBodega;
        this.nombreCliente = nombreCliente;
        this.fechaIngreso = fechaIngreso;
        this.estadoPaquete = estadoPaquete;
        this.nombresTransportadores = nombresTransportadores;
    }

    public String getNumeroBodega() {
        return numeroBodega;
    }

    public void setNumeroBodega(String numeroBodega) {
        this.numeroBodega = numeroBodega;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstadoPaquete() {
        return estadoPaquete;
    }

    public void setEstadoPaquete(String estadoPaquete) {
        this.estadoPaquete = estadoPaquete;
    }

    public String getNombresTransportadores() {
        return nombresTransportadores;
    }

    public void setNombresTransportadores(String nombresTransportadores) {
        this.nombresTransportadores = nombresTransportadores;
    }
    
    
}
