package Car;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class mainVehiculo {

    private static Scanner scanner = new Scanner(System.in);
    private static Vehiculo myVehiculo = new Vehiculo("l", "l", LocalDate.now(), 9);
    private static Car myCar = new Car("l", "l", LocalDate.now(), 9, "l");
    private static Motocicleta myMotocicleta = new Motocicleta("l", "l", LocalDate.now(), 9, 2);
    private static Camion myCamion = new Camion("l", "l", LocalDate.now(), 9, 9);
    private static Bicicleta myBicicleta = new Bicicleta("l", "l", LocalDate.now(), 9, "l");

    public static void primerMenu(){
        System.out.println("--------------------------------------------");
        System.out.println("1- Agregar un nuevo vehículo");
        System.out.println("2- Eliminar un vehículo por modelo.");
        System.out.println("3- Listar todos los vehículos registrados.");
        System.out.println("4- Buscar vehículo por su modelo");
        System.out.println("5- Buscar por clave");
        System.out.println("6- Salir del programa");
        System.out.println("--------------------------------------------");
    }

    public static void segundoMenu(){
        System.out.println("-----------------");
        System.out.println("1- Coche");
        System.out.println("2- Motocicleta");
        System.out.println("3- Camión");
        System.out.println("4- Bicicleta");
        System.out.println("5- Atrás");
        System.out.println("-----------------");
    }

    public static void addNewVehicle(){
        System.out.println("<<AÑADIR VEHÍCULO>>");
        int opcion;
        boolean continuar = true;
        segundoMenu();

        while (continuar){
            do {
                try {
                    System.out.print("Elige una subopción: ");
                    opcion = scanner.nextInt();

                    if (opcion < 0 || opcion > 5) {
                        System.out.println("<<OPCIÓN NO VÁLIDA>> Debe ser un número entre 0 y 5");
                    }
                } catch (Exception e) {
                    System.out.println("<<ERROR>> Debes ingresar un número válido");
                    scanner.next();
                    opcion = -1;
                }
            } while (opcion < 0 || opcion > 5);

            switch (opcion){
                case 0:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;
                case 1:
                    Car car = myCar.obtenerDatosCoche();

                    if (myVehiculo.addVehiculo(car)){
                        System.out.println("Se ha añadido correctamente");
                    } else {
                        System.out.println("Este vehículo ya existe");
                    }
                    System.out.println("-------------------------------");
                    break;
                case 2:
                    Motocicleta motocicleta = myMotocicleta.obtenerDatosMotocicleta();

                    if (myVehiculo.addVehiculo(motocicleta)){
                        System.out.println("Se ha añadido correctamente");
                    } else {
                        System.out.println("Este vehículo ya existe");
                    }
                    System.out.println("-------------------------------");
                    break;
                case 3:
                    Camion camion = myCamion.obtenerDatosCamion();

                    if (myVehiculo.addVehiculo(camion)){
                        System.out.println("Se ha añadido correctamente");
                    } else {
                        System.out.println("Este vehículo ya existe");
                    }
                    System.out.println("-------------------------------");
                    break;
                case 4:
                    Bicicleta bicicleta = myBicicleta.obtenerDatosBicicleta();

                    if (myVehiculo.addVehiculo(bicicleta)){
                        System.out.println("Se ha añadido correctamente");
                    } else {
                        System.out.println("Este vehículo ya existe");
                    }
                    System.out.println("-------------------------------");
                    break;
                case 5:
                    System.out.println("Cancelando...");
                    continuar = false;
                    primerMenu();
                    break;
            }
        }
    }

    public static void removeVehicle(){
        System.out.println("<<ELIMINAR VEHÍCULO>>");
        String modelo;

        scanner.nextLine();

        do {
            System.out.print("Modelo del vehículo: ");
            modelo = scanner.nextLine();

            if (!modelo.matches("[a-zA-Z]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!modelo.matches("[a-zA-Z]+"));

        Vehiculo eliminarVehiculo = myVehiculo.queryVehiculo(modelo);

        if (myVehiculo.queryVehiculo(modelo) != null){
            myVehiculo.removeVehiculo(eliminarVehiculo);
            System.out.println("Se ha elimimado correctamente");
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    public static void findVehiculo(){
        System.out.println("<<BUSCAR VEHÍCULO>>");
        String modelo;

        scanner.nextLine();

        do {
            System.out.print("Modelo del vehículo: ");
            modelo = scanner.nextLine();

            if (!modelo.matches("[a-zA-Z]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!modelo.matches("[a-zA-Z]+"));

        Vehiculo buscarVehiculo = myVehiculo.queryVehiculo(modelo);

        if (myVehiculo.queryVehiculo(modelo)!=null){
            System.out.println(buscarVehiculo);
        } else {
            System.out.println("No se ha encontrado este vehículo");
        }
    }

    public static void findClave() {
        System.out.println("<<BUSCAR VEHÍCULO POR CLAVE>>");
        scanner.nextLine();

        System.out.print("Ingrese la clave (marca, modelo, fecha, kilometraje): ");
        String clave = scanner.nextLine().toLowerCase();

        System.out.print("Ingrese el valor: ");
        String valor = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        ArrayList<Vehiculo> resultados = new ArrayList<>();

        for (Vehiculo vehiculo : Vehiculo.getVehiculos()) {
            switch (clave) {
                case "marca":
                    if (vehiculo.getMarca().equalsIgnoreCase(valor)) {
                        resultados.add(vehiculo);
                    }
                    break;
                case "modelo":
                    if (vehiculo.getModelo().equalsIgnoreCase(valor)) {
                        resultados.add(vehiculo);
                    }
                    break;
                case "fecha":
                    try {
                        LocalDate fechaBuscada = LocalDate.parse(valor, formatter);
                        if (vehiculo.getfFabricacion().equals(fechaBuscada)) {
                            resultados.add(vehiculo);
                        }
                    } catch (Exception e) {
                        System.out.println("Formato de fecha incorrecto. Usa dd/MM/YYYY");
                        return;
                    }
                    break;
                case "kilometraje":
                    try {
                        double kmBuscado = Double.parseDouble(valor);
                        if (vehiculo.getKilometraje() == kmBuscado) {
                            resultados.add(vehiculo);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Kilometraje inválido. Debe ser un número.");
                        return;
                    }
                    break;
                default:
                    System.out.println("Clave no válida.");
                    return;
            }
        }

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron vehículos");
        } else {
            System.out.println("Vehículo/s encontrados: ");
            for (Vehiculo vehiculo : resultados) {
                System.out.println(vehiculo);
            }
        }
    }


    public static void printVehiculos(){
        System.out.println("<<LISTA VEHÍCULOS>>");
        ArrayList<Vehiculo> misVehiculos = Vehiculo.getVehiculos();

        if (misVehiculos.isEmpty()){
            System.out.println("La lista de vehículos está vacía");
        }

        for (Vehiculo vehiculos : misVehiculos){
            System.out.println(vehiculos);
        }
    }

    public static void main(String[] args) {
        System.out.println("<<AÑADIR VEHÍCULO>>");
        int opcion;
        boolean continuar = true;
        primerMenu();

        while (continuar){
            do {
                try {
                    System.out.print("Elige una opción: ");
                    opcion = scanner.nextInt();

                    if (opcion < 0 || opcion > 6) {
                        System.out.println("<<OPCIÓN NO VÁLIDA>> Debe ser un número entre 0 y 6");
                    }
                } catch (Exception e) {
                    System.out.println("<<ERROR>> Debes ingresar un número válido");
                    scanner.next();
                    opcion = -1;
                }
            } while (opcion < 0 || opcion > 6);

            switch (opcion){
                case 1:
                    addNewVehicle();
                    break;
                case 2:
                    removeVehicle();
                    break;
                case 3:
                    printVehiculos();
                    break;
                case 4:
                    findVehiculo();
                    break;
                case 5:
                    findClave();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;
            }
        }
    }
}
