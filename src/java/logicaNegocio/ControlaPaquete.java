/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import dao.PaqueteDAO;
import dao.IPaqueteDAO;
import dto.EstadoPaqueteDTO;
import dto.PaquetesDTO;
import java.util.List;
import javax.ejb.Stateless;
import logicaNegocio.interfaces.IControlaPaquete;
import modelo.Paquete;

@Stateless
public class ControlaPaquete implements IControlaPaquete {

    private IPaqueteDAO paqueteDAO = new PaqueteDAO();

    public ControlaPaquete() {
    }

    public List<Paquete> consultarPaquete() {
        return paqueteDAO.consultarPaqueteDB();
    }

    public boolean guardarPaquete(Paquete paquete) {
        return paqueteDAO.guardarPaqueteDB(paquete);
    }
    
    @Override
    public List<PaquetesDTO> consultarPaqueteDTO() {
        return paqueteDAO.consultarPaqueteDTO();
    }
    
    @Override
    public EstadoPaqueteDTO consultaEstadoPaquete(String numGuia){
        return paqueteDAO.consultaEstadoPaquete(numGuia);
    }
    
}
