package Heores_del_Reino;

import java.util.Scanner;

public class Guerrero extends Heroe{
    private int fuerza;
    private static Scanner scanner = new Scanner(System.in);

    public Guerrero(String name, int nivel, int puntosvida, armaEspecial armaespecial, int fuerza) {
        super(name, nivel, puntosvida, armaespecial);
        this.fuerza = fuerza;
    }

    public Guerrero atacar(){
        String name;
        int nivel, puntosVida, fuerza;
        do {
            System.out.print("Nombre del Guerrero/a: ");
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
                System.out.print("Fuerza: ");
                fuerza = scanner.nextInt();

                if (fuerza >= 1000) {
                    System.out.println("Error. Los puntos de fuerza deben ser menor a 1000");
                    scanner.nextLine();
                    fuerza = -1;
                }
            } catch (Exception e) {
                System.out.println("Error. Formato no válido");
                scanner.next();
                fuerza = -1;
            }
        } while (fuerza < 0);

        scanner.nextLine();

        armaEspecial armaSeleccionada = armaEspecial.obtenerArma();

        return new Guerrero(name, nivel, puntosVida, armaSeleccionada, fuerza);
    }

    @Override
    public String toString() {
        return "Guerrero: [Nombre: " + getName() + ", nivel: " + getNivel() + ", puntos de vida: " + getPuntosvida() + ", fuerza: " + fuerza + ", arma especial: " + getArmaespecial();
    }
}
