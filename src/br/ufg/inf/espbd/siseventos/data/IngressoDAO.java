/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data;


import br.ufg.inf.espbd.siseventos.model.Ingresso;
import java.util.List;

/**
 *
 * @author alunoinf
 */
public interface IngressoDAO {
    
    public void salvar(Ingresso ingresso);
    public void atualizar(Ingresso ingresso);
    public void remover(Ingresso ingresso);
    public List<Ingresso> listar();
}
