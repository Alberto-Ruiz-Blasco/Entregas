package ej1;

import java.util.HashMap;
import java.util.Scanner;

public class mainUbicacion {

    private static HashMap<Integer, Ubicacion> ubicaciones;

    public mainUbicacion() {
        ubicaciones = new HashMap<>();

        ubicaciones.put(0, new Ubicacion(0, "Estás sentado en la clase de programación"));
        ubicaciones.put(1, new Ubicacion(1, "Estás en la cima de una montaña"));
        ubicaciones.put(2, new Ubicacion(2, "Estás bañándote en la playa"));
        ubicaciones.put(3, new Ubicacion(3, "Estás dentro de un edificio muy alto"));
        ubicaciones.put(4, new Ubicacion(4, "Estás de pie en un puente"));
        ubicaciones.put(5, new Ubicacion(5, "Estás en un bosque"));

        ubicaciones.get(1).addExit("N",5);
        ubicaciones.get(1).addExit("S",4);
        ubicaciones.get(1).addExit("E",3);
        ubicaciones.get(1).addExit("O",2);
        ubicaciones.get(1).addExit("Q",0);

        ubicaciones.get(2).addExit("N",5);
        ubicaciones.get(2).addExit("Q",0);

        ubicaciones.get(3).addExit("O",1);
        ubicaciones.get(3).addExit("Q",0);

        ubicaciones.get(4).addExit("N",1);
        ubicaciones.get(4).addExit("O",2);
        ubicaciones.get(4).addExit("Q",0);

        ubicaciones.get(5).addExit("S",1);
        ubicaciones.get(5).addExit("O",2);
        ubicaciones.get(5).addExit("Q",0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mainUbicacion mainubicacion = new mainUbicacion();
        int posicion = 1;
        String direccion;

        System.out.println("ººººººººººººººººººººººººººººººººººº");

        do {
            System.out.println("OUTPUT: ");
            System.out.println(mainubicacion.ubicaciones.get(posicion).getDescripcion());
            System.out.print("Tus salidas válidas son: ");
            for (String salida : mainUbicacion.ubicaciones.get(posicion).getExists().keySet()){
                System.out.print(salida + " ");
            }

            System.out.println();
            System.out.println("ººººººººººººººººººººººººººººººººººº");

            System.out.print("INPUT: ");
            direccion = scanner.nextLine().toUpperCase();

            if (mainubicacion.ubicaciones.get(posicion).getExists().containsKey(direccion)){
                posicion = mainubicacion.ubicaciones.get(posicion).getExists().get(direccion);

            } else {
                System.out.println("No puedes ir a ese lugar");
            }
        } while (!direccion.equalsIgnoreCase("Q"));

        System.out.println("Saliendo...");
    }
}
