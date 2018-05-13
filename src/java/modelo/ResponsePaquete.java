/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author JOLU
 */
public class ResponsePaquete {

    private String coordenada;
    private String nombre_destinatario;
    private String direccion_paquete;
    private String telefono;

    public String getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    public String getNombre_destinatario() {
        return nombre_destinatario;
    }

    public void setNombre_destinatario(String nombre_destinatario) {
        this.nombre_destinatario = nombre_destinatario;
    }

    public String getDireccion_paquete() {
        return direccion_paquete;
    }

    public void setDireccion_paquete(String direccion_paquete) {
        this.direccion_paquete = direccion_paquete;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}