/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Emil
 */
public class Ordre {
    
    private int id;
    private String oprettelsesdato, leveringsdato;
    private ArrayList<Varesalg> varesalgsListe; 
    private Kunde kunde;

    public Ordre(int id, String oprettelsesdato, String leveringsdato, Kunde kunde) {
        this.id = id;
        this.oprettelsesdato = oprettelsesdato;
        this.leveringsdato = leveringsdato;
        varesalgsListe = new ArrayList<>();
        this.kunde = kunde;
    }

    public Ordre(String oprettelsesdato ) {
        this.oprettelsesdato = oprettelsesdato;
    }
    
    public void addVareTilOrdre(Product product, int antal){
        varesalgsListe.add(new Varesalg(antal, product)); 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Varesalg> getVaresalgsListe() {
        return varesalgsListe;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }    

    public String getOprettelsesdato() {
        return oprettelsesdato;
    }

    public void setOprettelsesdato(String oprettelsesdato) {
        this.oprettelsesdato = oprettelsesdato;
    }

    public String getLeveringsdato() {
        return leveringsdato;
    }

    public void setLeveringsdato(String leveringsdato) {
        this.leveringsdato = leveringsdato;
    }
    
    @Override
    public String toString(){
        return id+ " " + oprettelsesdato + " "+ leveringsdato; 
    }
}
