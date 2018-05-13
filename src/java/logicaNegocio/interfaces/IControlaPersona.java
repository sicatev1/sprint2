/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio.interfaces;

import java.util.List;
import javax.ejb.Local;
import modelo.Persona;
import modelo.Destinatario;
import modelo.Remitente;

@Local
public interface IControlaPersona {

public List<Remitente> consultarRemitente(String where);

    public boolean guardarRemitente(Remitente remitente);

    public List<Destinatario> consultarDestinatario(String where);

    public boolean guardarDestinatario(Destinatario destinatario);

}
