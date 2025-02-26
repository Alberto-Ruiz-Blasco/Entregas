package book;

import java.util.Scanner;

public class Comic extends Libro{

    private String illustrator;
    private static Scanner scanner = new Scanner(System.in);

    public Comic(String titulo, String autor, int paginas, String illustrator) {
        super(titulo, autor, paginas);
        this.illustrator = illustrator;
    }

    public void showIllustrations(){
        System.out.println("Mostrar ilustraciones");
    }

    public Comic datosComic(){
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

            System.out.print("Ilustrador: ");
            illustrator = scanner.nextLine();

            if (!illustrator.matches("[a-zA-Z\\s]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!illustrator.matches("[a-zA-Z\\s]+"));

        return new Comic(titulo,autor,paginas,illustrator);
    }

    @Override
    public String toString() {
        return "COMIC: [Título: " + getTitulo() + ", autor: " + getAutor() + ", páginas: " + getPaginas() + ", ilustrador: " + illustrator + "]";
    }
}
