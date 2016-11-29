/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientspmotorbet;

/**
 *
 * @author paolo
 */
public class BetLine {
    private String nomepilota;
    private String cognomepilota;
    private String campionato;
    private String gara;
    private int posizione;
    private float quota;
    DAOBetline DaoBetline;
    
    public BetLine(String nomepilota, String cognomepilota, String campionato, String gara, int posizione, float quota) {
        this.setNomepilota(nomepilota);
        this.setCognomepilota(cognomepilota);
        this.setCampionato(campionato);
        this.setGara(gara);
        this.setPosizione(posizione);
        this.setQuota(quota);
        DaoBetline = new DAOBetline();
    }

    public BetLine() {
        DaoBetline = new DAOBetline();
    }
    
    public boolean salva(String id, String cf){
        return(this.DaoBetline.salva(id, cf, this));
    }
    
    public void setNomepilota(String nomepilota) {
        this.nomepilota = nomepilota;
    }

    public void setCognomepilota(String cognomepilota) {
        this.cognomepilota = cognomepilota;
    }

    public void setCampionato(String campionato) {
        this.campionato = campionato;
    }

    public void setGara(String gara) {
        this.gara = gara;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    public void setQuota(float quota) {
        this.quota = quota;
    }

    public String getNomepilota() {
        return nomepilota;
    }

    public String getCognomepilota() {
        return cognomepilota;
    }

    public String getCampionato() {
        return campionato;
    }

    public String getGara() {
        return gara;
    }

    public int getPosizione() {
        return posizione;
    }

    public float getQuota() {
        return quota;
    }
  
}
