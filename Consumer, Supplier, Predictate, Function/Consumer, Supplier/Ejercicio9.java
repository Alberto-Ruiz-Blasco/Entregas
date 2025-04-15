package Consumer;

import java.util.function.BiConsumer;

public class Ejercicio9 {

    public static void calculator (int a, int b, BiConsumer<Integer, Integer> numeros){
        numeros.accept(a,b);
    }

    public static void main(String[] args) {
        BiConsumer<Integer, Integer> suma = (a,b) -> System.out.println("Suma de los números: " + (a+b));
        BiConsumer<Integer, Integer> resta = (a,b) -> System.out.println("Resta de los números: " + (a-b));
        BiConsumer<Integer, Integer> mult = (a,b) -> System.out.println("Multiplicación de los números: " + (a*b));

        calculator(3,2,suma);
        calculator(9,3,resta);
        calculator(5,10,mult);
    }
}
