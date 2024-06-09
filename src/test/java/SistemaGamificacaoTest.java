package test.java;

import main.java.Disciplina;
import main.java.Participante;
import main.java.Recompensa;
import main.java.SistemaGamificacao;
import main.java.Desafio;
import main.java.TipoRecompensa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaGamificacaoTest {
    private SistemaGamificacao sistema;

    @BeforeEach
    public void setup() {
        sistema = new SistemaGamificacao();
    }

    @Test
    public void testAdicionarDesafio() {
        Disciplina disciplina = new Disciplina(1, "Matemática", "Matemática básica");
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição do desafio 1", 10, disciplina);
        sistema.adicionarDesafio(desafio);
        assertEquals(1, sistema.getDesafios().size());
        assertEquals(desafio, sistema.getDesafios().get(0));
    }

    @Test
    public void testAdicionarRecompensa() {
        Recompensa recompensa = new Recompensa(1, "Recompensa 1", TipoRecompensa.BRONZE);
        sistema.adicionarRecompensa(recompensa);
        assertEquals(1, sistema.getRecompensas().size());
        assertEquals(recompensa, sistema.getRecompensas().get(0));
    }

    @Test
    public void testAdicionarParticipante() {
        Participante participante = new Participante(1, "João");
        sistema.adicionarParticipante(participante);
        assertEquals(1, sistema.getParticipantes().size());
        assertEquals(participante, sistema.getParticipantes().get(0));
    }

    @Test
    public void testAdicionarDisciplina() {
        Disciplina disciplina = new Disciplina(1, "Matemática", "Matemática básica");
        sistema.adicionarDisciplina(disciplina);
        assertEquals(1, sistema.getDisciplinas().size());
        assertEquals(disciplina, sistema.getDisciplinas().get(0));
    }

    @Test
    public void testGetRanking() {
        Participante participante1 = new Participante(1, "João");
        Participante participante2 = new Participante(2, "Maria");
        Participante participante3 = new Participante(3, "Pedro");

        Desafio desafio1 = new Desafio(1, "Desafio 1", "Descrição do desafio 1", 10, new Disciplina(1, "Matemática", "Matemática básica"));
        Desafio desafio2 = new Desafio(2, "Desafio 2", "Descrição do desafio 2", 20, new Disciplina(2, "Física", "Física básica"));

        participante1.completarDesafio(desafio1);
        participante2.completarDesafio(desafio1);
        participante2.completarDesafio(desafio2);
        participante3.completarDesafio(desafio2);

        sistema.adicionarParticipante(participante1);
        sistema.adicionarParticipante(participante2);
        sistema.adicionarParticipante(participante3);

        assertEquals(participante2, sistema.getRanking().get(0));
        assertEquals(participante3, sistema.getRanking().get(1));
        assertEquals(participante1, sistema.getRanking().get(2));
    }
}
