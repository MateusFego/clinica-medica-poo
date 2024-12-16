package br.edu.imepac.administrativo.servicos;

import br.edu.imepac.administrativo.daos.FuncionarioDao;
import br.edu.imepac.administrativo.entidades.Funcionario;
import br.edu.imepac.administrativo.entidades.EnumTipoFuncionario;

import java.util.List;
import java.util.ArrayList;

public class GerenciamentoFuncionario {

    private static FuncionarioDao funcionarioDao = new FuncionarioDao();

    public GerenciamentoFuncionario() {
        this.funcionarioDao = new FuncionarioDao();
    }

    // Method to register a new employee
    public static void cadastrarFuncionario(String usuario, String senha, String nome, int idade, String sexo, String cpf, String rua, String numero, String bairro, String cidade, String estado, String contato, String email, String enumTipoFuncionario) {
        if (usuario != null && senha != null && nome != null) {
            FuncionarioDao.save(usuario, senha, nome, idade, sexo, cpf, rua, numero, bairro, cidade, estado, contato, email, enumTipoFuncionario);
            System.out.println("Funcionario cadastrado com sucesso!");
        } else {
            System.out.println("Dados do funcionario invalidos.");
        }
    }

    public static void editarFuncionario(Long idfuncionario, String usuario, String senha, String nome, int idade, String sexo, String cpf, String rua, String numero, String bairro, String cidade, String estado, String contato, String email, String enumTipoFuncionario) {
        if (idfuncionario!= null && usuario != null && senha != null && nome != null) {
            Funcionario funcionario;
            if(enumTipoFuncionario.equals("ATENDENTE")){
            funcionario = new Funcionario(idfuncionario, usuario, senha, nome, idade, sexo, cpf, rua, numero, bairro, cidade, estado, contato, email, EnumTipoFuncionario.ATENDENTE);
                FuncionarioDao.update(funcionario);
            }else if(enumTipoFuncionario.equals("MEDICO")){
            funcionario = new Funcionario(idfuncionario, usuario, senha, nome, idade, sexo, cpf, rua, numero, bairro, cidade, estado, contato, email, EnumTipoFuncionario.MEDICO);
                FuncionarioDao.update(funcionario);
            }else if(enumTipoFuncionario.equals("ADMINISTRADOR")){
            funcionario = new Funcionario(idfuncionario, usuario, senha, nome, idade, sexo, cpf, rua, numero, bairro, cidade, estado, contato, email, EnumTipoFuncionario.ADMINISTRADOR);
                FuncionarioDao.update(funcionario);
            }
            System.out.println("Funcionario cadastrado com sucesso!");
        } else {
            System.out.println("Dados do funcionario invalidos.");
        }

    }

    // Method to read employee information by ID
    public static Funcionario buscarFuncionario(long idFuncionario) {
        Funcionario funcionario = funcionarioDao.getById(idFuncionario);
        if (funcionario != null) {
            System.out.println("Funcionario encontrado: " + funcionario.getNome());
            return funcionario;
        } else {
            System.out.println("Funcionario nao encontrado.");
            return null;
        }
    }

    // Method to update employee information
    public void atualizarFuncionario(Funcionario funcionario) {
        if (funcionario != null && funcionario.getId() > 0) {
            funcionarioDao.update(funcionario);
            System.out.println("Funcionario atualizado com sucesso!");
        } else {
            System.out.println("Funcionario nao encontrado ou dados invalidos.");
        }
    }

    // Method to delete an employee
    public void deletarFuncionario(long idFuncionario) {
        Funcionario funcionario = funcionarioDao.getById(idFuncionario);
        if (funcionario != null) {
            funcionarioDao.delete(idFuncionario);
            System.out.println("Funcionario deletado com sucesso!");
        } else {
            System.out.println("Funcionario nao encontrado.");
        }
    }

    // Method to list all employees
    public static List<Funcionario> listarFuncionario() {
        return FuncionarioDao.getAll();
    }

    // Helper method to list employees by type (ADMINISTRADOR, ATENDENTE, MEDICO)
    public List<Funcionario> listarFuncionarioPorTipo(EnumTipoFuncionario tipoFuncionario) {
        List<Funcionario> funcionarios = funcionarioDao.getAll();
        List<Funcionario> filteredFuncionarios = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getEnumTipoFuncionario() == tipoFuncionario) {
                filteredFuncionarios.add(funcionario);
            }
        }
        if (!filteredFuncionarios.isEmpty()) {
            for (Funcionario funcionario : filteredFuncionarios) {
                System.out.println("Funcionario ID: " + funcionario.getId() + " - " + funcionario.getNome() + " - Tipo: " + tipoFuncionario);
            }
            return filteredFuncionarios;
        } else {
            System.out.println("Nenhum funcionario do tipo " + tipoFuncionario + " encontrado.");
            return List.of();
        }
    }
}