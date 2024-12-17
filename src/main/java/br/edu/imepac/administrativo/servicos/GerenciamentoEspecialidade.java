package br.edu.imepac.administrativo.servicos;

import br.edu.imepac.administrativo.daos.EspecialidadeDao;
import br.edu.imepac.administrativo.entidades.Especialidade;
import java.util.List;

public class GerenciamentoEspecialidade {

    private EspecialidadeDao especialidadeDao;

    public GerenciamentoEspecialidade() {
        this.especialidadeDao = new EspecialidadeDao();
    }

    public void cadastrarEspecialidade(Especialidade especialidade) {
        if (especialidade != null && especialidade.getNomeEspecialidade() != null && !especialidade.getNomeEspecialidade().isEmpty()) {
            especialidadeDao.save(especialidade);
            System.out.println("Especialidade cadastrado com sucesso!");
        } else {
            System.out.println("Dados do especialidade invalidos.");
        }
    }

    public Especialidade lerEspecialidade(long idEspecialidade) {
        Especialidade especialidade = especialidadeDao.getById(idEspecialidade);
        if (especialidade != null) {
            System.out.println("Especialidade encontrado: " + especialidade.getNomeEspecialidade());
            return especialidade;
        } else {
            System.out.println("Especialidade nao encontrado.");
            return null;
        }
    }

    public void atualizarEspecialidade(Especialidade especialidade) {
        if (especialidade != null && especialidade.getIdEspecialidade() > 0) {
            especialidadeDao.update(especialidade);
            System.out.println("Especialidade atualizado com sucesso!");
        } else {
            System.out.println("Especialidade nao encontrado ou dados invalidos.");
        }
    }

    public void deletarEspecialidade(long idEspecialidade) {
        Especialidade especialidade = especialidadeDao.getById(idEspecialidade);
        if (especialidade != null) {
            especialidadeDao.delete(idEspecialidade);
            System.out.println("Especialidade deletado com sucesso!");
        } else {
            System.out.println("Especialidade nao encontrado.");
        }
    }

    public List<Especialidade> listarEspecialidade() {
        List<Especialidade> especialidades = especialidadeDao.getAll();
        if (!especialidades.isEmpty()) {
            for (Especialidade especialidade : especialidades) {
                System.out.println("Especialidade ID: " + especialidade.getIdEspecialidade() + " - " + especialidade.getNomeEspecialidade());
            }
            return especialidades;
        } else {
            System.out.println("Nenhum especialidade encontrado.");
            return List.of();
        }
    }
}
