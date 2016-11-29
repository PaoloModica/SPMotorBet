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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author paolo
 */
public class clientSPMotorbet {

    private static clientSPMotorbet Singleton;  //GoF Singleton Pattern
    DAOCliente DaoCliente;
    private List<Cliente> clienti;
    DAOBookmaker DaoBookmaker;
    DAOBet DaoBet;
    public List<Bet> listaBet;

    Cliente clienteCorrente;

    private Bet istanza;
    
    private clientSPMotorbet() {
        this.clienti = new ArrayList<Cliente>();
        this.DaoCliente = new DAOCliente();
	this.clienti = this.DaoCliente.caricaLista();
        this.DaoBookmaker = new DAOBookmaker();
        this.DaoBet = new DAOBet();
    }
    
    public static clientSPMotorbet getInstance(){ //GoF Singleton Pattern
        if(Singleton == null){
            Singleton = new clientSPMotorbet();
        }
        return Singleton;
    }

    public Cliente getClienteCorrente() {
        return this.clienteCorrente;
    }
    
    public String GeneraID(){
        String stringa = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(10);
        for( int i = 0; i < 10; i++ ) 
            sb.append( stringa.charAt( rnd.nextInt(stringa.length()) ) );
        return sb.toString();
    }
    
    public boolean login(String username, String password){
        boolean loggedIn = false;
        
        for(int i = 0; i<(this.clienti.size()); i++){
            if(this.clienti.get(i).getUsername().equals(username) && this.clienti.get(i).getPassword().equals(password)){
                this.clienteCorrente = new Cliente();
                this.clienteCorrente = this.clienti.get(i);
                this.clienteCorrente.setListaBet(this.DaoBet);
                loggedIn = true;
                break;
            }else{
                loggedIn = false;
            }
        }
        
        return loggedIn;
    }
    
    public void logout(){
        //reset dell'istanza corrente di Bet
        if(this.istanza != null)
            this.istanza.svuotaListaPuntate();
        this.istanza = null;
        //reset dell'istanza corrente del conto del cliente
        this.clienteCorrente = null;       
 
    }
    
    public void istanzaBet(){
        if(istanza == null){
            istanza = new Bet();
            istanza.setCf(this.clienteCorrente.getCodicefiscale());
            istanza.setId(this.GeneraID());
        }
    }
    
    public Bet getBet(){
        return this.istanza;
    }
    
    public List<String> popolaCampionato(){
        return(this.DaoBookmaker.caricaListaCampionati());
    }
    
    public List<String> popolaGara(String selCampionato){
        return(this.DaoBookmaker.caricaListaGare(selCampionato));
    }
    
    public List<String> popolaPilota(String selCampionato, String selGara){
        return(this.DaoBookmaker.caricaListaPiloti(selCampionato, selGara));
    }
    
    public List<Quotazione> popolaQuote(String selCampionato, String selGara, String[] selPilota){
        return(this.DaoBookmaker.caricaListaQuote(selCampionato, selGara, selPilota));
    }
    
    public boolean aggPuntata(String nomepilota, String cognomepilota, String campionato, String gara, int posizione, float quota){
       istanza.addBetLine(nomepilota, cognomepilota, campionato, gara, posizione, quota); //demandiamo all'istanza di Bet la creazione della BetLine per il pattern Low Coupling, in modo da garantire basso accoppiamento
        if((istanza.getDimListaPuntate() == 0) || !istanza.betLinePresente(istanza.getBetLineCorrente())){
            istanza.addPuntata(istanza.getBetLineCorrente());
            return true;
        }else{
            return false;
        }
    }
    
    //questo
    public boolean confermaGiocata(){
        boolean res1 = this.istanza.salva(this.DaoBet);
        boolean res2 = this.istanza.salvaPuntate();
        
        if(res1 && res2){       //Se il salvataggio sul DB della Bet e delle Betline a questa associata è andato a buon fine
            this.clienteCorrente.getContoPersonale().aggiungiMovimento(-this.istanza.getImporto());
            boolean res3 = this.clienteCorrente.getContoPersonale().aggiorna();
            boolean res4 = this.clienteCorrente.getContoPersonale().getMovimentoCorrente().salva(this.clienteCorrente.getCodicefiscale());
            
            if(res3 && res4){       //Se il salvataggio del Movimento e l'aggiornamento del Conto sulDB va a buon fine
                this.getClienteCorrente().addBet(this.istanza);
                this.istanza.setId("");
                this.istanza.setImporto(0);
                this.istanza.setVincitaPotenziale(0);
                this.istanza.svuotaListaPuntate();
                this.istanza.setId(this.GeneraID());
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    //
    
    public List<Bet> visScommesse(){
        this.getClienteCorrente().setListaBet(this.DaoBet);
        return(this.getClienteCorrente().getListaBet());
    }
    
    public List<BetLine> visDetScommessa(String id){
        int i;
        for(i=0;i < this.getClienteCorrente().getListaBet().size();i++){
            if(this.getClienteCorrente().getListaBet().get(i).getId().equals(id)){
                break;
            }
        }
        return this.getClienteCorrente().getListaBet().get(i).getPuntate();
    }
    
    public boolean verificaImporto(float importo){
        return(importo <= this.getClienteCorrente().getContoPersonale().getSaldo());
    }
}
