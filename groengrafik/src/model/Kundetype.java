/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.*;

/**
 *
 * @author Emil
 */
public class Kundetype {
    
    private int id, rabat;
    private String titel, betalingsbetingelser;

    public Kundetype(int id, int rabat, String titel, String betalingsbetingelser) {
        this.id = id;
        this.rabat = rabat;
        this.titel = titel;
        this.betalingsbetingelser = betalingsbetingelser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRabat() {
        return rabat;
    }

    public void setRabat(int rabat) {
        this.rabat = rabat;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getBetalingsbetingelser() {
        return betalingsbetingelser;
    }

    public void setBetalingsbetingelser(String betalingsbetingelser) {
        this.betalingsbetingelser = betalingsbetingelser;
    }
    
    
}
