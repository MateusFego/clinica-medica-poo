package br.edu.imepac.administrativo.servicos;

import br.edu.imepac.administrativo.daos.PacienteDao;
import br.edu.imepac.administrativo.entidades.Funcionario;
import br.edu.imepac.administrativo.entidades.Paciente;

import java.util.List;

public class GerenciamentoPaciente {

    private static PacienteDao pacienteDao;

    public GerenciamentoPaciente() {
        this.pacienteDao = new PacienteDao();
    }

    // Method to register a new pacient
    public static void cadastrarPaciente(String nome, int idade, String sexo, String cpf, String rua, String numero, String complemento, String bairro, String cidade, String estado, String contato, String email) {
        if (nome != null && cpf != null) {
            pacienteDao.cadastrarPaciente(nome, idade, sexo, cpf, rua, numero, complemento, bairro, cidade, estado, contato, email);
            System.out.println("Paciente cadastrado com sucesso!");
        } else {
            System.out.println("Dados do paciente invalidos.");
        }
    }

    // Method to read pacient information by ID
    public static Paciente buscarPaciente(long idPaciente) {
        Paciente paciente = PacienteDao.getById(idPaciente);
        if (paciente != null) {
            System.out.println("Funcionario encontrado: " + paciente.getNome());
            return paciente;
        } else {
            System.out.println("Funcionario nao encontrado.");
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
    public static List<Paciente> listarPaciente() {
        return PacienteDao.getAll();
    }
}
