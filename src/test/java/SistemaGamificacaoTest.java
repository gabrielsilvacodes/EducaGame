package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaGamificacaoTest {
    private SistemaGamificacao sistema;

    @BeforeEach
    public void setup() {
        sistema = new SistemaGamificacao();
    }

    @Test
    public void testAdicionarDesafio() {
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição 1", 100, new Disciplina(1, "Matemática", "Descrição"));
        sistema.adicionarDesafio(desafio);
        assertTrue(sistema.getDesafios().contains(desafio));
    }

    @Test
    public void testAdicionarRecompensa() {
        Recompensa recompensa = new Recompensa(1, "Recompensa 1", TipoRecompensa.BRONZE);
        sistema.adicionarRecompensa(recompensa);
        assertTrue(sistema.getRecompensas().contains(recompensa));
    }

    @Test
    public void testAdicionarParticipante() {
        Participante participante = new Participante(1, "Participante 1");
        sistema.adicionarParticipante(participante);
        assertTrue(sistema.getParticipantes().contains(participante));
    }

    @Test
    public void testAdicionarDisciplina() {
        Disciplina disciplina = new Disciplina(1, "Matemática", "Descrição");
        sistema.adicionarDisciplina(disciplina);
        assertTrue(sistema.getDisciplinas().contains(disciplina));
    }
}
