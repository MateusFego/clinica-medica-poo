package br.edu.imepac.administrativo.entidades;

public class Especialidade {
    private long idEspecialidade;
    private String nomeEspecialidade;
    private String descricaoEspecialidade;
    public long getIdEspecialidade() { return idEspecialidade; }
    public void setIdEspecialidade( long idEspecialidade ) { this.idEspecialidade = idEspecialidade; }
    public String getNomeEspecialidade() { return nomeEspecialidade;}
    public void setNomeEspecialidade( String nomeEspecialidade) { this.nomeEspecialidade = nomeEspecialidade; }
    public String getDescricaoEspecialidade() { return descricaoEspecialidade; }
    public void setDescricaoEspecialidade( String descricaoEspecialidade ) { this.descricaoEspecialidade = descricaoEspecialidade;}
}
