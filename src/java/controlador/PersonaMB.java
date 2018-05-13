/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.PersonaDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Persona;
import dao.IPersonaDAO;
import java.util.ArrayList;
import javax.ejb.EJB;
import logicaNegocio.interfaces.IControlaPersona;

@ManagedBean
@RequestScoped
public class PersonaMB {

    @EJB
    private IControlaPersona controlaPersonaInterface;

    private Persona personaSelected;
    private List<Persona> lstPersona;

    public PersonaMB() {
        personaSelected = new Persona();
        lstPersona = new ArrayList<>();
    }

    public void guardarRemitente() {

//        boolean guardado = controlaPersonaInterface.guardarRemitente(personaSelected);
//        if (guardado) {
//
//            lstPersona = controlaPersonaInterface.consultarRemitente();
//            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Remitente Guardado", "");
//            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
//        }
    }

    public void guardarDestinatario() {

//        boolean guardado = controlaPersonaInterface.guardarDestinatario(personaSelected);
//        if (guardado) {
//
//            lstPersona = controlaPersonaInterface.consultarDestinatario(null);
//            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Destinatario Guardado", "");
//            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
//        }
    }

    public void limpiar() {
        personaSelected = new Persona();
    }

    public Persona getPersonaSelected() {
        return personaSelected;
    }

    public void setPersonaSelected(Persona personaSelected) {
        this.personaSelected = personaSelected;
    }

    public List<Persona> getLstPersona() {
        return lstPersona;
    }

    public void setLstPersona(List<Persona> lstPersona) {
        this.lstPersona = lstPersona;
    }
}
