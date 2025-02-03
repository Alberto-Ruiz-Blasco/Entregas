package abstraccion.ej7;

import java.util.Arrays;

public class mainEj7 {
    public static void main(String[] args) {
        Estudiante[] estudiantes = new Estudiante[5];
        estudiantes[0] = new Estudiante("Patri",12, 1.70);
        estudiantes[1] = new Estudiante("Manuel",43, 1.73);
        estudiantes[2] = new Estudiante("Javier",72, 1.89);
        estudiantes[3] = new Estudiante("Alicia",52, 1.68);
        estudiantes[4] = new Estudiante("Alberto",35, 1.89);


        System.out.println("Estudiantes sin ordenar");
        for (Estudiante estudiante : estudiantes){
            System.out.println(estudiante);
        }

        System.out.println();
        Arrays.sort(estudiantes);

        System.out.println("Estudiantes ordenados");
        for (Estudiante est : estudiantes){
            System.out.println(est);
        }
    }
}
