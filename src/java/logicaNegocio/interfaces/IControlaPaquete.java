/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio.interfaces;

import dto.EstadoPaqueteDTO;
import dto.PaquetesDTO;
import java.util.List;
import javax.ejb.Local;
import modelo.Paquete;

@Local
public interface IControlaPaquete {

    public List<Paquete> consultarPaquete();

    public boolean guardarPaquete(Paquete paquete);
    public List<PaquetesDTO> consultarPaqueteDTO();
    public EstadoPaqueteDTO consultaEstadoPaquete(String numGuia);
}
