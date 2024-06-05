package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal do sistema de gamificação.
 */
public class SistemaGamificacao {
    private List<Desafio> desafios = new ArrayList<>();
    private List<Recompensa> recompensas = new ArrayList<>();
    private List<Participante> participantes = new ArrayList<>();

    public void adicionarDesafio(Desafio desafio) {
        desafios.add(desafio);
    }

    public void adicionarRecompensa(Recompensa recompensa) {
        recompensas.add(recompensa);
    }

    public void adicionarParticipante(Participante participante) {
        participantes.add(participante);
    }

    public List<Desafio> getDesafios() {
        return desafios;
    }

    public List<Recompensa> getRecompensas() {
        return recompensas;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }
}
