package EjerciciosFicheros;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ejercicio5 {

    public static void ordenar(String ficheroEntrada, String ficheroSalida){
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
            return;
        }

        Collections.sort(lineas);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ficheroSalida))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String ficheroEntrada ="C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\datos.txt";
        String ficheroSalida = "C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\ej5.txt";
        ordenar(ficheroEntrada,ficheroSalida);
    }
}