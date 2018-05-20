/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import conexion.ConexionSingleton;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author FamiliaHaderLubo
 */
public class consultas  {

    public boolean autentificacion(String usuario, String contraseña) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        Statement s = null;
        String resp;
        FacesMessage msg = null;
        try {
            String sql = "select * from usuarios where nombre =? and password = ?";
            pst = ConexionSingleton.getInstancia().getConexion().prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            rs = pst.executeQuery();

            if (rs.absolute(1)) {
                resp = "bodega.xhtml";
                return true;

            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error en el Login debe de registrarse", "credenciales no validadas");
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }

        } catch (Exception e) {
            System.err.println("error" + e);
        }

        return false;
    }

   
}
