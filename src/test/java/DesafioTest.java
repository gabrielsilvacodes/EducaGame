package test.java;

import main.java.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesafioTest {
    private Desafio desafio;

    @BeforeEach
    void setUp() {
        desafio = new Desafio(1, "Desafio 1", "Descrição do Desafio 1", 100);
    }

    @Test
    void testGetId() {
        assertEquals(1, desafio.getId());
    }

    @Test
    void testGetTitulo() {
        assertEquals("Desafio 1", desafio.getTitulo());
    }

    @Test
    void testGetDescricao() {
        assertEquals("Descrição do Desafio 1", desafio.getDescricao());
    }

    @Test
    void testGetPontos() {
        assertEquals(100, desafio.getPontos());
    }

    @Test
    void testSetTitulo() {
        desafio.setTitulo("Novo Título");
        assertEquals("Novo Título", desafio.getTitulo());
    }

    @Test
    void testSetDescricao() {
        desafio.setDescricao("Nova Descrição");
        assertEquals("Nova Descrição", desafio.getDescricao());
    }

    @Test
    void testSetPontos() {
        desafio.setPontos(200);
        assertEquals(200, desafio.getPontos());
    }
}