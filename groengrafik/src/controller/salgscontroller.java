/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.ArrayList;
import java.util.Calendar;
import model.Kunde;
import model.Ordre;
import model.Varesalg;

/**
 *
 * @author Maja
 */
public class salgscontroller {
 
    public void OpretOrdre (ArrayList<Varesalg> varesalgsListe, Kunde kunde) {
       Ordre ordre = new Ordre(Calendar.getInstance()+"",Calendar.getInstance()+"",varesalgsListe,kunde);        
    }
    
    
}
