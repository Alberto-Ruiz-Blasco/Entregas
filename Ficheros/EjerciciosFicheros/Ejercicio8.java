package EjerciciosFicheros;

import java.util.Scanner;

public class Ejercicio8 {
    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarArchivoPantalla (String archivo){
        System.out.print("Introduce la palabra del archivo: ");
        String palabra = scanner.nextLine();

    }

    public static void main(String[] args) {
        String archivo = "C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\datos.txt";
        mostrarArchivoPantalla(archivo);
    }
}
