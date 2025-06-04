package EjerciciosFicheros;

import javax.annotation.processing.Filer;
import java.io.*;
import java.util.Scanner;

public class Ejercicio3 {

    public static boolean esPrimo(int numero){
        for (int i=2; i<=Math.sqrt(numero); i++){
            if (numero % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void escribirPrimo(){
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\primos.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i=1; i<=500; i++){
                if (esPrimo(i)){
                    bufferedWriter.write(Integer.toString(i));
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void leerPrimo(){
        File file = new File("C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\primos.txt");
        Scanner entrada;
        try {
            entrada = new Scanner(file);
            while (entrada.hasNextInt()) {
                System.out.println(entrada.nextLine());
            }
            entrada.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        escribirPrimo();
        leerPrimo();
    }
}
