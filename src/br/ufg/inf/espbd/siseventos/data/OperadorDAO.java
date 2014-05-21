/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data;


import br.ufg.inf.espbd.siseventos.model.Operador;
import java.util.List;

/**
 *
 * @author alunoinf
 */
public interface OperadorDAO {
    
    public void salvar(Operador operador);
    public void atualizar(Operador operador);
    public void remover(Operador operador);
    public List<Operador> listar();
    public Operador getByUsuario(String usuario);
}
