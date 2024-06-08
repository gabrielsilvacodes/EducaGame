package main.java;

import java.util.Scanner;

public class Util {
    public static void exibirMenuPrincipal(SistemaGamificacao sistema, Scanner scanner) {
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Menu Professor");
            System.out.println("2. Menu Participante");
            System.out.println("0. Sair");

            int opcao = lerOpcao(scanner);

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

            int opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar Disciplina:");
                    int idDisciplina = lerInt(scanner, "ID");
                    System.out.print("Nome: ");
                    String nomeDisciplina = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricaoDisciplina = scanner.nextLine();
                    Disciplina disciplina = new Disciplina(idDisciplina, nomeDisciplina, descricaoDisciplina);
                    sistema.adicionarDisciplina(disciplina);
                    System.out.println("Disciplina adicionada com sucesso!");
                    break;
                case 2:
                    if (sistema.getDisciplinas().isEmpty()) {
                        System.out.println("Nenhuma disciplina encontrada. Adicione uma disciplina primeiro.");
                        break;
                    }
                    System.out.println("Adicionar Desafio:");
                    int idDesafio = lerInt(scanner, "ID");
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    int pontos = lerInt(scanner, "Pontos");
                    System.out.println("Selecione uma Disciplina pelo ID:");
                    for (Disciplina d : sistema.getDisciplinas()) {
                        System.out.println(d.getId() + ". " + d.getNome());
                    }
                    int idDisc = lerInt(scanner, "Disciplina ID");
                    Disciplina disciplinaEscolhida = sistema.getDisciplinas().stream()
                            .filter(d -> d.getId() == idDisc)
                            .findFirst()
                            .orElse(null);
                    if (disciplinaEscolhida == null) {
                        System.out.println("Disciplina não encontrada.");
                        break;
                    }
                    Desafio desafio = new Desafio(idDesafio, titulo, descricao, pontos, disciplinaEscolhida);
                    sistema.adicionarDesafio(desafio);
                    disciplinaEscolhida.adicionarDesafio(desafio);
                    System.out.println("Desafio adicionado com sucesso!");
                    break;
                case 3:
                    System.out.println("Adicionar Recompensa:");
                    int idRecompensa = lerInt(scanner, "ID");
                    System.out.print("Descrição: ");
                    String descricaoRecompensa = scanner.nextLine();
                    TipoRecompensa tipo = lerTipoRecompensa(scanner);
                    Recompensa recompensa = new Recompensa(idRecompensa, descricaoRecompensa, tipo);
                    sistema.adicionarRecompensa(recompensa);
                    System.out.println("Recompensa adicionada com sucesso!");
                    break;
                case 4:
                    System.out.println("Adicionar Participante:");
                    int idParticipante = lerInt(scanner, "ID");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    Participante participante = new Participante(idParticipante, nome);
                    sistema.adicionarParticipante(participante);
                    System.out.println("Participante adicionado com sucesso!");
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
        int idParticipante = lerInt(scanner, "ID");
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

            int opcao = lerOpcao(scanner);
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
                    int idDesafio = lerInt(scanner, "ID do Desafio");
                    Desafio desafio = sistema.getDesafios().stream()
                            .filter(d -> d.getId() == idDesafio)
                            .findFirst()
                            .orElse(null);
                    if (desafio != null) {
                        participante.aceitarDesafio(desafio);
                        System.out.println("Desafio aceito com sucesso!");
                        // Exibir a recompensa recebida após aceitar o desafio
                        Recompensa recompensa = participante.getRecompensas().get(participante.getRecompensas().size() - 1);
                        System.out.println("Recompensa recebida: " + recompensa.getDescricao() + " (" + recompensa.getTipo() + ")");
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

    private static int lerOpcao(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Digite um número.");
            return -1;
        }
    }

    private static int lerInt(Scanner scanner, String campo) {
        while (true) {
            System.out.print(campo + ": ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }

    private static TipoRecompensa lerTipoRecompensa(Scanner scanner) {
        while (true) {
            try {
                return TipoRecompensa.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo inválido. Digite BRONZE, PRATA ou OURO.");
            }
        }
    }
}
