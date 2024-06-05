package main.java;

/**
 * Classe base para recompensas no sistema de gamificação.
 */
public abstract class RecompensaBase {
    private int id;
    private String descricao;

    public RecompensaBase(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
