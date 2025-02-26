package Car;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Camion extends Vehiculo{

    private int capacidadCarga;
    private static Scanner scanner = new Scanner(System.in);

    public Camion(String marca, String modelo, LocalDate fFabricacion, double kilometraje, int capacidadCarga) {
        super(marca, modelo, fFabricacion, kilometraje);
        this.capacidadCarga = capacidadCarga;
    }

    public Camion obtenerDatosCamion(){
        String marca, modelo;
        double kilometraje;
        int capacidadCarga;

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

        do {
            try {
                System.out.print("Capacidad de carga: ");
                capacidadCarga = scanner.nextInt();

            } catch (Exception e){
                System.out.println("Error. Formato no válido");
                scanner.next();
                capacidadCarga = -1;
            }
        } while (capacidadCarga<0);

        return new Camion(marca,modelo,fFabricacion,kilometraje,capacidadCarga);
    }

    @Override
    public String toString() {
        return "CAMIÓN: [Marca: " + getMarca() + ", modelo: " + getModelo() + ", fecha de fabricación: " + getfFabricacion() + ", kilometraje: " + getKilometraje() + ", capacidad de carga: " + capacidadCarga + "]";

    }
}
