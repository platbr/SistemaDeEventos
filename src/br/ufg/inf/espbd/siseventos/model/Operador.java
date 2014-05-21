/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.model;

/**
 *
 * @author alunoinf
 */
public class Operador {
    
    private int id;
    private String nome;
    private String usuario;
    private String senha;
    private NivelAcesso nivelAcesso;

    public NivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(NivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
    
    
    
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
