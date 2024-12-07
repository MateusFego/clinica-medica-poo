package br.edu.imepac.administrativo.entidades;

public class Convenio {
    private long idConvenio;
    private String nomeConvenio;
    private String descricaoConvenio;
    public Convenio(long idConvenio, String nomeConvenio, String descricaoConvenio) {
        this.idConvenio = idConvenio;
        this.nomeConvenio = nomeConvenio;
        this.descricaoConvenio = descricaoConvenio;
    }
    public long getIdConvenio() { return idConvenio; }
    public void setIdConvenio( long idConvenio ) { this. idConvenio = idConvenio; }
    public String getNomeConvenio() { return nomeConvenio; }
    public void setNomeConvenio( String nomeConvenio ) { this.nomeConvenio = nomeConvenio; }
    public String getDescricaoConvenio() { return descricaoConvenio; }
    public void setDescricaoConvenio( String descricaoConvenio ) { this.descricaoConvenio = descricaoConvenio; }
}
