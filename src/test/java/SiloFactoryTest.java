import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SiloFactoryTest {
    @Test
    void deveObterOsSilosPeloNome() {
        SiloFactory fabrica = SiloFactory.getInstance();
        assertTrue(fabrica.obterSilo("Trigo") instanceof SiloTrigo);
        assertTrue(fabrica.obterSilo("Milho") instanceof SiloMilho);
        assertTrue(fabrica.obterSilo("Cevada") instanceof SiloCevada);
    }

    @Test
    void deveRejeitarSiloInexistente() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
                () -> SiloFactory.getInstance().obterSilo("Inexistente"));
        assertEquals("Silo inexistente", erro.getMessage());
    }

    @Test
    void deveRejeitarClasseQueNaoEhSilo() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
                () -> SiloFactory.getInstance().obterSilo("Factory"));
        assertEquals("Silo inválido", erro.getMessage());
    }

    @Test
    void deveRejeitarClasseAbstrata() {
        IllegalArgumentException erro = assertThrows(IllegalArgumentException.class,
                () -> SiloFactory.getInstance().obterSilo(""));
        assertEquals("Silo inválido", erro.getMessage());
    }
}
