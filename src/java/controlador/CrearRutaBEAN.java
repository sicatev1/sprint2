/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import logicaNegocio.ControlaBodega;
import logicaNegocio.ResponsePaqueteLogic;
import logicaNegocio.interfaces.IControlaBodega;
import logicaNegocio.interfaces.IResponsePaqueteLogic;
import modelo.ResponsePaquete;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author JOLU
 */
@ViewScoped
@ManagedBean
public class CrearRutaBEAN {

    private List<SelectItem> comboBodegas;
    private int bodegaSelected;
    private IControlaBodega controlBodega;
    private IResponsePaqueteLogic controlresponsePaquete;
    private List<ResponsePaquete> paquetes;
    private MapModel draggableModel;

//    LatLng coordInit;
    String coordInit;

    @PostConstruct
    public void init() {
        
        coordInit = "3.4516467, -76.5319854";
        bodegaSelected = 0;
        paquetes = new ArrayList<>();
        controlBodega = new ControlaBodega();
        controlresponsePaquete = new ResponsePaqueteLogic();
        comboBodegas = utilidades.UtilCombos.getComboBodega(controlBodega);
        draggableModel = new DefaultMapModel();
    }

    public void cargarPaquetes() {
        if (bodegaSelected != 0) {
            paquetes = controlresponsePaquete.getPaqueteByBodega(bodegaSelected);
            if (paquetes == null || paquetes.isEmpty()) {
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No hay paquetes para esta bodega", "");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            } else {
                cargarMapa();

            }
        } else {
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe seleccionar una bodega", "");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }

    }

    public void cargarMapa() {
        for (ResponsePaquete objeto : paquetes) {
            String[] latlng = objeto.getCoordenada().split(",");
            LatLng coord = new LatLng(Double.parseDouble(latlng[0]), Double.parseDouble(latlng[1]));
            
            draggableModel.addOverlay(new Marker(coord, objeto.getNombre_destinatario()));
        }
        for (Marker premarker : draggableModel.getMarkers()) {
            
            premarker.setDraggable(true);
        }
        editCoordenadaInit();
    }

    public void editCoordenadaInit() {

        coordInit = paquetes.get(0).getCoordenada() + "," + paquetes.get(paquetes.size() - 1).getCoordenada();
        

    }

    public List<SelectItem> getComboBodegas() {
        return comboBodegas;
    }

    public void setComboBodegas(List<SelectItem> comboBodegas) {
        this.comboBodegas = comboBodegas;
    }

    public int getBodegaSelected() {
        return bodegaSelected;
    }

    public void setBodegaSelected(int bodegaSelected) {
        this.bodegaSelected = bodegaSelected;
    }

    public IControlaBodega getControlBodega() {
        return controlBodega;
    }

    public void setControlBodega(IControlaBodega controlBodega) {
        this.controlBodega = controlBodega;
    }

    public IResponsePaqueteLogic getControlresponsePaquete() {
        return controlresponsePaquete;
    }

    public void setControlresponsePaquete(IResponsePaqueteLogic controlresponsePaquete) {
        this.controlresponsePaquete = controlresponsePaquete;
    }

    public List<ResponsePaquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<ResponsePaquete> paquetes) {
        this.paquetes = paquetes;
    }

    public MapModel getDraggableModel() {
        return draggableModel;
    }

    public void setDraggableModel(MapModel draggableModel) {
        this.draggableModel = draggableModel;
    }

    public String getCoordInit() {
        return coordInit;
    }

    public void setCoordInit(String coordInit) {
        this.coordInit = coordInit;
    }

}