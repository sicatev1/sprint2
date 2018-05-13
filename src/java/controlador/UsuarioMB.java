/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuarioDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Usuario;
import dao.IUsuarioDAO;
import java.util.ArrayList;
import javax.ejb.EJB;
import logicaNegocio.interfaces.IControlaUsuario;

@ManagedBean
@RequestScoped
public class UsuarioMB {

    @EJB
    private IControlaUsuario controlaUsuarioInterface;

    private Usuario usuarioSelected;
    private List<Usuario> lstUsuario;

    public UsuarioMB() {
        usuarioSelected = new Usuario();
        lstUsuario = new ArrayList<>();
    }

    public void guardarUsuario() {

        boolean guardado = controlaUsuarioInterface.guardarUsuario(usuarioSelected);
        if (guardado) {

            lstUsuario = controlaUsuarioInterface.consultarUsuario();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Guardada", "");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }

    public void limpiar() {
        usuarioSelected = new Usuario();
    }

    public Usuario getUsuarioSelected() {
        return usuarioSelected;
    }

    public void setUsuarioSelected(Usuario usuarioSelected) {
        this.usuarioSelected = usuarioSelected;
    }

    public List<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(List<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }
}
