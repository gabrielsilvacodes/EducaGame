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
    private Recompensa recompensa;

    public Desafio(int id, String titulo, String descricao, int pontos, Disciplina disciplina, Recompensa recompensa) {
        if (id <= 0 || titulo == null || titulo.isEmpty() || descricao == null || descricao.isEmpty() || pontos <= 0) {
            throw new IllegalArgumentException("Argumentos inválidos para criar um Desafio.");
        }
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.pontos = pontos;
        this.disciplina = disciplina;
        this.recompensa = recompensa;
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

    public Recompensa getRecompensa() {
        return recompensa;
    }
}
