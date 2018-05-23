/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.ConexionSingleton;
import dto.EstadoPaqueteDTO;
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
import utilidades.ConstantesApp;
import utilidades.ConstantesApp.EstadosTrazabilidad;

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
            String estado = "";
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
            ps.setDate(2, new java.sql.Date(paquete.getFecha_entrega().getDate(), paquete.getFecha_entrega().getMonth(), paquete.getFecha_entrega().getYear()));
            ps.setDate(3, new java.sql.Date(paquete.getFecha_ingreso().getDate(), paquete.getFecha_ingreso().getMonth(), paquete.getFecha_ingreso().getYear()));
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

    public List<PaquetesDTO> consultarPaqueteDTO() {

        List<PaquetesDTO> lstPaquete = new ArrayList();

        ResultSet rs = null;
        Statement s = null;
        String sql = "SELECT P.IDPAQUETE,P.GUIA,P.FECHA_ENTREGA, P.FECHA_INGRESO, \n"
                + "R.idremitente,R.nombre as nombrere, R.identificacion as identificacionre, R.direccion as direccionre, R.telefono as telefonore, R.ciudad as ciudadre, \n"
                + "D.iddestinatario, D.nombre as nombrede, D.identificacion as identificacionde, D.direccion as direccionde, D.coordenadas, D.telefono as telefonode, D.ciudad as ciudadde\n"
                + "FROM PAQUETES P INNER JOIN REMITENTES R ON P.REMITENTE=R.IDREMITENTE INNER JOIN DESTINATARIOS D \n"
                + "ON P.DESTINATARIO=D.IDDESTINATARIO";

        /*String sql = "SELECT P.IDPAQUETE,P.GUIA,P.FECHA_ENTREGA, P.FECHA_INGRESO, \n"
                + "R.idremitente,R.nombre as nombrere, R.identificacion as identificacionre, R.direccion as direccionre, R.telefono as telefonore, R.ciudad as ciudadre, \n"
                + "D.iddestinatario, D.nombre as nombrede, D.identificacion as identificacionde, D.direccion as direccionde, D.coordenadas, D.telefono as telefonode, D.ciudad as ciudadde\n"
                + "FROM PAQUETES P, REMITENTES R, DESTINATARIOS D \n"
                + "WHERE P.REMITENTE=R.IDREMITENTE  AND P.DESTINATARIO=D.IDDESTINATARIO";*/
        try {

            System.out.println("consultando todos los paquetes : consultarPaqueteDTODB()");

            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);

            String codPaquete;
            String guia;
            String fecha_entrega;
            String fecha_ingreso;

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

                codPaquete = (rs.getInt("idpaquete")) + "";
                guia = rs.getString("guia");
                fecha_entrega = rs.getString("fecha_entrega");
                fecha_ingreso = rs.getString("fecha_ingreso");
                codigoRe = rs.getInt("idremitente");
                nombreRe = rs.getString("nombrere");
                identificacionRe = rs.getInt("identificacionre");
                direccionRe = rs.getString("direccionre");
                telefonoRe = rs.getString("telefonore");
                ciudadRe = rs.getString("ciudadre");

                codigoDe = rs.getInt("iddestinatario");
                nombreDe = rs.getString("nombrede");
                identificacionDe = rs.getInt("identificacionde");
                direccionDe = rs.getString("direccionde");
                telefonoDe = rs.getString("telefonode");
                ciudadDe = rs.getString("ciudadde");
                coordenadaDe = rs.getString("coordenadas");

                System.out.println("Se recupero el registro con la guia " + guia);

                PaquetesDTO paqueteDTO = new PaquetesDTO(guia, fecha_entrega, fecha_ingreso, codigoRe, nombreRe, identificacionRe, direccionRe, telefonoRe, ciudadRe, codigoDe, nombreDe, identificacionDe, direccionDe, telefonoDe, ciudadDe, coordenadaDe);
                paqueteDTO.setCodPaquete(Integer.parseInt(codPaquete));
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

    @Override
    public EstadoPaqueteDTO consultaEstadoPaquete(String numGuia) {

        EstadoPaqueteDTO estadoPaqueteDTO = null;
        ResultSet rs = null;
        Statement s = null;
        String idPaquete = null;
        String sql = "select p.estado as estado, d.nombre as nombre, p.idpaquete as paquete, p.fecha_entrega as fechaentrega from paquetes p, destinatarios d "
                + " where p.destinatario = d.iddestinatario and p.guia = '" + numGuia + "'";
        try {

            System.out.println("consultando estado de los paquetes : consultaEstadoPaquete()");

            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);

            while (rs.next()) {

                estadoPaqueteDTO = new EstadoPaqueteDTO();
                EstadosTrazabilidad estado = ConstantesApp.EstadosTrazabilidad.obtenerPorCodigo(rs.getString("estado"));
                estadoPaqueteDTO.setEstadoActual(estado.getNombre());
                estadoPaqueteDTO.setNombreCliente(rs.getString("nombre"));
                estadoPaqueteDTO.setFechaEntrega(rs.getDate("fechaentrega"));
                estadoPaqueteDTO.setNumeroGuia(numGuia);

                idPaquete = rs.getString("paquete");
            }

            s.clearBatch();

            if (idPaquete != null) {
                sql = "SELECT fecha FROM trazabilidad WHERE paquete = " + idPaquete + " and estado = " + EstadosTrazabilidad.INGRESADO.getCodigo();
                rs = s.executeQuery(sql);
                while (rs.next()) {
                    estadoPaqueteDTO.setFechaIngresoBodega(rs.getDate("fecha"));
                }
            }

        } catch (SQLException ex) {

            System.err.println("Error al consultar paqueteDTO");
            ex.printStackTrace();

        } finally {
            try {
                s.close();
//                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(PaqueteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return estadoPaqueteDTO;
        }
    }
}
