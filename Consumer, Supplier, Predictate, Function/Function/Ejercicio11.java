package Function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Ejercicio11 {
    public static void main(String[] args) {
        List<String> cadena = Arrays.asList("Palabra", "Cocodrilo", "Ave", "Avestruz");

        BiFunction<String, Integer, String> longitudMayorQue5 = (texto, longitud) -> {
            if (texto.length() > longitud) {
                return texto;
            } else {
                return null;
            }
        };

        for (String texto : cadena) {
            String resultado = longitudMayorQue5.apply(texto, 5);
            if (resultado != null) {
                System.out.println(resultado + " tiene una longitud mayor que 5");
            }
        }
    }
}
