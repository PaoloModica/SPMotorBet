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
public class Quotazione {
    private int posizione;
    private String CognomePilota;
    private String NomePilota;
    private String gara;
    private String campionato;
    private float quota;

    public Quotazione() {
    }

    public int getPosizione() {
        return posizione;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    public String getCognomePilota() {
        return CognomePilota;
    }

    public void setCognomePilota(String CognomePilota) {
        this.CognomePilota = CognomePilota;
    }

    public String getNomePilota() {
        return NomePilota;
    }

    public void setNomePilota(String NomePilota) {
        this.NomePilota = NomePilota;
    }

    public String getGara() {
        return gara;
    }

    public void setGara(String gara) {
        this.gara = gara;
    }

    public String getCampionato() {
        return campionato;
    }

    public void setCampionato(String campionato) {
        this.campionato = campionato;
    }

    public float getQuota() {
        return quota;
    }

    public void setQuota(float quota) {
        this.quota = quota;
    }
}
