package main.java;

/**
 * Classe que representa um Desafio no sistema de gamificação.
 */
public class Desafio {
    private int id;
    private String titulo;
    private String descricao;
    private int pontos;
    private Disciplina disciplina;

    public Desafio(int id, String titulo, String descricao, int pontos, Disciplina disciplina) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.pontos = pontos;
        this.disciplina = disciplina;
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

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
