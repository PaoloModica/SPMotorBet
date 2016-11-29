/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmotorbet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;

/**
 *
 * @author paolo
 */
public class DAOConto {
    public boolean salva(Conto conto){
        try{
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s&pmotorbet?" + "user=root&password=123456");     
            PreparedStatement pst2 = conn.prepareStatement("INSERT INTO conti (cf, saldo) VALUES ('"+conto.getCf()+"','"+conto.getSaldo()+"')");
            pst2.execute();
            conn.close();
            return true;
            }catch(Exception e){
                return false;
            }
    }
    
    public boolean aggiorna(Conto conto){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s&pmotorbet?" + "user=root&password=123456");
            Statement stmt = conn.createStatement();
            stmt.execute("UPDATE conti SET saldo="+conto.getSaldo()+" WHERE cf= '"+conto.getCf()+"'");
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
