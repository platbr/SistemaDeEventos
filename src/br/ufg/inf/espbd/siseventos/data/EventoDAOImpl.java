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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            String sql = "INSERT INTO evento (" + COLUMN_NOME + " , " + COLUMN_INICIO + " , " + COLUMN_FIM + " , " + COLUMN_LOCAL + ") VALUES(?,?,?,?)";
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
            String sql = "update Evento set " + COLUMN_NOME + " = ?, " + COLUMN_INICIO + "= ?, " + COLUMN_FIM + "= ?, " + COLUMN_LOCAL + " = ? WHERE " + COLUMN_ID + " = ?";
            ps = conexao.prepareStatement(sql);
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
    public void remover(Integer evento) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql;
        try {
            conn = ConnectionFactory.getInstance().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        sql = "DELETE FROM evento WHERE id=?;";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, evento);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Evento> listar() {
        List<Evento> lstCadastro = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        sql = "select * from evento ORDER by nome";
        try {
            ps = (PreparedStatement) ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            System.out.println(rs);
            lstCadastro = new ArrayList<Evento>();
            while (rs.next()) {
                Evento evento = new Evento();
                evento.setId(rs.getInt("id"));
                evento.setNome(rs.getString("nome"));
                evento.setFim(rs.getTimestamp("fim"));
                evento.setInicio(rs.getTimestamp("inicio"));
                evento.setLocal(rs.getString("local"));
                lstCadastro.add(evento);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lstCadastro;
    }

    @Override
    public Evento getById(Integer id) {
        Evento evento = new Evento();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        sql = "SELECT * FROM evento WHERE id=?";
        try {
            ps = (PreparedStatement) ConnectionFactory.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                evento.setId(rs.getInt("id"));
                evento.setFim(rs.getTimestamp("fim"));
                evento.setInicio(rs.getTimestamp("inicio"));
                evento.setLocal(rs.getString("local"));
                evento.setNome(rs.getString("nome"));
                return evento;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
