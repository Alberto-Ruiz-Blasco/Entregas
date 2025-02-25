package Heores_del_Reino;

import java.util.Scanner;

public class Arquero extends Heroe{
    private int precision;
    private static Scanner scanner = new Scanner(System.in);

    public Arquero(String name, int nivel, int puntosvida, armaEspecial armaespecial, int precision) {
        super(name, nivel, puntosvida, armaespecial);
        this.precision = precision;
    }

    public Arquero disparar(){
        String name;
        int nivel, puntosVida, precision;
        do {
            System.out.print("Nombre del Arquero/a: ");
            name = scanner.nextLine();

            if (!name.matches("[a-zA-Z]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!name.matches("[a-zA-Z]+"));

        do {
            try {
                System.out.print("Nivel: ");
                nivel = scanner.nextInt();

                scanner.nextLine();

                if (nivel >= 1000) {
                    System.out.println("Error. El nivel debe ser menor a 1000");
                    scanner.nextLine();
                    nivel = -1;
                }
            } catch (Exception e) {
                System.out.println("Error. Formato no válido");
                scanner.next();
                nivel = -1;
            }
        } while (nivel < 0);

        do {
            try {
                System.out.print("Puntos de vida: ");
                puntosVida = scanner.nextInt();

                scanner.nextLine();

                if (puntosVida >= 1000) {
                    System.out.println("Error. Los puntos de vida ser menor a 1000");
                    scanner.nextLine();
                    puntosVida = -1;
                }
            } catch (Exception e) {
                System.out.println("Error. Formato no válido");
                scanner.next();
                puntosVida = -1;
            }
        } while (puntosVida < 0);

        do {
            try {
                System.out.print("Precisión: ");
                precision = scanner.nextInt();

                if (precision >= 1000) {
                    System.out.println("Error. Los puntos de fuerza deben ser menor a 1000");
                    scanner.nextLine();
                    precision = -1;
                }
            } catch (Exception e) {
                System.out.println("Error. Formato no válido");
                scanner.next();
                precision = -1;
            }
        } while (precision < 0);

        scanner.nextLine();

        armaEspecial armaSeleccionada = armaEspecial.obtenerArma();

        return new Arquero(name, nivel, puntosVida, armaSeleccionada, precision);
    }

    @Override
    public String toString() {
        return "Arquero: [Nombre: " + getName() + ", nivel: " + getNivel() + ", puntos de vida: " + getPuntosvida() + ", precisión: " + precision + ", arma especial: " + getArmaespecial();
    }
}
