package Consumer;

import java.util.function.Supplier;

public class Ejercicio4 {
    public static void main(String[] args) {
        Supplier<String> palabra = () -> "Java es un lenguaje de programación";
        System.out.println(palabra.get());
    }
}
