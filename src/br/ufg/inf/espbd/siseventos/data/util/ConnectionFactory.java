/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.data.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alunoinf
 */
public class ConnectionFactory {

    private static ConnectionFactory instance = null;
    private Connection conexao;

    private ConnectionFactory() throws SQLException {
        conexao = DriverManager.getConnection("jdbc:mysql://localhost/eventos", "root", "h4ll");
    }

    public Connection getConnection() {
        return conexao;
    }

    public static ConnectionFactory getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionFactory();
        }

        return instance;

    }
}
