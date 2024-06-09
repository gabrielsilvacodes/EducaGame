package test.java;

import main.java.Disciplina;
import main.java.Desafio;
import main.java.Participante;
import main.java.Recompensa;
import main.java.TipoRecompensa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticipanteTest {
    private Participante participante;
    private Disciplina disciplina;

    @BeforeEach
    public void setup() {
        participante = new Participante(1, "João");
        disciplina = new Disciplina(1, "Matemática", "Matemática básica");
    }

    @Test
    public void testCompletarDesafio() {
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição do desafio 1", 10, disciplina);
        participante.completarDesafio(desafio);
        assertEquals(1, participante.getDesafiosCompletos().size());
        assertEquals(desafio, participante.getDesafiosCompletos().get(0));
    }

    @Test
    public void testAdicionarRecompensa() {
        Recompensa recompensa = new Recompensa(1, "Recompensa 1", TipoRecompensa.BRONZE);
        participante.adicionarRecompensa(recompensa);
        assertEquals(1, participante.getRecompensas().size());
        assertEquals(recompensa, participante.getRecompensas().get(0));
    }

    @Test
    public void testGetTotalPontos() {
        Desafio desafio1 = new Desafio(1, "Desafio 1", "Descrição do desafio 1", 10, disciplina);
        Desafio desafio2 = new Desafio(2, "Desafio 2", "Descrição do desafio 2", 20, disciplina);
        participante.completarDesafio(desafio1);
        participante.completarDesafio(desafio2);
        assertEquals(30, participante.getTotalPontos());
    }
}
