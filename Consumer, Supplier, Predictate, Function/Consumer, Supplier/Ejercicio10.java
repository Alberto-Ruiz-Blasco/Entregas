package Consumer;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ejercicio10 {

    public static void main(String[] args) {
        Map<Integer, String> mapa = new LinkedHashMap<>();
        mapa.put(6, "seis");
        mapa.put(7, "siete");
        mapa.put(8, "ocho");
        mapa.put(9, "nueve");
        mapa.put(10, "diez");

        mapa.forEach((clave, valor) -> System.out.println("Clave: " + clave + ", " + "valor: " + valor));
    }
}
