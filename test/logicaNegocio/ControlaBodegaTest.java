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
public class ControlaBodegaTest {

    public ControlaBodegaTest() {
    }

    /**
     * Test of consultarDestinatarios method, of class ControlaBodega.
     */
    @Test
    public void testValidarConsultaBodega() throws Exception {
        System.out.println("consultarBodegas");
        ControlaBodega instance = new ControlaBodega();
        List<Bodega> result = instance.consultarBodegas();
        boolean hayBodegas = result.isEmpty();
        assertEquals(false, hayBodegas);
    }



}