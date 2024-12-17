package br.edu.imepac.administrativo.servicos;

import br.edu.imepac.administrativo.daos.ConvenioDao;
import br.edu.imepac.administrativo.entidades.Convenio;

import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GerenciamentoConvenio {

    private static ConvenioDao convenioDao;

    public GerenciamentoConvenio() {
        this.convenioDao = new ConvenioDao();
    }

    // Method to register a new insurances
    public static void cadastrarConvenio(String nome, String descricao) {
        if (nome != null && descricao != null ) {
            convenioDao.save(nome, descricao);
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
    public static List<Convenio> listarConvenio() {
        return convenioDao.listarConvenio();
    }
}