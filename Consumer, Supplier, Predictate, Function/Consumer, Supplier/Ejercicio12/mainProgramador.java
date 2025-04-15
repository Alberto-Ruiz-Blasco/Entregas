package Consumer.Ejercicio12;

import java.time.LocalDate;
import java.util.function.Supplier;

public class mainProgramador {
    public static void main(String[] args) {
        Supplier<Programador> programador =()-> new Programador("Pepe", 3, LocalDate.of(2024, 7, 12));
        Programador progr = programador.get();
        System.out.println(progr);
    }
}
