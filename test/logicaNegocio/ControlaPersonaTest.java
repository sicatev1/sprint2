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
import modelo.Destinatario;
import modelo.Paquete;
import modelo.Remitente;
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
public class ControlaPersonaTest {

    public ControlaPersonaTest() {
    }


    @Test
    public void testValidarConsultaRemitente() throws Exception {
        System.out.println("consultarRemitente");
        ControlaPersona instance = new ControlaPersona();
        List<Remitente> result = instance.consultarRemitente("");
        boolean hayRemitentes = result.isEmpty();
        assertEquals(false, hayRemitentes);
    }

    @Test
    public void testValidarConsultaDestinatario() throws Exception {
        System.out.println("consultarDestinatario");
        ControlaPersona instance = new ControlaPersona();
        List<Destinatario> result = instance.consultarDestinatario("");
        boolean hayDestinatarios = result.isEmpty();
        assertEquals(false, hayDestinatarios);
    }
    

}