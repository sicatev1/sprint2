/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.EstadoPaqueteDTO;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logicaNegocio.interfaces.IControlaPaquete;

/**
 *
 * @author desarrollador
 */
@ManagedBean
@ViewScoped
public class ConsultaEstadoPaqMB {

    private EstadoPaqueteDTO paqueteSelected;
    private String numGuia;

    @EJB
    private IControlaPaquete controlaPaqueteInterface;

    @PostConstruct
    public void init() {
        paqueteSelected = new EstadoPaqueteDTO();
    }

    public void buscarEstadoPaquete() {
        System.out.println("Entro a buscar estado del paquete");

        paqueteSelected = new EstadoPaqueteDTO();
        paqueteSelected = controlaPaqueteInterface.consultaEstadoPaquete(numGuia);
        if (paqueteSelected != null) {

            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Se encontro registro del paquete", "");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar un numero de guia valido", "");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }

    }
    
    public void limpiar(){
        paqueteSelected = new EstadoPaqueteDTO();
        numGuia = null;
    }

    public EstadoPaqueteDTO getPaqueteSelected() {
        return paqueteSelected;
    }

    public void setPaqueteSelected(EstadoPaqueteDTO paqueteSelected) {
        this.paqueteSelected = paqueteSelected;
    }

    public String getNumGuia() {
        return numGuia;
    }

    public void setNumGuia(String numGuia) {
        this.numGuia = numGuia;
    }

}
