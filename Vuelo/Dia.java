package Vuelo;

import java.util.Objects;
import java.util.Scanner;

public class Dia {
    private static Scanner scanner = new Scanner(System.in);
    private int diaVuelo = 0;
    private int mesVuelo = 0;

    public Dia(int diaVuelo, int mesVuelo) {
        this.diaVuelo = diaVuelo;
        this.mesVuelo = mesVuelo;
    }

    public int getDiaVuelo() {
        return diaVuelo;
    }

    public int getMesVuelo() {
        return mesVuelo;
    }

    public Dia obtenerDia(){
        do {
            try {
                System.out.print("Introduce el día del vuelo (dd-MM): ");
                String inputDia = scanner.nextLine();
                String[] partesDia = inputDia.split("-");
                diaVuelo = Integer.parseInt(partesDia[0]);
                mesVuelo = Integer.parseInt(partesDia[1]);

                if (diaVuelo < 1 || diaVuelo > 31 || mesVuelo < 1 || mesVuelo > 12) {
                    System.out.println("Fecha no válida");
                    diaVuelo = 0;
                    mesVuelo = 0;
                }
            } catch (Exception e) {
                System.out.println("Error. Formato de día no válido o valores fuera de rango");
            }
        } while (diaVuelo == 0 || mesVuelo == 0);

        return new Dia(diaVuelo,mesVuelo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Dia dia = (Dia) obj;

        return diaVuelo == dia.diaVuelo && mesVuelo == dia.mesVuelo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(diaVuelo, mesVuelo);
    }

    @Override
    public String toString() {
        return diaVuelo + "-" + mesVuelo;
    }
}
