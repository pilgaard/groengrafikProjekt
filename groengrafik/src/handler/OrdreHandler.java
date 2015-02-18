/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Ordre;
import model.Varesalg;


/**
 *
 * @author chrisjustesen
 */
public class OrdreHandler {
    
    public static void OpretOrdre(Ordre ordre) throws SQLException {
        
        
        String sql = "insert into ProductRequest(deadline, creationDate, stateid, employeeid,customerid)"
                + "values('"+ordre.getLeveringsdato()+"','"+ordre.getOprettelsesdato()+"',1,1,"+ordre.getKunde().getId()+");";
        DatabaseHandler.getInstance().execute(sql);
        
    }
    
    public static void tilføjvaretilordre (int ordreid, Varesalg varesalg) throws SQLException{
        String sql = "insert into productrequestline(amount, Product.id,productrequestordernumber)"+
                "values ("+varesalg.getAntal()+","+varesalg.getProduct().getId()+","+ordreid+");";
        DatabaseHandler.getInstance().execute(sql);
        }
    }

