package br.edu.imepac.atendimento.servicos;

import br.edu.imepac.atendimento.daos.ProntuarioDao;
import br.edu.imepac.atendimento.entidades.Prontuario;

import java.util.List;

public class GerenciamentoProntuario {

    private ProntuarioDao prontuarioDao;

    public GerenciamentoProntuario() {
        this.prontuarioDao = new ProntuarioDao();
    }

    public void cadastrarProntuario(Prontuario prontuario) {
        if (prontuario != null && prontuario.getReceituario() != null && !prontuario.getReceituario().isEmpty()) {
            prontuarioDao.save(prontuario);
            System.out.println("Prontuario cadastrado com sucesso!");
        } else {
            System.out.println("Dados do funcionario invalidos.");
        }
    }

    public Prontuario lerProntuario(long idProntuario) {
        Prontuario prontuario = prontuarioDao.getById(idProntuario);
        if (prontuario != null) {
            System.out.println("Prontuario encontrado: " + prontuario.getReceituario());
            return prontuario;
        } else {
            System.out.println("Prontuario nao encontrado.");
            return null;
        }
    }

    public void atualizarProntuario(Prontuario prontuario) {
        if (prontuario != null && prontuario.getIdProntuario() > 0) {
            prontuarioDao.update(prontuario);
            System.out.println("Prontuario atualizado com sucesso!");
        } else {
            System.out.println("Prontuario nao encontrado ou dados invalidos.");
        }
    }

    public void deletarProntuario(long idProntuario) {
        Prontuario prontuario = prontuarioDao.getById(idProntuario);
        if (prontuario != null) {
            prontuarioDao.delete(idProntuario);
            System.out.println("Prontuario deletado com sucesso!");
        } else {
            System.out.println("Prontuario nao encontrado.");
        }
    }

    public List<Prontuario> listarProntuario() {
        List<Prontuario> prontuarios = prontuarioDao.getAll();
        if (!prontuarios.isEmpty()) {
            for (Prontuario prontuario : prontuarios) {
                System.out.println("Prontuario ID: " + prontuario.getIdProntuario() + " - " + prontuario.getReceituario());
            }
            return prontuarios;
        } else {
            System.out.println("Nenhum prontuario encontrado.");
            return List.of();
        }
    }
}