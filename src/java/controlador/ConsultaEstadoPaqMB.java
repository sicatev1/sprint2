/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Paquete;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@ViewScoped
public class ConsultaEstadoPaqMB {

    private Paquete paqueteSelected;
    private String numGuia;

    @PostConstruct
    public void init() {
        paqueteSelected = new Paquete();
    }
    
    public void buscarEstadoPaquete(){
        System.out.println("Entro a buscar estado del paquete");
    }

    public Paquete getPaqueteSelected() {
        return paqueteSelected;
    }

    public void setPaqueteSelected(Paquete paqueteSelected) {
        this.paqueteSelected = paqueteSelected;
    }

    public String getNumGuia() {
        return numGuia;
    }

    public void setNumGuia(String numGuia) {
        this.numGuia = numGuia;
    }

}
