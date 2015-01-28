/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.KundeType;

/**
 *
 * @author Emil
 */
public class KundeTypeHandler {
    
    
    
    public static ArrayList<KundeType> hentkundetyper() throws SQLException {
        ArrayList<KundeType> ktlist = new ArrayList<>();
        String SQL = "select * from kundetype;";
        ResultSet rs = DatabaseHandler.getInstance().select(SQL);
        KundeType kundetype = null;
        while (rs.next()) {
            //KundeType(int id, int rabat, String titel, String betalingsbetingelser) 
            kundetype = new KundeType(rs.getInt("id"), rs.getString ("titel"), rs.getInt("rabat"), rs.getString("betalingsBetingelse")) ;
            ktlist.add(kundetype);
        }
        return ktlist;
    }
}
