package br.edu.imepac.agendamento.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consulta {
    private long idConsulta;
    private LocalDateTime dataHorario;
    private String sintomas;
    private boolean eRetorno;
    private boolean estaAtiva;
    public Consulta () {}
    public long getIdConsulta() { return idConsulta; }
    public void setIdConsulta( long idConsulta ) { this.idConsulta = idConsulta; }
    public LocalDateTime getDataHorario() { return dataHorario; }
    public void setDataHorario( LocalDateTime dataHorario ) { this.dataHorario = dataHorario; }
    public String getSintomas() { return sintomas; }
    public void setSintomas( String sintomas ) { this.sintomas = sintomas; }
    public boolean getERetorno() { return eRetorno; }
    public void setERetorno( boolean eRetorno ) { this.eRetorno = eRetorno; }
    public boolean getEstaAtiva() { return estaAtiva; }
    public void setEstaAtiva( boolean estaAtiva ) { this.estaAtiva = estaAtiva; }
}
