package test.java;

import main.java.Disciplina;
import main.java.Desafio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisciplinaTest {

    @Test
    public void testAdicionarDesafio() {
        Disciplina disciplina = new Disciplina(1, "Matemática", "Aulas de matemática básica");
        Desafio desafio = new Desafio(1, "Resolver Equações", "Resolver equações de segundo grau", 10, disciplina);
        disciplina.adicionarDesafio(desafio);
        assertEquals(1, disciplina.getDesafios().size());
        assertTrue(disciplina.getDesafios().contains(desafio));
    }
}
