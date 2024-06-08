package main.java;

/**
 * Classe base para recompensas no sistema de gamificação.
 */
public abstract class RecompensaBase {
    private final int id;
    private final String descricao;

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
