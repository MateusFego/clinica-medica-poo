package br.edu.imepac.agendamento.entidades;

import java.time.LocalDate;

public class Consulta {
    private long idConsulta;
    private LocalDate dataHorario;
    private String sintomas;
    private boolean eRetorno;
    private boolean estaAtiva;
    public long getIdConsulta() { return idConsulta; }
    public void setIdConsulta( long idConsulta ) { this.idConsulta = idConsulta; }
    public LocalDate getDataHorario() { return dataHorario; }
    public void setDataHorario( LocalDate dataHorario ) { this.dataHorario = dataHorario; }
    public String getSintomas() { return sintomas; }
    public void setSintomas( String sintomas ) { this.sintomas = sintomas; }
    public boolean getERetorno() { return eRetorno; }
    public void setERetorno( boolean eRetorno ) { this.eRetorno = eRetorno; }
    public boolean getEstaAtiva() { return estaAtiva; }
    public void setEstaAtiva( boolean estaAtiva ) { this.estaAtiva = estaAtiva; }
}
