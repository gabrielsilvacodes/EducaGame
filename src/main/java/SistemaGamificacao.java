package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe principal do sistema de gamificação.
 */
public class SistemaGamificacao {
    private final List<Desafio> desafios = new ArrayList<>();
    private final List<Recompensa> recompensas = new ArrayList<>();
    private final List<Participante> participantes = new ArrayList<>();
    private final List<Disciplina> disciplinas = new ArrayList<>();

    public void adicionarDesafio(Desafio desafio) {
        desafios.add(desafio);
    }

    public void adicionarRecompensa(Recompensa recompensa) {
        recompensas.add(recompensa);
    }

    public void adicionarParticipante(Participante participante) {
        participantes.add(participante);
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
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

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<Participante> getRanking() {
        return participantes.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getTotalPontos(), p1.getTotalPontos()))
                .collect(Collectors.toList());
    }
}
