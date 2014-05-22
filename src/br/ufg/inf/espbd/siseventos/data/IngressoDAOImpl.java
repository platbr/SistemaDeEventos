/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data;

import br.ufg.inf.espbd.siseventos.data.util.ConnectionFactory;
import br.ufg.inf.espbd.siseventos.model.Ingresso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wagner
 */
public class IngressoDAOImpl implements IngressoDAO {
    private final String TABLE_INGRESSO = "ingresso";
    private final String COLUMN_NUMERO = "numero";
    private final String COLUMN_ID = "id";
    private final String COLUMN_ID_AREA = "id_area";

    Connection conexao;
    PreparedStatement ps;
    ResultSet resultSet;
    Statement s;

    @Override
    public void salvar(Ingresso ingresso) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "insert into " + TABLE_INGRESSO + " (" + COLUMN_NUMERO + " , " + COLUMN_ID_AREA + ") VALUES(?,?)";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, ingresso.getNumero());
            ps.setInt(2, ingresso.getId_area());
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
    public void atualizar(Ingresso ingresso) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "update " + TABLE_INGRESSO + " set " + COLUMN_NUMERO + " = ?, " + COLUMN_ID_AREA + "= ? WHERE " + COLUMN_ID + " = ?";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1, ingresso.getNumero());
            ps.setInt(2, ingresso.getId_area());
            ps.setLong(3, ingresso.getId());
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
    public void remover(Ingresso ingresso) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "delete from " + TABLE_INGRESSO + " where " + COLUMN_ID + "= ?";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setLong(1, ingresso.getId());
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
    public List<Ingresso> listar() {
        List<Ingresso> ingressos = new ArrayList<>();
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            s = conexao.createStatement();
            resultSet = s.executeQuery("select * from " + TABLE_INGRESSO);
            while (resultSet.next()) {
                Ingresso ingresso = new Ingresso();
                ingresso.setId(resultSet.getLong(COLUMN_ID));
                ingresso.setNumero(resultSet.getString(COLUMN_NUMERO));
                ingresso.setId_area(resultSet.getInt(COLUMN_ID_AREA));
                ingressos.add(ingresso);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar objeto: "
                    + ex.getMessage());
        } catch (RuntimeException ex) {
            throw new RuntimeException("Erro ao conectar-se ao banco: "
                    + ex.getMessage());
        }
        return ingressos;
    }

    @Override
    public Ingresso getById(Long id) {
        Ingresso ingresso = null;
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "select * from " + TABLE_INGRESSO + " where " + COLUMN_ID + " = ?";

            ps = conexao.prepareStatement(sql);

            ps.setLong(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                ingresso = new Ingresso();
                ingresso.setId(resultSet.getLong(COLUMN_ID));
                ingresso.setNumero(resultSet.getString(COLUMN_NUMERO));
                ingresso.setId_area(resultSet.getInt(COLUMN_ID_AREA));
            } else {
                throw new RuntimeException("Ingresso não encontrado");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar objeto: "
                    + ex.getMessage());
        } catch (RuntimeException ex) {
            throw new RuntimeException("Erro ao conectar-se ao banco: "
                    + ex.getMessage());
        }
        return ingresso;
    }
}
