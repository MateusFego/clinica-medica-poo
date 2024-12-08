package br.edu.imepac.administrativo.servicos;

import br.edu.imepac.administrativo.daos.PacienteDao;
import br.edu.imepac.administrativo.entidades.Paciente;

import java.util.List;

public class GerenciamentoPaciente {

    private PacienteDao pacienteDao;

    public GerenciamentoPaciente() {
        this.pacienteDao = new PacienteDao();
    }

    // Method to register a new pacient
    public void cadastrarPaciente(Paciente paciente) {
        if (paciente != null && paciente.getNome() != null && !paciente.getNome().isEmpty()) {
            pacienteDao.save(paciente);
            System.out.println("Paciente cadastrado com sucesso!");
        } else {
            System.out.println("Dados do paciente invalidos.");
        }
    }

    // Method to read pacient information by ID
    public Paciente lerPaciente(long idPaciente) {
        Paciente paciente = pacienteDao.getById(idPaciente);
        if (paciente != null) {
            System.out.println("Paciente encontrado: " + paciente.getNome());
            return paciente;
        } else {
            System.out.println("Paciente nao encontrado.");
            return null;
        }
    }

    // Method to update pacient information
    public void atualizarPaciente(Paciente paciente) {
        if (paciente != null && paciente.getId() > 0) {
            pacienteDao.update(paciente);
            System.out.println("Paciente atualizado com sucesso!");
        } else {
            System.out.println("Paciente nao encontrado ou dados invalidos.");
        }
    }

    // Method to delete an pacient
    public void deletarPaciente(long idPaciente) {
        Paciente paciente = pacienteDao.getById(idPaciente);
        if (paciente != null) {
            pacienteDao.delete(idPaciente);
            System.out.println("Paciente deletado com sucesso!");
        } else {
            System.out.println("Paciente nao encontrado.");
        }
    }

    // Method to list all pacients
    public List<Paciente> listarPaciente() {
        List<Paciente> pacientes = pacienteDao.getAll();
        if (!pacientes.isEmpty()) {
            for (Paciente paciente : pacientes) {
                System.out.println("Paciente ID: " + paciente.getId() + " - " + paciente.getNome());
            }
            return pacientes;
        } else {
            System.out.println("Nenhum paciente encontrado.");
            return List.of();
        }
    }
}
