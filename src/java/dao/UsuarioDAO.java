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

import modelo.Usuario;

public class UsuarioDAO implements IUsuarioDAO {

    public UsuarioDAO() {
    }

    public List<Usuario> consultarUsuarioDB() {

        List<Usuario> lstUsuario = new ArrayList();

        ResultSet rs = null;
        Statement s = null;
        String sql = "select nombre,apellido,cedula,password,rol_id,estado_id from \"USUARIO\"";
        try {

            System.out.println("consultando todos las bodegas : consultarTodos()");

            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);
            String nombre = "";
            String apellido = "";
            String cedula = "";
            String password = "";
            String rol_id = "";
            String estado_id = "";

            while (rs.next()) {

                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                cedula = rs.getString("cedula");
                password = rs.getString("password");
                rol_id = rs.getString("rol_id");
                estado_id = rs.getString("estado_id");

                System.out.println("Se recupero el registro con el nombre " + nombre);

                Usuario usuario = new Usuario(nombre,apellido,cedula,password,rol_id,estado_id);
                lstUsuario.add(usuario);

            }

        } catch (SQLException ex) {

            System.err.println("Error al consultar Usuario");
            ex.printStackTrace();
            lstUsuario = new ArrayList();

        } finally {
            try {
                s.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return lstUsuario;
    }

    public boolean guardarUsuarioDB(Usuario usuario) {

        String insert = "insert into \"USUARIO\" (nombre,apellido,cedula,password,rol_id,estado_id) values(?,?,?,?,?,?)";

        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            ConexionSingleton.getInstancia().getConexion().setAutoCommit(false);

            ps = ConexionSingleton.getInstancia().getConexion().prepareStatement(insert);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCedula());
            ps.setString(1, usuario.getPassword());
            ps.setString(2, usuario.getRol());
            ps.setString(3, usuario.getEstado());

            ps.executeUpdate();
            ConexionSingleton.getInstancia().getConexion().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

}
