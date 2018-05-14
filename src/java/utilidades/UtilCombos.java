package utilidades;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

import logicaNegocio.interfaces.IControlaBodega;
import modelo.Bodega;

/**
 *
 * @author JOLU
 */
public class UtilCombos {

    public static List<SelectItem> getComboBodega(IControlaBodega control) {
        List<Bodega> listaBodegas = control.consultarBodegas();
        List<SelectItem> resultado = new ArrayList<>();
        for (Bodega objeto : listaBodegas) {
            SelectItem temp = new SelectItem(objeto.getCodigo(), objeto.getNombre());
            resultado.add(temp);

        }
        return resultado;

    }

}