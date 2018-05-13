/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import dao.UsuarioDAO;
import dao.IUsuarioDAO;
import java.util.List;
import javax.ejb.Stateless;
import logicaNegocio.interfaces.IControlaUsuario;
import modelo.Usuario;

@Stateless
public class ControlaUsuario implements IControlaUsuario {

    private IUsuarioDAO usuarioDAO = new UsuarioDAO();

    public ControlaUsuario() {
    }

    public List<Usuario> consultarUsuario() {
        return usuarioDAO.consultarUsuarioDB();
    }

    public boolean guardarUsuario(Usuario usuario) {
        return usuarioDAO.guardarUsuarioDB(usuario);
    }
}
