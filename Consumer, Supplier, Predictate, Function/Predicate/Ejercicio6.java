package Predicate;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Ejercicio6 {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1,2,29,10,25,30,28,10,11,27);

        Predicate<Integer> mayor25 = i -> i >25;
        Predicate<Integer> menor30 = i -> i < 30;
        Predicate<Integer> validate = mayor25.and(menor30);

        Consumer<Integer> numbers = s -> System.out.println(s);
        numeros.stream().filter(validate).forEach(numbers);
    }
}
