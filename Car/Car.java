package Car;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Car extends Vehiculo{

    private String tipoMotor;
    private static Scanner scanner = new Scanner(System.in);

    public Car(String marca, String modelo, LocalDate fFabricacion, double kilometraje, String tipoMotor) {
        super(marca, modelo, fFabricacion, kilometraje);
        this.tipoMotor = tipoMotor;
    }

    public Car obtenerDatosCoche(){
        String marca, modelo, tipomotor;
        double kilometraje;

        LocalDate fFabricacion = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            System.out.print("Marca: ");
            marca = scanner.nextLine();

            if (!marca.matches("[a-zA-Z\\s]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!marca.matches("[a-zA-Z\\s]+"));

        do {
            System.out.print("Modelo: ");
            modelo = scanner.nextLine();

            if (!modelo.matches("[a-zA-Z\\s]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!modelo.matches("[a-zA-Z\\s]+"));

        do {
            try {
                System.out.print("Fecha de fabricación (dd/MM/yyyy): ");
                String input = scanner.nextLine();
                fFabricacion = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Error. Formato de fecha no válido");
            }
        } while (fFabricacion == null);

        do {
            try {
                System.out.print("Kilometraje: ");
                kilometraje = scanner.nextDouble();

            } catch (Exception e){
                System.out.println("Error. Formato no válido");
                scanner.next();
                kilometraje = -1;
            }
        } while (kilometraje<0);

        scanner.nextLine();

        do {
            System.out.print("Tipo de motor: ");
            tipomotor = scanner.nextLine();

            if (!tipomotor.matches("[a-zA-Z\\s]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!tipomotor.matches("[a-zA-Z\\s]+"));

        return new Car(marca,modelo,fFabricacion,kilometraje,tipoMotor);
    }

    @Override
    public String toString() {
        return "COCHE: [Marca: " + getMarca() + ", modelo: " + getModelo() + ", fecha de fabricación: " + getfFabricacion() + ", kilometraje: " + getKilometraje() + ", tipo de motor: " + tipoMotor + "]";
    }
}
