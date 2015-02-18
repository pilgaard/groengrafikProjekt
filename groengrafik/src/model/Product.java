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
public class Product {
private int id, amount, minamount, productionTime;
private String pName, description;

    public Product(int id, String pName, String description, int amount, int minamount, int productionTime) {
        this.id = id;
        this.amount = amount;
        this.minamount = minamount;
        this.productionTime = productionTime;
        this.pName = pName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMinamount() {
        return minamount;
    }

    public void setMinamount(int minamount) {
        this.minamount = minamount;
    }

    public int getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(int productionTime) {
        this.productionTime = productionTime;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString(){
        return ""+pName;
    }


}
