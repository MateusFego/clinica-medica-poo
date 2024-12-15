package br.edu.imepac.administrativo.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Funcionario {
    private long id;
    private String usuario;
    private String senha;
    private String nome;
    private int idade;
    private char sexo;
    private String cpf;
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String contato;
    private String email;
    private LocalDate dataNascimento;
    EnumTipoFuncionario enumTipoFuncionario;
    private List<Especialidade> especialidades;
    public Funcionario(long id, String usuario, String senha, String nome, int idade, char sexo,
                       String cpf, String rua, String numero, String complemento, String bairro,
                       String cidade, String estado, String contato, String email, LocalDate dataNascimento,
                       EnumTipoFuncionario enumTipoFuncionario) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.contato = contato;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.enumTipoFuncionario = enumTipoFuncionario;
        this.especialidades = new ArrayList<>();
    }
    public Funcionario() {}
    public long getId() { return id; }
    public void setId( long id ) { this.id = id; }
    public String getUsuario() { return usuario; }
    public void setUsuario( String usuario ) { this.usuario = usuario; }
    public String getSenha() { return senha; }
    public void setSenha( String senha ) { this.senha = senha; }
    public String getNome() { return nome; }
    public void setNome( String nome ) { this.nome = nome; }
    public int getIdade() { return idade; }
    public void setIdade( int idade) { this.idade = idade; }
    public char getSexo() { return sexo; }
    public void setSexo( char sexo ) { this.sexo = sexo; }
    public String getCpf() { return cpf; }
    public void setCpf( String cpf ) { this.cpf = cpf; }
    public String getRua() { return rua; }
    public void setRua( String rua) { this.rua = rua; }
    public String getNumero() { return numero; }
    public void setNumero( String numero ) { this.numero = numero; }
    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento ) { this.complemento = complemento; }
    public String getBairro() { return bairro; }
    public void setBairro( String bairro) { this.bairro = bairro; }
    public String getCidade() { return cidade; }
    public void setCidade( String cidade ) { this.cidade = cidade; }
    public String getEstado() { return estado; }
    public void setEstado( String estado) { this.estado = estado; }
    public String getContato() { return contato; }
    public void setContato( String contato ) { this.contato = contato; }
    public String getEmail() { return email; }
    public void setEmail( String email) { this.email = email; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }
    public EnumTipoFuncionario getEnumTipoFuncionario() { return enumTipoFuncionario; }
    public void setEnumTipoFuncionario( EnumTipoFuncionario enumTipoFuncionario ) { this.enumTipoFuncionario = enumTipoFuncionario; }
    public List<Especialidade> getEspecialidades() { return especialidades; }
    public void setEspecialidades(List<Especialidade> especialidades) { this.especialidades = especialidades; }
    public void addEspecialidade(Especialidade especialidade) { this.especialidades.add(especialidade); }
    public void removeEspecialidade(Especialidade especialidade) { this.especialidades.remove(especialidade); }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", sexo=" + sexo +
                ", cpf='" + cpf + '\'' +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", contato='" + contato + '\'' +
                ", email='" + email + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", enumTipoFuncionario=" + enumTipoFuncionario +
                ", especialidades=" + especialidades +
                '}';
    }
}
