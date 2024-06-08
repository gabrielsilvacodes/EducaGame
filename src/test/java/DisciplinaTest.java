package test.java;

import main.java.Disciplina;
import main.java.Desafio;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisciplinaTest {
    @Test
    public void testGetters() {
        Disciplina disciplina = new Disciplina(1, "Matemática", "Disciplina de Matemática");
        assertEquals(1, disciplina.getId());
        assertEquals("Matemática", disciplina.getNome());
        assertEquals("Disciplina de Matemática", disciplina.getDescricao());
    }

    @Test
    public void testAdicionarDesafio() {
        Disciplina disciplina = new Disciplina(1, "Matemática", "Disciplina de Matemática");
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição 1", 100, disciplina);
        disciplina.adicionarDesafio(desafio);
        List<Desafio> desafios = disciplina.getDesafios();
        assertEquals(1, desafios.size());
        assertTrue(desafios.contains(desafio));
    }
}
