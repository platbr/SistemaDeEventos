/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data;

import br.ufg.inf.espbd.siseventos.model.Cliente;
import java.util.List;

/**
 *
 * @author alunoinf
 */
public interface ClienteDAO {
    
    public void salvar(Cliente cliente);
    public void atualizar(Cliente cliente);
    public void remover(Cliente cliente);
    public List<Cliente> listar();
    public Cliente getById(int id);
}
