package main.java;

import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    public static void exibirMenuPrincipal(SistemaGamificacao sistema, Scanner scanner) {
        while (true) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Menu Professor");
            System.out.println("2. Menu Participante");
            System.out.println("0. Sair");

            int opcao = obterOpcao(scanner);

            switch (opcao) {
                case 1:
                    MenuProfessor.exibirMenu(sistema, scanner);
                    break;
                case 2:
                    MenuParticipante.exibirMenu(sistema, scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static int obterOpcao(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next(); // Limpa a entrada inválida
        }
        return scanner.nextInt();
    }
}
