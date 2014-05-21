/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemadeeventos;

import br.ufg.inf.espbd.siseventos.data.EventoDAOImpl;
import br.ufg.inf.espbd.siseventos.model.Evento;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;

/**
 *
 * @author alunoinf
 */
public class SistemaDeEventos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, InterruptedException {
        // TODO code application logic here

        //ConnectionFactory.getInstance();

/*
        while (true) {
            try {
                Operador op = new Operador();
                //op.setId(1);
                op.setNome("woshington");
                op.setUsuario("wos");
                op.setSenha("teste");
                op.setNivelAcesso(NivelAcesso.GERENCIAL);
                OperadorDAOImpl opimp = new OperadorDAOImpl();
                opimp.salvar(op);
                

            } catch (RuntimeException e) {
                System.out.println("Erro ao tentar inserir: " + e.getMessage());

            }
            Thread.sleep(10000);
        }
*/
        while (true) {
            try {
                Evento ev = new Evento();
                //op.setId(1);
                ev.setNome("Corrida Maluca");
                LocalDateTime teste = LocalDateTime.of(2014,Month.APRIL, 12, 17, 0);
              
               
                ev.setInicio(teste);
                
                ev.setFim(teste);
                ev.setLocal("Autodromo de Goiania");
                System.out.println("AQUI " + ev.getInicio());
                System.out.println("AQUI " + ev.getFim());
                EventoDAOImpl opimp = new EventoDAOImpl();
                opimp.salvar(ev);
                

            } catch (RuntimeException e) {
                System.out.println("Erro ao tentar inserir: " + e.getMessage());

            }
            Thread.sleep(10000);
        }
        
        /*          *
         * Operador op2=new Operador(); //op2.setId(2); op2.setNome("wagner");
         * op2.setUsuario("wagner2"); op2.setSenha("teste2");
         * op2.setNivelAcesso(NivelAcesso.OPERACIONAL);
         *
         * //opimp.salvar(op2); //opimp.remover(op2);
         *
         * //opimp.getByUsuario("wos");
         *
         * System.out.println(opimp.getByUsuario("wos").getNivelAcesso());
         * System.out.println(opimp.listar()); //List<Operador> operadores=new
         * ArrayList<> for (Operador op3 : opimp.listar()) {
         * System.out.println(op3.getNome());
         * System.out.println(op3.getNivelAcesso()); }
         *
         */
    }
}
