/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data;


import br.ufg.inf.espbd.siseventos.model.Venda;
import java.util.List;

/**
 *
 * @author alunoinf
 */
public interface VendaDAO {
    public void salvar(Venda venda);
    public void atualizar(Venda venda);
    public void remover(Venda venda);
    public List<Venda> listar();
    public Venda getById(Long id);
}
