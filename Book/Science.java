package book;

import java.util.Scanner;

public class Science extends Libro{

    private String field;
    private static Scanner scanner = new Scanner(System.in);

    public Science(String titulo, String autor, int paginas, String field) {
        super(titulo, autor, paginas);
        this.field = field;
    }

    public void explainConccept(){
        System.out.println("Explicar concepto");
    }

    public Science datosScience(){
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

            System.out.print("Campo: ");
            field = scanner.nextLine();

            if (!field.matches("[a-zA-Z\\s]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!field.matches("[a-zA-Z\\s]+"));

        return new Science(titulo,autor,paginas,field);
    }

    @Override
    public String toString() {
        return "SCIENCE: [Título: " + getTitulo() + ", autor: " + getAutor() + ", páginas: " + getPaginas() + ", campo: " + field + "]";
    }
}
