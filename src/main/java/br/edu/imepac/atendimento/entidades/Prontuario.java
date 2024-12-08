package br.edu.imepac.atendimento.entidades;

public class Prontuario {
    private long idProntuario;         // ID of the medical record
    private String receituario;       // Prescription from the consultation
    private String exames;            // Required exams for the patient
    private String observacoes;       // General observations for the patient

    // Constructor to initialize the Prontuario object
    public Prontuario(int idProntuario, String receituario, String exames, String observacoes) {
        this.idProntuario = idProntuario;
        this.receituario = receituario;
        this.exames = exames;
        this.observacoes = observacoes;
    }

    public Prontuario() {}
    public long getIdProntuario() { return idProntuario; }
    public void setIdProntuario(long idProntuario) { this.idProntuario = idProntuario; }
    public String getReceituario() { return receituario; }
    public void setReceituario(String receituario) { this.receituario = receituario; }
    public String getExames() { return exames; }
    public void setExames(String exames) { this.exames = exames; }
    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
