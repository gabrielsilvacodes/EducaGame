package test.java;

import main.java.Disciplina;
import main.java.Desafio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DesafioTest {

    @Test
    public void testConstrutorValido() {
        Disciplina disciplina = new Disciplina(1, "Matemática", "Matemática básica");
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição do desafio 1", 10, disciplina);
        assertEquals(1, desafio.getId());
        assertEquals("Desafio 1", desafio.getTitulo());
        assertEquals("Descrição do desafio 1", desafio.getDescricao());
        assertEquals(10, desafio.getPontos());
        assertEquals(disciplina, desafio.getDisciplina());
    }

    @Test
    public void testConstrutorInvalido() {
        Disciplina disciplina = new Disciplina(1, "Matemática", "Matemática básica");
        assertThrows(IllegalArgumentException.class, () -> {
            new Desafio(-1, "Desafio 1", "Descrição do desafio 1", 10, disciplina);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Desafio(1, null, "Descrição do desafio 1", 10, disciplina);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Desafio(1, "Desafio 1", null, 10, disciplina);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Desafio(1, "Desafio 1", "Descrição do desafio 1", -10, disciplina);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Desafio(1, "Desafio 1", "Descrição do desafio 1", 10, null);
        });
    }
}
