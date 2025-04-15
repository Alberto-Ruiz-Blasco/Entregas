package Consumer.Ejercicio12;

import java.time.LocalDate;

public class Programador {

    private String nombre;
    private double salario;
    private LocalDate fecin;

    public Programador(String nombre, double salario, LocalDate fecin) {
        this.nombre = nombre;
        this.salario = salario;
        this.fecin = fecin;
    }

    public Programador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Programador{" +
                "nombre='" + nombre + '\'' +
                ", salario=" + salario +
                ", fecin=" + fecin +
                '}';
    }
}
