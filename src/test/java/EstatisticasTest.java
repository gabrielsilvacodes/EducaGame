package test.java;

import main.java.Estatisticas;
import main.java.Participante;
import main.java.SistemaGamificacao;
import main.java.Disciplina;
import main.java.Desafio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Disciplina disciplina = new Disciplina(1, "Matemática", "Matemática básica");
        Participante participante = new Participante(1, "João");
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição do desafio 1", 10, disciplina);

        sistema.adicionarParticipante(participante);
        participante.completarDesafio(desafio);

        assertEquals(1, estatisticas.getTotalDesafiosCompletos());
    }

    @Test
    public void testGetTotalPontos() {
        Disciplina disciplina = new Disciplina(1, "Matemática", "Matemática básica");
        Participante participante = new Participante(1, "João");
        Desafio desafio = new Desafio(1, "Desafio 1", "Descrição do desafio 1", 10, disciplina);

        sistema.adicionarParticipante(participante);
        participante.completarDesafio(desafio);

        assertEquals(10, estatisticas.getTotalPontos());
    }
}
