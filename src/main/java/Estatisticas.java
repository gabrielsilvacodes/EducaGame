package main.java;

/**
 * Classe que calcula e armazena estatísticas do sistema de gamificação.
 */
public class Estatisticas {
    private final SistemaGamificacao sistema;

    public Estatisticas(SistemaGamificacao sistema) {
        this.sistema = sistema;
    }

    public int getTotalDesafiosCompletos() {
        return sistema.getParticipantes().stream()
                .mapToInt(p -> p.getDesafiosCompletos().size())
                .sum();
    }

    public int getTotalPontos() {
        return sistema.getParticipantes().stream()
                .mapToInt(p -> p.getDesafiosCompletos().stream().mapToInt(Desafio::getPontos).sum())
                .sum();
    }

    public void imprimirEstatisticasParticipantes() {
        System.out.println("Total de desafios completos: " + getTotalDesafiosCompletos());
        System.out.println("Total de pontos: " + getTotalPontos());
    }
}
