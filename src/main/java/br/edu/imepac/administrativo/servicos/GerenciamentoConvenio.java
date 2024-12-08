package br.edu.imepac.administrativo.servicos;

import br.edu.imepac.administrativo.daos.ConvenioDao;
import br.edu.imepac.administrativo.entidades.Convenio;

import java.util.List;

public class GerenciamentoConvenio {

    private ConvenioDao convenioDao;

    public GerenciamentoConvenio() {
        this.convenioDao = new ConvenioDao();
    }

    // Method to register a new insurances
    public void cadastrarConvenio(Convenio convenio) {
        if (convenio != null && convenio.getNomeConvenio() != null && !convenio.getNomeConvenio().isEmpty()) {
            convenioDao.save(convenio);
            System.out.println("Convenio cadastrado com sucesso!");
        } else {
            System.out.println("Dados do convenio invalidos.");
        }
    }

    // Method to read insurances information by ID
    public Convenio lerConvenio(long idConvenio) {
        Convenio convenio = convenioDao.getById(idConvenio);
        if (convenio != null) {
            System.out.println("Convenio encontrado: " + convenio.getNomeConvenio());
            return convenio;
        } else {
            System.out.println("Convenio nao encontrado.");
            return null;
        }
    }

    // Method to update insurances information
    public void atualizarConvenio(Convenio convenio) {
        if (convenio != null && convenio.getIdConvenio() > 0) {
            convenioDao.update(convenio);
            System.out.println("Convenio atualizado com sucesso!");
        } else {
            System.out.println("Convenio nao encontrado ou dados invalidos.");
        }
    }

    // Method to delete an insurances
    public void deletarConvenio(long idConvenio) {
        Convenio convenio = convenioDao.getById(idConvenio);
        if (convenio != null) {
            convenioDao.delete(idConvenio);
            System.out.println("Convenio deletado com sucesso!");
        } else {
            System.out.println("Convenio nao encontrado.");
        }
    }

    // Method to list all insurances
    public List<Convenio> listarConvenio() {
        List<Convenio> convenios = convenioDao.getAll();
        if (!convenios.isEmpty()) {
            for (Convenio convenio : convenios) {
                System.out.println("Convenio ID: " + convenio.getIdConvenio() + " - " + convenio.getNomeConvenio());
            }
            return convenios;
        } else {
            System.out.println("Nenhum convenio encontrado.");
            return List.of();
        }
    }
}