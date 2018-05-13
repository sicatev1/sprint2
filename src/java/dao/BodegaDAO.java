
package dao;

import conexion.ConexionSingleton;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import modelo.Bodega;


public class BodegaDAO implements IBodegaDAO{
    
//    @PersistenceUnit(unitName = "UnidadDePersistencia")
//    private EntityManager entityManager;

    public BodegaDAO() {
    }
    
  
    public List<Bodega> consultarTodos(){
        
        List<Bodega> lstBodegas = new ArrayList();

        ResultSet rs = null;
        Statement s = null;
        String sql = "select idbodega,nombre,telefono,direccion from BODEGAS";
        try {
          
            System.out.println("consultando todos las bodegas : consultarTodos()");
     
            s = ConexionSingleton.getInstancia().getConexion().createStatement();
            rs = s.executeQuery(sql);
            String codigo="";
            String nombre = "";  
            String telefono = "";
            String direccion = "";
            
            while (rs.next()) {
                
                codigo= String.valueOf(rs.getInt("idbodega")) ;
                nombre = rs.getString("nombre");
                telefono = rs.getString("telefono");
                direccion = rs.getString("direccion");
                
                System.out.println("Se recupero el registro con el nombre "+nombre);
                
                Bodega bodega = new Bodega(codigo,nombre, telefono, direccion);
                lstBodegas.add(bodega);
                
            }
            
        } catch (SQLException ex) {
         
            System.err.println("Error al consultar bodegas");
            ex.printStackTrace();
            lstBodegas = new ArrayList();
            
        } 
        finally {
            try {
                s.close();
                rs.close();
            } catch (Exception ex) {
                Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
        }
        
        return lstBodegas;
    }

   
   public boolean guardarBodega(Bodega bodega) {
       
        String insert = "INSERT INTO BODEGAS (nombre,direccion,telefono) VALUES(?,?,?)";
        
        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            ConexionSingleton.getInstancia().getConexion().setAutoCommit(false);

            ps = ConexionSingleton.getInstancia().getConexion().prepareStatement(insert);
            ps.setString(1, bodega.getNombre());
            ps.setString(2, bodega.getDireccion());
            ps.setString(3, bodega.getTelefono());

            ps.executeUpdate();
            ConexionSingleton.getInstancia().getConexion().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
//                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

//    @Override
//    public void eliminar(Bodega destinatario) {
//         String insert = "delete from \"DESTINOS\" where nombre = ?";
//        
//        PreparedStatement ps = null;
//        try {
//            ConexionSingleton.getInstancia().getConexion().setAutoCommit(false);
//
//            ps = ConexionSingleton.getInstancia().getConexion().prepareStatement(insert);
//            ps.setString(1, destinatario.getNombre());
//
//            ps.executeUpdate();
//            ConexionSingleton.getInstancia().getConexion().commit();
//        } catch (Exception ex) {
//            Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                ps.close();
//            } catch (Exception ex) {
//                Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }

    @Override
    public boolean editarBodega(Bodega bodega) {
           String update = "UPDATE BODEGAS SET nombre=?,direccion=?,telefono=? WHERE BODEGAS.idbodega="+ bodega.getCodigo();
        
        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            ConexionSingleton.getInstancia().getConexion().setAutoCommit(false);

            ps = ConexionSingleton.getInstancia().getConexion().prepareStatement(update);
            ps.setString(1, bodega.getNombre());
            ps.setString(2, bodega.getDireccion());
            ps.setString(3, bodega.getTelefono());

            ps.executeUpdate();
            ConexionSingleton.getInstancia().getConexion().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
//                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(BodegaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
    
    
}
