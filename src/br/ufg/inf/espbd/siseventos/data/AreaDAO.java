/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data;

import br.ufg.inf.espbd.siseventos.model.Area;
import java.util.List;

/**
 *
 * @author alunoinf
 */
public interface AreaDAO {

    public void salvar(Area area);
    public void atualizar(Area area);
    public void remover(Area area);
    public List<Area> listar();
    public Area getById(int id);
}
