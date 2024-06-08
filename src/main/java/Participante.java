package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Participante no sistema de gamificação.
 */
public class Participante implements Desafiavel {
    private final int id;
    private final String nome;
    private final List<Desafio> desafiosCompletos = new ArrayList<>();
    private final List<Recompensa> recompensas = new ArrayList<>();

    public Participante(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public void completarDesafio(Desafio desafio) {
        desafiosCompletos.add(desafio);
    }

    public void adicionarRecompensa(Recompensa recompensa) {
        recompensas.add(recompensa);
    }

    public List<Desafio> getDesafiosCompletos() {
        return desafiosCompletos;
    }

    public List<Recompensa> getRecompensas() {
        return recompensas;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void aceitarDesafio(Desafio desafio) {
        completarDesafio(desafio);
        Recompensa recompensa = new Recompensa(desafio.getId(), "Recompensa por completar o desafio: " + desafio.getTitulo(), calcularTipoRecompensa(desafio.getPontos()));
        adicionarRecompensa(recompensa);
    }

    private TipoRecompensa calcularTipoRecompensa(int pontos) {
        if (pontos < 50) {
            return TipoRecompensa.BRONZE;
        } else if (pontos < 100) {
            return TipoRecompensa.PRATA;
        } else {
            return TipoRecompensa.OURO;
        }
    }

    public void removerDesafio(Desafio desafio) {
        desafiosCompletos.remove(desafio);
    }

    public void removerRecompensa(Recompensa recompensa) {
        recompensas.remove(recompensa);
    }
}
