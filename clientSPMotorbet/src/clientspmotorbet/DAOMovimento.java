/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientspmotorbet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;

/**
 *
 * @author paolo
 */
public class DAOMovimento {
        public boolean salva(String cf, Movimento movimento){
        try{
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s&pmotorbet?" + "user=root&password=123456");     
            PreparedStatement pst3 = conn.prepareStatement("INSERT INTO movimenti (cf, importo) VALUES ('"+cf+"','"+movimento.getImporto()+"')");
            pst3.execute();
            conn.close();
            return true;
            }catch(Exception e){
                return false;
            }
    }
    
}
