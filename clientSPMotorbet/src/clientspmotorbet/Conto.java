/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientspmotorbet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Salvo
 */
public class Conto {
   private String cf;
   private float saldo;
   private ArrayList<Movimento> movimenti;
   DAOConto DAOConto;

   public Conto(String cf) {
       this.DAOConto = new DAOConto();
       this.cf = cf;
       this.movimenti = new ArrayList();
   }
   
   public boolean salva(){
        return(this.DAOConto.salva(this));
   }
   
   public boolean aggiorna(){
       return(this.DAOConto.aggiorna(this));
   }
   
   public String getCf() {
        return cf;
   }
   
   public void setCf(String cf) {
        this.cf = cf;
   }

   public Float getSaldo() {
        return saldo;
   }

   public void setSaldo(float saldo) {
        this.saldo = saldo;
   }
   
   public void aggiornaSaldo(float importo){
       this.saldo+=importo;
   }
   
   public void aggiungiMovimento(float importo) {
       Movimento m1 = new Movimento(importo);
       this.movimenti.add(m1);
       this.aggiornaSaldo(m1.getImporto());
   }
   
   public Movimento getMovimentoCorrente(){
        return this.movimenti.get(this.movimenti.size()-1);
   }
}