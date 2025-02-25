package Heores_del_Reino;

import java.util.Scanner;

public class Asesino extends Heroe {
    private int sigilo;
    private static Scanner scanner = new Scanner(System.in);

    public Asesino(String name, int nivel, int puntosvida, armaEspecial armaespecial, int sigilo) {
        super(name, nivel, puntosvida, armaespecial);
        this.sigilo = sigilo;
    }

    public Asesino asesinar(){
        String name;
        int nivel, puntosVida, sigilo;
        do {
            System.out.print("Nombre del Asesino/a: ");
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
                System.out.print("Sigilo: ");
                sigilo = scanner.nextInt();

                if (sigilo >= 1000) {
                    System.out.println("Error. Los puntos de fuerza deben ser menor a 1000");
                    scanner.nextLine();
                    sigilo = -1;
                }
            } catch (Exception e) {
                System.out.println("Error. Formato no válido");
                scanner.next();
                sigilo = -1;
            }
        } while (sigilo < 0);

        scanner.nextLine();

        armaEspecial armaSeleccionada = armaEspecial.obtenerArma();

        return new Asesino(name, nivel, puntosVida, armaSeleccionada, sigilo);
    }

    @Override
    public String toString() {
        return "Asesino: [Nombre: " + getName() + ", nivel: " + getNivel() + ", puntos de vida: " + getPuntosvida() + ", sigilo: " + sigilo + ", arma especial: " + getArmaespecial();
    }
}
