package book;

import java.util.ArrayList;
import java.util.Scanner;

public class mainLibro {

    private static Scanner scanner = new Scanner(System.in);
    private static Libro libro = new Libro("Albert in Java", "Alberto", 1000);
    private static Novel novel = new Novel("Si","no",100,"prosa");
    private static Science science = new Science("Si","no",100,"prosa");
    private static History history = new History("Si","no",100,"dos");
    private static Comic comic = new Comic("Si","no",100, "yo");

    public static void primerMenu(){
        System.out.println("----------------------");
        System.out.println("1- Añadir libro");
        System.out.println("2- Eliminar libro");
        System.out.println("3- Buscar libro");
        System.out.println("4- Listado de libros");
        System.out.println("5- Salir");
        System.out.println("----------------------");
    }

    public static void segundoMenu(){
        System.out.println("-----------------");
        System.out.println("1- Novel");
        System.out.println("2- Science book");
        System.out.println("3- History book");
        System.out.println("4- Comic book");
        System.out.println("5- Cancelar");
        System.out.println("-----------------");
    }

    public static void addNewLibro(){
        System.out.println("<<AÑADIR LIBRO>>");
        int opcion;
        boolean continuar = true;

        segundoMenu();

        while (continuar){
            do {
                try {
                    System.out.print("Elige una subopción: ");
                    opcion = scanner.nextInt();

                    if (opcion<0 || opcion>5){
                        System.out.println("Las opciones van del 1 al 5");
                        opcion = -1;
                    }
                } catch (Exception e){
                    System.out.println("Formato no válido");
                    scanner.next();
                    opcion = -1;
                }
            } while (opcion<0);

            switch (opcion){
                case 1:
                    Novel newNovel = novel.datosNovela();

                    if (novel.addNewLibro(newNovel)){
                        System.out.println("Libro añadido correctamente");
                    } else {
                        System.out.println("Ya existe este libro");
                    }
                    System.out.println(newNovel);
                    System.out.println("-----------------------------------");
                    break;
                case 2:
                    Science newScience = science.datosScience();

                    if (science.addNewLibro(newScience)){
                        System.out.println("Libro añadido correctamente");
                    } else {
                        System.out.println("Ya existe este libro");
                    }
                    System.out.println(newScience);
                    System.out.println("-----------------------------------");
                    break;
                case 3:
                    History newHistory = history.datosHistory();

                    if (history.addNewLibro(newHistory)){
                        System.out.println("Libro añadido correctamente");
                    } else {
                        System.out.println("Ya existe este libro");
                    }
                    System.out.println(newHistory);
                    System.out.println("-----------------------------------");
                    break;
                case 4:
                    Comic newComic = comic.datosComic();

                    if (comic.addNewLibro(newComic)){
                        System.out.println("Libro añadido correctamente");
                    } else {
                        System.out.println("Ya existe este libro");
                    }
                    System.out.println(newComic);
                    System.out.println("-----------------------------------");
                    break;
                case 5:
                    System.out.println("Cancelando...");
                    continuar = false;
                    primerMenu();
                    break;
            }
        }
    }

    public static void removeLibro(){
        System.out.println("<<ELIMINAR LIBRO>>");
        String titulo;

        scanner.nextLine();

        do {
            System.out.print("Título del libro: : ");
            titulo = scanner.nextLine();

            if (!titulo.matches("[a-zA-Z]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!titulo.matches("[a-zA-Z]+"));

        Libro eliminarLibro = libro.queryLibro(titulo);

        if (libro.queryLibro(titulo) != null){
            libro.removeLibro(eliminarLibro);
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    public static void findLibro(){
        System.out.println("<<BUSCAR LIBRO>>");
        String titulo;

        scanner.nextLine();

        do {
            System.out.print("Título del libro: : ");
            titulo = scanner.nextLine();

            if (!titulo.matches("[a-zA-Z]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!titulo.matches("[a-zA-Z]+"));

        Libro buscarLibro = libro.queryLibro(titulo);

        if (libro.queryLibro(titulo) != null){
            System.out.println(buscarLibro);
        } else {
            System.out.println("Libro no encontrado");
        }
    }

    public static void listaLibros(){
        System.out.println("<<LISTA DE LIBROS>>");
        ArrayList<Libro> lista = Libro.getLibros();

        if (lista.isEmpty()) {
            System.out.println("No hay libros registrados");
            return;
        }

        for (Libro misLibros : lista){
            System.out.println(misLibros);
        }
    }

    public static void main(String[] args) {
        int opcion;
        boolean continuar = true;

        primerMenu();

        while (continuar){
            do {
                try {
                    System.out.print("Elige una opción: ");
                    opcion = scanner.nextInt();

                    if (opcion<0 || opcion>5){
                        System.out.println("Las opciones van del 1 al 5");
                        opcion = -1;
                    }
                } catch (Exception e){
                    System.out.println("Formato no válido");
                    scanner.next();
                    opcion = -1;
                }
            } while (opcion<0);

            switch (opcion){
                case 1:
                    addNewLibro();
                    break;
                case 2:
                    removeLibro();
                    break;
                case 3:
                    findLibro();
                    break;
                case 4:
                    listaLibros();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;
            }
        }
    }
}
