/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import dao.ITrazaPaqueteDAO;
import dao.TrazaPaqueteDAO;
import dto.PaquetePorBodegaDTO;
import java.util.List;
import javax.ejb.Stateless;
import logicaNegocio.interfaces.IControlaTrazabilidad;

/**
 *
 * @author cristian
 */
@Stateless
public class ControlaTrazabilidad implements IControlaTrazabilidad{
    
    private ITrazaPaqueteDAO trazaPaqueteDAO = new TrazaPaqueteDAO();
    
    public List<PaquetePorBodegaDTO> consultarTrazabilidadPorBodega(String idBodega){
        return trazaPaqueteDAO.consultarTrazabilidadPorBodega(idBodega);
    }
}
