package main.java;

import java.util.ArrayList;
import java.util.List;

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

    public List<Desafio> getDesafios() {
        return desafios;
    }

    public List<Recompensa> getRecompensas() {
        return recompensas;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void removerDesafio(Desafio desafio) {
        desafios.remove(desafio);
    }

    public void removerRecompensa(Recompensa recompensa) {
        recompensas.remove(recompensa);
    }

    public void removerParticipante(Participante participante) {
        participantes.remove(participante);
    }

    public void removerDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }
}
