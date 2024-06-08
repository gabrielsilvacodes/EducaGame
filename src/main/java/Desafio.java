package main.java;

public class Desafio {
    private int id;
    private String titulo;
    private String descricao;
    private int pontos;
    private Disciplina disciplina;

    public Desafio(int id, String titulo, String descricao, int pontos, Disciplina disciplina) {
        if (pontos <= 0 || disciplina == null) {
            throw new IllegalArgumentException("Pontos devem ser positivos e disciplina não pode ser nula.");
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