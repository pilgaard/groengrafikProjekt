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
import model.KundeType;
import model.PostNummer;

/**
 *
 * @author Emil
 */
public abstract class KundeHandler {

    public static Kunde hentKundeVedTlfNr(String telefon) throws SQLException {
        String SQL = "select * from kunde join kundetype on kunde.KundeTypeid = KundeType.id join postnr on kunde.postNr = postnr.postNr where tlfNr = '"+telefon+"';";
        ResultSet rs = DatabaseHandler.getInstance().select(SQL);
        Kunde kunde = null;
        if (rs.next()) {
            PostNummer postNr = new PostNummer(rs.getInt("postNr"), rs.getString("byNavn"));
            KundeType kundeType = new KundeType(rs.getInt("id"), rs.getString("titel"), rs.getInt("rabat"),  rs.getString("betalingsBetingelser"));
            kunde = new Kunde(rs.getInt("id"), rs.getString("forNavn"), rs.getString("efterNavn"), rs.getString("adresse"), rs.getString("tlfNr"), rs.getString("email"), postNr, kundeType);

        }
        return kunde;
    }
    
    public static ArrayList<Kunde> hentAlleKunder(PostNummer postnummer, KundeType kundetype) throws SQLException {
        ArrayList<Kunde> kundelist = new ArrayList<>();
        String SQL = "select * from kunde join kundetype on kunde.KundeTypeid = KundeType.id join postnr on kunde.postNr = postnr.postNr; ";
        ResultSet rs = DatabaseHandler.getInstance().select(SQL);
        Kunde kunde = null;
        while (rs.next()) {
            kunde = new Kunde(rs.getInt("id"), rs.getString("forNavn"), rs.getString("efterNavn"), rs.getString("adresse"), rs.getString("tlfNr"), rs.getString("email"), postnummer, kundetype);
            kundelist.add(kunde);
        }
        return kundelist;
    }

}
