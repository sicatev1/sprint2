/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import dao.IResponsePaqueteDAO;
import dao.ResponsePaqueteDAO;
import java.util.List;
import logicaNegocio.interfaces.IResponsePaqueteLogic;
import modelo.ResponsePaquete;

/**
 *
 * @author JOLU
 */
public class ResponsePaqueteLogic implements IResponsePaqueteLogic {

    IResponsePaqueteDAO dao;

    public ResponsePaqueteLogic() {
        dao = new ResponsePaqueteDAO();
    }

    @Override
    public List<ResponsePaquete> getPaqueteByBodega(int idBodega) {

        return dao.getPaqueteByBodega(idBodega);

    }

}