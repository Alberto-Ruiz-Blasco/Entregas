package Function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ejercicio6a10 {

    public static BiFunction<Integer, Integer, String> realizar(BiFunction<Integer, Integer, String> bifuncion){
        return bifuncion;
    }

    public static <T, U, R> BiFunction<T, U, R> realizarGenerico(BiFunction<T, U, R> bifuncion) {
        return bifuncion;
    }

    public static void main(String[] args) {
        System.out.println("EJERCICIO 6");
        BiFunction<Integer, Integer, Double> potencia = (a, b) -> Math.pow(a, b);
        double resultado = potencia.apply(2, 3);
        System.out.println("El resultado es: " + resultado);

        System.out.println();

        System.out.println("EJERCICIO 7");
        Function<Double, String> convertir = (a) -> a.toString();
        String numero = convertir.apply(8.0);
        System.out.println("El resultado es: " + numero);

        System.out.println();

        System.out.println("EJERCICIO 8");
        BiFunction<Integer, Integer, String> bifuncion = potencia.andThen(convertir);
        String resultado2 = bifuncion.apply(2, 4);
        System.out.println("El resultado es: " + resultado2);

        System.out.println();

        System.out.println("EJERCICIO 9");
        BiFunction<Integer, Integer, String> funcionUsada = realizar(bifuncion);
        String resultado3 = funcionUsada.apply(2, 4);
        System.out.println("El resultado es: " + resultado3);

        System.out.println();

        System.out.println("EJERCICIO 10");
        BiFunction<Integer, Integer, String> funcionUsada2 = realizarGenerico(bifuncion);
        String resultado4 = funcionUsada2.apply(2, 4);
        System.out.println("El resultado es: " + resultado4);

    }
}
