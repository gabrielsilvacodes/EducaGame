package main.java;

/**
 * Classe que representa uma Recompensa no sistema de gamificação.
 */
public class Recompensa extends RecompensaBase {
    private TipoRecompensa tipo;

    public Recompensa(int id, String descricao, TipoRecompensa tipo) {
        super(id, descricao);
        this.tipo = tipo;
    }

    public TipoRecompensa getTipo() {
        return tipo;
    }
}
