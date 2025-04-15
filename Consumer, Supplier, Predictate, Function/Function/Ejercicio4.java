package Function;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Ejercicio4 {

    public static HashMap<String, Integer> convertirListaEnMap (List<String> cadena, Function<String, Integer> extraerLongitud){
        HashMap<String, Integer> mapa = new HashMap<>();

        for (String texto : cadena) {
            mapa.put(texto, texto.length());
        }
        return mapa;
    }

    public static void main(String[] args) {
        List<String> cadena = Arrays.asList("Palabra", "Cocodrilo", "Ave", "Avestruz");

        Map<String, Integer> mapa = convertirListaEnMap(cadena, (String texto) -> texto.length());

        mapa.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
