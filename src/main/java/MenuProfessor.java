package main.java;

import java.util.Scanner;

public class MenuProfessor {
    public static void exibirMenu(SistemaGamificacao sistema, Scanner scanner) {
        while (true) {
            System.out.println("Menu Professor:");
            System.out.println("1. Adicionar Disciplina");
            System.out.println("2. Adicionar Recompensa");
            System.out.println("3. Adicionar Desafio");
            System.out.println("4. Adicionar Participante");
            System.out.println("5. Visualizar Estatísticas do Sistema");
            System.out.println("0. Voltar ao Menu Principal");

            int opcao = MenuPrincipal.obterOpcao(scanner);

            switch (opcao) {
                case 1:
                    adicionarDisciplina(sistema, scanner);
                    break;
                case 2:
                    adicionarRecompensa(sistema, scanner);
                    break;
                case 3:
                    adicionarDesafio(sistema, scanner);
                    break;
                case 4:
                    adicionarParticipante(sistema, scanner);
                    break;
                case 5:
                    visualizarEstatisticas(sistema);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void adicionarDisciplina(SistemaGamificacao sistema, Scanner scanner) {
        System.out.println("Adicionar Disciplina:");
        System.out.print("ID: ");
        int idDisciplina = MenuPrincipal.obterOpcao(scanner);
        scanner.nextLine();
        System.out.print("Nome: ");
        String nomeDisciplina = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricaoDisciplina = scanner.nextLine();
        Disciplina disciplina = new Disciplina(idDisciplina, nomeDisciplina, descricaoDisciplina);
        sistema.adicionarDisciplina(disciplina);
        System.out.println("Disciplina adicionada com sucesso!");
    }

    private static void adicionarRecompensa(SistemaGamificacao sistema, Scanner scanner) {
        System.out.println("Adicionar Recompensa:");
        System.out.print("ID: ");
        int idRecompensa = MenuPrincipal.obterOpcao(scanner);
        scanner.nextLine();
        System.out.print("Descrição: ");
        String descricaoRecompensa = scanner.nextLine();
        System.out.print("Tipo (BRONZE, PRATA, OURO): ");
        TipoRecompensa tipo;
        while (true) {
            try {
                tipo = TipoRecompensa.valueOf(scanner.nextLine().toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo inválido. Digite BRONZE, PRATA ou OURO:");
            }
        }
        Recompensa recompensa = new Recompensa(idRecompensa, descricaoRecompensa, tipo);
        sistema.adicionarRecompensa(recompensa);
        System.out.println("Recompensa adicionada com sucesso!");
    }

    private static void adicionarDesafio(SistemaGamificacao sistema, Scanner scanner) {
        System.out.println("Adicionar Desafio:");
        System.out.print("ID: ");
        int idDesafio = MenuPrincipal.obterOpcao(scanner);
        scanner.nextLine();
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Pontos: ");
        int pontos = MenuPrincipal.obterOpcao(scanner);
        System.out.print("ID da Disciplina: ");
        int disciplinaId = MenuPrincipal.obterOpcao(scanner);
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
    }

    private static void adicionarParticipante(SistemaGamificacao sistema, Scanner scanner) {
        System.out.println("Adicionar Participante:");
        System.out.print("ID: ");
        int idParticipante = MenuPrincipal.obterOpcao(scanner);
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        Participante participante = new Participante(idParticipante, nome);
        sistema.adicionarParticipante(participante);
        System.out.println("Participante adicionado com sucesso!");
    }

    private static void visualizarEstatisticas(SistemaGamificacao sistema) {
        System.out.println("Visualizar Estatísticas do Sistema:");
        Estatisticas estatisticas = new Estatisticas(sistema);
        System.out.println("Total de desafios completos: " + estatisticas.getTotalDesafiosCompletos());
        System.out.println("Total de pontos: " + estatisticas.getTotalPontos());
    }
}
