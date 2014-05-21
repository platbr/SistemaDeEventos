/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data;

import br.ufg.inf.espbd.siseventos.data.util.ConnectionFactory;
import br.ufg.inf.espbd.siseventos.model.Evento;
import java.sql.*;
import java.util.List;

/**
 *
 * @author wos
 */
public class EventoDAOImpl implements EventoDAO {

    private final String COLUMN_NOME = "nome";
    private final String COLUMN_INICIO = "inicio";
    private final String COLUMN_FIM = "fim";
    private final String COLUMN_LOCAL = "local";
    private final String COLUMN_ID = "id";
    Connection conexao;
    PreparedStatement ps;
    ResultSet resultSet;
    Statement s;

    @Override
    public void salvar(Evento evento) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO Evento (" + COLUMN_NOME + " , " + COLUMN_INICIO + " , " + COLUMN_FIM + " , " + COLUMN_LOCAL + ") VALUES(?,?,?,?)";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1, evento.getNome());
            ps.setTimestamp(2, evento.getInicio());
            ps.setTimestamp(3, evento.getFim());
            ps.setString(4, evento.getLocal());
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
    public void atualizar(Evento evento) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "update Evento set " + COLUMN_NOME + " = ?, " + COLUMN_INICIO + "= ?, " + COLUMN_FIM + "= ?, " + COLUMN_LOCAL + " = ? WHERE " + COLUMN_ID + " = ?";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1, evento.getNome());
            ps.setTimestamp(2, evento.getInicio());
            ps.setTimestamp(3, evento.getFim());
            ps.setString(4, evento.getLocal());
            ps.setLong(4, evento.getId());
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
    public void remover(Evento evento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Evento> listar() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}