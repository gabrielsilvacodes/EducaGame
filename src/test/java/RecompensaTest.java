package test.java;

import main.java.Recompensa;
import main.java.TipoRecompensa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecompensaTest {

    @Test
    public void testConstrutor() {
        Recompensa recompensa = new Recompensa(1, "Medalha de Ouro", TipoRecompensa.OURO);
        assertEquals(1, recompensa.getId());
        assertEquals("Medalha de Ouro", recompensa.getDescricao());
        assertEquals(TipoRecompensa.OURO, recompensa.getTipo());
    }
}
