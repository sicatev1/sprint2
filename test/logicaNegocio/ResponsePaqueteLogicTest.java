/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import java.util.List;
import modelo.ResponsePaquete;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author desarrollador
 */
public class ResponsePaqueteLogicTest {

    public ResponsePaqueteLogicTest() {
    }
    
     @Test
    public void testValidarConsultaPaqueteLogic() throws Exception {
        System.out.println("consultarPaquetePorBodega");
        ResponsePaqueteLogic instance = new ResponsePaqueteLogic();
        List<ResponsePaquete> result = instance.getPaqueteByBodega(1);
        boolean hayDatos = result.isEmpty();
        assertEquals(false, hayDatos);
    }
    
}
