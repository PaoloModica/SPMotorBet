/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmotorbet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import sun.security.util.Password;

/**
 *
 * @author Salvo
 */
public class Cliente{
    private String nome;
    private String cognome;
    private String codicefiscale;
    private Date data_di_nascita; 
    private String telefono;
    private String indirizzo;

    private String username;
    private String password;

    private Conto contoPersonale;
    //DAOCliente DAOCliente;

    public Cliente() {
    }
    
    public boolean salva(DAOCliente DC, DateFormat format2){
        return(DC.salva(this, format2));
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodicefiscale() {
        return codicefiscale;
    }

    public void setCodicefiscale(String codicefiscale) {
        this.codicefiscale = codicefiscale;
    }
    
    public Date getData_di_nascita() {
        return data_di_nascita;
    }

    public void setData_di_nascita(Date data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }
  
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Conto getContoPersonale() {
        return this.contoPersonale;
    }

    public void setContoPersonale() {
        this.contoPersonale = new Conto(this.getCodicefiscale());
    }
    
}
