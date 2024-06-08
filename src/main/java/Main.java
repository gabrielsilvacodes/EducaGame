package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaGamificacao sistema = new SistemaGamificacao();
        Scanner scanner = new Scanner(System.in);
        Util.exibirMenuPrincipal(sistema, scanner);
    }
}
