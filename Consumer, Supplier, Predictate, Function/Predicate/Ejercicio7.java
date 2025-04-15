package Predicate;

import java.util.List;
import java.util.function.Predicate;

public class Ejercicio7 {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(1,22,29,10,25,30,22,10,11,27);
        Predicate<Integer> igualA22 = i -> i == 22;

        long cantidad = numeros.stream().filter(igualA22).count();
        System.out.println("Cantidad de veces que se repite: " + cantidad);
    }
}
