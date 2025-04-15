package Function;

import java.util.function.BiFunction;

public class Ejercicio5 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> sumar = (a, b) -> a + b;
        int resultado = sumar.apply(8, 7);
        System.out.println("La suma es: " + resultado);
    }

}
