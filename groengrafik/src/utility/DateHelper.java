/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Jeppe
 */
public class DateHelper {
    
    /**
     * Jeppe skal skældes ud hvis det ikke virker..
     * Giver dig datoer som string til de næste 14 dage
     * @return 
     */
    public static String[] next14Days(){
        Calendar cal = Calendar.getInstance();
        
        String[] dates = new String[14];
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        for (int i = 0; i < dates.length; i++) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
           dates[i] = sdf.format(cal.getTime());            
        }
        return dates;
    }
}
