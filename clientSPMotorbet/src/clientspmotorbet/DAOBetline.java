/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientspmotorbet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paolo
 */
public class DAOBetline {
    
    //questo
    public boolean salva(String id, String cf, BetLine betline ){
        try{
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s&pmotorbet?" + "user=root&password=123456");     
            PreparedStatement pst2 = conn.prepareStatement("INSERT INTO betline (id, nomepilota, cognomepilota, campionato, gara, posizione, quota, cf) VALUES ('"+id+"','"+betline.getNomepilota()+"','"+betline.getCognomepilota()+"','"+betline.getCampionato()+"','"+betline.getGara()+"','"+betline.getPosizione()+"','"+betline.getQuota()+"','"+cf+"')");
            pst2.execute();
            conn.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    //

    public List<BetLine> caricaListaBetline(String id){
        List<BetLine> listaBetline = new ArrayList<BetLine>();
        BetLine betline;
        int  i;
        try{
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s&pmotorbet?" + "user=root&password=123456");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nomepilota,cognomepilota,campionato,gara,posizione,quota FROM betline WHERE id='"+ id +"' ");
            i = 0;
            while(rs.next()){          
                listaBetline.add( i, betline = new BetLine());
                listaBetline.get(i).setNomepilota(rs.getString("nomepilota"));
                listaBetline.get(i).setCognomepilota(rs.getString("cognomepilota"));
                listaBetline.get(i).setCampionato(rs.getString("campionato"));
                listaBetline.get(i).setGara(rs.getString("gara"));
                listaBetline.get(i).setPosizione(rs.getInt("posizione"));
                listaBetline.get(i).setQuota(rs.getFloat("quota"));
                
                i++;
            }
            
            rs.close();
            conn.close();
        }catch(Exception e){   
        }
        return listaBetline;
    }
    
}
