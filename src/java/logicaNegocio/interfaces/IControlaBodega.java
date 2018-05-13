/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio.interfaces;

import java.util.List;
import javax.ejb.Local;
import modelo.Bodega;

/**
 *
 * @author desarrollador
 */
@Local
public interface IControlaBodega {
    
     public List<Bodega> consultarBodegas();
     public boolean guardarBodega(Bodega bodega);
     public boolean editarBodega(Bodega bodega);
}
