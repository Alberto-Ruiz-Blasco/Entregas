package EjerciciosFicheros.Ejercicio9;

import ArtistaFicheros.Artista;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LeerEj9 {

    public static void main(String[] args) {

        File archivo=new File("C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\empleados.txt");
        try {
            FileInputStream fis = new FileInputStream(archivo);
            ObjectInputStream ois= new ObjectInputStream(fis);
            while(fis.available()>0) {
                Ejercicio9 artista=(Ejercicio9) ois.readObject();
                System.out.println(artista.toString());
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
