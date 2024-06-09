package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Participante no sistema de gamificação.
 */
public class Participante implements Desafiavel {
    private int id;
    private String nome;
    private List<Desafio> desafiosCompletos = new ArrayList<>();
    private List<Recompensa> recompensas = new ArrayList<>();

    public Participante(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public void completarDesafio(Desafio desafio) {
        desafiosCompletos.add(desafio);
        // Lógica adicional para completar desafio
    }

    public void adicionarRecompensa(Recompensa recompensa) {
        recompensas.add(recompensa);
    }

    public List<Desafio> getDesafiosCompletos() {
        return desafiosCompletos;
    }

    public List<Recompensa> getRecompensas() {
        return recompensas;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    // Método adicional para listar todos os desafios do participante
    public List<Desafio> getDesafios() {
        return desafiosCompletos;
    }

    // Método para aceitar um desafio e receber recompensa
    public void aceitarDesafio(Desafio desafio, SistemaGamificacao sistema) {
        desafiosCompletos.add(desafio);
        // Adicionar lógica para adicionar recompensa com base nos pontos do desafio
        Recompensa recompensa = sistema.gerarRecompensa(desafio);
        this.adicionarRecompensa(recompensa);
    }
}
