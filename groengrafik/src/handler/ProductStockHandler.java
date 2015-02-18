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
        
    public ArrayList<Product> getAllProducts() throws SQLException{
        ArrayList<Product> productList = new ArrayList<>();
        
        String sql = "SELECT * FROM ProductStock";
        
        ResultSet rs = DatabaseHandler.getInstance().select(sql);
        
        while(rs.next()){
            Product product = new Product(rs.getInt("id"), rs.getString("pName"), rs.getString("description"), rs.getInt("amount"), rs.getInt("minAmount"), rs.getInt("productTime"));
            
            productList.add(product);
            
        }
        return productList;
        
    }
}
