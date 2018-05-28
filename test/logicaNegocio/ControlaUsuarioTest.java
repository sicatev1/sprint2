/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import controlador.BodegaMB;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import logicaNegocio.interfaces.IControlaBodega;
import modelo.Bodega;
import modelo.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cristian gomez ruiz
 */
public class ControlaUsuarioTest {

    public ControlaUsuarioTest() {
    }


    @Test
    public void testValidarConsultaUsuario() throws Exception {
        System.out.println("consultarUsuarios");
        ControlaUsuario instance = new ControlaUsuario();
        List<Usuario> result = instance.consultarUsuario();
        boolean hayUsuarios = result.isEmpty();
        assertEquals(false, hayUsuarios);
    }



}