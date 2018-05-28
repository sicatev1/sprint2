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
import modelo.Paquete;
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
public class ControlaPaqueteTest {

    public ControlaPaqueteTest() {
    }


    @Test
    public void testValidarConsultaPaquete() throws Exception {
        System.out.println("consultarPaquete");
        ControlaPaquete instance = new ControlaPaquete();
        List<Paquete> result = instance.consultarPaquete();
        boolean hayPaquetes = result.isEmpty();
        assertEquals(false, hayPaquetes);
    }



}