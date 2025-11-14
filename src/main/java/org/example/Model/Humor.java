package org.example.Model;

public class Humor {

    private int id;
    private int idUsuario;
    private int nivelHumor;
    private int nivelEnergia;
    private String sentimento;
    private String observacao;
    private String dataRegistro;
    private String periodoDia;
    private String origemRegistro;

    public Humor() {}

    public Humor(int id, int idUsuario, int nivelHumor, int nivelEnergia, String sentimento,
                 String observacao, String dataRegistro, String periodoDia, String origemRegistro) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.nivelHumor = nivelHumor;
        this.nivelEnergia = nivelEnergia;
        this.sentimento = sentimento;
        this.observacao = observacao;
        this.dataRegistro = dataRegistro;
        this.periodoDia = periodoDia;
        this.origemRegistro = origemRegistro;
    }

    public int getId() { return id; }
    public int getIdUsuario() { return idUsuario; }
    public int getNivelHumor() { return nivelHumor; }
    public int getNivelEnergia() { return nivelEnergia; }
    public String getSentimento() { return sentimento; }
    public String getObservacao() { return observacao; }
    public String getDataRegistro() { return dataRegistro; }
    public String getPeriodoDia() { return periodoDia; }
    public String getOrigemRegistro() { return origemRegistro; }

    public void setId(int id) { this.id = id; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
    public void setNivelHumor(int nivelHumor) { this.nivelHumor = nivelHumor; }
    public void setNivelEnergia(int nivelEnergia) { this.nivelEnergia = nivelEnergia; }
    public void setSentimento(String sentimento) { this.sentimento = sentimento; }
    public void setObservacao(String observacao) { this.observacao = observacao; }
    public void setDataRegistro(String dataRegistro) { this.dataRegistro = dataRegistro; }
    public void setPeriodoDia(String periodoDia) { this.periodoDia = periodoDia; }
    public void setOrigemRegistro(String origemRegistro) { this.origemRegistro = origemRegistro; }
}
