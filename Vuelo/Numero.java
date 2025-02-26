package Vuelo;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Numero {
    private static Scanner scanner = new Scanner(System.in);

    public Numero() {
    }

    public YearMonth obtenerNumero(){
        DateTimeFormatter numeroFormatter = DateTimeFormatter.ofPattern("yyyy-MM");

        YearMonth numeroVuelo = null;

        do {
            try {
                System.out.print("Introduce el número de vuelo (yyyy-MM): ");
                String inputNumero = scanner.nextLine();

                numeroVuelo = YearMonth.parse(inputNumero, numeroFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("Error. Formato de número de vuelo no válido");
            }
        } while (numeroVuelo == null);

        return numeroVuelo;
    }
}
