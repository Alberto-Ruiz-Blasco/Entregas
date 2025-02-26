package Vuelo;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;

public class mainVuelo {
    private static Scanner scanner = new Scanner(System.in);
    private static Vuelo vuelo = new Vuelo(YearMonth.now(), "Si", "Tambien", new Dia(2,3), "primerisima");
    private static Dia miDia = new Dia(20,12);
    private static Numero miNumero = new Numero();

    public static void menu(){
        System.out.println("=================================");
        System.out.println("VUELOS DEL AEROPUERTO DE VALENCIA");
        System.out.println("=================================");
        System.out.println("1- Imprimir todos los vuelos");
        System.out.println("2- Buscar un número de vuelo");
        System.out.println("3- Buscar vuelo por clave");
        System.out.println("4- Añadir vuelo nuevo");
        System.out.println("5- Borrar vuelo por número");
        System.out.println("0- Salir");
        System.out.println("---------------------------------");
    }

    public static void printVuelo(){
        System.out.println("<<LISTA DE VUELOS>>");

        ArrayList<Vuelo> listaVuelos = vuelo.getVuelos();

        if (listaVuelos.isEmpty()){
            System.out.println("No hay vuelos");
        }

        for (Vuelo misVuelos : listaVuelos){
            System.out.println(misVuelos);
        }
    }

    public static void findVuelo(){
        System.out.println("<<BUSCAR VUELO POR NÚMERO>>");
        YearMonth numero;

        ArrayList<Vuelo> listaVuelos = vuelo.getVuelos();

        if (listaVuelos.isEmpty()){
            System.out.println("No hay vuelos");
        }

        numero = miNumero.obtenerNumero();

        Vuelo buscarVuelo = Vuelo.queryVuelo(numero);

        if (buscarVuelo != null){
            System.out.println(buscarVuelo);
        } else {
            System.out.println("No se ha encontrado el vuelo");
        }
    }

    public static void findClave(){
        System.out.println("<<BUSCAR POR CLAVE>>");

        if (Vuelo.getVuelos().isEmpty()){
            System.out.println("No hay vuelos");
            return;
        }

        String clave;

        scanner.nextLine();

        do {
            System.out.print("Clave (en minúsculas): ");
            clave = scanner.nextLine();


            if (!clave.matches("numero|origen|destino|dia|clase")){
                System.out.println("Opción no válida");
            }
        } while (!clave.matches("numero|origen|destino|dia|clase"));

        String valor;
        System.out.print("Valor: ");
        valor = scanner.nextLine().trim();

        ArrayList<Vuelo> findClave = vuelo.queryClave(clave,valor);

        if (findClave.isEmpty()){
            System.out.println("No existe este vuelo");
        } else {
            for (Vuelo vuelo : findClave){
                System.out.println(vuelo);
            }
        }
    }

    public static void addNewVuelo(){
        System.out.println("<<AÑADIR VUELO>>");
        YearMonth numero;
        String origen, destino, clase;
        Dia dia;

        numero = miNumero.obtenerNumero();

        scanner.nextLine();

        do {
            System.out.print("Origen: ");
            origen = scanner.nextLine();

            if (!origen.matches("[a-zA-Z\\s]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!origen.matches("[a-zA-Z\\s]+"));

        do {
            System.out.print("Destino: ");
            destino= scanner.nextLine();

            if (!destino.matches("[a-zA-Z\\s]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!destino.matches("[a-zA-Z\\s]+"));

        dia = miDia.obtenerDia();

        do {
            System.out.print("Clase (Turista o Primera): ");
            clase = scanner.nextLine();

            if (!clase.matches("Turista|turista|Primera|primera")){
                System.out.println("Error. Formato no válido");
            }
        } while (!clase.matches("Turista|turista|Primera|primera"));

        Vuelo newVuelo = new Vuelo(numero,origen,destino,dia,clase);

        if (vuelo.addNewVuelo(newVuelo)){
            System.out.println("Se ha añadido correctamente");
        } else {
            System.out.println("Este vuelo ha existe");
        }
    }

    public static void removeVuelo(){
        System.out.println("<<ELIMINAR VUELO>>");
        YearMonth numero;

        ArrayList<Vuelo> listaVuelos = vuelo.getVuelos();

        if (listaVuelos.isEmpty()){
            System.out.println("No hay vuelos");
        }

        numero = miNumero.obtenerNumero();

        Vuelo eliminarVuelo = Vuelo.queryVuelo(numero);

        if (eliminarVuelo != null){
            vuelo.removeVuelo(eliminarVuelo);
            System.out.println("Se ha eliminado correctamente el número " + numero);
        } else {
            System.out.println("Este vuelo no existe");
        }
    }

    public static void main(String[] args) {

        Vuelo vuelo1 = new Vuelo(YearMonth.of(2023, 1), "Valencia", "Menorca", new Dia(15, 8), "Turista");
        Vuelo vuelo2 = new Vuelo(YearMonth.of(2023, 2), "Valencia", "Tenerife", new Dia(20, 8), "Turista");
        Vuelo vuelo3 = new Vuelo(YearMonth.of(2023, 3), "París", "Valencia", new Dia(15, 8), "Primera");
        Vuelo vuelo4 = new Vuelo(YearMonth.of(2023, 4), "Atenas", "Valencia", new Dia(20, 8), "Primera");

        vuelo.addNewVuelo(vuelo1);
        vuelo.addNewVuelo(vuelo2);
        vuelo.addNewVuelo(vuelo3);
        vuelo.addNewVuelo(vuelo4);

        boolean continuar = true;
        int opcion;
        menu();

        while(continuar) {
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

            switch (opcion) {
                case 1:
                    printVuelo();
                    break;
                case 2:
                    findVuelo();
                    break;
                case 3:
                    findClave();
                    break;
                case 4:
                    addNewVuelo();
                    break;
                case 5:
                    removeVuelo();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("<<OPCIÓN NO VÁLIDA>>");
            }
        }
    }
}
