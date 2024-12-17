package br.edu.imepac.administrativo.servicos;

import br.edu.imepac.administrativo.daos.ConexaoDao;
import br.edu.imepac.administrativo.entidades.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicosFrontEnd {
    // Login method
    public static String login (String usuario, String senha){
        String query = "Select * from funcionario where usuario = ? and senha = ?";
        String tipo = new String();
        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usuario);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Funcionario funcionario = new Funcionario();
                    tipo = String.valueOf(rs.getString("tipofuncionario"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipo;
    }

}

