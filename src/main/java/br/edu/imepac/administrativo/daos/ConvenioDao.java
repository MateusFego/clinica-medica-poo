package br.edu.imepac.administrativo.daos;

import br.edu.imepac.administrativo.entidades.Convenio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConvenioDao {

    public void save(Convenio convenio) {
        String query = "INSERT INTO Convenio (nomeConvenio, descricaoConvenio) VALUES (?, ?)";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, convenio.getNomeConvenio());
            stmt.setString(2, convenio.getDescricaoConvenio());

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        convenio.setIdConvenio(rs.getLong(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Convenio getById(long id) {
        String query = "SELECT * FROM Convenio WHERE idConvenio = ?";
        Convenio convenio = null;

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    convenio = new Convenio();
                    convenio.setIdConvenio(rs.getLong("idConvenio"));
                    convenio.setNomeConvenio(rs.getString("nomeConvenio"));
                    convenio.setDescricaoConvenio(rs.getString("descricaoConvenio"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return convenio;
    }

    public List<Convenio> getAll() {
        List<Convenio> convenios = new ArrayList<>();
        String query = "SELECT * FROM Convenio";

        try (Connection conn = ConexaoDao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Convenio convenio = new Convenio();
                convenio.setIdConvenio(rs.getLong("idConvenio"));
                convenio.setNomeConvenio(rs.getString("nomeConvenio"));
                convenio.setDescricaoConvenio(rs.getString("descricaoConvenio"));
                convenios.add(convenio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return convenios;
    }

    public void update(Convenio convenio) {
        String query = "UPDATE Convenio SET nomeConvenio = ?, descricaoConvenio = ? WHERE idConvenio = ?";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, convenio.getNomeConvenio());
            stmt.setString(2, convenio.getDescricaoConvenio());
            stmt.setLong(3, convenio.getIdConvenio());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        String query = "DELETE FROM Convenio WHERE idConvenio = ?";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
