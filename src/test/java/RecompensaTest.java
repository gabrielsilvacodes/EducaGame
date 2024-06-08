package test.java;

import main.java.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecompensaTest {
    @Test
    public void testGetters() {
        Recompensa recompensa = new Recompensa(1, "Recompensa 1", TipoRecompensa.BRONZE);
        assertEquals(1, recompensa.getId());
        assertEquals("Recompensa 1", recompensa.getDescricao());
        assertEquals(TipoRecompensa.BRONZE, recompensa.getTipo());
    }
}
