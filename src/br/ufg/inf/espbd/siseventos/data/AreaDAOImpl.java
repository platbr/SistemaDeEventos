/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data;

import br.ufg.inf.espbd.siseventos.data.util.ConnectionFactory;
import br.ufg.inf.espbd.siseventos.model.Area;
import java.sql.*;
import java.util.List;

/**
 *
 * @author alunoinf
 */
public class AreaDAOImpl implements AreaDAO{
    
    private final String COLUMN_ID = "id";
    private final String COLUMN_NOME = "nome";
    private final String COLUMN_VALOR = "valor";
    private final String COLUMN_ID_EVENTO = "id_evento";
    
    Connection conexao;
    PreparedStatement ps;
    ResultSet resultSet;
    Statement s;

    @Override
    public void salvar(Area area) {
         try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO Area (" + COLUMN_NOME + " , " + COLUMN_VALOR + " , " + COLUMN_ID_EVENTO + ") VALUES(?,?,?)";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1, area.getNome());
            ps.setDouble(2, area.getValor());
            ps.setInt(3, area.getEvento().getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro " + ex.getSQLState()
                    + "ao salvar o objeto: " + ex.getLocalizedMessage());
        } catch (RuntimeException ex) {
            throw new RuntimeException("Erro ao conectar-se ao banco: "
                    + ex.getMessage());
        }
    }

    @Override
    public void atualizar(Area area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(Area area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Area> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
