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

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of consultarDestinatarios method, of class ControlaBodega.
     */
    @Test
    public void testValidarConsultaBodega() throws Exception {
        System.out.println("consultarBodegas");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        IControlaBodega instance = (IControlaBodega)container.getContext().lookup("java:global/classes/ControlaBodega!logicaNegocio.interfaces.IControlaBodega");

        ControlaBodega instance = new ControlaBodega();
        List<Bodega> expResult = null;
        List<Bodega> result = instance.consultarBodegas();
        assertEquals(1, result.size());
//        container.close();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    @Test
    public void testLimpiar() throws Exception {
        System.out.println("test saludo");
//         EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//         BodegaMB instance = (BodegaMB)container.getContext().lookup("java:global/classes/BodegaMB");

        BodegaMB instance = new BodegaMB();
//        String saludo = instance.saludar();
//        assertEquals("Bienvenido a SICATE", saludo);
//         container.close();
    }

}