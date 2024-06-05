package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstatisticasTest {
    private SistemaGamificacao sistema;
    private Estatisticas estatisticas;

    @BeforeEach
    void setUp() {
        sistema = new SistemaGamificacao();
        estatisticas = new Estatisticas(sistema);

        Participante participante1 = new Participante(1, "Participante 1");
        Participante participante2 = new Participante(2, "Participante 2");

        Desafio desafio1 = new Desafio(1, "Desafio 1", "Descrição do Desafio 1", 100);
        Desafio desafio2 = new Desafio(2, "Desafio 2", "Descrição do Desafio 2", 200);

        participante1.aceitarDesafio(desafio1);
        participante1.completarDesafio(desafio1);

        participante2.aceitarDesafio(desafio2);
        participante2.completarDesafio(desafio2);

        sistema.adicionarParticipante(participante1);
        sistema.adicionarParticipante(participante2);
    }

    @Test
    void testGetTotalDesafiosCompletos() {
        assertEquals(2, estatisticas.getTotalDesafiosCompletos());
    }

    @Test
    void testGetTotalPontos() {
        assertEquals(300, estatisticas.getTotalPontos());
    }
}