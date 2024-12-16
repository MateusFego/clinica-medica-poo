package br.edu.imepac.administrativo.daos;

import br.edu.imepac.administrativo.entidades.Paciente;
import br.edu.imepac.agendamento.entidades.Consulta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {

    public static void cadastrarPaciente( String nome, int idade, String sexo, String cpf, String rua, String numero, String complemento, String bairro, String cidade, String estado, String contato, String email) {
        String query = "INSERT INTO paciente (nome, idade, sexo, cpf, rua, numero, complemento, bairro, cidade, estado, contato, email) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setString(3, sexo);
            stmt.setString(4, cpf);
            stmt.setString(5, rua);
            stmt.setString(6, numero);
            stmt.setString(7, complemento);
            stmt.setString(8, bairro);
            stmt.setString(9, cidade);
            stmt.setString(10, estado);
            stmt.setString(11, contato);
            stmt.setString(12, email);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        Paciente paciente = new Paciente();
                        paciente.setId(rs.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Paciente getById(long id) {
        String query = "SELECT * FROM paciente WHERE id = ?";
        Paciente paciente = null;

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    paciente = new Paciente();
                    paciente.setId(rs.getLong("id"));
                    paciente.setNome(rs.getString("nome"));
                    paciente.setIdade(rs.getInt("idade"));
                    paciente.setSexo(rs.getString("sexo").charAt(0));
                    paciente.setCpf(rs.getString("cpf"));
                    paciente.setRua(rs.getString("rua"));
                    paciente.setNumero(rs.getString("numero"));
                    paciente.setComplemento(rs.getString("complemento"));
                    paciente.setBairro(rs.getString("bairro"));
                    paciente.setCidade(rs.getString("cidade"));
                    paciente.setEstado(rs.getString("estado"));
                    paciente.setContato(rs.getString("contato"));
                    paciente.setEmail(rs.getString("email"));
                    paciente.setDataNascimento(rs.getDate("dataNascimento").toLocalDate());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    public static List<Paciente> getAll() {
        List<Paciente> pacientes = new ArrayList<>();
        String query = "SELECT * FROM paciente";

        try (Connection conn = ConexaoDao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getLong("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setIdade(rs.getInt("idade"));
                paciente.setSexo(rs.getString("sexo").charAt(0));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setRua(rs.getString("rua"));
                paciente.setNumero(rs.getString("numero"));
                paciente.setComplemento(rs.getString("complemento"));
                paciente.setBairro(rs.getString("bairro"));
                paciente.setCidade(rs.getString("cidade"));
                paciente.setEstado(rs.getString("estado"));
                paciente.setContato(rs.getString("contato"));
                paciente.setEmail(rs.getString("email"));
                paciente.setDataNascimento(null);
                pacientes.add(paciente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public void update(Paciente paciente) {
        String query = "UPDATE paciente SET nome = ?, idade = ?, sexo = ?, cpf = ?, rua = ?, numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, contato = ?, email = ?, dataNascimento = ? WHERE id = ?";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, paciente.getNome());
            stmt.setInt(2, paciente.getIdade());
            stmt.setString(3, String.valueOf(paciente.getSexo()));
            stmt.setString(4, paciente.getCpf());
            stmt.setString(5, paciente.getRua());
            stmt.setString(6, paciente.getNumero());
            stmt.setString(7, paciente.getComplemento());
            stmt.setString(8, paciente.getBairro());
            stmt.setString(9, paciente.getCidade());
            stmt.setString(10, paciente.getEstado());
            stmt.setString(11, paciente.getContato());
            stmt.setString(12, paciente.getEmail());
            stmt.setDate(13, Date.valueOf(paciente.getDataNascimento()));
            stmt.setLong(14, paciente.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        String query = "DELETE FROM paciente WHERE id = ?";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

