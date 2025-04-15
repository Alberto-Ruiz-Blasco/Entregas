package Predicate;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ejercicio9 {
    public static void main(String[] args) {
        List<String> words = List.of("Pilares", "Atómico", "Oso","Calvo", "Palo", "Alberto");
        Predicate<String> noEmpiezaPorP = s -> !s.startsWith("P");

        Consumer<String> palabras = s -> System.out.println(s);
        words.stream().filter(noEmpiezaPorP).forEach(palabras);
    }
}
