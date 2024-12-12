package br.edu.imepac.agendamento.daos;

import br.edu.imepac.agendamento.entidades.Consulta;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import br.edu.imepac.administrativo.daos.ConexaoDao;

public class ConsultaDao {

    public static void save(String data, String horario, String sintomas, Boolean retorno, Boolean ativa) {
        String query = "INSERT INTO Consulta (dataHorario, sintomas, eRetorno, estaAtiva) VALUES (?, ?, ?, ?)";
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            LocalDate date = LocalDate.parse(data, dataFormatter);
            LocalTime hora = LocalTime.parse(horario, horaFormatter);
            LocalDateTime dateTime = LocalDateTime.of(date, hora);
            DateTimeFormatter dbFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String dateTimeString = dateTime.format(dbFormatter);
            stmt.setString(1, dateTimeString);
            stmt.setString(2, sintomas);
            stmt.setBoolean(3, retorno);
            stmt.setBoolean(4, ativa);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        Consulta consulta = new Consulta();
                        long consultaId = rs.getLong(1);
                        consulta.setIdConsulta(consultaId);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Consulta getById(long id) {
        String query = "SELECT * FROM Consulta WHERE idConsulta = ?";
        Consulta consulta = null;

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    consulta = new Consulta();
                    consulta.setIdConsulta(rs.getLong("idConsulta"));
                    consulta.setDataHorario(rs.getDate("dataHorario").toLocalDate());
                    consulta.setSintomas(rs.getString("sintomas"));
                    consulta.setERetorno(rs.getBoolean("eRetorno"));
                    consulta.setEstaAtiva(rs.getBoolean("estaAtiva"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;
    }

    public List<Consulta> getAll() {
        List<Consulta> consultas = new ArrayList<>();
        String query = "SELECT * FROM Consulta";

        try (Connection conn = ConexaoDao.getConexao();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setIdConsulta(rs.getLong("idConsulta"));
                consulta.setDataHorario(rs.getDate("dataHorario").toLocalDate());
                consulta.setSintomas(rs.getString("sintomas"));
                consulta.setERetorno(rs.getBoolean("eRetorno"));
                consulta.setEstaAtiva(rs.getBoolean("estaAtiva"));
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }

    public void update(Consulta consulta) {
        String query = "UPDATE Consulta SET dataHorario = ?, sintomas = ?, eRetorno = ?, estaAtiva = ? WHERE idConsulta = ?";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setDate(1, Date.valueOf(consulta.getDataHorario()));
            stmt.setString(2, consulta.getSintomas());
            stmt.setBoolean(3, consulta.getERetorno());
            stmt.setBoolean(4, consulta.getEstaAtiva());
            stmt.setLong(5, consulta.getIdConsulta());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(long id) {
        String query = "DELETE FROM Consulta WHERE idConsulta = ?";

        try (Connection conn = ConexaoDao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

