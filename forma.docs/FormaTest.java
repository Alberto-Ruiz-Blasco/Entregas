package Forma;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FormaTest {
    @Test
    public void testToString() {
        Esfera esfera = new Esfera(5);
        Rectangulo rectangulo = new Rectangulo("Rectangulo",4, 6);
        Cilindro cilindro = new Cilindro("Cilindro",3, 7);

        assertTrue(esfera.toString().contains("Esfera"));
        assertTrue(rectangulo.toString().contains("Rectangulo"));
        assertTrue(cilindro.toString().contains("Cilindro"));
    }

    @Test
    public void testArea() {
        Esfera esfera = new Esfera(5);
        Rectangulo rectangulo = new Rectangulo("Rectangulo",4, 6);
        Cilindro cilindro = new Cilindro("Cilindro",3, 7);

        assertEquals(4 * Math.PI * 5 * 5, esfera.area(), 0.01);
        assertEquals(4 * 6, rectangulo.area(), 0.01);
        assertEquals(2 * Math.PI * 3 * (3 + 7), cilindro.area(), 0.01);
    }

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
