package br.edu.imepac.atendimento.daos;

import br.edu.imepac.atendimento.entidades.Prontuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.edu.imepac.administrativo.daos.ConexaoDao;

public class ProntuarioDao {

    public void save(Prontuario prontuario) {
        String query = "INSERT INTO Prontuario (receituario, exames, observacoes) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, prontuario.getReceituario());
            stmt.setString(2, prontuario.getExames());
            stmt.setString(3, prontuario.getObservacoes());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        prontuario.setIdProntuario(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Prontuario getById(int id) {
        String query = "SELECT * FROM Prontuario WHERE idProntuario = ?";
        Prontuario prontuario = null;

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    prontuario = new Prontuario();
                    prontuario.setIdProntuario(rs.getInt("idProntuario"));
                    prontuario.setReceituario(rs.getString("receituario"));
                    prontuario.setExames(rs.getString("exames"));
                    prontuario.setObservacoes(rs.getString("observacoes"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prontuario;
    }

    public List<Prontuario> getAll() {
        List<Prontuario> prontuarios = new ArrayList<>();
        String query = "SELECT * FROM Prontuario";

        try (Connection conn = ConexaoDao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Prontuario prontuario = new Prontuario();
                prontuario.setIdProntuario(rs.getInt("idProntuario"));
                prontuario.setReceituario(rs.getString("receituario"));
                prontuario.setExames(rs.getString("exames"));
                prontuario.setObservacoes(rs.getString("observacoes"));
                prontuarios.add(prontuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prontuarios;
    }

    public void update(Prontuario prontuario) {
        String query = "UPDATE Prontuario SET receituario = ?, exames = ?, observacoes = ? WHERE idProntuario = ?";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, prontuario.getReceituario());
            stmt.setString(2, prontuario.getExames());
            stmt.setString(3, prontuario.getObservacoes());
            stmt.setInt(4, prontuario.getIdProntuario());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String query = "DELETE FROM Prontuario WHERE idProntuario = ?";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

