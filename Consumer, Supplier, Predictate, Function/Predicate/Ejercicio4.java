package Predicate;

import java.util.function.Predicate;

public class Ejercicio4 {
    public static void main(String[] args) {
        Predicate<Integer> distintoDeCien = i -> i != 100;
        System.out.println(distintoDeCien.test(101));
        System.out.println(distintoDeCien.test(10));
        System.out.println(distintoDeCien.test(100));
    }
}
