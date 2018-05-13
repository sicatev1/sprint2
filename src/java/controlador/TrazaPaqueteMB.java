/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.PaquetePorBodegaDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import logicaNegocio.interfaces.IControlaPaquete;
import logicaNegocio.interfaces.IControlaPersona;
import modelo.Paquete;
import modelo.Persona;

/**
 *
 * @author cristian
 */
@ManagedBean
@ViewScoped
public class TrazaPaqueteMB {
    
    private List<Paquete> listPaquetesPorBodega;
    private Paquete paqueteSelected;
    private Persona destinatario;
    private List<PaquetePorBodegaDTO> listPaquetePorBodegaDTO;
    
    private String codigoBodega;
    
    @EJB
    private IControlaPaquete controlaPaqueteInterface;
    
    @EJB
    private IControlaPersona controlaPersonaInterface;

    @PostConstruct
    public void inicilizarPagina(){
        listPaquetesPorBodega = new ArrayList<>();
        listPaquetePorBodegaDTO = new ArrayList<>();
    }
    
    public void consultarPaquetesPorBodega(){
        
        List<Paquete> listPaqueteTemp = controlaPaqueteInterface.consultarPaquete();
        if(listPaqueteTemp != null && !listPaqueteTemp.isEmpty()){
            listPaquetesPorBodega = new ArrayList<>();
            for (Paquete paquete : listPaqueteTemp) {
                //Filtra por el paquete seleccionado
//                if(paquete.getBodega().equalsIgnoreCase(codigoBodega)){
//                    
//                    PaquetePorBodegaDTO paquetePorBodegaDTO = new PaquetePorBodegaDTO();
//                    paquetePorBodegaDTO.setNumeroBodega(codigoBodega);
//                    
//                    Persona persona = controlaPersonaInterface.consultarDestinatario(" where iddestinatario = "+paquete.getDestinatario()).get(0);
//                    
//                    paquetePorBodegaDTO.setNombreCliente(persona.getNombre());
//                    listPaquetesPorBodega.add(paquete);
//                }
            }
        }
        else{
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, 
                    "No se encontraron paquetes asociados a la bodega", "");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public String getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(String codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public List<Paquete> getListPaquetesPorBodega() {
        return listPaquetesPorBodega;
    }

    public void setListPaquetesPorBodega(List<Paquete> listPaquetesPorBodega) {
        this.listPaquetesPorBodega = listPaquetesPorBodega;
    }

    public Paquete getPaqueteSelected() {
        return paqueteSelected;
    }

    public void setPaqueteSelected(Paquete paqueteSelected) {
        this.paqueteSelected = paqueteSelected;
    }

    public List<PaquetePorBodegaDTO> getListPaquetePorBodegaDTO() {
        return listPaquetePorBodegaDTO;
    }

    public void setListPaquetePorBodegaDTO(List<PaquetePorBodegaDTO> listPaquetePorBodegaDTO) {
        this.listPaquetePorBodegaDTO = listPaquetePorBodegaDTO;
    }
    
    
    
    
    
    
    
    
    
}
