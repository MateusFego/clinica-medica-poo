package br.edu.imepac.administrativo.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/clinica_medica";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private Connection conexao;

    protected Connection getConexao() {
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            return conexao;
        } catch (SQLException erro) {
            erro.printStackTrace();
            throw new RuntimeException("Erro ao conectar com o banco de dados", erro);
        } catch (ClassNotFoundException erro ) {
            throw new RuntimeException("Erro ao conectar com o banco de dados", erro );
        }
    }

    public void closeConexao() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException erro) {
                erro.printStackTrace();
            }
        }
    }
}
