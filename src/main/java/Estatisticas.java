package main.java;

/**
 * Classe que calcula e armazena estatísticas do sistema de gamificação.
 */
public class Estatisticas {
    private SistemaGamificacao sistema;
    private int totalDesafiosCompletos;
    private int totalPontos;

    public Estatisticas(SistemaGamificacao sistema) {
        this.sistema = sistema;
    }

    public int getTotalDesafiosCompletos() {
        return totalDesafiosCompletos;
    }

    public int getTotalPontos() {
        return totalPontos;
    }

    public void calcularEstatisticas() {
        totalDesafiosCompletos = sistema.getParticipantes().stream()
                .mapToInt(p -> p.getDesafiosCompletos().size())
                .sum();
        totalPontos = sistema.getParticipantes().stream()
                .mapToInt(p -> p.getDesafiosCompletos().stream().mapToInt(Desafio::getPontos).sum())
                .sum();
    }
}
