/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data;

import br.ufg.inf.espbd.siseventos.model.Evento;
import java.util.List;

/**
 *
 * @author alunoinf
 */
public interface EventoDAO {
    
    public void salvar(Evento evento);
    public void atualizar(Evento evento);
    public void remover(Integer evento);
    public List<Evento> listar();
    public Evento getById(Integer id);
}
