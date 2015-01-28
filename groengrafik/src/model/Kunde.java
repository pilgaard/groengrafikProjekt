/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Emil
 */
public class Kunde {
    
    private int id;
    private String fornavn, efternavn, adresse, tlfNr, email;
    PostNummer postnummer;

    public Kunde(int id, String fornavn, String efternavn, String adresse, String tlfNr, String email) {
        this.id = id;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.adresse = adresse;
        this.tlfNr = tlfNr;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public void setTlfNr(String tlfNr) {
        this.tlfNr = tlfNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PostNummer getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(PostNummer postnummer) {
        this.postnummer = postnummer;
    }
    
    
    @Override
    public String toString(){
        return fornavn+ " " + efternavn; 
    }
    
}
