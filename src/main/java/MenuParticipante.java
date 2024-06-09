package main.java;

import java.util.List;
import java.util.Scanner;

public class MenuParticipante {
    public static void exibirMenu(SistemaGamificacao sistema, Scanner scanner) {
        System.out.print("Digite o ID do participante: ");
        int idParticipante = MenuPrincipal.obterOpcao(scanner);
        scanner.nextLine(); // Consume newline

        Participante participante = sistema.getParticipantes().stream()
                .filter(p -> p.getId() == idParticipante)
                .findFirst()
                .orElse(null);

        if (participante == null) {
            System.out.println("Participante não encontrado.");
            return;
        }

        while (true) {
            System.out.println("Menu Participante - " + participante.getNome() + ":");
            System.out.println("1. Visualizar Desafios Completos");
            System.out.println("2. Visualizar Recompensas");
            System.out.println("3. Aceitar Desafio");
            System.out.println("4. Visualizar Ranking");
            System.out.println("0. Voltar ao Menu Principal");

            int opcao = MenuPrincipal.obterOpcao(scanner);

            switch (opcao) {
                case 1:
                    System.out.println("Desafios Completos:");
                    for (Desafio desafio : participante.getDesafiosCompletos()) {
                        System.out.println("- " + desafio.getTitulo());
                    }
                    break;
                case 2:
                    System.out.println("Recompensas:");
                    for (Recompensa recompensa : participante.getRecompensas()) {
                        System.out.println("- " + recompensa.getDescricao() + " (" + recompensa.getTipo() + ")");
                    }
                    break;
                case 3:
                    System.out.println("Digite o ID do desafio a ser aceito: ");
                    int idDesafio = MenuPrincipal.obterOpcao(scanner);
                    scanner.nextLine(); // Consume newline
                    Desafio desafio = sistema.getDesafios().stream()
                            .filter(d -> d.getId() == idDesafio)
                            .findFirst()
                            .orElse(null);
                    if (desafio != null) {
                        participante.aceitarDesafio(desafio);
                        Recompensa recompensa = sistema.getRecompensas().stream()
                                .filter(r -> r.getId() == idDesafio) // Assume que o ID da recompensa é igual ao do desafio
                                .findFirst()
                                .orElse(null);
                        if (recompensa != null) {
                            participante.adicionarRecompensa(recompensa);
                            System.out.println("Desafio aceito e recompensa " + recompensa.getDescricao() + " recebida!");
                        } else {
                            System.out.println("Desafio aceito, mas nenhuma recompensa encontrada.");
                        }
                    } else {
                        System.out.println("Desafio não encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("Ranking de Participantes:");
                    List<Participante> ranking = sistema.getRanking();
                    for (int i = 0; i < Math.min(3, ranking.size()); i++) {
                        Participante p = ranking.get(i);
                        System.out.println((i + 1) + ". " + p.getNome() + " - " + p.getTotalPontos() + " pontos");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
