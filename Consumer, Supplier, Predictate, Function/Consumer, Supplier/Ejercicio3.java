package Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Ejercicio3 {
    public static void main(String[] args) {
        List<String> palabras = new ArrayList<>();
        Consumer<String> palabra = word -> System.out.println(word.charAt(word.length()-1));
        palabras.add("Dalea");
        palabras.add("av");
        palabras.add("tue");
        palabras.add("cuerpos");
        palabras.add("alegríat");
        palabras.add("macarenar");
        palabras.add("perrou");
        palabras.add("gatoc");
        palabras.add("peze");
        palabras.add("aves");
        palabras.forEach(palabra);
    }
}
