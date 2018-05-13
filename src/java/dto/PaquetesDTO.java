/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Erick Pulido
 */
public class PaquetesDTO {
    
    private Integer codPaquete;
    private String guia;
    private String fecha_entrega;
    private String fecha_ingreso;
    
    private Integer codigoRe;
    private String nombreRe;
    private Integer identificacionRe;
    private String direccionRe;
    private String telefonoRe;
    private String ciudadRe;
    
    private Integer codigoDe;
    private String nombreDe;
    private Integer identificacionDe;
    private String direccionDe;
    private String telefonoDe;
    private String ciudadDe;
    private String coordenadaDe;

    public PaquetesDTO() {
    }

    public PaquetesDTO(String guia, String fecha_entrega, String fecha_ingreso, Integer codigoRe, String nombreRe, Integer identificacionRe, String direccionRe, String telefonoRe, String ciudadRe, Integer codigoDe, String nombreDe, Integer identificacionDe, String direccionDe, String telefonoDe, String ciudadDe, String coordenadaDe) {
        this.guia = guia;
        this.fecha_entrega = fecha_entrega;
        this.fecha_ingreso = fecha_ingreso;
        this.codigoRe = codigoRe;
        this.nombreRe = nombreRe;
        this.identificacionRe = identificacionRe;
        this.direccionRe = direccionRe;
        this.telefonoRe = telefonoRe;
        this.ciudadRe = ciudadRe;
        this.codigoDe = codigoDe;
        this.nombreDe = nombreDe;
        this.identificacionDe = identificacionDe;
        this.direccionDe = direccionDe;
        this.telefonoDe = telefonoDe;
        this.ciudadDe = ciudadDe;
        this.coordenadaDe = coordenadaDe;
    }

    public Integer getCodPaquete() {
        return codPaquete;
    }

    public void setCodPaquete(Integer codPaquete) {
        this.codPaquete = codPaquete;
    }

   
    
    public String getCiudadDe() {
        return ciudadDe;
    }

    public void setCiudadDe(String ciudadDe) {
        this.ciudadDe = ciudadDe;
    }

    public String getCiudadRe() {
        return ciudadRe;
    }

    public void setCiudadRe(String ciudadRe) {
        this.ciudadRe = ciudadRe;
    }

    public Integer getCodigoDe() {
        return codigoDe;
    }

    public void setCodigoDe(Integer codigoDe) {
        this.codigoDe = codigoDe;
    }

    public Integer getCodigoRe() {
        return codigoRe;
    }

    public void setCodigoRe(Integer codigoRe) {
        this.codigoRe = codigoRe;
    }

    public String getCoordenadaDe() {
        return coordenadaDe;
    }

    public void setCoordenadaDe(String coordenadaDe) {
        this.coordenadaDe = coordenadaDe;
    }


    public String getDireccionDe() {
        return direccionDe;
    }

    public void setDireccionDe(String direccionDe) {
        this.direccionDe = direccionDe;
    }

    public String getDireccionRe() {
        return direccionRe;
    }

    public void setDireccionRe(String direccionRe) {
        this.direccionRe = direccionRe;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingrso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public Integer getIdentificacionDe() {
        return identificacionDe;
    }

    public void setIdentificacionDe(Integer identificacionDe) {
        this.identificacionDe = identificacionDe;
    }

    public Integer getIdentificacionRe() {
        return identificacionRe;
    }

    public void setIdentificacionRe(Integer identificacionRe) {
        this.identificacionRe = identificacionRe;
    }

    public String getNombreDe() {
        return nombreDe;
    }

    public void setNombreDe(String nombreDe) {
        this.nombreDe = nombreDe;
    }

    public String getNombreRe() {
        return nombreRe;
    }

    public void setNombreRe(String nombreRe) {
        this.nombreRe = nombreRe;
    }

    public String getTelefonoDe() {
        return telefonoDe;
    }

    public void setTelefonoDe(String telefonoDe) {
        this.telefonoDe = telefonoDe;
    }

    public String getTelefonoRe() {
        return telefonoRe;
    }

    public void setTelefonoRe(String telefonoRe) {
        this.telefonoRe = telefonoRe;
    }
    
    
    
}
