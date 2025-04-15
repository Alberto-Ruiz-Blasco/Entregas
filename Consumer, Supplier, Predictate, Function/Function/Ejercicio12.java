package Function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Ejercicio12 {
    public static void main(String[] args) {
        List<String> cadena = Arrays.asList("Palabra", "Cocodrilo", "Ave", "Avestruz");

        Function<String, String> empiezaConLetra = (texto) -> {
            if (texto.startsWith("A")) {
                return texto;
            } else {
                return null;
            }
        };

        for (String texto : cadena) {
            String resultado = empiezaConLetra.apply(texto);
            if (resultado != null) {
                System.out.println(resultado + " empieza con una letra A");
            }
        }
    }
}
