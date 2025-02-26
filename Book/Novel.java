package book;

import java.util.Scanner;

public class Novel extends Libro {

    private String writingStyle;
    private static Scanner scanner = new Scanner(System.in);

    public Novel(String titulo, String autor, int paginas, String writingStyle) {
        super(titulo, autor, paginas);
        this.writingStyle = writingStyle;
    }

    public void summarize(){
        System.out.println("Resumir libro");
    }

    public Novel datosNovela(){
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

            System.out.print("Estilo de escritura: ");
            writingStyle = scanner.nextLine();

            if (!writingStyle.matches("[a-zA-Z\\s]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!writingStyle.matches("[a-zA-Z\\s]+"));

        return new Novel(titulo,autor,paginas,writingStyle);
    }

    @Override
    public String toString() {
        return "NOVELA: [Título: " + getTitulo() + ", autor: " + getAutor() + ", páginas: " + getPaginas() + ", estilo: " + writingStyle + "]";
    }
}
