/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data;

import br.ufg.inf.espbd.siseventos.data.util.ConnectionFactory;
import br.ufg.inf.espbd.siseventos.model.Evento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wos
 */
public class EventoDAOImpl implements EventoDAO {
    private final String TABLE_EVENTO = "evento";
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
            String sql = "insert into " + TABLE_EVENTO + " (" + COLUMN_NOME + " , " + COLUMN_INICIO + " , " + COLUMN_FIM + " , " + COLUMN_LOCAL + ") VALUES(?,?,?,?)";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, evento.getNome());
            ps.setTimestamp(2, evento.getInicio());
            ps.setTimestamp(3, evento.getFim());
            ps.setString(4, evento.getLocal());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
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
            String sql = "update " + TABLE_EVENTO + " set " + COLUMN_NOME + " = ?, " + COLUMN_INICIO + "= ?, " + COLUMN_FIM + "= ?, " + COLUMN_LOCAL + " = ? WHERE " + COLUMN_ID + " = ?";
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
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "delete from " + TABLE_EVENTO + " where " + COLUMN_ID + "= ?";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setInt(1, evento.getId());
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
    public List<Evento> listar() {
        List<Evento> eventos = new ArrayList<>();
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            s = conexao.createStatement();
            resultSet = s.executeQuery("select * from " + TABLE_EVENTO);
            while (resultSet.next()) {
                Evento evento = new Evento();
                evento.setId(resultSet.getInt(COLUMN_ID));
                evento.setNome(resultSet.getString(COLUMN_NOME));
                evento.setInicio(resultSet.getTimestamp(COLUMN_INICIO));
                evento.setFim(resultSet.getTimestamp(COLUMN_FIM));
                evento.setLocal(resultSet.getString(COLUMN_LOCAL));
                eventos.add(evento);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar objeto: "
                    + ex.getMessage());
        } catch (RuntimeException ex) {
            throw new RuntimeException("Erro ao conectar-se ao banco: "
                    + ex.getMessage());
        }
        return eventos;
    }

    @Override
    public Evento getById(int id) {
        Evento evento = null;
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "select * from " + TABLE_EVENTO + " where " + COLUMN_ID + " = ?";
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                evento = new Evento();
                evento.setId(resultSet.getInt(COLUMN_ID));
                evento.setNome(resultSet.getString(COLUMN_NOME));
                evento.setInicio(resultSet.getTimestamp(COLUMN_INICIO));
                evento.setFim(resultSet.getTimestamp(COLUMN_FIM));
                evento.setLocal(resultSet.getString(COLUMN_LOCAL));
            } else {
                throw new RuntimeException("Evento não encontrado");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar objeto: "
                    + ex.getMessage());
        } catch (RuntimeException ex) {
            throw new RuntimeException("Erro ao conectar-se ao banco: "
                    + ex.getMessage());
        }
        return evento;
    }
}
