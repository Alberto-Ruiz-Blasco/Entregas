package Alojados;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Alojados {

    public static void copiar(String ficheroEntrada, String ficheroSalida) {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ficheroEntrada))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(";");

                if (campos.length>=3){
                    String primerCampo = campos[0];
                    String tercerCampo = campos[2];
                    String septimoCampo = campos[7];

                    if (septimoCampo.contains("H")) {
                        lineas.add(primerCampo + "; " + tercerCampo);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
            return;
        }

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
        String ficheroEntrada = "C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\Alojados\\jugadores.txt";
        String ficheroSalida = "C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\Alojados\\alojadosHotel.txt";
        copiar(ficheroEntrada, ficheroSalida);
    }
}
