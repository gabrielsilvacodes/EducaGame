package test.java;

import main.java.Desafio;
import main.java.Disciplina;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DesafioTest {

    @Test
    public void testConstrutorValido() {
        Disciplina disciplina = new Disciplina(1, "Matemática", "Aulas de matemática básica");
        Desafio desafio = new Desafio(1, "Resolver Equações", "Resolver equações de segundo grau", 10, disciplina);
        assertNotNull(desafio);
        assertEquals(1, desafio.getId());
        assertEquals("Resolver Equações", desafio.getTitulo());
        assertEquals("Resolver equações de segundo grau", desafio.getDescricao());
        assertEquals(10, desafio.getPontos());
        assertEquals(disciplina, desafio.getDisciplina());
    }

    @Test
    public void testConstrutorInvalido() {
        Disciplina disciplina = new Disciplina(1, "Matemática", "Aulas de matemática básica");
        assertThrows(IllegalArgumentException.class, () -> {
            new Desafio(-1, null, null, -10, null);
        });
    }
}
