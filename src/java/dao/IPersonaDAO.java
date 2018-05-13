/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import modelo.Destinatario;
import modelo.Remitente;

public interface IPersonaDAO {

    public List<Remitente> consultarRemitenteDB(String where);

    public boolean guardarRemitenteDB(Remitente remitente);

    public List<Destinatario> consultarDestinatarioDB(String where);

    public boolean guardarDestinatarioDB(Destinatario destinatario);

}
