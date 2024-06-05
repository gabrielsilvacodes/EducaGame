package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma Disciplina no sistema de gamificação.
 */
public class Disciplina {
    private int id;
    private String nome;
    private String descricao;
    private List<Desafio> desafios = new ArrayList<>();

    public Disciplina(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void adicionarDesafio(Desafio desafio) {
        desafios.add(desafio);
    }

    public List<Desafio> getDesafios() {
        return desafios;
    }
}
