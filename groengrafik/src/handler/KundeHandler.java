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
        String SQL = "select * from Costumer join CostumerType on Costumer.costumerTypeId = CostumerType.id join ZipCode on costumer.ZipCodezip = ZipCode.zip where phoneNumber = '"+telefon+"';";
        ResultSet rs = DatabaseHandler.getInstance().select(SQL);
        Kunde kunde = null;
        if (rs.next()) {
            PostNummer postNr = new PostNummer(rs.getInt("zip"), rs.getString("district"));
            KundeType kundeType = new KundeType(rs.getInt("id"), rs.getString("statustitle"), rs.getInt("discount"),  rs.getString("paymentCondition"));
            kunde = new Kunde(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("adress"), rs.getString("phoneNumber"), postNr, kundeType);

        }
        return kunde;
    }
    
    public static ArrayList<Kunde> hentAlleKunder(PostNummer postnummer, KundeType kundetype) throws SQLException {
        ArrayList<Kunde> kundelist = new ArrayList<>();
        String SQL = "select * from costumer join costumertype on costumer.costumerTypeid = CostumerType.id join ZipCode on costumer.zipCodezip = ZipCode.zip; ";
        ResultSet rs = DatabaseHandler.getInstance().select(SQL);
        Kunde kunde = null;
        while (rs.next()) {
            kunde = new Kunde(rs.getInt("id"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("adress"), rs.getString("phoneNumber"), postnummer, kundetype);
            kundelist.add(kunde);
        }
        return kundelist;
    }

}
