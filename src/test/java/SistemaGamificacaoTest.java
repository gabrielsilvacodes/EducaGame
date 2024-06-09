package test.java;

import java.util.List;
import main.java.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaGamificacaoTest {

    @Test
    public void testAdicionarParticipante() {
        SistemaGamificacao sistema = new SistemaGamificacao();
        Participante participante = new Participante(1, "João");
        sistema.adicionarParticipante(participante);
        assertEquals(1, sistema.getParticipantes().size());
        assertTrue(sistema.getParticipantes().contains(participante));
    }

    @Test
    public void testAdicionarDisciplina() {
        SistemaGamificacao sistema = new SistemaGamificacao();
        Disciplina disciplina = new Disciplina(1, "Matemática", "Aulas de matemática básica");
        sistema.adicionarDisciplina(disciplina);
        assertEquals(1, sistema.getDisciplinas().size());
        assertTrue(sistema.getDisciplinas().contains(disciplina));
    }

    @Test
    public void testGetRanking() {
        SistemaGamificacao sistema = new SistemaGamificacao();
        Participante participante1 = new Participante(1, "João");
        Participante participante2 = new Participante(2, "Maria");
        sistema.adicionarParticipante(participante1);
        sistema.adicionarParticipante(participante2);
        Disciplina disciplina = new Disciplina(1, "Matemática", "Aulas de matemática básica");
        Desafio desafio1 = new Desafio(1, "Desafio 1", "Descrição 1", 10, disciplina);
        Desafio desafio2 = new Desafio(2, "Desafio 2", "Descrição 2", 20, disciplina);
        participante1.aceitarDesafio(desafio1);
        participante2.aceitarDesafio(desafio2);
        List<Participante> ranking = sistema.getRanking();
        assertEquals(participante2, ranking.get(0));
        assertEquals(participante1, ranking.get(1));
    }
}
