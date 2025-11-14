package org.example.Model;

public class Lembrete {

    private int id;
    private int idUsuario;
    private String tipoPausa;
    private String mensagem;
    private String horario;
    private String frequencia;
    private String canalEnvio;
    private int ativo;
    private String dataCriacao;

    public Lembrete() {}

    public Lembrete(int id, int idUsuario, String tipoPausa, String mensagem,
                    String horario, String frequencia, String canalEnvio,
                    int ativo, String dataCriacao) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.tipoPausa = tipoPausa;
        this.mensagem = mensagem;
        this.horario = horario;
        this.frequencia = frequencia;
        this.canalEnvio = canalEnvio;
        this.ativo = ativo;
        this.dataCriacao = dataCriacao;
    }

    public int getId() { return id; }
    public int getIdUsuario() { return idUsuario; }
    public String getTipoPausa() { return tipoPausa; }
    public String getMensagem() { return mensagem; }
    public String getHorario() { return horario; }
    public String getFrequencia() { return frequencia; }
    public String getCanalEnvio() { return canalEnvio; }
    public int getAtivo() { return ativo; }
    public String getDataCriacao() { return dataCriacao; }

    public void setId(int id) { this.id = id; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public void setTipoPausa(String tipoPausa) { this.tipoPausa = tipoPausa; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
    public void setHorario(String horario) { this.horario = horario; }
    public void setFrequencia(String frequencia) { this.frequencia = frequencia; }
    public void setCanalEnvio(String canalEnvio) { this.canalEnvio = canalEnvio; }
    public void setAtivo(int ativo) { this.ativo = ativo; }
    public void setDataCriacao(String dataCriacao) { this.dataCriacao = dataCriacao; }
}
