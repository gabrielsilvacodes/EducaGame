package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisciplinaTest {
    private Disciplina disciplina;

    @BeforeEach
    void setUp() {
        disciplina = new Disciplina(1, "Matemática", "Disciplina de Matemática");
    }

    @Test
    void testGetId() {
        assertEquals(1, disciplina.getId());
    }

    @Test
    void testGetNome() {
        assertEquals("Matemática", disciplina.getNome());
    }

    @Test
    void testGetDescricao() {
        assertEquals("Disciplina de Matemática", disciplina.getDescricao());
    }
}