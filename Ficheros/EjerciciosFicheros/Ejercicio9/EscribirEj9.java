package EjerciciosFicheros.Ejercicio9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirEj9 {

    public static void main(String[] args) {

        Ejercicio9 juan = new Ejercicio9("57720916K","Juan", 30, 2100);
        Ejercicio9 pepe = new Ejercicio9("43329881L","Pepe", 50, 2700);


        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\empleados.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(juan);
            oos.writeObject(pepe);
            fos.close();
            oos.close();
            System.out.println("Objetos escritos en el fichero con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
