/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import dao.PersonaDAO;
import dao.IPersonaDAO;
import java.util.List;
import javax.ejb.Stateless;
import logicaNegocio.interfaces.IControlaPersona;
import modelo.Destinatario;
import modelo.Persona;
import modelo.Remitente;

@Stateless
public class ControlaPersona implements IControlaPersona {

    private IPersonaDAO personaDAO = new PersonaDAO();

    public ControlaPersona() {
    }

    public List<Remitente> consultarRemitente(String where) {
        return personaDAO.consultarRemitenteDB(where);
    }

    public boolean guardarRemitente(Remitente remitente) {
        return personaDAO.guardarRemitenteDB(remitente);
    }

    public List<Destinatario> consultarDestinatario(String where) {
        return personaDAO.consultarDestinatarioDB(where);
    }

    public boolean guardarDestinatario(Destinatario destinatario) {
        return personaDAO.guardarDestinatarioDB(destinatario);
    }

}
