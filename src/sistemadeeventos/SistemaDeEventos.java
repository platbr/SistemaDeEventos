/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeeventos;

import br.ufg.espbd.siseventos.controller.Login;
import br.ufg.inf.espbd.siseventos.data.VendaDAOImpl;
import br.ufg.inf.espbd.siseventos.model.StatusVenda;
import br.ufg.inf.espbd.siseventos.model.Venda;
import java.sql.SQLException;
import java.time.LocalDateTime;

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

        //new Login().setVisible(true);
                Venda venda = new Venda();
                venda.setId(2);
                
                VendaDAOImpl opimp = new VendaDAOImpl();
                //opimp.salvar(venda);
                //opimp.atualizar(venda);
                opimp.alterarStatus(venda,StatusVenda.CONFIRMADO);


    }
}
