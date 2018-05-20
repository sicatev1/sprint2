/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Usuario;
import utilidades.consultas;

/**
 *
 * @author cristian
 */
@ManagedBean
@SessionScoped
public class LoginMB {
    
    
    private Usuario usuarioSelected;

    @PostConstruct
    public void init(){
        usuarioSelected = new Usuario();
    }
    
    @PreDestroy
    public void destroy(){
        
    }
    
     public String validate() {

        FacesMessage msg = null;
        String resp = "";

        consultas conn = new consultas();

        if (conn.autentificacion(usuarioSelected.getNombre(), usuarioSelected.getPassword())) {
            resp = "home";

            return resp;
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en el Login debe de registrarse", "credenciales no validadas");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;

    }
    
     public String goNextPage() {
        return "usuario2";
    }

    public String goNextInicio() {
        return "inicio";
    }
    
    public Usuario getUsuarioSelected() {
        return usuarioSelected;
    }

    public void setUsuarioSelected(Usuario usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }
    
    
    
    
    
    
}
