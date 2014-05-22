/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data;

import br.ufg.inf.espbd.siseventos.data.util.ConnectionFactory;
import br.ufg.inf.espbd.siseventos.model.Cliente;
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
public class ClienteDAOImpl implements ClienteDAO {

    private final String COLUMN_ID = "id";
    private final String COLUMN_NOME = "nome";
    Connection conexao;
    PreparedStatement ps;
    ResultSet resultSet;
    Statement s;

    @Override
    public void salvar(Cliente cliente) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "INSERT INTO Cliente (" + COLUMN_NOME + ") VALUES(?)";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1, cliente.getNome());
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
    public void atualizar(Cliente cliente) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "update Cliente set " + COLUMN_NOME + "= ? WHERE " + COLUMN_ID + " = ?";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1, cliente.getNome());
            ps.setInt(2, cliente.getId());
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
    public void remover(Cliente cliente) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "delete from Cliente where " + COLUMN_ID + "= ?";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setInt(1, cliente.getId());
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
    public List<Cliente> listar() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            s = conexao.createStatement();
            resultSet = s.executeQuery("select * from Cliente");
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt(COLUMN_ID));
                cliente.setNome(resultSet.getString(COLUMN_NOME));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar objeto: "
                    + ex.getMessage());
        } catch (RuntimeException ex) {
            throw new RuntimeException("Erro ao conectar-se ao banco: "
                    + ex.getMessage());
        }
        return clientes;
    }

    @Override
    public Cliente getById(int id) {
        Cliente cliente = null;
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "select * from Cliente where " + COLUMN_ID + " = ?";
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setId(resultSet.getInt(COLUMN_ID));
                cliente.setNome(resultSet.getString(COLUMN_NOME));
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
        return cliente;
    }

}
