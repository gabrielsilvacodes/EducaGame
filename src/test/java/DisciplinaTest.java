package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisciplinaTest {
    private Disciplina disciplina;

    @BeforeEach
    public void setup() {
        disciplina = new Disciplina(1, "Matemática", "Descrição de Matemática");
    }

    @Test
    public void testGetId() {
        assertEquals(1, disciplina.getId());
    }

    @Test
    public void testGetNome() {
        assertEquals("Matemática", disciplina.getNome());
    }

    @Test
    public void testGetDescricao() {
        assertEquals("Descrição de Matemática", disciplina.getDescricao());
    }

    @Test
    public void testAdicionarDesafio() {
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição 1", 100, disciplina);
        disciplina.adicionarDesafio(desafio);
        assertTrue(disciplina.getDesafios().contains(desafio));
    }
}
