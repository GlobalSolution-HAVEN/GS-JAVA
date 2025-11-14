package org.example.Model;

public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String senha;
    private String telefone;
    private String dataCadastro;
    private String status;
    private String tipoUsuario;
    private String setor;

    public Usuario() {}

    public Usuario(int id, String nome, String email, String senha, String telefone,
                   String dataCadastro, String status, String tipoUsuario, String setor) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.dataCadastro = dataCadastro;
        this.status = status;
        this.tipoUsuario = tipoUsuario;
        this.setor = setor;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public String getTelefone() { return telefone; }
    public String getDataCadastro() { return dataCadastro; }
    public String getStatus() { return status; }
    public String getTipoUsuario() { return tipoUsuario; }
    public String getSetor() { return setor; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }
    public void setSenha(String senha) { this.senha = senha; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setDataCadastro(String dataCadastro) { this.dataCadastro = dataCadastro; }
    public void setStatus(String status) { this.status = status; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }
    public void setSetor(String setor) { this.setor = setor; }
}
