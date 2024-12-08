package br.edu.imepac.agendamento.servicos;

import br.edu.imepac.agendamento.daos.ConsultaDao;
import br.edu.imepac.agendamento.entidades.Consulta;

import java.util.List;

public class GerenciamentoConsulta {

    private ConsultaDao consultaDao;

    public GerenciamentoConsulta() {
        this.consultaDao = new ConsultaDao();
    }

    // Cadastrar consulta
    public void cadastrarConsulta(Consulta consulta) {
        if (consulta != null && consulta.getDataHorario() != null) {  // Check if DataHorario is not null
            consultaDao.save(consulta);
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
    public List<Consulta> listarConsulta() {
        List<Consulta> consultas = consultaDao.getAll();
        if (!consultas.isEmpty()) {
            for (Consulta consulta : consultas) {
                System.out.println("Consulta ID: " + consulta.getIdConsulta() + " - Data: " + consulta.getDataHorario());  // Displaying DataHorario
            }
            return consultas;
        } else {
            System.out.println("Nenhuma consulta encontrada.");
            return List.of();
        }
    }
}
