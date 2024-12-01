package br.edu.imepac.atendimento.entidades;

public class Prontuario {
    private long idProntuario;
    private String receituario;
    private String exames;
    private String observacoes;
    public long getIdProntuario() { return idProntuario; }
    public void setIdProntuario( long idProntuario ) { this.idProntuario = idProntuario;}
    public String getReceituario() { return receituario; }
    public void setReceituario( String receituario) { this.receituario = receituario;}
    public String getExames() { return exames; }
    public void setExames( String exames ) { this.exames = exames;}
    public String getObservacoes() { return observacoes; }
    public void setObservacoes( String observacoes ) { this.observacoes = observacoes;}
}
