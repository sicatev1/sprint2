/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.ResponsePaquete;

/**
 *
 * @author JOLU
 */
public interface IResponsePaqueteDAO {
    
    public List<ResponsePaquete> getPaqueteByBodega(int idBodega);
    
}