/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.ConexionSingleton;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.ResponsePaquete;

/**
 *
 * @author JOLU
 */
public class ResponsePaqueteDAO implements IResponsePaqueteDAO {

    @Override
    public List<ResponsePaquete> getPaqueteByBodega(int idBodega) {

        List<ResponsePaquete> resultado = new ArrayList<>();

        ResultSet rs = null;
        Statement s = null;
        String sql = "select destinatarios.coordenadas 'coordenada' , destinatarios.nombre 'nombre_destinatario' , "
                + "destinatarios.direccion 'direccion_paquete' , destinatarios.telefono from paquetes inner join bodegas on "
                + "paquetes.bodega = bodegas.idbodega inner join destinatarios on "
                + "destinatarios.iddestinatario = paquetes.destinatario where paquetes.estado = 1 "
                + "and bodegas.idbodega = " + idBodega + " ";
        try {

            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);
            while (rs.next()) {
                ResponsePaquete objeto = new ResponsePaquete();

                objeto.setCoordenada(rs.getString("coordenada"));
                objeto.setDireccion_paquete(rs.getString("direccion_paquete"));
                objeto.setNombre_destinatario(rs.getString("nombre_destinatario"));
                objeto.setTelefono(rs.getString("telefono"));
                resultado.add(objeto);

            }

        } catch (SQLException ex) {

            System.err.println("Error "+BodegaDAO.class.getName()+ " -> getPaqueteByBodega() ->" + ex.getMessage());

        } finally {
            try {
                s.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultado;
    }

}