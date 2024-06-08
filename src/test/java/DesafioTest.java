package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DesafioTest {
    private Disciplina disciplina;

    @BeforeEach
    public void setup() {
        disciplina = new Disciplina(1, "Matemática", "Descrição de Matemática");
    }

    @Test
    public void testConstrutorValido() {
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição 1", 100, disciplina);
        assertEquals(1, desafio.getId());
        assertEquals("Desafio 1", desafio.getTitulo());
        assertEquals("Descrição 1", desafio.getDescricao());
        assertEquals(100, desafio.getPontos());
        assertEquals(disciplina, desafio.getDisciplina());
    }

    @Test
    public void testConstrutorInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Desafio(1, "Desafio 1", "Descrição 1", -100, disciplina));
        assertThrows(IllegalArgumentException.class, () -> new Desafio(1, "Desafio 1", "Descrição 1", 100, null));
    }
}
