package Function;

import java.util.function.Consumer;
import java.util.function.Function;

public class Ejemplo {
    public static void main(String[] args) {
        //Ejercicio 1
        System.out.println("EJERCICIO 1");
        Function<String, Integer> extraerLongitud = s -> s.length();
        Integer longitud = extraerLongitud.apply("Genero");
        System.out.println("logitud: " + longitud);

        Consumer<String> imprimir = i -> System.out.println(i);
        imprimir.accept("longitud: " + (extraerLongitud.apply("Genero")));

        System.out.println();

        //Ejercicio2
        System.out.println("EJERCICIO 2");
        Function<Integer, Integer> potencia = i -> (int) Math.pow(2, i);
        Integer valor = potencia.apply(4);
        System.out.println("Valor: " + valor);

        System.out.println();

        //Ejercicio 3
        System.out.println("EJERCICIO 3");
        Function<String, Integer> bifunciones = extraerLongitud.andThen(potencia);
        System.out.println("Valor: " + bifunciones.apply("Programación"));
    }
}
