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

    public Ordre(int id, String oprettelsesdato, String leveringsdato) {
        this.id = id;
        this.oprettelsesdato = oprettelsesdato;
        this.leveringsdato = leveringsdato;
        varesalgsListe = new ArrayList<>();
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
