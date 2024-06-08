package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um Participante no sistema de gamificação.
 */
public class Participante implements Desafiavel {
    private final int id;
    private final String nome;
    private final List<Desafio> desafiosCompletos = new ArrayList<>();
    private final List<Recompensa> recompensas = new ArrayList<>();

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

    // Método para aceitar um desafio
    public void aceitarDesafio(Desafio desafio) {
        desafiosCompletos.add(desafio);
    }
}
