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
public class Status {
    
    private int id;
    private String statustilstand;

    public Status(int id, String statustilstand) {
        this.id = id;
        this.statustilstand = statustilstand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatustilstand() {
        return statustilstand;
    }

    public void setStatustilstand(String statustilstand) {
        this.statustilstand = statustilstand;
    }
    
    
}
