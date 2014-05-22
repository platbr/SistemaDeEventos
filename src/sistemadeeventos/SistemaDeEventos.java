/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeeventos;

import br.ufg.espbd.siseventos.controller.AreaController;
import br.ufg.espbd.siseventos.controller.Login;
import br.ufg.inf.espbd.siseventos.data.AreaDAOImpl;
import br.ufg.inf.espbd.siseventos.data.VendaDAOImpl;
import br.ufg.inf.espbd.siseventos.data.util.Rotinas;
import br.ufg.inf.espbd.siseventos.model.Area;
import br.ufg.inf.espbd.siseventos.model.StatusVenda;
import br.ufg.inf.espbd.siseventos.model.Venda;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author alunoinf
 */
public class SistemaDeEventos {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws SQLException, InterruptedException {

        AreaDAOImpl arDAO = new AreaDAOImpl();
        Area area = new Area();
        area.setNome("VIP");
        area.setValor(100.00f);
        area.setId_evento(1);
        area.setLotacao(50);
        arDAO.salvar(area);
        Rotinas.gerarIngressos(area);

    }
}
