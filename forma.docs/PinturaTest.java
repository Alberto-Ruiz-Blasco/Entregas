package Forma;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PinturaTest {
    @Test
    public void testCalcularPintura() {
        Pintura pintura = new Pintura(10);
        Esfera esfera = new Esfera(5);
        Rectangulo rectangulo = new Rectangulo("Rectangulo", 4, 6);
        Cilindro cilindro = new Cilindro("Cilindro",3, 7);

        assertEquals(esfera.area() / 10, pintura.cantidadPintura(esfera), 0.01);
        assertEquals(rectangulo.area() / 10, pintura.cantidadPintura(rectangulo), 0.01);
        assertEquals(cilindro.area() / 10, pintura.cantidadPintura(cilindro), 0.01);
    }
}
