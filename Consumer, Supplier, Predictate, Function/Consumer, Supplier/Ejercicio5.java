package Consumer;

import java.util.function.Supplier;

public class Ejercicio5 {
    public static void main(String[] args) {
        Supplier<Double> random = () -> Math.random();
        Double numero = random.get();
        System.out.println("Numero: " + numero);
    }
}
