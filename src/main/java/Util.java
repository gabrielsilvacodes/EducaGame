package main.java;

import java.util.Scanner;

public class Util {
    public static void exibirMenuPrincipal(SistemaGamificacao sistema, Scanner scanner) {
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Menu Professor");
            System.out.println("2. Menu Participante");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
            System.out.println("1. Adicionar Desafio");
            System.out.println("2. Adicionar Recompensa");
            System.out.println("3. Adicionar Participante");
            System.out.println("4. Adicionar Disciplina");
            System.out.println("5. Visualizar Estatísticas do Sistema");
            System.out.println("0. Voltar ao Menu Principal");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar Desafio:");
                    System.out.print("ID: ");
                    int idDesafio = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Pontos: ");
                    int pontos = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("ID da Disciplina: ");
                    int idDisciplina = scanner.nextInt();
                    scanner.nextLine();
                    Disciplina disciplina = sistema.getDisciplinas().stream()
                            .filter(d -> d.getId() == idDisciplina)
                            .findFirst()
                            .orElse(null);
                    if (disciplina == null) {
                        System.out.println("Disciplina não encontrada.");
                        break;
                    }
                    Desafio desafio = new Desafio(idDesafio, titulo, descricao, pontos, disciplina);
                    sistema.adicionarDesafio(desafio);
                    System.out.println("Desafio adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("Adicionar Recompensa:");
                    System.out.print("ID: ");
                    int idRecompensa = scanner.nextInt();
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
                    System.out.println("Adicionar Participante:");
                    System.out.print("ID: ");
                    int idParticipante = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    Participante participante = new Participante(idParticipante, nome);
                    sistema.adicionarParticipante(participante);
                    System.out.println("Participante adicionado com sucesso!");
                    break;
                case 4:
                    System.out.println("Adicionar Disciplina:");
                    System.out.print("ID: ");
                    int idDisciplinaNovo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nomeDisciplina = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricaoDisciplina = scanner.nextLine();
                    Disciplina novaDisciplina = new Disciplina(idDisciplinaNovo, nomeDisciplina, descricaoDisciplina);
                    sistema.adicionarDisciplina(novaDisciplina);
                    System.out.println("Disciplina adicionada com sucesso!");
                    break;
                case 5:
                    System.out.println("Visualizar Estatísticas do Sistema:");
                    // Implemente a lógica para visualizar as estatísticas
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
        int idParticipante = scanner.nextInt();
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
            System.out.println("0. Voltar ao Menu Principal");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
                    int idDesafio = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Desafio desafio = sistema.getDesafios().stream()
                            .filter(d -> d.getId() == idDesafio)
                            .findFirst()
                            .orElse(null);
                    if (desafio != null) {
                        participante.aceitarDesafio(desafio);
                        System.out.println("Desafio aceito com sucesso!");
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
}
