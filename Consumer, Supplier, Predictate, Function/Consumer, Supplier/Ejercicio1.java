package Consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Cosas {
    public static void main(String[] args) {
        Consumer<String> printer3 = message-> System.out.println(message.substring(0,1).toUpperCase() + message.substring(1).toLowerCase());
        printer3.accept("ole los caracoles");
    }
}
