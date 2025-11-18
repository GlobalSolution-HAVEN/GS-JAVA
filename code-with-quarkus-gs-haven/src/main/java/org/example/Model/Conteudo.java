package org.example.Model;

public class Conteudo {

    private int id;
    private String titulo;
    private String tipo;
    private String categoria;
    private String url;
    private int duracaoSegundos;
    private String dificuldade;
    private String foco;
    private String idioma;
    private int ativo;

    public Conteudo() {}

    public Conteudo(int id, String titulo, String tipo, String categoria, String url,
                    int duracaoSegundos, String dificuldade, String foco, String idioma, int ativo) {
        this.id = id;
        this.titulo = titulo;
        this.tipo = tipo;
        this.categoria = categoria;
        this.url = url;
        this.duracaoSegundos = duracaoSegundos;
        this.dificuldade = dificuldade;
        this.foco = foco;
        this.idioma = idioma;
        this.ativo = ativo;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getTipo() { return tipo; }
    public String getCategoria() { return categoria; }
    public String getUrl() { return url; }
    public int getDuracaoSegundos() { return duracaoSegundos; }
    public String getDificuldade() { return dificuldade; }
    public String getFoco() { return foco; }
    public String getIdioma() { return idioma; }
    public int getAtivo() { return ativo; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setUrl(String url) { this.url = url; }
    public void setDuracaoSegundos(int duracaoSegundos) { this.duracaoSegundos = duracaoSegundos; }
    public void setDificuldade(String dificuldade) { this.dificuldade = dificuldade; }
    public void setFoco(String foco) { this.foco = foco; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public void setAtivo(int ativo) { this.ativo = ativo; }
}
