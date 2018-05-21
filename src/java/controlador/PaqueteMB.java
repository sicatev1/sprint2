/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.PaquetesDTO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import modelo.Paquete;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import logicaNegocio.interfaces.IControlaBodega;
import logicaNegocio.interfaces.IControlaPaquete;
import logicaNegocio.interfaces.IControlaPersona;
import modelo.Bodega;
import modelo.Destinatario;
import modelo.Remitente;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import utilidades.UtilFecha;

@ManagedBean(name = "paqueteMB")
@RequestScoped
public class PaqueteMB {

    @EJB
    private IControlaPaquete controlaPaqueteInterface;
    @EJB
    private IControlaPersona controlaPersonaInterface;
    @EJB
    private IControlaBodega controlaBodega;
    private UtilFecha utilFecha;
    private PaquetesDTO paqueteSelected;
    private Remitente remitente;
    private Destinatario destinatario;
    private Paquete paquete;
    private Bodega bodega;
    private List<Paquete> lstPaquete;
    private List<Remitente> lstRemitente;
    private List<Destinatario> lstDestinatario;
    private List<PaquetesDTO> lstPaqueteDTO;
    //Datos remitente
    private Integer codigoRem;
    private String nombreRem;
    private Integer identificacionRem;
    private String direccionRem;
    private String telefonoRem;
    private String ciudadRem;
    //Datos destinatario
    private Integer codigoDes;
    private String nombreDes;
    private Integer identificacionDes;
    private String direccionDes;
    private String telefonoDes;
    private String ciudadDes;
    private String coordenadas;
    //Datos paquete
    private String guia;
    private Date fecha_entrega;
    private String cod_paquete;
    
    private List<SelectItem> comboBodegas;
    private int bodegaSelected;
    private MapModel geoModel;
    private String centerGeoMap = "3.4516, -76.5320";
    

    @PostConstruct
    public void init() {
       // FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        paqueteSelected = new PaquetesDTO();
        lstPaqueteDTO = new ArrayList<>();
        comboBodegas = utilidades.UtilCombos.getComboBodega(controlaBodega);
        utilFecha = new UtilFecha();
        geoModel = new DefaultMapModel();
        consultarPaquetes();
    }

    public PaqueteMB() {
    }

    public void guardarPaquete() {

        try {

            remitente = new Remitente(codigoRem, nombreRem, identificacionRem, direccionRem, telefonoRem, ciudadRem);
            destinatario = new Destinatario(codigoDes, nombreDes, identificacionDes, "3.4654885, -76.5007286", telefonoDes, ciudadDes, "312323213");

            boolean guardoRem = controlaPersonaInterface.guardarRemitente(remitente);
            boolean guardoDes = controlaPersonaInterface.guardarDestinatario(destinatario);

            lstRemitente = controlaPersonaInterface.consultarRemitente(" WHERE IDENTIFICACION= " + identificacionRem);
            lstDestinatario = controlaPersonaInterface.consultarDestinatario(" WHERE IDENTIFICACION= " + identificacionDes);


            if (guardoRem && guardoDes) {
                String fechaActual = utilFecha.obtenerFechaActualString();
                paquete = new Paquete(guia, fecha_entrega, Calendar.getInstance().getTime(), "1", null, null, Integer.parseInt(""+bodegaSelected));

                for (Remitente remitente : lstRemitente) {
                    paquete.setRemitente(remitente.getCodigo());
                }
                for (Destinatario destinatario : lstDestinatario) {
                    paquete.setDestinatario(destinatario.getCodigo());
                }

                controlaPaqueteInterface.guardarPaquete(paquete);
                
                limpiar();
                //lstPaquete = controlaPaqueteInterface.consultarPaquete();
                
                //DESPUES DE ESTE PROCESO SE DEBE DE GUARDAR EN LA TABLA TRAZABILIDAD
                
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Paquete Guardado", "");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            }


        } catch (Exception e) {

            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Ocurrio un error: ", ""+e);
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }

    }
    
    
    public void seleccionPaquete(){
    
    codigoRem=paqueteSelected.getCodigoRe();
    nombreRem=paqueteSelected.getNombreDe();
    identificacionRem=paqueteSelected.getIdentificacionRe();
    direccionRem=paqueteSelected.getDireccionRe();
    telefonoRem=paqueteSelected.getTelefonoRe();
    ciudadRem=paqueteSelected.getCiudadDe();
    //Datos destinatario
    codigoDes=paqueteSelected.getCodigoDe();
    nombreDes=paqueteSelected.getNombreDe();
    identificacionDes=paqueteSelected.getIdentificacionDe();
    direccionDes=paqueteSelected.getDireccionDe();
    telefonoDes=paqueteSelected.getTelefonoDe();
    ciudadDes=paqueteSelected.getCiudadDe();
    coordenadas=paqueteSelected.getCoordenadaDe();
    //Datos paquete
    cod_paquete=paqueteSelected.getCodPaquete().toString();
    guia=paqueteSelected.getGuia();
//    fecha_entrega=  paqueteSelected.getFecha_entrega();
    
    }
    
    
    public void limpiar(){
    
    codigoRem=null;
    nombreRem=null;
    identificacionRem=null;
    direccionRem=null;
    telefonoRem=null;
    ciudadRem=null;
    //Datos destinatario
    codigoDes=null;
    nombreDes=null;
    identificacionDes=null;
    direccionDes=null;
    telefonoDes=null;
    ciudadDes=null;
    coordenadas=null;
    //Datos paquete
    cod_paquete=null;
    guia=null;
    fecha_entrega=null;
    
    lstPaqueteDTO = new ArrayList<>();
    paqueteSelected = new PaquetesDTO();
    
    }

    public void consultarPaquetes() {

//        PaquetesDTO paquetesDTO= new PaquetesDTO("1", "1234", "123455", "121313", 1, "pedrito", 12455, "dsdsad", "2312321", "cali", 1, "Juanito", 123456, "dasdasd", "323213", "cali", "dsdsd");
//        lstPaqueteDTO.add(paquetesDTO);
        
        if(lstPaqueteDTO.isEmpty()){
        lstPaqueteDTO = controlaPaqueteInterface.consultarPaqueteDTO();
        }
        
        
    }
    
    public void onGeocode(GeocodeEvent  event) {
        List<GeocodeResult> results = event.getResults();
         
        if (results != null && !results.isEmpty()) {
            LatLng center = results.get(0).getLatLng();
            centerGeoMap = center.getLat() + "," + center.getLng();
            coordenadas= center.getLat() + "," + center.getLng();
            for (int i = 0; i < results.size(); i++) {
                GeocodeResult result = results.get(i);
                geoModel.addOverlay(new Marker(result.getLatLng(), result.getAddress()));
            }
        }
    }
    
    

    public String getCiudadDes() {
        return ciudadDes;
    }

    public void setCiudadDes(String ciudadDes) {
        this.ciudadDes = ciudadDes;
    }

    public String getCiudadRem() {
        return ciudadRem;
    }

    public void setCiudadRem(String ciudadRem) {
        this.ciudadRem = ciudadRem;
    }

    public Integer getCodigoDes() {
        return codigoDes;
    }

    public void setCodigoDes(Integer codigoDes) {
        this.codigoDes = codigoDes;
    }

    public Integer getCodigoRem() {
        return codigoRem;
    }

    public void setCodigoRem(Integer codigoRem) {
        this.codigoRem = codigoRem;
    }

    public String getDireccionDes() {
        return direccionDes;
    }

    public void setDireccionDes(String direccionDes) {
        this.direccionDes = direccionDes;
    }

    public String getDireccionRem() {
        return direccionRem;
    }

    public void setDireccionRem(String direccionRem) {
        this.direccionRem = direccionRem;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getGuia() {
        return guia;
    }

    public void setGuia(String guia) {
        this.guia = guia;
    }

    public Integer getIdentificacionDes() {
        return identificacionDes;
    }

    public void setIdentificacionDes(Integer identificacionDes) {
        this.identificacionDes = identificacionDes;
    }

    public Integer getIdentificacionRem() {
        return identificacionRem;
    }

    public void setIdentificacionRem(Integer identificacionRem) {
        this.identificacionRem = identificacionRem;
    }

    public List<Paquete> getLstPaquete() {
        return lstPaquete;
    }

    public void setLstPaquete(List<Paquete> lstPaquete) {
        this.lstPaquete = lstPaquete;
    }

    public List<PaquetesDTO> getLstPaqueteDTO() {
        return lstPaqueteDTO;
    }

    public void setLstPaqueteDTO(List<PaquetesDTO> lstPaqueteDTO) {
        this.lstPaqueteDTO = lstPaqueteDTO;
    }

    public String getNombreDes() {
        return nombreDes;
    }

    public void setNombreDes(String nombreDes) {
        this.nombreDes = nombreDes;
    }

    public String getNombreRem() {
        return nombreRem;
    }

    public void setNombreRem(String nombreRem) {
        this.nombreRem = nombreRem;
    }

    public PaquetesDTO getPaqueteSelected() {
        return paqueteSelected;
    }

    public void setPaqueteSelected(PaquetesDTO paqueteSelected) {
        this.paqueteSelected = paqueteSelected;
    }

    public String getTelefonoDes() {
        return telefonoDes;
    }

    public void setTelefonoDes(String telefonoDes) {
        this.telefonoDes = telefonoDes;
    }

    public String getTelefonoRem() {
        return telefonoRem;
    }

    public void setTelefonoRem(String telefonoRem) {
        this.telefonoRem = telefonoRem;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public Destinatario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Destinatario destinatario) {
        this.destinatario = destinatario;
    }

    public Remitente getRemitente() {
        return remitente;
    }

    public void setRemitente(Remitente remitente) {
        this.remitente = remitente;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

  

    public String getCod_paquete() {
        return cod_paquete;
    }

    public void setCod_paquete(String cod_paquete) {
        this.cod_paquete = cod_paquete;
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

    public String getCenterGeoMap() {
        return centerGeoMap;
    }

    public void setCenterGeoMap(String centerGeoMap) {
        this.centerGeoMap = centerGeoMap;
    }

    public MapModel getGeoModel() {
        return geoModel;
    }

    public void setGeoModel(MapModel geoModel) {
        this.geoModel = geoModel;
    }
    
    
    
    
    
}
