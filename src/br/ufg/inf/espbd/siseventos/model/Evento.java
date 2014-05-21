/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.model;


/**
 *
 * @author alunoinf
 */
public class Evento {
//teste commit
    private int id;
    private String nome;
    private java.sql.Timestamp inicio;
    private java.sql.Timestamp fim;
    private String local;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public java.sql.Timestamp getInicio() {
        return inicio;
    }

    public void setInicio(java.sql.Timestamp inicio) {
        this.inicio = inicio;
    }

    public java.sql.Timestamp getFim() {
        return fim;
    }

    public void setFim(java.sql.Timestamp fim) {
        this.fim = fim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    
    
}
