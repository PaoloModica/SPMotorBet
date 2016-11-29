/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spmotorbet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Salvo
 */
public class Movimento {
    private float importo;
    DAOMovimento DAOMovimento;

    public Movimento(float imp){
        this.DAOMovimento = new DAOMovimento();
        this.setImporto(imp);
    }
    
    public boolean salva(String cf){
        return(this.DAOMovimento.salva(cf, this));
    }
    
    public float getImporto() {
        return importo;
    }

    public void setImporto(float importo) {
        this.importo = importo;
    }   
}
