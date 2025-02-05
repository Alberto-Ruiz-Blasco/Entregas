//Alberto Ruiz Blasco

import java.util.InputMismatchException;
import java.util.Scanner;

public class mainAutor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idautor = 0;
        String nacionalidad = "", premios = "", nombre = "", apellido1 = "", apellido2 = "";
        boolean datosCorrectos = false;

        do {
            try {
                System.out.print("Ingresa el id del autor: ");
                idautor = sc.nextInt();
                sc.nextLine();
                if (idautor <= 0) {
                    System.out.println("El id debe ser un número positivo");
                } else {
                    datosCorrectos = true;
                }
            } catch (Exception e) {
                System.out.println("Error en el id");
                sc.nextLine();
            }
        } while (!datosCorrectos);

        do {
            try {
                System.out.print("Ingresa la nacionalidad del autor: ");
                nacionalidad = sc.nextLine();
                if (nacionalidad.isEmpty()) {
                    System.out.println("Este campo no puede estar vacio");
                    datosCorrectos = false;
                } else {
                    datosCorrectos = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error en la nacionalidad");
            }
        } while (!datosCorrectos);

        do {
            try {
                System.out.print("Introduce el/los premio/s del autor: ");
                premios = sc.nextLine();
                if (premios.isEmpty()) {
                    System.out.println("Este campo no puede estar vacio");
                    datosCorrectos = false;
                } else {
                    datosCorrectos = true;
                }
            } catch (Exception e) {
                System.out.println("Error en los premios");
            }
        } while (!datosCorrectos);

        do {
            try {
                System.out.print("Introduce el nombre del autor: ");
                nombre = sc.nextLine();
                if (nombre.isEmpty()) {
                    System.out.println("Este campo no puede estar vacio");
                    datosCorrectos = false;
                } else {
                    datosCorrectos = true;
                }
            } catch (Exception e) {
                System.out.println("Error en el nombre");
            }
        } while (!datosCorrectos);

        do {
            try {
                System.out.print("Introduce el primer apellido: ");
                apellido1 = sc.nextLine();
                if (apellido1.isEmpty()) {
                    System.out.println("Este campo no puede estar vacio");
                    datosCorrectos = false;
                } else {
                    datosCorrectos = true;
                }
            } catch (Exception e) {
                System.out.println("Error en el primer apellido");
            }
        } while (!datosCorrectos);

        System.out.print("Introduce el segundo apellido (pulsa Enter si no tiene): ");
        apellido2 = sc.nextLine();
        if (apellido2.isEmpty()) {
            apellido2 = "";
        }

        Autor autor = new Autor(idautor, nacionalidad, premios, nombre, apellido1, apellido2);
        System.out.println(autor);
    }
}
