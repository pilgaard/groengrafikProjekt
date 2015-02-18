/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Product;

/**
 *
 * @author Jeppe
 */
public abstract class ProductStockHandler {
        
    public static ArrayList<Product> getAllProducts() throws SQLException{
        ArrayList<Product> productList = new ArrayList<>();
        
        String sql = "SELECT * FROM ProductStock";
        
        ResultSet rs = DatabaseHandler.getInstance().select(sql);
        
        while(rs.next()){
            Product product = new Product(rs.getInt("id"), rs.getString("pName"), rs.getString("description"), rs.getInt("amount"), rs.getInt("minAmount"), rs.getInt("productionTime"));
            
            productList.add(product);
            
        }
        return productList;
        
    }
    
    public static Product getProduct(String name) throws SQLException{
        String sql = "SELECT * FROM ProductStock where ProductStock.pName = name";
        ResultSet rs = DatabaseHandler.getInstance().select(sql);
        Product product = null;
        
             while(rs.next()){
            product = new Product(rs.getInt("id"), rs.getString("pName"), rs.getString("description"), rs.getInt("amount"), rs.getInt("minAmount"), rs.getInt("productionTime"));
            
            
            
        }
             return product;
    }
}
