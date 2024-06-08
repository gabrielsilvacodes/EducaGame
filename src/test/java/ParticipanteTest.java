package test.java;

import main.java.Desafio;
import main.java.Disciplina;
import main.java.Participante;
import main.java.Recompensa;
import main.java.TipoRecompensa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParticipanteTest {
    @Test
    public void testGetters() {
        Participante participante = new Participante(1, "João");
        assertEquals(1, participante.getId());
        assertEquals("João", participante.getNome());
    }

    @Test
    public void testCompletarDesafio() {
        Participante participante = new Participante(1, "João");
        Disciplina disciplina = new Disciplina(1, "Matemática", "Disciplina de Matemática");
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição 1", 100, disciplina);
        participante.completarDesafio(desafio);
        assertTrue(participante.getDesafiosCompletos().contains(desafio));
    }

    @Test
    public void testAdicionarRecompensa() {
        Participante participante = new Participante(1, "João");
        Recompensa recompensa = new Recompensa(1, "Recompensa 1", TipoRecompensa.BRONZE);
        participante.adicionarRecompensa(recompensa);
        assertTrue(participante.getRecompensas().contains(recompensa));
    }

    @Test
    public void testAceitarDesafio() {
        Participante participante = new Participante(1, "João");
        Disciplina disciplina = new Disciplina(1, "Matemática", "Disciplina de Matemática");
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição 1", 100, disciplina);
        participante.aceitarDesafio(desafio);
        assertTrue(participante.getDesafiosCompletos().contains(desafio));
    }
}
