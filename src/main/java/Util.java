package main.java;

import java.util.List;
import java.util.Scanner;

public class Util {

    public static void exibirMenuPrincipal(SistemaGamificacao sistema, Scanner scanner) {
        while (true) {
            mostrarOpcoesMenuPrincipal();
            int opcao = obterOpcao(scanner);

            switch (opcao) {
                case 1 -> exibirMenuProfessor(sistema, scanner);
                case 2 -> exibirMenuParticipante(sistema, scanner);
                case 0 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void mostrarOpcoesMenuPrincipal() {
        System.out.println("Selecione uma opção:");
        System.out.println("1. Menu Professor");
        System.out.println("2. Menu Participante");
        System.out.println("0. Sair");
    }

    public static void exibirMenuProfessor(SistemaGamificacao sistema, Scanner scanner) {
        while (true) {
            mostrarOpcoesMenuProfessor();
            int opcao = obterOpcao(scanner);

            switch (opcao) {
                case 1 -> adicionarDisciplina(sistema, scanner);
                case 2 -> adicionarRecompensa(sistema, scanner);
                case 3 -> adicionarDesafio(sistema, scanner);
                case 4 -> adicionarParticipante(sistema, scanner);
                case 5 -> visualizarEstatisticasSistema(sistema);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void mostrarOpcoesMenuProfessor() {
        System.out.println("Menu Professor:");
        System.out.println("1. Adicionar Disciplina");
        System.out.println("2. Adicionar Recompensa");
        System.out.println("3. Adicionar Desafio");
        System.out.println("4. Adicionar Participante");
        System.out.println("5. Visualizar Estatísticas do Sistema");
        System.out.println("0. Voltar ao Menu Principal");
    }

    private static void adicionarDisciplina(SistemaGamificacao sistema, Scanner scanner) {
        System.out.println("Adicionar Disciplina:");
        int idDisciplina = obterId(scanner, "ID");
        String nomeDisciplina = obterTexto(scanner, "Nome");
        String descricaoDisciplina = obterTexto(scanner, "Descrição");
        Disciplina disciplina = new Disciplina(idDisciplina, nomeDisciplina, descricaoDisciplina);
        sistema.adicionarDisciplina(disciplina);
        System.out.println("Disciplina adicionada com sucesso!");
    }

    private static void adicionarRecompensa(SistemaGamificacao sistema, Scanner scanner) {
        System.out.println("Adicionar Recompensa:");
        int idRecompensa = obterId(scanner, "ID");
        String descricaoRecompensa = obterTexto(scanner, "Descrição");
        TipoRecompensa tipo = obterTipoRecompensa(scanner);
        Recompensa recompensa = new Recompensa(idRecompensa, descricaoRecompensa, tipo);
        sistema.adicionarRecompensa(recompensa);
        System.out.println("Recompensa adicionada com sucesso!");
    }

    private static void adicionarDesafio(SistemaGamificacao sistema, Scanner scanner) {
        System.out.println("Adicionar Desafio:");
        int idDesafio = obterId(scanner, "ID");
        String titulo = obterTexto(scanner, "Título");
        String descricao = obterTexto(scanner, "Descrição");
        int pontos = obterId(scanner, "Pontos");
        int disciplinaId = obterId(scanner, "ID da Disciplina");
        Disciplina disciplinaDoDesafio = encontrarDisciplina(sistema, disciplinaId);

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
        int idParticipante = obterId(scanner, "ID");
        String nome = obterTexto(scanner, "Nome");
        Participante participante = new Participante(idParticipante, nome);
        sistema.adicionarParticipante(participante);
        System.out.println("Participante adicionado com sucesso!");
    }

    private static void visualizarEstatisticasSistema(SistemaGamificacao sistema) {
        System.out.println("Visualizar Estatísticas do Sistema:");
        Estatisticas estatisticas = new Estatisticas(sistema);
        estatisticas.imprimirEstatisticasParticipantes();
    }

    public static void exibirMenuParticipante(SistemaGamificacao sistema, Scanner scanner) {
        System.out.print("Digite o ID do participante: ");
        int idParticipante = obterOpcao(scanner);
        scanner.nextLine(); // Consume newline

        Participante participante = encontrarParticipante(sistema, idParticipante);

        if (participante == null) {
            System.out.println("Participante não encontrado.");
            return;
        }

        while (true) {
            mostrarOpcoesMenuParticipante();
            int opcao = obterOpcao(scanner);

            switch (opcao) {
                case 1 -> visualizarDesafiosCompletos(participante);
                case 2 -> visualizarRecompensas(participante);
                case 3 -> aceitarDesafio(sistema, scanner, participante);
                case 4 -> visualizarRanking(sistema);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void mostrarOpcoesMenuParticipante() {
        System.out.println("Menu Participante:");
        System.out.println("1. Visualizar Desafios Completos");
        System.out.println("2. Visualizar Recompensas");
        System.out.println("3. Aceitar Desafio");
        System.out.println("4. Visualizar Ranking");
        System.out.println("0. Voltar ao Menu Principal");
    }

    private static void visualizarDesafiosCompletos(Participante participante) {
        System.out.println("Desafios Completos:");
        for (Desafio desafio : participante.getDesafiosCompletos()) {
            System.out.println("- " + desafio.getTitulo());
        }
    }

    private static void visualizarRecompensas(Participante participante) {
        System.out.println("Recompensas:");
        for (Recompensa recompensa : participante.getRecompensas()) {
            System.out.println("- " + recompensa.getDescricao() + " (" + recompensa.getTipo() + ")");
        }
    }

    private static void aceitarDesafio(SistemaGamificacao sistema, Scanner scanner, Participante participante) {
        System.out.println("Digite o ID do desafio a ser aceito: ");
        int idDesafio = obterOpcao(scanner);
        scanner.nextLine(); // Consume newline
        Desafio desafio = encontrarDesafio(sistema, idDesafio);

        if (desafio != null) {
            participante.aceitarDesafio(desafio);
            Recompensa recompensa = encontrarRecompensa(sistema, idDesafio); // Assume que o ID da recompensa é igual ao do desafio
            if (recompensa != null) {
                participante.adicionarRecompensa(recompensa);
                System.out.println("Desafio aceito e recompensa " + recompensa.getDescricao() + " recebida!");
            } else {
                System.out.println("Desafio aceito, mas nenhuma recompensa encontrada.");
            }
        } else {
            System.out.println("Desafio não encontrado.");
        }
    }

    private static void visualizarRanking(SistemaGamificacao sistema) {
        System.out.println("Ranking de Participantes:");
        List<Participante> ranking = sistema.getRanking();
        for (int i = 0; i < Math.min(3, ranking.size()); i++) {
            Participante p = ranking.get(i);
            System.out.println((i + 1) + ". " + p.getNome() + " - " + p.getTotalPontos() + " pontos");
        }
    }

    private static int obterOpcao(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next(); // Limpa a entrada inválida
        }
        return scanner.nextInt();
    }

    private static int obterId(Scanner scanner, String mensagem) {
        System.out.print(mensagem + ": ");
        return obterOpcao(scanner);
    }

    private static String obterTexto(Scanner scanner, String mensagem) {
        System.out.print(mensagem + ": ");
        return scanner.nextLine();
    }

    private static TipoRecompensa obterTipoRecompensa(Scanner scanner) {
        System.out.print("Tipo (BRONZE, PRATA, OURO): ");
        return TipoRecompensa.valueOf(scanner.nextLine().toUpperCase());
    }

    private static Disciplina encontrarDisciplina(SistemaGamificacao sistema, int disciplinaId) {
        return sistema.getDisciplinas().stream()
                .filter(d -> d.getId() == disciplinaId)
                .findFirst()
                .orElse(null);
    }

    private static Participante encontrarParticipante(SistemaGamificacao sistema, int idParticipante) {
        return sistema.getParticipantes().stream()
                .filter(p -> p.getId() == idParticipante)
                .findFirst()
                .orElse(null);
    }

    private static Desafio encontrarDesafio(SistemaGamificacao sistema, int idDesafio) {
        return sistema.getDesafios().stream()
                .filter(d -> d.getId() == idDesafio)
                .findFirst()
                .orElse(null);
    }

    private static Recompensa encontrarRecompensa(SistemaGamificacao sistema, int idRecompensa) {
        return sistema.getRecompensas().stream()
                .filter(r -> r.getId() == idRecompensa)
                .findFirst()
                .orElse(null);
    }
}
