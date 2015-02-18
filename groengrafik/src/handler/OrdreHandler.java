/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package handler;

import java.sql.SQLException;
import model.Ordre;


/**
 *
 * @author chrisjustesen
 */
public class OrdreHandler {
    
    public static void OpretOrdre(Ordre ordre) throws SQLException {
        Ordre NyOrdre = new Ordre(0, null, null);
        
        
        
        String sql = "insert into ProductRequest"
                + "values('"+NyOrdre.getId()+"','"
                + ""+NyOrdre.getLeveringsdato()+"','"
                + ""+NyOrdre.getOprettelsesdato()+"''";
        
        DatabaseHandler.getInstance().execute(sql);
    }
    
}
