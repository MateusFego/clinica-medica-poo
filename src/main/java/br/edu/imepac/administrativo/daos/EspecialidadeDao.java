package br.edu.imepac.administrativo.daos;

import br.edu.imepac.administrativo.entidades.Especialidade;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDao {

    public void save(Especialidade especialidade) {
        String query = "INSERT INTO Especialidade (nomeEspecialidade, descricaoEspecialidade) VALUES (?, ?)";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, especialidade.getNomeEspecialidade());
            stmt.setString(2, especialidade.getDescricaoEspecialidade());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        especialidade.setIdEspecialidade(rs.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Especialidade getById(long id) {
        String query = "SELECT * FROM Especialidade WHERE idEspecialidade = ?";
        Especialidade especialidade = null;

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    especialidade = new Especialidade();
                    especialidade.setIdEspecialidade(rs.getLong("idEspecialidade"));
                    especialidade.setNomeEspecialidade(rs.getString("nomeEspecialidade"));
                    especialidade.setDescricaoEspecialidade(rs.getString("descricaoEspecialidade"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especialidade;
    }

    public List<Especialidade> getAll() {
        List<Especialidade> especialidades = new ArrayList<>();
        String query = "SELECT * FROM Especialidade";

        try (Connection conn = ConexaoDao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Especialidade especialidade = new Especialidade();
                especialidade.setIdEspecialidade(rs.getLong("idEspecialidade"));
                especialidade.setNomeEspecialidade(rs.getString("nomeEspecialidade"));
                especialidade.setDescricaoEspecialidade(rs.getString("descricaoEspecialidade"));
                especialidades.add(especialidade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especialidades;
    }

    public void update(Especialidade especialidade) {
        String query = "UPDATE Especialidade SET nomeEspecialidade = ?, descricaoEspecialidade = ? WHERE idEspecialidade = ?";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, especialidade.getNomeEspecialidade());
            stmt.setString(2, especialidade.getDescricaoEspecialidade());
            stmt.setLong(3, especialidade.getIdEspecialidade());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        String query = "DELETE FROM Especialidade WHERE idEspecialidade = ?";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
