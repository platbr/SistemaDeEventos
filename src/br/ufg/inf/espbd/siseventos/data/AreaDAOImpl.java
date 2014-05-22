/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data;

import br.ufg.inf.espbd.siseventos.data.util.ConnectionFactory;
import br.ufg.inf.espbd.siseventos.model.Area;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alunoinf
 */
public class AreaDAOImpl implements AreaDAO {

    private final String COLUMN_ID = "id";
    private final String COLUMN_NOME = "nome";
    private final String COLUMN_VALOR = "valor";
    private final String COLUMN_ID_EVENTO = "id_evento";
    private final String COLUMN_LOTACAO = "lotacao";

    Connection conexao;
    PreparedStatement ps;
    ResultSet resultSet;
    Statement s;

    @Override
    public void salvar(Area area) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO Area (" + COLUMN_NOME + " , " + COLUMN_VALOR + " , " + COLUMN_ID_EVENTO + " , " + COLUMN_LOTACAO + ") VALUES(?,?,?,?)";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1, area.getNome());
            ps.setDouble(2, area.getValor());
            ps.setInt(3, area.getId_evento());
            ps.setInt(4, area.getLotacao());
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
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "update Area set " + COLUMN_NOME + " = ?, " + COLUMN_VALOR + "= ?, " + COLUMN_ID_EVENTO + "= ?, " + COLUMN_LOTACAO + "= ? WHERE " + COLUMN_ID + " = ?";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1, area.getNome());
            ps.setDouble(2, area.getValor());
            ps.setLong(3, area.getId_evento());
            ps.setInt(4, area.getLotacao());
            ps.setInt(5, area.getId());
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
    public void remover(Area area) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "delete from Area where " + COLUMN_ID + "= ?";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setInt(1, area.getId());
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
    public List<Area> listar() {
        List<Area> areas = new ArrayList<>();
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            s = conexao.createStatement();
            resultSet = s.executeQuery("select * from Area");
            while (resultSet.next()) {
                Area area = new Area();
                area.setId(resultSet.getInt(COLUMN_ID));
                area.setNome(resultSet.getString(COLUMN_NOME));
                area.setValor(resultSet.getDouble(COLUMN_VALOR));
                area.setId_evento(resultSet.getInt(COLUMN_ID_EVENTO));
                area.setLotacao(resultSet.getInt(COLUMN_LOTACAO));
                areas.add(area);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar objeto: "
                    + ex.getMessage());
        } catch (RuntimeException ex) {
            throw new RuntimeException("Erro ao conectar-se ao banco: "
                    + ex.getMessage());
        }
        return areas;
    }

    @Override
    public Area getById(int id) {
        Area area = null;
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "select * from Area where " + COLUMN_ID + " = ?";
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                area = new Area();
                area.setId(resultSet.getInt(COLUMN_ID));
                area.setNome(resultSet.getString(COLUMN_NOME));
                area.setValor(resultSet.getDouble(COLUMN_VALOR));
                area.setId_evento(resultSet.getInt(COLUMN_ID_EVENTO));
                area.setLotacao(resultSet.getInt(COLUMN_LOTACAO));
            } else {
                throw new RuntimeException("Area não encontrada");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar objeto: "
                    + ex.getMessage());
        } catch (RuntimeException ex) {
            throw new RuntimeException("Erro ao conectar-se ao banco: "
                    + ex.getMessage());
        }
        return area;
    }

}
