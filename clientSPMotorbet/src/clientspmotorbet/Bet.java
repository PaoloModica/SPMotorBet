/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientspmotorbet;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author paolo
 */
public class Bet {
    private String id;
    private String cf;
    private float importo;
    private float vincitaPotenziale;
    private String data;
    
    private BetLine bl1;
    private ArrayList<BetLine> puntate;

    public ArrayList<BetLine> getPuntate() {
        return puntate;
    }
    
    
    public boolean salva(DAOBet DaoBet){
        return(DaoBet.salva(this));
    }
    
    //questo
    public boolean salvaPuntate(){
        boolean res = false;
        
        for(int i=0; i<this.getPuntate().size(); i++){
            res = this.getPuntata(i).salva(this.getId(), this.getCf());
        }
        
        return res;
    }
    //
    
    public void addBetLine(String nomepilota, String cognomepilota, String campionato, String gara, int posizione, float quota){
        bl1 = new BetLine(nomepilota, cognomepilota, campionato, gara, posizione, quota);
    }
    public BetLine getBetLineCorrente(){
        return this.bl1;
    }
    public String getId(){
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCf() {
        return cf;
    }

    public float getImporto() {
        return importo;
    }

    public float getVincitaPotenziale() {
        return vincitaPotenziale;
    }

    public String getData() {
        return data;
    }

    public void setPuntate(ArrayList<BetLine> puntate) {
        this.puntate = puntate;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public void setImporto(float importo) {
        this.importo = importo;
    }

    public void setVincitaPotenziale(float vincitaPotenziale) {
        this.vincitaPotenziale = vincitaPotenziale;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public void addPuntata(BetLine puntata) {
        this.puntate.add(puntata);
    }
    public void delPuntata(int i){
        this.puntate.remove(i);
    }
    public void svuotaListaPuntate(){
        while(!(this.puntate.isEmpty())){
            this.delPuntata(0);
        }     
    }
    public int getDimListaPuntate(){
        return(this.puntate.size());
    }
    
    //costruito così perchè il metodo contains() di ArrayList non funziona
    public boolean betLinePresente(BetLine bl1){
        for(int i = 0; i < this.getDimListaPuntate(); i++)
            if((this.puntate.get(i).getNomepilota().equals(bl1.getNomepilota())) && (this.puntate.get(i).getCognomepilota().equals(bl1.getCognomepilota())) 
                    && (this.puntate.get(i).getCampionato()).equals(bl1.getCampionato()) && (this.puntate.get(i).getGara()).equals(bl1.getGara()) 
                    && (this.puntate.get(i).getPosizione()==bl1.getPosizione()) && (this.puntate.get(i).getQuota()==bl1.getQuota()) )
                return true;
        return false;
    }
    public BetLine getPuntata(int i){
        return(this.puntate.get(i));
    }
    public Bet(){
        this.puntate = new ArrayList();
    }
    public float aggQuotaTotale(){
        float q = 1;
        
        if(this.getDimListaPuntate() == 0)
            return 0;
        for(int i = 0; i < this.getDimListaPuntate(); i++){
            q *= this.getPuntata(i).getQuota();
        }
        return q;
    }
}
