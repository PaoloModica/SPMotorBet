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
public class DAOCliente {
    public boolean ClienteEsistente;
    public boolean salva(Cliente cliente, DateFormat format2){
        try{
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s&pmotorbet?" + "user=root&password=123456");     
            PreparedStatement pst = conn.prepareStatement("INSERT INTO clienti (nome, cognome, cf, data_di_nascita, indirizzo, telefono, username, password) VALUES ('"+cliente.getNome()+"','"+cliente.getCognome()+"','"+cliente.getCodicefiscale()+"','"+format2.format(cliente.getData_di_nascita())+"','"+cliente.getIndirizzo()+"','"+cliente.getTelefono()+"','"+cliente.getUsername()+"','"+cliente.getPassword().toString()+"')");
            pst.execute();
            conn.close();
            return true;
            }catch(Exception e){
                return false;
            }
    }
    
    public List<Cliente> caricaLista(){
        List<Cliente> listaClienti = new ArrayList<Cliente>();
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Cliente cliente;
        int  i;
        try{
            Class.forName("com.mysql.jdbc.Driver");  // MySQL database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s&pmotorbet?" + "user=root&password=123456");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clienti INNER JOIN conti WHERE clienti.cf = conti.cf");
            i = 0;
            while(rs.next()){          
                listaClienti.add( i,cliente = new Cliente());
                listaClienti.get(i).setNome(rs.getString("clienti.nome"));
                listaClienti.get(i).setCognome(rs.getString("clienti.cognome"));
                listaClienti.get(i).setCodicefiscale(rs.getString("clienti.cf"));
                listaClienti.get(i).setData_di_nascita(format.parse(rs.getString("clienti.data_di_nascita")));
                listaClienti.get(i).setIndirizzo(rs.getString("clienti.indirizzo"));
                listaClienti.get(i).setTelefono(rs.getString("clienti.telefono"));
                listaClienti.get(i).setUsername(rs.getString("clienti.username"));
                listaClienti.get(i).setPassword(rs.getString("clienti.password"));
                listaClienti.get(i).setContoPersonale();
                listaClienti.get(i).getContoPersonale().setCf(rs.getString("conti.cf"));
                listaClienti.get(i).getContoPersonale().setSaldo(Float.parseFloat(rs.getString("conti.saldo")));
                
                i++;
            }
            
            rs.close();
            conn.close();
        }catch(Exception e){   
        }
        return listaClienti;
    }
    
}
