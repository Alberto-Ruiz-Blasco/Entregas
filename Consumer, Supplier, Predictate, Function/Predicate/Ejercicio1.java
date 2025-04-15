package Predicate;

import java.util.function.Predicate;

public class Ejercicio1 {
    public static void main(String[] args) {
        Predicate<Integer> mayorQueCien = i -> i > 100;
        System.out.println(mayorQueCien.test(101));
        System.out.println(mayorQueCien.test(10));
    }
}
