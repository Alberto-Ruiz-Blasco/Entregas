package EjerciciosFicheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\numNaturales.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int i=1; i<=100; i++){
                System.out.println(i + "");
                bufferedWriter.write(Integer.toString(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}

