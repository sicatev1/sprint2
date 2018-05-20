
package utilidades;


public class ConstantesApp {
    
    public enum EstadosTrazabilidad{
        
        INGRESADO("Ingresado","1"),
        EN_BODEGA("En bodega","2"),
        DESPACHADO("Despachado","3"),
        ENTREGADO("Entregado al destinatario","4");
        
        private String nombre;
        private String codigo;

        private EstadosTrazabilidad(String nombre, String codigo) {
            this.nombre = nombre;
            this.codigo = codigo;
        }

        public static EstadosTrazabilidad obtenerPorCodigo(String codigo){
            
            for(EstadosTrazabilidad estado :EstadosTrazabilidad.values()){
                if(estado.getCodigo().equals(codigo)){
                    return estado;
                }
            }
            return null;
        }
        
        public String getNombre() {
            return nombre;
        }

        public String getCodigo() {
            return codigo;
        }
    }
}
