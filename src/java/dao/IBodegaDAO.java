/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Bodega;

/**
 *
 * @author cristian
 */
public interface IBodegaDAO {
// 
    public List<Bodega> consultarTodos();
    public boolean guardarBodega(Bodega bodega);
    public boolean editarBodega(Bodega bodega);
//    public void eliminar(Bodega destinatario);
}
