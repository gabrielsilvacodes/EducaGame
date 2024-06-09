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
    private List<Disciplina> disciplinas = new ArrayList<>();
    private Estatisticas estatisticas;

    public SistemaGamificacao() {
        this.estatisticas = new Estatisticas(this);
    }

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

    public Estatisticas getEstatisticas() {
        return estatisticas;
    }

    public void atualizarEstatisticas() {
        this.estatisticas.calcularEstatisticas();
    }

    public Recompensa gerarRecompensa(Desafio desafio) {
        int pontos = desafio.getPontos();
        TipoRecompensa tipo;
        if (pontos < 50) {
            tipo = TipoRecompensa.BRONZE;
        } else if (pontos < 100) {
            tipo = TipoRecompensa.PRATA;
        } else {
            tipo = TipoRecompensa.OURO;
        }
        int idRecompensa = recompensas.size() + 1;
        Recompensa recompensa = new Recompensa(idRecompensa, "Recompensa para " + desafio.getTitulo(), tipo);
        adicionarRecompensa(recompensa);
        return recompensa;
    }
}
