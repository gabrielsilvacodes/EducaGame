package test.java;

import main.java.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParticipanteTest {

    @Test
    public void testAdicionarRecompensa() {
        Participante participante = new Participante(1, "João");
        Recompensa recompensa = new Recompensa(1, "Medalha de Ouro", TipoRecompensa.OURO);
        participante.adicionarRecompensa(recompensa);
        assertEquals(1, participante.getRecompensas().size());
        assertTrue(participante.getRecompensas().contains(recompensa));
    }

    @Test
    public void testAceitarDesafio() {
        Participante participante = new Participante(1, "João");
        Disciplina disciplina = new Disciplina(1, "Matemática", "Aulas de matemática básica");
        Desafio desafio = new Desafio(1, "Resolver Equações", "Resolver equações de segundo grau", 10, disciplina);
        participante.aceitarDesafio(desafio);
        assertEquals(1, participante.getDesafiosCompletos().size());
        assertTrue(participante.getDesafiosCompletos().contains(desafio));
    }
}
