package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EstatisticasTest {
    private SistemaGamificacao sistema;
    private Estatisticas estatisticas;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaGamificacao();
        estatisticas = new Estatisticas(sistema);

        Disciplina disciplina = new Disciplina(1, "Matemática", "Disciplina de Matemática");
        Desafio desafio1 = new Desafio(1, "Desafio 1", "Descrição 1", 100, disciplina);
        Desafio desafio2 = new Desafio(2, "Desafio 2", "Descrição 2", 200, disciplina);

        sistema.adicionarDesafio(desafio1);
        sistema.adicionarDesafio(desafio2);

        Participante participante1 = new Participante(1, "João");
        Participante participante2 = new Participante(2, "Maria");

        sistema.adicionarParticipante(participante1);
        sistema.adicionarParticipante(participante2);

        participante1.completarDesafio(desafio1);
        participante2.completarDesafio(desafio2);
    }

    @Test
    public void testGetTotalDesafiosCompletos() {
        assertEquals(2, estatisticas.getTotalDesafiosCompletos());
    }

    @Test
    public void testGetTotalPontos() {
        assertEquals(300, estatisticas.getTotalPontos());
    }
}
