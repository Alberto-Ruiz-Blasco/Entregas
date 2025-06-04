package EjerciciosFicheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio7 {

    public static void mostrarArchivoPantalla (String archivo){
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String archivo = "C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\datos.txt";
        mostrarArchivoPantalla(archivo);
    }
}
