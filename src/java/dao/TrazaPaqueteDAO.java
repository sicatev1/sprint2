/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.ConexionSingleton;
import dto.PaquetePorBodegaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Paquete;
import utilidades.ConstantesApp;

/**
 *
 * @author cristian
 */
public class TrazaPaqueteDAO implements ITrazaPaqueteDAO{

    @Override
    public List<PaquetePorBodegaDTO> consultarTrazabilidadPorBodega(String idBodega) {
         
        List<PaquetePorBodegaDTO> lstTrazabilidad = new ArrayList();

        ResultSet rs = null;
        Statement s = null;
        String sql = "select b.idbodega as numbodega, d.nombre as destinatario, e.estado as estado, p.idpaquete from trazabilidad t, paquetes p, "
                + "bodegas b, destinatarios d, estados e where t.paquete = p.idpaquete and b.idbodega = p.bodega "
                + "and d.iddestinatario = p.destinatario and e.idestado = t.estado " +
                "and b.idbodega = "+idBodega;
        
          try {
            
            System.out.println("consultando trazabilidad -consultarTrazabilidadPorBodega ");
            
            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);
            
             while (rs.next()) {
                 PaquetePorBodegaDTO paquetePorBodegaDTO = new PaquetePorBodegaDTO();
                 paquetePorBodegaDTO.setNumeroBodega(rs.getString("numbodega"));
                 paquetePorBodegaDTO.setNombreCliente(rs.getString("destinatario"));
                 paquetePorBodegaDTO.setEstadoPaquete(rs.getString("estado"));
                 lstTrazabilidad.add(paquetePorBodegaDTO);
             }
             } catch (SQLException ex) {
            
            System.err.println("Error al consultar Destinatario");
            ex.printStackTrace();
            
        } finally {
            try {
//                s.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
          return lstTrazabilidad;
    }
    
    
}
