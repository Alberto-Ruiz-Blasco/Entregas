package Predicate;

import java.util.function.Predicate;

public class Ejercicio2 {
    public static void main(String[] args) {
        Predicate<Integer> entreCienyTrescientos = i -> i >= 100 && i <= 300;
        System.out.println(entreCienyTrescientos.test(101));
        System.out.println(entreCienyTrescientos.test(10));
    }
}
