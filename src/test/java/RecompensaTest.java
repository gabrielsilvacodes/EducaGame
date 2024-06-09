package test.java;

import main.java.Recompensa;
import main.java.TipoRecompensa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecompensaTest {

    @Test
    public void testRecompensa() {
        Recompensa recompensa = new Recompensa(1, "Recompensa 1", TipoRecompensa.BRONZE);
        assertEquals(1, recompensa.getId());
        assertEquals("Recompensa 1", recompensa.getDescricao());
        assertEquals(TipoRecompensa.BRONZE, recompensa.getTipo());
    }
}
