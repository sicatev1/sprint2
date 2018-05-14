/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author desarrollador
 */
public class UtilFecha {

    public String obtenerFechaActualString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        
        return dateFormat.format(date);
    }

    public Date convertirStringaDate(String fecha) throws ParseException {


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(fecha);
        
        return date;

    }
    
    public static void main(String[] args) {
        
        try {

//            Date fecha = new UtilFecha().convertirStringaDate("Sun May 06 00:00:00 COT 2018");
          
            Date fecha = new Date("Sun May 06 00:00:00 COT 2018");
            System.out.println("Fecha "+fecha);
        } catch (Exception e) {
            
            System.err.println("Error "+e.getMessage());
        }
        
    }
}
