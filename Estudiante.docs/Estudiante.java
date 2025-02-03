package abstraccion.ej7;
import java.lang.Comparable;

public class Estudiante implements Comparable<Estudiante>{

    private String nombre;
    private int edad;
    private double altura;

    public Estudiante(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public int getEdad() {
        return edad;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public int compareTo(Estudiante otro) {
        int resultado=0;
        if (this.altura < otro.getAltura()){
            resultado = 1;
        } else if (this.altura > otro.getAltura()){
            resultado = -1;
        } else {
            if (this.edad < otro.getEdad()){
                resultado = 1;
            } else if (this.edad > otro.getEdad()){
                resultado = -1;
            }
        }
        return resultado;
    }

    @Override
    public String toString() {
        return nombre + " - Altura: " + altura + " - Edad: " + edad ;
    }
}
