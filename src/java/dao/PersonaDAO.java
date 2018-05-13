/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.ConexionSingleton;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import modelo.Destinatario;
import modelo.Persona;
import modelo.Remitente;

public class PersonaDAO implements IPersonaDAO {

    public PersonaDAO() {
    }

    public List<Remitente> consultarRemitenteDB(String where) {
        
        List<Remitente> lstRemitente = new ArrayList();
        
        ResultSet rs = null;
        Statement s = null;
        String sql = "select codigo, nombre,identificacion,direccion,telefono,ciudad from REMITENTES"+where;
        try {
            
            System.out.println("consultando todos los remitentes : consultarTodosRemitente()");
            
            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);
            Integer codigo;
            String nombre = "";
            Integer identificacion;
            String ciudad = "";
            String telefono = "";
            String direccion = "";
            
            while (rs.next()) {
                codigo = rs.getInt("codigo");
                nombre = rs.getString("nombre");
                identificacion = rs.getInt("identificacion");
                ciudad = rs.getString("ciudad");
                telefono = rs.getString("telefono");
                direccion = rs.getString("direccion");
             
                
                System.out.println("Se recupero el registro con el nombre " + nombre);
                
                Remitente remitente = new Remitente(codigo, nombre, identificacion, direccion, telefono, ciudad);
                lstRemitente.add(remitente);
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println("Error al consultar Remitente");
            ex.printStackTrace();
            lstRemitente = new ArrayList();
            
        } finally {
            try {
                s.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return lstRemitente;
    }
    
    public boolean guardarRemitenteDB(Remitente remitente) {
        
        String insert = "insert into REMITENTE (codigo,nombre,identificacion,direccion,telefono,ciudad) values(?,?,?,?,?,?)";
        
        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            ConexionSingleton.getInstancia().getConexion().setAutoCommit(false);
            
            ps = ConexionSingleton.getInstancia().getConexion().prepareStatement(insert);
            ps.setInt(1, remitente.getCodigo());
            ps.setString(2, remitente.getNombre());
            ps.setInt(3, remitente.getIdentificacion());
            ps.setString(4, remitente.getDireccion());
            ps.setString(5, remitente.getTelefono());
            ps.setString(6, remitente.getCiudad());
            
            ps.executeUpdate();
            ConexionSingleton.getInstancia().getConexion().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    
    public List<Persona> consultarRemitenteDB() {

        List<Persona> lstPersona = new ArrayList();

        ResultSet rs = null;
        Statement s = null;
        String sql = "select nombre,identificacion,direccion,coordenadas,telefono,nacional_id from \"REMITENTES\"";
        try {

            System.out.println("consultando todos los remitentes : consultarTodosRemitente()");

            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);
            String nombre = "";
            String identificacion = "";
            String coordenadas = "";
            String ciudad = "";
            String telefono = "";
            String direccion = "";

            while (rs.next()) {

                nombre = rs.getString("nombre");
                identificacion = rs.getString("identificacion");
                ciudad = rs.getString("nacional_id");
                telefono = rs.getString("telefono");
                direccion = rs.getString("direccion");
                coordenadas = rs.getString("coordenadas");

                System.out.println("Se recupero el registro con el nombre " + nombre);

                Persona persona = new Persona(nombre, identificacion, direccion, coordenadas, telefono, ciudad);
                lstPersona.add(persona);

            }

        } catch (SQLException ex) {

            System.err.println("Error al consultar Remitente");
            ex.printStackTrace();
            lstPersona = new ArrayList();

        } finally {
            try {
                s.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstPersona;
    }

    public boolean guardarRemitenteDB(Persona persona) {

        String insert = "insert into \"REMITENTE\" (nombre,identificacion,direccion,coordenadas,telefono,nacional_id) values(?,?,?,?,?,?)";

        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            ConexionSingleton.getInstancia().getConexion().setAutoCommit(false);

            ps = ConexionSingleton.getInstancia().getConexion().prepareStatement(insert);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getIdentificacion());
            ps.setString(3, persona.getDireccion());
            ps.setString(4, persona.getCoordenadas());
            ps.setString(5, persona.getTelefono());
            ps.setString(6, persona.getCiudad());

            ps.executeUpdate();
            ConexionSingleton.getInstancia().getConexion().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
     public List<Destinatario> consultarDestinatarioDB(String sqlWhere) {
        
        List<Destinatario> lstDestinatario = new ArrayList();
        
        ResultSet rs = null;
        Statement s = null;
        String sql = "select codigo,nombre,identificacion,direccion,coordenadas,telefono,ciudad from DESTINATARIO";
        
        if(sqlWhere != null && !sqlWhere.isEmpty()){
            sql = sql+sqlWhere;
        }
        try {
            
            System.out.println("consultando destinatarios : consultarTodosDestinatario()");
            
            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);
            
            Integer codigo;
            String nombre = "";
            Integer identificacion;
            String coordenadas = "";
            String ciudad = "";
            String telefono = "";
            String direccion = "";
            
            while (rs.next()) {
                codigo= rs.getInt("codigo");
                nombre = rs.getString("nombre");
                identificacion = rs.getInt("identificacion");
                ciudad = rs.getString("ciudad");
                telefono = rs.getString("telefono");
                direccion = rs.getString("direccion");
                coordenadas = rs.getString("coordenadas");
                
                System.out.println("Se recupero el registro con el nombre " + nombre);
                
                Destinatario destinatario = new Destinatario(codigo, nombre, identificacion, direccion, telefono, ciudad, coordenadas);
                lstDestinatario.add(destinatario);
                
            }
            
        } catch (SQLException ex) {
            
            System.err.println("Error al consultar Destinatario");
            ex.printStackTrace();
            lstDestinatario = new ArrayList();
            
        } finally {
            try {
                s.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return lstDestinatario;
    }
    
   
    @Override
    public boolean guardarDestinatarioDB(Destinatario destinatario) {
        
        String insert = "insert into DESTINATARIO (nombre,identificacion,direccion,coordenadas,telefono,ciudad) values(?,?,?,?,?,?)";
        
        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            ConexionSingleton.getInstancia().getConexion().setAutoCommit(false);
            
            ps = ConexionSingleton.getInstancia().getConexion().prepareStatement(insert);
            ps.setString(1, destinatario.getNombre());
            ps.setInt(2, destinatario.getIdentificacion());
            ps.setString(3, destinatario.getDireccion());
            ps.setString(4, destinatario.getCoordenada());
            ps.setString(5, destinatario.getTelefono());
            ps.setString(6, destinatario.getCiudad());
            
            ps.executeUpdate();
            ConexionSingleton.getInstancia().getConexion().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }


}
