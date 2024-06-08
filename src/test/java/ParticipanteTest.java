package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParticipanteTest {
    private Participante participante;

    @BeforeEach
    public void setup() {
        participante = new Participante(1, "Participante 1");
    }

    @Test
    public void testCompletarDesafio() {
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição 1", 100, new Disciplina(1, "Matemática", "Descrição"));
        participante.completarDesafio(desafio);
        assertTrue(participante.getDesafiosCompletos().contains(desafio));
    }

    @Test
    public void testAdicionarRecompensa() {
        Recompensa recompensa = new Recompensa(1, "Recompensa 1", TipoRecompensa.BRONZE);
        participante.adicionarRecompensa(recompensa);
        assertTrue(participante.getRecompensas().contains(recompensa));
    }
}
