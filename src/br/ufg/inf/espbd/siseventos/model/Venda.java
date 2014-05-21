/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.model;

import java.util.Calendar;

/**
 *
 * @author alunoinf
 */
public class Venda {
        
    private long id;
    private Calendar data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
    
    
    
}
