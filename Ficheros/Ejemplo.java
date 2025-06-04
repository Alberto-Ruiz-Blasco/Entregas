import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Ejemplo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter salida = null;
        try {
            salida = new PrintWriter("C:\\Users\\SRQ2\\Desktop\\algo\\datos.txt");
            String cadena;
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
            cadena = sc.nextLine();
            while (!cadena.equalsIgnoreCase("FIN")) {
                salida.println(cadena);
                cadena = sc.nextLine();
            }
            salida.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
