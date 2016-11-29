/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmotorbet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author paolo
 */
public class SPMotorBet {
    private static SPMotorBet Singleton;   //GoF Singleton Pattern
    
    
    
    DAOCliente DaoCliente;
    Cliente cliente;
    private List<Cliente> clienti;
    Conto conto;
    Movimento movimento;
    boolean clienteEsistente = false;
    float saldo;
    int count = 0;
    
    private SPMotorBet(){
        this.clienti = new ArrayList<Cliente>();
        this.DaoCliente = new DAOCliente();
	this.clienti = this.DaoCliente.caricaLista();
    };
    
    public static SPMotorBet getInstance(){ //GoF Singleton Pattern
        if(Singleton == null){
            Singleton = new SPMotorBet();
        }
        return Singleton;
    }
        private String GeneraPassword(){
            String stringa = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
            Random rnd = new Random();
            StringBuilder sb = new StringBuilder( 8 );
            for( int i = 0; i < 8; i++ )
                sb.append( stringa.charAt( rnd.nextInt(stringa.length()) ) );
            return(sb.toString());
        }
        
        public Cliente getClienteCorrente(){
            return this.cliente;
        }
        
        public boolean getClienteEsistente(){
            return this.clienteEsistente;
        }
        
        public void setClienteEsistente(boolean r){
            this.clienteEsistente = r;
        }
        
        public int InsNuovoCliente(String nome, String cognome, String indirizzo, String cf, String tel, String data){
            this.setClienteEsistente(false);
            this.cliente = new Cliente();
            int i=0;
            
            try{
                clienti = this.DaoCliente.caricaLista();
                while(i<=(clienti.size()-1)){
                    
                    if(clienti.get(i).getCodicefiscale().equals(cf)){
                        this.setClienteEsistente(true);
                    }
                    
                    i++;
                }
                
                if(!this.getClienteEsistente()){
                    this.cliente.setNome(nome);
                    this.cliente.setCognome(cognome);
                    this.cliente.setIndirizzo(indirizzo);
                    this.cliente.setCodicefiscale(cf);
                    this.cliente.setTelefono(tel);        
                    DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
                    this.cliente.setData_di_nascita(format.parse(data));
                    this.cliente.setContoPersonale();
                    this.cliente.getContoPersonale().aggiungiMovimento(5.0f);
                    return 1;   //cliente non presente nella listaClienti, tutto OK
                }else{
                    this.cliente= null;
                    return 2;   //cliente già esistente e presente nella listaCLienti. Errore
                }
            }catch(ParseException ex){
                this.cliente= null;
                return 3;   //formato della Data di Nascita non corretto
            }
        }
        public boolean ConfermaIscrizione(String username, DateFormat format2){
            this.cliente.setUsername(username);
            this.cliente.setPassword(this.GeneraPassword());
            boolean res = this.cliente.salva(DaoCliente, format2);
            boolean res1 = this.cliente.getContoPersonale().salva();
            boolean res2 = this.cliente.getContoPersonale().getMovimentoCorrente().salva(this.cliente.getCodicefiscale());
            if(res && res1 && res2){
                this.clienti.add(cliente);
                return true;
            } else{
                return false;
            }
            
        }
        
        public float accredita(String CodFisc, float imp){
            saldo = 0;
            int i=0;
            this.setClienteEsistente(false);
            
            this.clienti = this.DaoCliente.caricaLista();

            while(i<=(clienti.size()-1)){
                    
                if(clienti.get(i).getCodicefiscale().equals(CodFisc)){
                    this.setClienteEsistente(true);
                    break;
                }
                i++;
            }
            
            if(this.getClienteEsistente()){
                this.clienti.get(i).getContoPersonale().aggiungiMovimento(imp);
                boolean res = this.clienti.get(i).getContoPersonale().aggiorna();
                boolean res1 = this.clienti.get(i).getContoPersonale().getMovimentoCorrente().salva(this.clienti.get(i).getCodicefiscale());
                
                if(res && res1){
                    saldo = this.clienti.get(i).getContoPersonale().getSaldo(); //Movimento registrato con successo, OK
                }else{
                    saldo=-1;   //Errore, Codice Fiscale e Cliente non presenti nella listaClienti
                }
            }else{
                saldo = -1;    //Errore, Codice Fiscale e Cliente non presenti nella listaClienti
            }
            return saldo;
        }
        
        public float preleva(String CodFisc, float imp){
            saldo = 0;
            int i=0;
            this.setClienteEsistente(false);
            
            this.clienti = this.DaoCliente.caricaLista();

            while(i<=(clienti.size()-1)){
                    
                if(clienti.get(i).getCodicefiscale().equals(CodFisc)){
                    this.setClienteEsistente(true);
                    break;
                }
                i++;
            }
            if(this.getClienteEsistente()){
                if(this.clienti.get(i).getContoPersonale().getSaldo()>=imp){
                    this.clienti.get(i).getContoPersonale().aggiungiMovimento(-imp);
                    boolean res = this.clienti.get(i).getContoPersonale().aggiorna();
                    boolean res1 = this.clienti.get(i).getContoPersonale().getMovimentoCorrente().salva(this.clienti.get(i).getCodicefiscale());
                    
                    if(res && res1){
                        saldo = this.clienti.get(i).getContoPersonale().getSaldo(); //Movimento registrato con successo, OK
                    }else{
                        saldo = -1;     //Errore, Codice Fiscale e Cliente non presenti nella listaClienti
                    }
                }else{
                    saldo = -2;         //Errore, saldo sul conto personale del Cliente non sufficiente a coprire il prelievo
                }
            }else{
                saldo = -1;            //Errore, Codice Fiscale e Cliente non presenti nella listaClienti
            }
            return saldo;
        }        
        
}
