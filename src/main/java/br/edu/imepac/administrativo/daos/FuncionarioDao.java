package br.edu.imepac.administrativo.daos;

import br.edu.imepac.administrativo.entidades.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.edu.imepac.administrativo.entidades.EnumTipoFuncionario;
import br.edu.imepac.administrativo.entidades.Paciente;

public class FuncionarioDao {

    public static void save(String usuario, String senha, String nome, int idade, String sexo, String cpf, String rua, String numero, String bairro, String cidade, String estado, String contato, String email, String enumTipoFuncionario) {
        String query = "INSERT INTO funcionario (usuario, senha, nome, idade, sexo, cpf, rua, numero, bairro, cidade, estado, contato, email, tipoFuncionario) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            stmt.setString(3, nome);
            stmt.setInt(4, idade);
            stmt.setString(5, sexo);
            stmt.setString(6, cpf);
            stmt.setString(7, rua);
            stmt.setString(8, numero);
            stmt.setString(9, bairro);
            stmt.setString(10, cidade);
            stmt.setString(11, estado);
            stmt.setString(12, contato);
            stmt.setString(13, email);
            stmt.setString(14, enumTipoFuncionario);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        Funcionario funcionario = new Funcionario();
                        funcionario.setId(rs.getLong(1));  // Set the generated ID
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Funcionario getById(long id) {
        String query = "SELECT * FROM funcionario WHERE id = ?";
        Funcionario funcionario = null;

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    funcionario = new Funcionario();
                    funcionario.setId(rs.getLong("id"));
                    funcionario.setUsuario(rs.getString("usuario"));
                    funcionario.setSenha(rs.getString("senha"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setIdade(rs.getInt("idade"));
                    funcionario.setSexo(rs.getString("sexo").charAt(0));
                    funcionario.setCpf(rs.getString("cpf"));
                    funcionario.setRua(rs.getString("rua"));
                    funcionario.setNumero(rs.getString("numero"));
                    funcionario.setComplemento(rs.getString("complemento"));
                    funcionario.setBairro(rs.getString("bairro"));
                    funcionario.setCidade(rs.getString("cidade"));
                    funcionario.setEstado(rs.getString("estado"));
                    funcionario.setContato(rs.getString("contato"));
                    funcionario.setEmail(rs.getString("email"));
                    funcionario.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                    funcionario.setEnumTipoFuncionario(EnumTipoFuncionario.valueOf(rs.getString("tipoFuncionario")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }

    public static List<Funcionario> getAll() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "SELECT * FROM funcionario";

        try (Connection conn = ConexaoDao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getLong("id"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setSexo(rs.getString("sexo").charAt(0));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setRua(rs.getString("rua"));
                funcionario.setNumero(rs.getString("numero"));
                funcionario.setComplemento(rs.getString("complemento"));
                funcionario.setBairro(rs.getString("bairro"));
                funcionario.setCidade(rs.getString("cidade"));
                funcionario.setEstado(rs.getString("estado"));
                funcionario.setContato(rs.getString("contato"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                funcionario.setEnumTipoFuncionario(EnumTipoFuncionario.valueOf(rs.getString("tipoFuncionario")));
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    public void update(Funcionario funcionario) {
        String query = "UPDATE funcionario SET usuario = ?, senha = ?, nome = ?, idade = ?, sexo = ?, cpf = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, contato = ?, email = ?, dataNascimento = ?, tipoFuncionario = ? WHERE id = ?";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, funcionario.getUsuario());
            stmt.setString(2, funcionario.getSenha());
            stmt.setString(3, funcionario.getNome());
            stmt.setInt(4, funcionario.getIdade());
            stmt.setString(5, String.valueOf(funcionario.getSexo()));
            stmt.setString(6, funcionario.getCpf());
            stmt.setString(7, funcionario.getRua());
            stmt.setString(8, funcionario.getNumero());
            stmt.setString(9, funcionario.getComplemento());
            stmt.setString(10, funcionario.getBairro());
            stmt.setString(11, funcionario.getCidade());
            stmt.setString(12, funcionario.getEstado());
            stmt.setString(13, funcionario.getContato());
            stmt.setString(14, funcionario.getEmail());
            stmt.setDate(15, Date.valueOf(funcionario.getDataNascimento()));
            stmt.setString(16, funcionario.getEnumTipoFuncionario().toString());
            stmt.setLong(17, funcionario.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        String query = "DELETE FROM funcionario WHERE id = ?";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

