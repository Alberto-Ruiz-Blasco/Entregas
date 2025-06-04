package EjerciciosFicheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio6 {

    public static void contar(String archivo){
        List<String> lineas = new ArrayList<>();
        int totalCaracteres = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
                totalCaracteres += linea.length();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
            return;
        }

        System.out.println("Total de caracteres en el archivo: " + totalCaracteres);
    }

    public static void main(String[] args) {
        String archivo = "C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\datos.txt";
        contar(archivo);
    }
}
