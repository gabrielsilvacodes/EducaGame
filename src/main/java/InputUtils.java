package main.java;

import java.util.Scanner;

public class InputUtils {
    public static int obterOpcao(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número.");
            scanner.next(); // Limpa a entrada inválida
        }
        return scanner.nextInt();
    }
}
