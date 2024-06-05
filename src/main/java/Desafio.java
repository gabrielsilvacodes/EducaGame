package main.java;

/**
 * Classe que representa um desafio no sistema de gamificação.
 */
public class Desafio {
    private int id;
    private String titulo;
    private String descricao;
    private int pontos;

    public Desafio(int id, String titulo, String descricao, int pontos) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.pontos = pontos;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}