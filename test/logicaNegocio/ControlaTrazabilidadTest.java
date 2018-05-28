/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import controlador.BodegaMB;
import dto.PaquetePorBodegaDTO;
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
public class ControlaTrazabilidadTest {

    public ControlaTrazabilidadTest() {
    }


    @Test
    public void testValidarConsultaTrazabilidad() throws Exception {
        System.out.println("consultarTrazabilidad");
        ControlaTrazabilidad instance = new ControlaTrazabilidad();
        List<PaquetePorBodegaDTO> result = instance.consultarTrazabilidadPorBodega("1");
        boolean hayPaquetesTrazabilidad = result.isEmpty();
        assertEquals(false, hayPaquetesTrazabilidad);
    }



}