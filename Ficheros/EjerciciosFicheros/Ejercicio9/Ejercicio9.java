package EjerciciosFicheros.Ejercicio9;

import java.io.Serializable;

public class Ejercicio9 implements Serializable {

    private String dni;
    private String nombre;
    private int edad;
    private double sueldo;

    public Ejercicio9(String dni, String nombre, int edad, double sueldo) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "[DNI: " + dni + ", nombre: " + nombre + ", edad: " + edad + ", sueldo" + sueldo + "]";
    }
}
