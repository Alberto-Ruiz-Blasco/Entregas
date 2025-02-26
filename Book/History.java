package book;

import java.util.Scanner;

public class History extends Libro{

    private String era;
    private static Scanner scanner = new Scanner(System.in);

    public History(String titulo, String autor, int paginas, String era) {
        super(titulo, autor, paginas);
        this.era = era;
    }

    public void describeEra(){
        System.out.println("Describir era");
    }

    public History datosHistory(){
        String titulo, autor;
        int paginas;

        do {
            System.out.print("Título del libro: ");
            titulo = scanner.nextLine();

            if (!titulo.matches("[a-zA-Z\\s]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!titulo.matches("[a-zA-Z\\s]+"));

        do {
            System.out.print("Autor del libro: ");
            autor = scanner.nextLine();

            if (!autor.matches("[a-zA-Z\\s]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!autor.matches("[a-zA-Z\\s]+"));

        do {
            try {
                System.out.print("Páginas del libro: ");
                paginas = scanner.nextInt();

                if (paginas<=0 || paginas>10000){
                    System.out.println("El número de páginas debe estar entre 0 y 10000");
                    paginas = -1;
                }
            } catch (Exception e){
                System.out.println("Error. Formato no válido");
                scanner.next();
                paginas = -1;
            }
        } while (paginas<0);

        do {
            scanner.nextLine();

            System.out.print("Era: ");
            era = scanner.nextLine();

            if (!era.matches("[a-zA-Z\\s]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!era.matches("[a-zA-Z\\s]+"));

        return new History(titulo,autor,paginas,era);
    }

    @Override
    public String toString() {
        return "HISTORY: [Título: " + getTitulo() + ", autor: " + getAutor() + ", páginas: " + getPaginas() + ", era: " + era + "]";
    }
}
