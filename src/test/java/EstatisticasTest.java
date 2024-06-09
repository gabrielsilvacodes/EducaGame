package test.java;

import main.java.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstatisticasTest {

    @Test
    public void testGetTotalDesafiosCompletos() {
        SistemaGamificacao sistema = new SistemaGamificacao();
        Estatisticas estatisticas = new Estatisticas(sistema);
        Participante participante = new Participante(1, "João");
        sistema.adicionarParticipante(participante);
        Disciplina disciplina = new Disciplina(1, "Matemática", "Aulas de matemática básica");
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição 1", 10, disciplina);
        participante.aceitarDesafio(desafio);
        assertEquals(1, estatisticas.getTotalDesafiosCompletos());
    }

    @Test
    public void testGetTotalPontos() {
        SistemaGamificacao sistema = new SistemaGamificacao();
        Estatisticas estatisticas = new Estatisticas(sistema);
        Participante participante = new Participante(1, "João");
        sistema.adicionarParticipante(participante);
        Disciplina disciplina = new Disciplina(1, "Matemática", "Aulas de matemática básica");
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição 1", 10, disciplina);
        participante.aceitarDesafio(desafio);
        assertEquals(10, estatisticas.getTotalPontos());
    }
}
