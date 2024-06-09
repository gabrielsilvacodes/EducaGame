package main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe utilitária para o sistema de gamificação.
 */
public class Util {
    public static void exibirMenuPrincipal(SistemaGamificacao sistema, Scanner scanner) {
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Menu Professor");
            System.out.println("2. Menu Participante");
            System.out.println("0. Sair");

            int opcao = lerInteiro(scanner);

            switch (opcao) {
                case 1:
                    exibirMenuProfessor(sistema, scanner);
                    break;
                case 2:
                    exibirMenuParticipante(sistema, scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void exibirMenuProfessor(SistemaGamificacao sistema, Scanner scanner) {
        while (true) {
            System.out.println("Menu Professor:");
            System.out.println("1. Adicionar Disciplina");
            System.out.println("2. Adicionar Desafio");
            System.out.println("3. Adicionar Recompensa");
            System.out.println("4. Adicionar Participante");
            System.out.println("5. Visualizar Estatísticas do Sistema");
            System.out.println("0. Voltar ao Menu Principal");

            int opcao = lerInteiro(scanner);

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar Disciplina:");
                    System.out.print("ID: ");
                    int idDisciplina = lerInteiro(scanner);
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nomeDisciplina = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricaoDisciplina = scanner.nextLine();
                    Disciplina disciplina = new Disciplina(idDisciplina, nomeDisciplina, descricaoDisciplina);
                    sistema.adicionarDisciplina(disciplina);
                    System.out.println("Disciplina adicionada com sucesso!");
                    break;
                case 2:
                    System.out.println("Adicionar Desafio:");
                    System.out.print("ID: ");
                    int idDesafio = lerInteiro(scanner);
                    scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Pontos: ");
                    int pontos = lerInteiro(scanner);
                    scanner.nextLine();

                    // Selecionar disciplina para o desafio
                    System.out.println("Selecione a Disciplina pelo ID:");
                    for (Disciplina disc : sistema.getDisciplinas()) {
                        System.out.println(disc.getId() + ": " + disc.getNome());
                    }
                    int idDisciplinaDesafio = lerInteiro(scanner);
                    scanner.nextLine(); // Consume newline
                    Disciplina disciplinaDesafio = sistema.getDisciplinas().stream()
                            .filter(d -> d.getId() == idDisciplinaDesafio)
                            .findFirst()
                            .orElse(null);

                    if (disciplinaDesafio == null) {
                        System.out.println("Disciplina não encontrada. Desafio não adicionado.");
                    } else {
                        Desafio desafio = new Desafio(idDesafio, titulo, descricao, pontos, disciplinaDesafio);
                        sistema.adicionarDesafio(desafio);
                        System.out.println("Desafio adicionado com sucesso!");
                    }
                    break;
                case 3:
                    System.out.println("Adicionar Recompensa:");
                    System.out.print("ID: ");
                    int idRecompensa = lerInteiro(scanner);
                    scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricaoRecompensa = scanner.nextLine();
                    System.out.print("Tipo (BRONZE, PRATA, OURO): ");
                    TipoRecompensa tipo = null;
                    try {
                        tipo = TipoRecompensa.valueOf(scanner.nextLine().toUpperCase());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Tipo de recompensa inválido. Use BRONZE, PRATA ou OURO.");
                        break;
                    }
                    Recompensa recompensa = new Recompensa(idRecompensa, descricaoRecompensa, tipo);
                    sistema.adicionarRecompensa(recompensa);
                    System.out.println("Recompensa adicionada com sucesso!");
                    break;
                case 4:
                    System.out.println("Adicionar Participante:");
                    System.out.print("ID: ");
                    int idParticipante = lerInteiro(scanner);
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    Participante participante = new Participante(idParticipante, nome);
                    sistema.adicionarParticipante(participante);
                    System.out.println("Participante adicionado com sucesso!");
                    break;
                case 5:
                    System.out.println("Visualizar Estatísticas do Sistema:");
                    sistema.getEstatisticas().calcularEstatisticas();
                    System.out.println("Total de Desafios Completos: " + sistema.getEstatisticas().getTotalDesafiosCompletos());
                    System.out.println("Total de Pontos: " + sistema.getEstatisticas().getTotalPontos());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void exibirMenuParticipante(SistemaGamificacao sistema, Scanner scanner) {
        System.out.print("Digite o ID do participante: ");
        int idParticipante = lerInteiro(scanner);

        Participante participante = sistema.getParticipantes().stream()
                .filter(p -> p.getId() == idParticipante)
                .findFirst()
                .orElse(null);

        if (participante == null) {
            System.out.println("Participante não encontrado.");
            return;
        }

        while (true) {
            System.out.println("Menu Participante (" + participante.getNome() + "):");
            System.out.println("1. Visualizar Desafios Completos");
            System.out.println("2. Visualizar Recompensas");
            System.out.println("3. Aceitar Desafio");
            System.out.println("0. Voltar ao Menu Principal");

            int opcao = lerInteiro(scanner);

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
                    int idDesafio = lerInteiro(scanner);
                    Desafio desafio = sistema.getDesafios().stream()
                            .filter(d -> d.getId() == idDesafio)
                            .findFirst()
                            .orElse(null);
                    if (desafio != null) {
                        participante.aceitarDesafio(desafio, sistema);
                        System.out.println("Desafio aceito com sucesso!");
                        System.out.println("Recompensa Recebida: " + participante.getRecompensas().get(participante.getRecompensas().size() - 1).getDescricao());
                    } else {
                        System.out.println("Desafio não encontrado.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static int lerInteiro(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
                scanner.nextLine(); // Limpar a entrada inválida
            }
        }
    }
}
