/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.PaquetePorBodegaDTO;
import java.util.List;

/**
 *
 * @author cristian
 */
public interface ITrazaPaqueteDAO {
    public List<PaquetePorBodegaDTO> consultarTrazabilidadPorBodega(String idBodega);
}
