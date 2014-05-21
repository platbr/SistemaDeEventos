/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufg.inf.espbd.siseventos.data;

import br.ufg.inf.espbd.siseventos.data.util.ConnectionFactory;
import br.ufg.inf.espbd.siseventos.model.StatusVenda;
import br.ufg.inf.espbd.siseventos.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wagner
 */
public class VendaDAOImpl implements VendaDAO{
    private final String COLUMN_ID = "id";
    private final String COLUMN_DATA = "data";
    private final String COLUMN_STATUS_VENDA = "status_venda";
    private final String COLUMN_ID_CLIENTE = "id_cliente";
    private final String COLUMN_ID_OPERADOR = "id_operador";
    private final String COLUMN_ID_INGRESSO = "id_ingresso";

    Connection conexao;
    PreparedStatement ps;
    ResultSet resultSet;
    Statement s;

    @Override
    public void salvar(Venda venda) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO Venda (" + COLUMN_DATA + " , " + COLUMN_STATUS_VENDA + " , " + COLUMN_ID_CLIENTE + " , " + COLUMN_ID_OPERADOR + " , " + COLUMN_ID_INGRESSO + ") VALUES(?,?,?,?,?)";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setTimestamp(1, venda.getData());
            ps.setString(2, venda.getStatus().toString());
            ps.setInt(3, venda.getId_cliente());
            ps.setInt(4, venda.getId_operador());
            ps.setInt(5, venda.getId_ingresso());
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
    public void atualizar(Venda venda) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "update Venda set " + COLUMN_DATA + " = ?, " + COLUMN_STATUS_VENDA + "= ?, " + COLUMN_ID_CLIENTE + "= ?, " + COLUMN_ID_OPERADOR + "= ?, " + COLUMN_ID_INGRESSO + " = ? WHERE " + COLUMN_ID + " = ?";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setTimestamp(1, venda.getData());
            ps.setString(2, venda.getStatus().toString());
            ps.setInt(3, venda.getId_cliente());
            ps.setInt(4, venda.getId_operador());
            ps.setInt(5, venda.getId_ingresso());
            ps.setLong(6, venda.getId());
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
    public void remover(Venda venda) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "delete from Venda where " + COLUMN_ID + "= ?";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setLong(1, venda.getId());
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
    public List<Venda> listar() {
        List<Venda> vendas = new ArrayList<>();
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            s = conexao.createStatement();
            resultSet = s.executeQuery("select * from Venda");

            while (resultSet.next()) {
                Venda venda = new Venda();
                venda.setId(resultSet.getLong(COLUMN_ID));
                venda.setData(resultSet.getTimestamp(COLUMN_DATA));
                venda.setStatus(StatusVenda.fromString(resultSet.getString(COLUMN_STATUS_VENDA)));
                venda.setId_cliente(resultSet.getInt(COLUMN_ID_CLIENTE));
                venda.setId_ingresso(resultSet.getInt(COLUMN_ID_INGRESSO));
                venda.setId_operador(resultSet.getInt(COLUMN_ID_OPERADOR));
                vendas.add(venda);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar objeto: "
                    + ex.getMessage());
        } catch (RuntimeException ex) {
            throw new RuntimeException("Erro ao conectar-se ao banco: "
                    + ex.getMessage());
        }

        return vendas;
    }

    @Override
    public Venda getById(Long id) {

        Venda venda = null;
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "select * from Venda where " + COLUMN_ID + " = ?";

            ps = conexao.prepareStatement(sql);

            ps.setLong(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                venda = new Venda();
                venda.setId(resultSet.getLong(COLUMN_ID));
                venda.setData(resultSet.getTimestamp(COLUMN_DATA));
                venda.setStatus(StatusVenda.fromString(resultSet.getString(COLUMN_STATUS_VENDA)));
                venda.setId_cliente(resultSet.getInt(COLUMN_ID_CLIENTE));
                venda.setId_ingresso(resultSet.getInt(COLUMN_ID_INGRESSO));
                venda.setId_operador(resultSet.getInt(COLUMN_ID_OPERADOR));
            } else {

                throw new RuntimeException("Usuário não encontrado");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar objeto: "
                    + ex.getMessage());
        } catch (RuntimeException ex) {
            throw new RuntimeException("Erro ao conectar-se ao banco: "
                    + ex.getMessage());
        }
        return venda;
    }

    @Override
    public void alterarStatus(Venda venda, StatusVenda status) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "update Venda set " + COLUMN_STATUS_VENDA + " = ? WHERE " + COLUMN_ID + " = ?";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1, status.toString());
            ps.setLong(2, venda.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro " + ex.getSQLState()
                    + "ao salvar o objeto: " + ex.getLocalizedMessage());
        } catch (RuntimeException ex) {
            throw new RuntimeException("Erro ao conectar-se ao banco: "
                    + ex.getMessage());
        }
    }
    
}
