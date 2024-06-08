package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstatisticasTest {
    private SistemaGamificacao sistema;
    private Estatisticas estatisticas;

    @BeforeEach
    public void setup() {
        sistema = new SistemaGamificacao();
        estatisticas = new Estatisticas(sistema);
    }

    @Test
    public void testGetTotalDesafiosCompletos() {
        Participante participante = new Participante(1, "Participante 1");
        sistema.adicionarParticipante(participante);
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição 1", 100, new Disciplina(1, "Matemática", "Descrição"));
        participante.completarDesafio(desafio);
        assertEquals(1, estatisticas.getTotalDesafiosCompletos());
    }

    @Test
    public void testGetTotalPontos() {
        Participante participante = new Participante(1, "Participante 1");
        sistema.adicionarParticipante(participante);
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição 1", 100, new Disciplina(1, "Matemática", "Descrição"));
        participante.completarDesafio(desafio);
        assertEquals(100, estatisticas.getTotalPontos());
    }
}
