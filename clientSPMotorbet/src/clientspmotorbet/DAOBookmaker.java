/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientspmotorbet;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class DAOBookmaker {
    public List<String> caricaListaCampionati(){
        List<String> listaCampionati = new ArrayList<String>();
        //DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //Quotazione quota;
        int  i;
        try{
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmaker?" + "user=root&password=123456");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT denominazione FROM campionati");
            i = 0;
            while(rs.next()){          
                listaCampionati.add(i, rs.getString("denominazione"));            
                i++;
            }
            
            rs.close();
            conn.close();
        }catch(Exception e){   
        }
        return listaCampionati;
    }
    
    public List<String> caricaListaGare(String selCampionato){
        List<String> listaGare = new ArrayList<String>();
        
        int  i;
        try{
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmaker?" + "user=root&password=123456");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT gare.denominazione FROM gare WHERE gare.campionato='"+selCampionato+"'");
            i = 0;
            while(rs.next()){          
                listaGare.add(i, rs.getString("gare.denominazione"));           
                i++;
            }
            
            rs.close();
            conn.close();
        }catch(Exception e){   
        }
        return listaGare;
    }

    public List<String> caricaListaPiloti(String selCampionato, String selGara){
        List<String> listaPiloti = new ArrayList<String>();
        
        int  i;
        try{
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmaker?" + "user=root&password=123456");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT DISTINCT quote.nomepilota, quote.cognomepilota FROM quote WHERE quote.campionato='"+selCampionato+"' AND quote.gara='"+selGara+"'");
            i = 0;
            while(rs.next()){
                listaPiloti.add(i, (rs.getString("quote.nomepilota") + " " + rs.getString("quote.cognomepilota")));
                               
                i++;
            }
            
            rs.close();
            conn.close();
        }catch(Exception e){   
        }
        return listaPiloti;
    }
    
    public List<Quotazione> caricaListaQuote(String selCampionato, String selGara, String[] selPilota){
        List<Quotazione> listaQuote = new ArrayList<Quotazione>();
        //DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Quotazione quota;
        int  i;
        try{
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmaker?" + "user=root&password=123456");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT nomepilota AS Nome, cognomepilota AS Cognome, posizione, quota FROM quote WHERE quote.campionato='"+selCampionato+"' AND quote.gara='"+selGara+"' AND quote.nomepilota='"+selPilota[0]+"' AND quote.cognomepilota='"+selPilota[1]+"'");
            i = 0;
            while(rs.next()){          
                listaQuote.add(i, quota = new Quotazione());
                listaQuote.get(i).setCampionato(selCampionato);
                listaQuote.get(i).setGara(selGara);
                listaQuote.get(i).setNomePilota(rs.getString("Nome"));
                listaQuote.get(i).setCognomePilota(rs.getString("Cognome"));
                listaQuote.get(i).setPosizione(Integer.parseInt(rs.getString("posizione")));
                listaQuote.get(i).setQuota(Float.parseFloat(rs.getString("quota")));
                
                i++;
            }
            
            rs.close();
            conn.close();
        }catch(Exception e){   
        }
        return listaQuote;
    }    
}
