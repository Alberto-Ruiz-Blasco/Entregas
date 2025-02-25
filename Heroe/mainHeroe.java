package Heores_del_Reino;

import java.util.ArrayList;
import java.util.Scanner;

public class mainHeroe {
    private static Scanner scanner = new Scanner(System.in);
    private static Heroe heroe = new Heroe("Heroe",100,10,new armaEspecial("Arma",100));
    private static Guerrero guerrero = new Guerrero("Guerrero",100,100,new armaEspecial("Arma",100),30);
    private static Mago mago = new Mago("Mago",100,100,new armaEspecial("Arma",100),30);
    private static Arquero arquero = new Arquero("Arquero",100,100,new armaEspecial("Arma",100),30);
    private static Asesino asesino = new Asesino("Asesino",100,100,new armaEspecial("Arma",100),30);

    public static void primerMenu(){
        System.out.println("---------------------------------------------------");
        System.out.println("1- Añadir nuevo héroe");
        System.out.println("2- Añadir un arma nueva al arsenal");
        System.out.println("3- Eliminar un héroe por su nombre");
        System.out.println("4- Buscar un héroe y mostrar sus detalles");
        System.out.println("5- Listar todos los héroes registrados en el gremio");
        System.out.println("6- Salir del programa");
        System.out.println("---------------------------------------------------");
    }

    public static void segundoMenu(){
        System.out.println("----------------------------------");
        System.out.println("¿Qué tipo de héroe quieres añadir?");
        System.out.println("0- Cancelar");
        System.out.println("1: Guerrero/a");
        System.out.println("2: Mago/a");
        System.out.println("3: Arquero/a");
        System.out.println("4- Asesino/a");
        System.out.println("----------------------------------");
    }

    public static void addNewHeroe(){
        System.out.println("<<AÑADIR HÉROE>>");
        int opcion;
        boolean continuar = true;
        segundoMenu();

        while(continuar) {
            do {
                try {
                    System.out.print("Elige una subopción: ");
                    opcion = scanner.nextInt();

                    if (opcion < 0 || opcion > 4) {
                        System.out.println("<<OPCIÓN NO VÁLIDA>> Debe ser un número entre 0 y 6");
                    }
                } catch (Exception e) {
                    System.out.println("<<ERROR>> Debes ingresar un número válido");
                    scanner.next();
                    opcion = -1;
                }
            } while (opcion < 0 || opcion > 4);

            switch (opcion) {
                case 0:
                    System.out.println("Cancelando...");
                    continuar = false;
                    primerMenu();
                    break;
                case 1:
                    Guerrero newGuerrero = guerrero.atacar();

                    if (guerrero.addHeroe(newGuerrero)) {
                        System.out.println("Se ha añadido correctamente");
                    } else {
                        System.out.println("Este héroe ya existe");
                    }
                    System.out.println(newGuerrero);
                    break;
                case 2:
                    Mago newMago = mago.hechizar();

                    if (heroe.addHeroe(newMago)) {
                        System.out.println("Se ha añadido correctamente");
                    } else {
                        System.out.println("Este héroe ya existe");
                    }
                    System.out.println(newMago);
                    break;
                case 3:
                    Arquero newArquero = arquero.disparar();

                    if (arquero.addHeroe(newArquero)) {
                        System.out.println("Se ha añadido correctamente");
                    } else {
                        System.out.println("Este héroe ya existe");
                    }
                    System.out.println(newArquero);
                    break;
                case 4:
                    Asesino newAsesino = asesino.asesinar();

                    if (asesino.addHeroe(newAsesino)) {
                        System.out.println("Se ha añadido correctamente");
                    } else {
                        System.out.println("Este héroe ya existe");
                    }
                    System.out.println(newAsesino);
                    break;
            }    }
    }

    public static void newWeapon(){
        String name;
        int danyo;

        scanner.nextLine();

        do {
            System.out.print("Nombre del arma especial: ");
            name = scanner.nextLine();

            if (!name.matches("[a-zA-Z]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!name.matches("[a-zA-Z]+"));

        do {
            try {
                System.out.print("Daño: ");
                danyo = scanner.nextInt();

                scanner.nextLine();

                if (danyo >= 1000) {
                    System.out.println("Error. El daño debe ser menor a 1000");
                    scanner.nextLine();
                    danyo = -1;
                }
            } catch (Exception e) {
                System.out.println("Error. Formato no válido");
                scanner.next();
                danyo = -1;
            }
        } while (danyo < 0);

        armaEspecial nuevaArma = new armaEspecial(name, danyo);

        System.out.println("Se ha añadido el arma correctamente: " + nuevaArma);

        armaEspecial.agregarArmaAlArsenal(nuevaArma);

        armaEspecial.mostrarArmas();
    }

    public static void removeHeroe(){
        System.out.println("<<ELIMINAR HÉROE>>");
        String name;

        scanner.nextLine();

        do {
            System.out.print("Nombre del héroe a eliminar: ");
            name = scanner.nextLine();

            if (!name.matches("[a-zA-Z]+")) {
                System.out.println("Error. Formato no válido");
            }
        } while (!name.matches("[a-zA-Z]+"));

        Heroe heroeAEliminar = heroe.queryHeroe(name);

        if (heroeAEliminar != null) {
            heroe.removeHeroe(heroeAEliminar);
            System.out.println("Héroe eliminado correctamente");
        } else {
            System.out.println("Héroe no encontrado");
        }
    }


    public static void listaHeroes(){
        System.out.println("LISTA DE HÉROES");

        ArrayList<Heroe> lista = Heroe.getHeroes();

        if (lista.isEmpty()) {
            System.out.println("No hay héroes registrados");
            return;
        }

        for (Heroe h : lista) {
            System.out.println(h);
        }
    }

    public static void findHeroe(){
        System.out.println("<<BUSCAR HÉROE>>");
        String name;

        scanner.nextLine();

        do {
            System.out.print("Nombre del héroe a buscar: ");
            name = scanner.nextLine();

            if (!name.matches("[a-zA-Z]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!name.matches("[a-zA-Z]+"));

        Heroe buscarHeroe = Heroe.queryHeroe(name);

        if (buscarHeroe != null) {
            System.out.println(buscarHeroe);
        } else {
            System.out.println("Héroe no encontrado");
        }
    }

    public static void main(String[] args) {
        boolean continuar = true;
        int opcion;
        primerMenu();

        while(continuar) {
            do {
                try {
                    System.out.print("Elige una opción: ");
                    opcion = scanner.nextInt();

                    if (opcion < 0 || opcion > 6) {
                        System.out.println("<<OPCIÓN NO VÁLIDA>> Debe ser un número entre 0 y 6");
                    }
                } catch (Exception e) {
                    System.out.println("<<ERROR>> Debes ingresar un número válido");
                    scanner.next();
                    opcion = -1;
                }
            } while (opcion < 0 || opcion > 6);

            switch (opcion) {
                case 1:
                    addNewHeroe();
                    break;
                case 2:
                    newWeapon();
                    break;
                case 3:
                    removeHeroe();
                    break;
                case 4:
                    findHeroe();
                    break;
                case 5:
                    listaHeroes();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;
                default:
                    System.out.println("<<OPCIÓN NO VÁLIDA>>");
            }
        }
    }
}
