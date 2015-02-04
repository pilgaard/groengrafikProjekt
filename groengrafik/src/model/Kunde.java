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
    private String fornavn, efternavn, adresse, tlfNr;
    private PostNummer postnummer;
    private KundeType kundetype;
    
    public Kunde(int id, String fornavn, String efternavn, String adresse, String tlfNr, PostNummer postnummer, KundeType kundetype) {
        this.id = id;
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.adresse = adresse;
        this.tlfNr = tlfNr;
        this.postnummer = postnummer;
        this.kundetype = kundetype;
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


    public PostNummer getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(PostNummer postnummer) {
        this.postnummer = postnummer;
    }

    public KundeType getKundetype() {
        return kundetype;
    }

    public void setKundetype(KundeType kundetype) {
        this.kundetype = kundetype;
    }
    
    
    
    @Override
    public String toString(){
        return fornavn+ " " + efternavn; 
    }
    
}
