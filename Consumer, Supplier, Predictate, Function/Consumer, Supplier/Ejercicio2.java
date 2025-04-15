package Consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Cosas {
    public static void main(String[] args) {
        System.out.println("-----Lista enteros (EJERCICIO 2)-----");
        List<Integer> elements = new ArrayList<>();
        Consumer<Integer> elemento = element-> System.out.println(element);
        elements.add(1);
        elements.add(2);
        elements.add(3);
        elements.add(4);
        elements.add(5);
        elements.add(6);
        elements.add(7);
        elements.add(8);
        elements.add(9);
        elements.add(10);
        names.forEach(element-> System.out.println(element));
    }
}
