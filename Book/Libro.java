package book;

import java.util.ArrayList;

public class Libro {

    private String titulo;
    private String autor;
    private int paginas;
    private static ArrayList<Libro> libros = new ArrayList<>();

    public Libro(String titulo, String autor, int paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public static ArrayList<Libro> getLibros() {
        return libros;
    }

    public boolean addNewLibro(Libro libro){
        if (findLibro(getTitulo())>=0){
            return false;
        }
        libros.add(libro);
        return true;
    }

    public boolean removeLibro(Libro libro){
        if (findLibro(getTitulo())>=0){
            libros.remove(libro);
            return true;
        }
        return false;
    }

    public Libro queryLibro(String titulo){
        for (Libro libro : libros){
            if (libro.getTitulo().equalsIgnoreCase(titulo)){
                return libro;
            }
        }
        return null;
    }

    private int findLibro(String titulo){
        int index=0;
        for (Libro libro : libros){
            if (libro.getTitulo().equalsIgnoreCase(titulo)){
                return index;
            }
            index++;
        }
        return -1;
    }
}
