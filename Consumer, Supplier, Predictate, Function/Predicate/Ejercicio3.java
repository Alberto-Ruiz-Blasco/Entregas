package Predicate;

import java.util.function.Predicate;

public class Ejercicio3 {
    public static void main(String[] args) {
        Predicate<Integer> checker = i -> i >100 || i<50;
        System.out.println(checker.test(200));
        System.out.println(checker.test(2));
        System.out.println(checker.test(70));
    }
}
