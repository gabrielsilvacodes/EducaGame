package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SistemaGamificacaoTest {
    private SistemaGamificacao sistema;

    @BeforeEach
    void setUp() {
        sistema = new SistemaGamificacao();
    }

    @Test
    void testAdicionarDesafio() {
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição do Desafio 1", 100);
        sistema.adicionarDesafio(desafio);
        assertTrue(sistema.getDesafios().contains(desafio));
    }

    @Test
    void testAdicionarRecompensa() {
        Recompensa recompensa = new Recompensa(1, "Recompensa 1", TipoRecompensa.BRONZE);
        sistema.adicionarRecompensa(recompensa);
        assertTrue(sistema.getRecompensas().contains(recompensa));
    }

    @Test
    void testAdicionarParticipante() {
        Participante participante = new Participante(1, "Participante 1");
        sistema.adicionarParticipante(participante);
        assertTrue(sistema.getParticipantes().contains(participante));
    }
}