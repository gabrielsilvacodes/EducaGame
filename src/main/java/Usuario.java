package main.java;

/**
 * Classe que representa um Usuário no sistema de gamificação.
 */
public class Usuario {
    private final int id;
    private final String nome;

    public Usuario(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
