/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.ConexionSingleton;
import dto.PaquetesDTO;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Paquete;

public class PaqueteDAO implements IPaqueteDAO {

    public PaqueteDAO() {
    }

    public List<Paquete> consultarPaqueteDB() {

        List<Paquete> lstPaquete = new ArrayList();

        ResultSet rs = null;
        Statement s = null;
        String sql = "select * from PAQUETES";
        try {

            System.out.println("consultando todos los paquetes : consultarPaqueteDB()");

            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);
            String guia = "";
            Date fecha_entrega;
            Date fecha_ingreso;
            String estado="";
            Integer remitente;
            Integer destinatario;
            Integer bodega;

            while (rs.next()) {

                guia = rs.getString("guia");
                fecha_entrega = rs.getDate("fecha_entrega");
                fecha_ingreso = rs.getDate("fecha_ingreso");
                estado = rs.getString("estado");
                remitente = rs.getInt("remitente");
                destinatario = rs.getInt("destinatario");
                bodega = rs.getInt("bodega");

                System.out.println("Se recupero el registro con la guia " + guia);

                Paquete paquete = new Paquete(guia, fecha_entrega, fecha_ingreso, estado, remitente, destinatario, bodega);
                lstPaquete.add(paquete);

            }

        } catch (SQLException ex) {

            System.err.println("Error al consultar paquete");
            ex.printStackTrace();
            lstPaquete = new ArrayList();

        } finally {
            try {
                s.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstPaquete;
    }

    public boolean guardarPaqueteDB(Paquete paquete) {

        String insert = "insert into PAQUETES (guia,fecha_entrega,fecha_ingreso,estado,remitente,destinatario,bodega) values(?,?,?,?,?,?,?)";

        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            ConexionSingleton.getInstancia().getConexion().setAutoCommit(false);

            ps = ConexionSingleton.getInstancia().getConexion().prepareStatement(insert);
            ps.setString(1, paquete.getGuia());
            ps.setDate(2, new java.sql.Date(paquete.getFecha_entrega().getDate(),paquete.getFecha_entrega().getMonth(),paquete.getFecha_entrega().getYear()));
            ps.setDate(3,  new java.sql.Date(paquete.getFecha_ingreso().getDate(),paquete.getFecha_ingreso().getMonth(),paquete.getFecha_ingreso().getYear()));
            ps.setString(4, paquete.getEstado());
            ps.setInt(5, paquete.getRemitente());
            ps.setInt(6, paquete.getDestinatario());
            ps.setInt(7, paquete.getBodega());

            ps.executeUpdate();
            ConexionSingleton.getInstancia().getConexion().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
//                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public List<PaquetesDTO> consultarPaqueteDTO() {

        List<PaquetesDTO> lstPaquete = new ArrayList();

        ResultSet rs = null;
        Statement s = null;
        String sql = "SELECT P.IDPAQUETE,P.GUIA,P.FECHA_ENTREGA, P.FECHA_INGRESO, R.*, D.* FROM PAQUETES P, REMITENTES R, DESTINATARIOS D WHERE P.REMITENTE=R.IDREMITENTE AND P.DESTINATARIO=D.IDDESTINATARIO";
        try {

            System.out.println("consultando todos los paquetes : consultarPaqueteDTODB()");

            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);

            String guia;
            String fecha_entrega;
            String fecha_salida;

            Integer codigoRe;
            String nombreRe;
            Integer identificacionRe;
            String direccionRe;
            String telefonoRe;
            String ciudadRe;

            Integer codigoDe;
            String nombreDe;
            Integer identificacionDe;
            String direccionDe;
            String telefonoDe;
            String ciudadDe;
            String coordenadaDe;

            while (rs.next()) {

                guia = rs.getString("guia");
                fecha_entrega = rs.getString("fecha_Entrega");
                fecha_salida = rs.getString("fecha_Salida");
                codigoRe= rs.getInt("idremitente");
                nombreRe= rs.getString("nombre");
                identificacionRe= rs.getInt("identificacion");
                direccionRe= rs.getString("direccion");
                telefonoRe= rs.getString("telefono");
                ciudadRe= rs.getString("ciudad");
                

                codigoDe= rs.getInt("iddestinatario");
                nombreDe= rs.getString("nombre");
                identificacionDe= rs.getInt("identificacion");
                direccionDe= rs.getString("direccion");
                telefonoDe= rs.getString("telefono");
                ciudadDe= rs.getString("ciudad");
                coordenadaDe= rs.getString("coordenadas");

                System.out.println("Se recupero el registro con la guia " + guia);

                PaquetesDTO paqueteDTO = new PaquetesDTO(guia, fecha_entrega, fecha_salida, codigoRe, nombreRe, identificacionRe, direccionRe, telefonoRe, ciudadRe, codigoDe, nombreDe, identificacionDe, direccionDe, telefonoDe, ciudadDe, coordenadaDe);
                lstPaquete.add(paqueteDTO);

            }

        } catch (SQLException ex) {

            System.err.println("Error al consultar paqueteDTO");
            ex.printStackTrace();
            lstPaquete = new ArrayList();

        } finally {
            try {
                s.close();
//                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


        return lstPaquete;
    }
}
