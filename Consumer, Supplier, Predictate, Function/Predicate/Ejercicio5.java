package Predicate;

import java.util.function.BiPredicate;

public class Ejercicio5 {
    public static void main(String[] args) {
        BiPredicate<String, String> dosStringsSonIguales = (s1, s2) -> s1.equals(s2);
        System.out.println(dosStringsSonIguales.test("hola", "hola"));
        System.out.println(dosStringsSonIguales.test("hola", "adios"));
    }
}
