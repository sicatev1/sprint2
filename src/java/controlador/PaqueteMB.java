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
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import logicaNegocio.interfaces.IControlaBodega;
import logicaNegocio.interfaces.IControlaPaquete;
import logicaNegocio.interfaces.IControlaPersona;
import modelo.Bodega;
import modelo.Destinatario;
import modelo.Remitente;
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
    private List<Bodega> lstBodega;
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
    private String fecha_entrega;
    private Integer cod_paquete;

    @PostConstruct
    public void init() {
        paqueteSelected = new PaquetesDTO();
        lstPaqueteDTO = new ArrayList<>();
        consultarPaquetes();
    }

    public PaqueteMB() {
    }

    public void guardarPaquete() {

        try {

            remitente = new Remitente(codigoRem, nombreRem, identificacionRem, direccionRem, telefonoRem, ciudadRem);
            destinatario = new Destinatario(codigoDes, nombreDes, identificacionDes, direccionDes, telefonoDes, ciudadDes, coordenadas);



            boolean guardoRem = controlaPersonaInterface.guardarRemitente(remitente);
            boolean guardoDes = controlaPersonaInterface.guardarDestinatario(destinatario);

            lstRemitente = controlaPersonaInterface.consultarRemitente("WHERE IDENTIFICACION= " + identificacionRem);
            lstDestinatario = controlaPersonaInterface.consultarDestinatario("WHERE IDENTIFICACION= " + identificacionDes);


            if (guardoRem && guardoDes) {
                String fechaActual = utilFecha.obtenerFechaActualString();
                paquete = new Paquete(guia, utilFecha.convertirStringaDate(fecha_entrega), utilFecha.convertirStringaDate(fechaActual), "1", null, null, Integer.parseInt(bodega.getCodigo()));

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
    cod_paquete=paqueteSelected.getCodPaquete();
    guia=paqueteSelected.getGuia();
    fecha_entrega=paqueteSelected.getFecha_entrega();
    
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

        if(lstPaqueteDTO.isEmpty()){
        lstPaqueteDTO = controlaPaqueteInterface.consultarPaqueteDTO();
        }
        
        
    }

    public void consultarBodegas() {

        lstBodega = controlaBodega.consultarBodegas();
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

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
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

    public List<Bodega> getLstBodega() {
        return lstBodega;
    }

    public void setLstBodega(List<Bodega> lstBodega) {
        this.lstBodega = lstBodega;
    }

    public Integer getCod_paquete() {
        return cod_paquete;
    }

    public void setCod_paquete(Integer cod_paquete) {
        this.cod_paquete = cod_paquete;
    }
    
    
    
}
