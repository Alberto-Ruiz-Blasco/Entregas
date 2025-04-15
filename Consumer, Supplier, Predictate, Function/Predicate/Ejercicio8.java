package Predicate;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ejercicio8 {
    public static void main(String[] args) {
        List<String> words = List.of("Avestruz", "Atómico", "Oso","Calvo", "Palo", "Alberto");
        Predicate<String> startsWithA = s -> s.startsWith("A");
        Predicate<String> longitud5 =s -> s.length() == 5;
        Predicate<String> validate = startsWithA.or(longitud5);

        Consumer<String> palabras = s -> System.out.println(s);
        words.stream().filter(validate).forEach(palabras);
    }
}
