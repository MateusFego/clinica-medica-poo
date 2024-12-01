package br.edu.imepac.administrativo.entidades;

public class Medico extends Funcionario {
    private String crm;
    private long idEspecialidade;
    private String nomeEspecialidade;
    private String descricaoEspecialidade;
    public String getCrm() { return crm; }
    public void setCrm( String crm ) { this.crm = crm; }
    public long getIdEspecialidade() { return idEspecialidade; }
    public void setIdEspecialidade( long idEspecialidade ) { this.idEspecialidade = idEspecialidade; }
    public String getNomeEspecialidade() { return nomeEspecialidade; }
    public void setNomeEspecialidade( String nomeEspecialidade ) { this.nomeEspecialidade = nomeEspecialidade; }
    public String getDescricaoEspecialidade() { return descricaoEspecialidade; }
    public void setDescricaoEspecialidade( String descricaoEspecialidade ) { this.descricaoEspecialidade = descricaoEspecialidade; }
}
