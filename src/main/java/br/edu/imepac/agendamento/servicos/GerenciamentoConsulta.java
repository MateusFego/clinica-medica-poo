package br.edu.imepac.agendamento.servicos;

import br.edu.imepac.agendamento.daos.ConsultaDao;
import br.edu.imepac.agendamento.entidades.Consulta;

import java.util.List;

public class GerenciamentoConsulta {

    private static ConsultaDao consultaDao;

    public GerenciamentoConsulta() {
        this.consultaDao = new ConsultaDao();
    }

    // Cadastrar consulta
    public static void cadastrarConsulta(String data, String horario, String sintomas, Boolean retorno, Boolean ativa) {
        if (data != null && horario != null) {  // Check if DataHorario is not null
            consultaDao.save( data, horario, sintomas, retorno, ativa);
            System.out.println("Consulta cadastrada com sucesso!");
        } else {
            System.out.println("Dados da consulta inválidos.");
        }
    }

    // Ler consulta
    public Consulta lerConsulta(long idConsulta) {
        Consulta consulta = consultaDao.getById(idConsulta);
        if (consulta != null) {
            System.out.println("Consulta encontrada: " + consulta.getDataHorario()); // Displaying DataHorario
            return consulta;
        } else {
            System.out.println("Consulta não encontrada.");
            return null;
        }
    }

    // Atualizar consulta
    public void atualizarConsulta(Consulta consulta) {
        if (consulta != null && consulta.getIdConsulta() > 0) {  // Using getIdConsulta() to validate
            consultaDao.update(consulta);
            System.out.println("Consulta atualizada com sucesso!");
        } else {
            System.out.println("Consulta não encontrada ou dados inválidos.");
        }
    }

    // Deletar consulta
    public void deletarConsulta(long idConsulta) {
        Consulta consulta = consultaDao.getById(idConsulta);
        if (consulta != null) {
            consultaDao.delete(idConsulta);
            System.out.println("Consulta deletada com sucesso!");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }

    // Listar consultas
    public static List<Consulta> listarConsulta() {
        return consultaDao.getAll();
    }
}
