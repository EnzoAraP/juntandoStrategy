import org.example.Silo;
import org.example.SiloFactory;
import org.example.Vaca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VacaTest {
    private Vaca vaca;
    private final SiloFactory fabrica = SiloFactory.getInstance();

    @BeforeEach
    void setup() {
        vaca = new Vaca();
    }

    @Test
    void devePesar200Trigo() {
        vaca.comer(fabrica.obterSilo("Trigo"), 1);
        assertEquals(200, vaca.getPeso());
    }

    @Test
    void devePesar150Cevada() {
        vaca.comer(fabrica.obterSilo("Cevada"), 1);
        assertEquals(150, vaca.getPeso());
    }

    @Test
    void devePesarCemMilho() {
        vaca.comer(fabrica.obterSilo("Milho"), 1);
        assertEquals(100, vaca.getPeso());
    }

    @Test
    void deveTrocarEstrategiaEAcumularPeso() {
        vaca.comer(fabrica.obterSilo("Trigo"), 2);
        vaca.comer(fabrica.obterSilo("Milho"), 3);
        vaca.comer(fabrica.obterSilo("Cevada"), 4);
        assertEquals(1300, vaca.getPeso());
    }

    @Test
    void deveValidarQuantidadeSemAlterarPeso() {
        Silo silo = fabrica.obterSilo("Trigo");
        vaca.comer(silo, 1);
        assertThrows(IllegalArgumentException.class, () -> vaca.comer(silo, -1));
        vaca.comer(silo, 0);
        assertEquals(200, vaca.getPeso());
    }

    @Test
    void deveUsarTemplateComOutraEstrategia() {
        Silo silo = new Silo() {
            @Override
            protected int getGanhoPorUnidade() {
                return 50;
            }
        };
        vaca.comer(silo, 3);
        assertEquals(150, vaca.getPeso());
    }

    @Test
    void deveCompartilharFabricaSemCompartilharPesoDasVacas() {
        assertSame(fabrica, SiloFactory.getInstance());
        Silo silo = fabrica.obterSilo("Trigo");
        vaca.comer(silo, 1);
        Vaca outra = new Vaca();
        outra.comer(silo, 2);
        assertEquals(200, vaca.getPeso());
        assertEquals(400, outra.getPeso());
    }
}
