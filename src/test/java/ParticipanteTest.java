package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParticipanteTest {
    private Participante participante;

    @BeforeEach
    void setUp() {
        participante = new Participante(1, "Participante 1");
    }

    @Test
    void testAceitarDesafio() {
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição do Desafio 1", 100);
        participante.aceitarDesafio(desafio);
        assertTrue(participante.getDesafios().contains(desafio));
    }

    @Test
    void testCompletarDesafio() {
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição do Desafio 1", 100);
        participante.aceitarDesafio(desafio);
        participante.completarDesafio(desafio);
        assertTrue(participante.getDesafiosCompletos().contains(desafio));
        assertFalse(participante.getDesafios().contains(desafio));
    }

    @Test
    void testAdicionarRecompensa() {
        Recompensa recompensa = new Recompensa(1, "Recompensa 1", TipoRecompensa.BRONZE);
        participante.adicionarRecompensa(recompensa);
        assertTrue(participante.getRecompensas().contains(recompensa));
    }
}