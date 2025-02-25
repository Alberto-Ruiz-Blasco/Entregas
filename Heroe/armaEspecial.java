package Heores_del_Reino;

import java.util.ArrayList;
import java.util.Scanner;

public class armaEspecial {
    private String nombreArma;
    private int danyo;
    private static ArrayList<armaEspecial> arsenal = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public armaEspecial(String nombreArma, int danyo) {
        this.nombreArma = nombreArma;
        this.danyo = danyo;
    }

    public String getNombreArma() {
        return nombreArma;
    }

    public int getDanyo() {
        return danyo;
    }

    public static void mostrarArmas() {
        System.out.println("............ARMAS............");
        for (armaEspecial arma : arsenal) {
            System.out.println(arma);
        }
        System.out.println("..............................");
    }

    public static armaEspecial obtenerArma() {
        if (arsenal.isEmpty()) {
            System.out.println("No hay armas disponibles");
            return null;
        }

        mostrarArmas();

        System.out.print("Elige un arma por su nombre: ");
        String name = scanner.nextLine();

        for (armaEspecial arma : arsenal) {
            if (arma.getNombreArma().equalsIgnoreCase(name)) {
                return arma;
            }
        }

        System.out.println("Arma no encontrada, elige una válida");
        return obtenerArma();
    }

    @Override
    public String toString() {
        return "Arma especial: [Nombre: " + nombreArma + ", daño: " + danyo + "]";
    }

    public static void agregarArmaAlArsenal(armaEspecial nuevaArma) {
        arsenal.add(nuevaArma);
    }
}
