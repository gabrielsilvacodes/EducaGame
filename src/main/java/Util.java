package main.java;

import java.util.List;
import java.util.Scanner;

public class Util {
    public static void exibirMenuPrincipal(SistemaGamificacao sistema, Scanner scanner) {
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Menu Professor");
            System.out.println("2. Menu Participante");
            System.out.println("0. Sair");

            int opcao = obterOpcao(scanner);

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
            System.out.println("2. Adicionar Recompensa");
            System.out.println("3. Adicionar Desafio");
            System.out.println("4. Adicionar Participante");
            System.out.println("5. Visualizar Estatísticas do Sistema");
            System.out.println("0. Voltar ao Menu Principal");

            int opcao = obterOpcao(scanner);

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar Disciplina:");
                    System.out.print("ID: ");
                    int idDisciplina = obterOpcao(scanner);
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
                    System.out.println("Adicionar Recompensa:");
                    System.out.print("ID: ");
                    int idRecompensa = obterOpcao(scanner);
                    scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricaoRecompensa = scanner.nextLine();
                    System.out.print("Tipo (BRONZE, PRATA, OURO): ");
                    TipoRecompensa tipo = TipoRecompensa.valueOf(scanner.nextLine().toUpperCase());
                    Recompensa recompensa = new Recompensa(idRecompensa, descricaoRecompensa, tipo);
                    sistema.adicionarRecompensa(recompensa);
                    System.out.println("Recompensa adicionada com sucesso!");
                    break;
                case 3:
                    System.out.println("Adicionar Desafio:");
                    System.out.print("ID: ");
                    int idDesafio = obterOpcao(scanner);
                    scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Pontos: ");
                    int pontos = obterOpcao(scanner);
                    System.out.print("ID da Disciplina: ");
                    int disciplinaId = obterOpcao(scanner);
                    scanner.nextLine();
                    Disciplina disciplinaDoDesafio = sistema.getDisciplinas().stream()
                            .filter(d -> d.getId() == disciplinaId)
                            .findFirst()
                            .orElse(null);
                    if (disciplinaDoDesafio != null) {
                        Desafio desafio = new Desafio(idDesafio, titulo, descricao, pontos, disciplinaDoDesafio);
                        sistema.adicionarDesafio(desafio);
                        System.out.println("Desafio adicionado com sucesso!");
                    } else {
                        System.out.println("Disciplina não encontrada.");
                    }
                    break;
                case 4:
                    System.out.println("Adicionar Participante:");
                    System.out.print("ID: ");
                    int idParticipante = obterOpcao(scanner);
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    Participante participante = new Participante(idParticipante, nome);
                    sistema.adicionarParticipante(participante);
                    System.out.println("Participante adicionado com sucesso!");
                    break;
                case 5:
                    System.out.println("Visualizar Estatísticas do Sistema:");
                    Estatisticas estatisticas = new Estatisticas(sistema);
                    System.out.println("Total de desafios completos: " + estatisticas.getTotalDesafiosCompletos());
                    System.out.println("Total de pontos: " + estatisticas.getTotalPontos());
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
        int idParticipante = obterOpcao(scanner);
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
            System.out.println("Menu Participante:");
            System.out.println("1. Visualizar Desafios Completos");
            System.out.println("2. Visualizar Recompensas");
            System.out.println("3. Aceitar Desafio");
            System.out.println("4. Visualizar Ranking");
            System.out.println("0. Voltar ao Menu Principal");

            int opcao = obterOpcao(scanner);

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
                    int idDesafio = obterOpcao(scanner);
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

    private static int obterOpcao(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next(); // Limpa a entrada inválida
        }
        return scanner.nextInt();
    }
}
