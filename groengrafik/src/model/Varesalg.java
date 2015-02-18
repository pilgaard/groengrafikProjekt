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
public class Varesalg {
    
    private int id, antal;
    private Product product;

    public Varesalg(int id, int antal, Product product) {
        this.id = id;
        this.antal = antal;
        this.product = product;
    }

    public Varesalg(int antal, Product product) {
        this.antal = antal;
        this.product = product;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public Product getProduct() {
        return product;
    }
    
    
    @Override
    public String toString(){
        return antal + " " + product.getpName();
    }
}
