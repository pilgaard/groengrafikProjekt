/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Kunde;

/**
 *
 * @author Emil
 */
public abstract class KundeHandler {

    public static Kunde hentKundeVedTlfNr(String telefon) throws SQLException {
        String SQL = "select * from kunde where tlfNr = '" + telefon + "'";
        ResultSet rs = DatabaseHandler.getInstance().select(SQL);
        Kunde kunde = null;
        if (rs.next()) {
            kunde = new Kunde(rs.getInt("id"), rs.getString("forNavn"), rs.getString("efterNavn"), rs.getString("adresse"), rs.getString("tlfNr"), rs.getString("email"));

        }
        return kunde;
    }
    
    public static ArrayList<Kunde> hentAlleKunder() throws SQLException {
        ArrayList<Kunde> kundelist = new ArrayList<>();
        String SQL = "select * from kunde";
        ResultSet rs = DatabaseHandler.getInstance().select(SQL);
        Kunde kunde = null;
        while (rs.next()) {
            kunde = new Kunde(rs.getInt("id"), rs.getString("forNavn"), rs.getString("efterNavn"), rs.getString("adresse"), rs.getString("tlfNr"), rs.getString("email"));
            kundelist.add(kunde);
        }
        return kundelist;
    }

}
