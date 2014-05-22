/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data;

import br.ufg.inf.espbd.siseventos.data.util.ConnectionFactory;
import br.ufg.inf.espbd.siseventos.model.NivelAcesso;
import br.ufg.inf.espbd.siseventos.model.Operador;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wos
 */
public class OperadorDAOImpl implements OperadorDAO {

    private final String TABLE_OPERADOR = "operador";
    private final String COLUMN_NOME = "nome";
    private final String COLUMN_USUARIO = "usuario";
    private final String COLUMN_SENHA = "senha";
    private final String COLUMN_ID = "id";
    private final String COLUMN_NIVEL_ACESSO = "nivel_acesso";
    Connection conexao;
    PreparedStatement ps;
    ResultSet resultSet;
    Statement s;

    @Override
    public void salvar(Operador operador) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "insert into " + TABLE_OPERADOR + " (" + COLUMN_NOME + " , " + COLUMN_USUARIO + " , " + COLUMN_SENHA + " , " + COLUMN_NIVEL_ACESSO + ") VALUES(?,?,?,?)";
            ps = conexao.prepareStatement(sql);
            ps.setString(1, operador.getNome());
            ps.setString(2, operador.getUsuario());
            ps.setString(3, operador.getSenha());
            ps.setString(4, operador.getNivelAcesso().toString());
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
    public void atualizar(Operador operador) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "update " + TABLE_OPERADOR + " set " + COLUMN_NOME + " = ?, " + COLUMN_USUARIO + "= ?, " + COLUMN_SENHA + "= ?, " + COLUMN_NIVEL_ACESSO + " = ? WHERE " + COLUMN_USUARIO + " = ?";
            ps = conexao.prepareStatement(sql);
            System.out.println(sql);
            ps.setString(1, operador.getNome());
            ps.setString(2, operador.getUsuario());
            ps.setString(3, operador.getSenha());
            ps.setString(4, operador.getNivelAcesso().toString());
            ps.setString(5, operador.getUsuario());

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
    public void remover(Operador operador) {
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "delete from " + TABLE_OPERADOR + " where " + COLUMN_USUARIO + "= ?";
            ps = conexao.prepareStatement(sql);

            ps.setString(1, operador.getUsuario());
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
    public List<Operador> listar() {
        List<Operador> operadores = new ArrayList<>();
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            s = conexao.createStatement();
            resultSet = s.executeQuery("select * from " + TABLE_OPERADOR);

            while (resultSet.next()) {
                Operador operador = new Operador();
                operador.setId(resultSet.getInt(COLUMN_ID));
                operador.setUsuario(resultSet.getString(COLUMN_USUARIO));
                operador.setSenha(resultSet.getString(COLUMN_SENHA));
                operador.setNome(resultSet.getString(COLUMN_NOME));
                operador.setNivelAcesso(NivelAcesso.fromString(resultSet.getString(COLUMN_NIVEL_ACESSO)));
                operadores.add(operador);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar objeto: "
                    + ex.getMessage());
        } catch (RuntimeException ex) {
            throw new RuntimeException("Erro ao conectar-se ao banco: "
                    + ex.getMessage());
        }

        return operadores;
    }

    @Override
    public Operador getByUsuario(String usuario) {

        Operador operador = null;
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "select * from " + TABLE_OPERADOR + " where " + COLUMN_USUARIO + " = ?";

            ps = conexao.prepareStatement(sql);

            ps.setString(1, usuario);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                operador = new Operador();
                operador.setId(resultSet.getInt(COLUMN_ID));
                operador.setUsuario(resultSet.getString(COLUMN_USUARIO));
                operador.setSenha(resultSet.getString(COLUMN_SENHA));
                operador.setNome(resultSet.getString(COLUMN_NOME));
                operador.setNivelAcesso(NivelAcesso.fromString(resultSet.getString(COLUMN_NIVEL_ACESSO)));
                // operador.setNivelAcesso();              

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
        return operador;
    }

    @Override
    public Operador getById(String id) {

        Operador operador = null;
        try {
            conexao = ConnectionFactory.getInstance().getConnection();
            String sql = "select * from " + TABLE_OPERADOR + " where " + COLUMN_ID + " = ?";

            ps = conexao.prepareStatement(sql);

            ps.setString(1, id);
            resultSet = ps.executeQuery();
            if (resultSet.next()) {
                operador = new Operador();
                operador.setId(resultSet.getInt(COLUMN_ID));
                operador.setUsuario(resultSet.getString(COLUMN_USUARIO));
                operador.setSenha(resultSet.getString(COLUMN_SENHA));
                operador.setNome(resultSet.getString(COLUMN_NOME));
                operador.setNivelAcesso(NivelAcesso.fromString(resultSet.getString(COLUMN_NIVEL_ACESSO)));
                // operador.setNivelAcesso();              

            } else {

                throw new RuntimeException("Operador não encontrado");
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao recuperar objeto: "
                    + ex.getMessage());
        } catch (RuntimeException ex) {
            throw new RuntimeException("Erro ao conectar-se ao banco: "
                    + ex.getMessage());
        }
        return operador;
    }
}
