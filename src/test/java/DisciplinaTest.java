package test.java;

import main.java.Disciplina;
import main.java.Desafio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisciplinaTest {
    private Disciplina disciplina;

    @BeforeEach
    public void setup() {
        disciplina = new Disciplina(1, "Matemática", "Matemática básica");
    }

    @Test
    public void testAdicionarDesafio() {
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição do desafio 1", 10, disciplina);
        disciplina.adicionarDesafio(desafio);
        assertEquals(1, disciplina.getDesafios().size());
        assertTrue(disciplina.getDesafios().contains(desafio));
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
        assertEquals("Matemática básica", disciplina.getDescricao());
    }

    @Test
    public void testGetDesafios() {
        Desafio desafio1 = new Desafio(1, "Desafio 1", "Descrição do desafio 1", 10, disciplina);
        Desafio desafio2 = new Desafio(2, "Desafio 2", "Descrição do desafio 2", 20, disciplina);
        disciplina.adicionarDesafio(desafio1);
        disciplina.adicionarDesafio(desafio2);
        assertEquals(2, disciplina.getDesafios().size());
        assertTrue(disciplina.getDesafios().contains(desafio1));
        assertTrue(disciplina.getDesafios().contains(desafio2));
    }
}