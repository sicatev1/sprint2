/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio.interfaces;

import java.util.List;
import javax.ejb.Local;
import modelo.Usuario;

@Local
public interface IControlaUsuario {

    public List<Usuario> consultarUsuario();

    public boolean guardarUsuario(Usuario usuario);
}
