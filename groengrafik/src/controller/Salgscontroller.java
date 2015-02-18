/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import handler.OrdreHandler;
import java.sql.SQLException;
import model.Kunde;
import model.Ordre;
import model.Product;
import model.Varesalg;
import utility.DateHelper;

/**
 *
 * @author Maja
 */

public class Salgscontroller {
    
   private  static Salgscontroller instance;
   private Ordre aktivOrdre;
 
 public static Salgscontroller getInstance(){
        if(instance== null){
            instance= new Salgscontroller();
        }  
        return instance;
}

 public void OpretNyOrdre () {
       aktivOrdre = new Ordre(DateHelper.next14Days()[0]);        
}
 
public void afslutOrdre(Kunde kunde, String leveringsDato) throws SQLException{
    aktivOrdre.setKunde(kunde);
    aktivOrdre.setLeveringsdato(leveringsDato);
    Ordre nyOrdre =  OrdreHandler.OpretOrdre(aktivOrdre);
    for (Varesalg varesalg : aktivOrdre.getVaresalgsListe()) {
        OrdreHandler.tilføjvaretilordre(nyOrdre.getId(), varesalg);
    }
}

public void tilføjVareTilOrdre(Product product, int antal){
    aktivOrdre.addVareTilOrdre(product, antal);
    System.out.println("Den er blevet tilføjet");
}

    public Ordre getAktivOrdre() {
        return aktivOrdre;
    }



}