/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.PaquetesDTO;
import java.util.List;
import modelo.Paquete;

public interface IPaqueteDAO {

    public List<Paquete> consultarPaqueteDB();
    public List<PaquetesDTO> consultarPaqueteDTO();
    public boolean guardarPaqueteDB(Paquete paquete);
}
