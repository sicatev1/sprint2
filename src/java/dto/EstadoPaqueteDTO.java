/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

/**
 *
 * @author desarrollador
 */
public class EstadoPaqueteDTO{
    
    private String numeroGuia;
    private String nombreCliente;
    private Date fechaIngresoBodega;
    private String estadoActual;
    private Date fechaAproxEntrega;
    private Date fechaEntrega;

    public EstadoPaqueteDTO() {
    }

    public EstadoPaqueteDTO(String numeroGuia, String nombreCliente, Date fechaIngresoBodega, String estadoActual, Date fechaAproxEntrega, Date fechaEntrega) {
        this.numeroGuia = numeroGuia;
        this.nombreCliente = nombreCliente;
        this.fechaIngresoBodega = fechaIngresoBodega;
        this.estadoActual = estadoActual;
        this.fechaAproxEntrega = fechaAproxEntrega;
        this.fechaEntrega = fechaEntrega;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFechaIngresoBodega() {
        return fechaIngresoBodega;
    }

    public void setFechaIngresoBodega(Date fechaIngresoBodega) {
        this.fechaIngresoBodega = fechaIngresoBodega;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

    public Date getFechaAproxEntrega() {
        return fechaAproxEntrega;
    }

    public void setFechaAproxEntrega(Date fechaAproxEntrega) {
        this.fechaAproxEntrega = fechaAproxEntrega;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }
    
    
    
}
