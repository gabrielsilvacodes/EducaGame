package test.java;

import main.java.Desafio;
import main.java.Disciplina;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DesafioTest {
    @Test
    public void testGetters() {
        Disciplina disciplina = new Disciplina(1, "Matemática", "Disciplina de Matemática");
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição 1", 100, disciplina);
        assertEquals(1, desafio.getId());
        assertEquals("Desafio 1", desafio.getTitulo());
        assertEquals("Descrição 1", desafio.getDescricao());
        assertEquals(100, desafio.getPontos());
        assertEquals(disciplina, desafio.getDisciplina());
    }

    @Test
    public void testConstrutorInvalido() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Desafio(1, "Desafio 1", "Descrição 1", -100, null);
        });
        assertEquals("Pontos devem ser positivos e disciplina não pode ser nula.", exception.getMessage());
    }
}