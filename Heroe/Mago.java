package Heores_del_Reino;

import ej1.Contacto;

import java.util.Scanner;

public class Mago extends Heroe{
    private int mana;
    private static Scanner scanner = new Scanner(System.in);

    public Mago(String name, int nivel, int puntosvida, armaEspecial armaespecial, int mana) {
        super(name, nivel, puntosvida, armaespecial);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public Mago hechizar(){
        String name;
        int nivel, puntosVida, mana;
        do {
            System.out.print("Nombre del Mago/a: ");
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
                System.out.print("Mana: ");
                mana = scanner.nextInt();

                if (mana >= 1000) {
                    System.out.println("Error. El mana ser menor a 1000");
                    scanner.nextLine();
                    mana = -1;
                }
            } catch (Exception e) {
                System.out.println("Error. Formato no válido");
                scanner.next();
                mana = -1;
            }
        } while (mana < 0);

        scanner.nextLine();

        armaEspecial armaSeleccionada = armaEspecial.obtenerArma();

        return new Mago(name, nivel, puntosVida, armaSeleccionada, mana);
    }

    @Override
    public String toString() {
        return "Héroe: [Nombre: " + getName() + ", nivel: " + getNivel() + ", puntos de vida: " + getPuntosvida() + ", mana: " + mana + ", arma especial: " + getArmaespecial();
    }
}
