import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class LecturaChar {
    public static void main(String[] args) {
        FileReader fr;
        try {
            fr = new FileReader("C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\ej5.txt");
            BufferedReader entrada = new BufferedReader(fr);
            int car = entrada.read();
            while (car != -1) {
                System.out.print((char) car);
                car = entrada.read();
            }
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
