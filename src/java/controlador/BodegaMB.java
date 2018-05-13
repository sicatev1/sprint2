/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Bodega;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import logicaNegocio.interfaces.IControlaBodega;

/**
 *
 * @author cristian gomez ruiz
 */
@ManagedBean
@ViewScoped
public class BodegaMB {
    
    @EJB
    private IControlaBodega controlaBodegaInterface;
    
    private Bodega bodegaSelected=new Bodega();
    private List<Bodega> lstBodega=new ArrayList<>();
    
    
    
    @PostConstruct
    public void init() {
        
//        probar injeccion de dependencias
        lstBodega = controlaBodegaInterface.consultarBodegas();
        
    }
    

    public void guardarBodega(){
        
        if (bodegaSelected.getCodigo()==null) {

            boolean guardado = controlaBodegaInterface.guardarBodega(bodegaSelected);
            if (guardado) {

                lstBodega = controlaBodegaInterface.consultarBodegas();
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bodega Guardada", "");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
                limpiar();
            }
        }else{
        
            boolean editar = controlaBodegaInterface.editarBodega(bodegaSelected);
            if (editar) {

                lstBodega = controlaBodegaInterface.consultarBodegas();
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bodega Editada", "");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
                limpiar();
            }
        
        
        }
        
        
    }
    
    public void limpiar(){
        bodegaSelected = new Bodega();
    }
    
    public Bodega getBodegaSelected() {
        return bodegaSelected;
    }

    public void setBodegaSelected(Bodega bodegaSelected) {
        this.bodegaSelected = bodegaSelected;
    }

    public List<Bodega> getLstBodega() {
        return lstBodega;
    }

    public void setLstBodega(List<Bodega> lstBodega) {
        this.lstBodega = lstBodega;
    }
    
    
    
}
