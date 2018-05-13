/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio.interfaces;

import java.util.List;
import modelo.ResponsePaquete;

/**
 *
 * @author cristian
 */
public interface IResponsePaqueteLogic {
     public List<ResponsePaquete> getPaqueteByBodega(int idBodega);
}
