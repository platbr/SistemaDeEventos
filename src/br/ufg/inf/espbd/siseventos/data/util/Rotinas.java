/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data.util;

import br.ufg.inf.espbd.siseventos.data.IngressoDAO;
import br.ufg.inf.espbd.siseventos.data.IngressoDAOImpl;
import br.ufg.inf.espbd.siseventos.model.Area;
import br.ufg.inf.espbd.siseventos.model.Ingresso;

/**
 *
 * @author wagner
 */
public class Rotinas {
    
    public static void gerarIngressos(Area area) {
        IngressoDAO ingDAO = new IngressoDAOImpl();
        for (int i = 1; i <= area.getLotacao(); i++) {
            Ingresso ingresso = new Ingresso();
            ingresso.setNumero(area.getId_evento() + "-" + area.getId() + "-" + i);
            ingresso.setId_area(area.getId());
            ingDAO.salvar(ingresso);
        }
        
    }    
    
}
