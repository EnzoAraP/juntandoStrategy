
import org.example.Vaca;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class VacaTest {
    private Vaca vaca;
    @BeforeEach
    void setup()
    {
         vaca = new Vaca();

    }
    @Test
    void devePesar200Trigo(){
    vaca.ComerTrigo(1);
    assertEquals(200,vaca.getPeso());
    }
    @Test
    void devePesar150Cevada(){
        vaca.ComerCevada(1);
        assertEquals(150,vaca.getPeso());
    }
    @Test
    void devePesarCemMilho(){
        vaca.ComerMilho(1);
        assertEquals(100,vaca.getPeso());
    }

}
