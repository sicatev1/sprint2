package logicaNegocio;

import dao.BodegaDAO;
import dao.IBodegaDAO;
import java.util.List;
import javax.ejb.Stateless;
import logicaNegocio.interfaces.IControlaBodega;
import modelo.Bodega;

@Stateless
public class ControlaBodega implements IControlaBodega{

     private IBodegaDAO bodegaDAO = new BodegaDAO();
    
    public ControlaBodega() {
    }

    public List<Bodega> consultarBodegas(){
        return bodegaDAO.consultarTodos();
    }
    
    public boolean guardarBodega(Bodega bodega){
        return bodegaDAO.guardarBodega(bodega);
    }

    @Override
    public boolean editarBodega(Bodega bodega) {
       return bodegaDAO.editarBodega(bodega);
    }
}
