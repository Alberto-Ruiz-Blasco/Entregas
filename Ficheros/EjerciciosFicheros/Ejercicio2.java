package EjerciciosFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Ejercicio2 {

    public static int obtenerSumaNumerosArchivo(String archivo){
        File file = new File(archivo);
        int numero, suma = 0, cont = 0;
        Scanner entrada;
        try {
            entrada = new Scanner(file);
            while (entrada.hasNextInt()) {
                numero = entrada.nextInt();
                System.out.println(numero);
                suma = suma + numero;
                cont++;
            }
            System.out.println("Número leídos: " + cont);
            entrada.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return suma;
    }

    public static void main(String[] args) {
        String ejercicio1 = "C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\numNaturales.txt";
        int suma = obtenerSumaNumerosArchivo(ejercicio1);
        System.out.println("Suma: " + suma);
    }
}

