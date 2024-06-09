package main.java;

/**
 * Classe que representa um Desafio no sistema de gamificação.
 */
public class Desafio {
    private final int id;
    private final String titulo;
    private final String descricao;
    private final int pontos;
    private final Disciplina disciplina;

    public Desafio(int id, String titulo, String descricao, int pontos, Disciplina disciplina) {
        if (id <= 0 || titulo == null || descricao == null || pontos <= 0 || disciplina == null) {
            throw new IllegalArgumentException("Parâmetros inválidos para criar um Desafio.");
        }
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
