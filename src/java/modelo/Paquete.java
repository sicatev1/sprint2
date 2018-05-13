/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;

public class Paquete implements Serializable {

    private String guia;
    private Date fecha_entrega;
    private Date fecha_ingreso;
    private String estado;
    private Integer remitente;
    private Integer destinatario;
    private Integer bodega;

    public Paquete() {    

}

    public Paquete(String guia, Date fecha_entrega, Date fecha_ingreso, String estado, Integer remitente, Integer destinatario, Integer bodega) {
        this.guia = guia;
        this.fecha_entrega = fecha_entrega;
        this.fecha_ingreso = fecha_ingreso;
        this.estado = estado;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.bodega = bodega;
    }

    
    public Integer getBodega() {
        return bodega;
    }

    public void setBodega(Integer bodega) {
        this.bodega = bodega;
    }

    public Integer getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Integer destinatario) {
        this.destinatario = destinatario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public Integer getRemitente() {
        return remitente;
    }

    public void setRemitente(Integer remitente) {
        this.remitente = remitente;
    }
    
    
    
    
}
