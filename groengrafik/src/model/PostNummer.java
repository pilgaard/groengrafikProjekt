/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Holds Zipcode and name of the city.
 *
 * @author Jeppe
 */
public class PostNummer {

    private int postNummer;
    private String bynavn;

    public PostNummer(int postNummer, String bynavn) {
        this.postNummer = postNummer;
        this.bynavn = bynavn;
    }

    public int getPostNummer(){
        return postNummer;
    }

    public String getBynavn(){
        return bynavn;
    }

    @Override
    public String toString() {
        return postNummer + " " + bynavn;
    }
}
