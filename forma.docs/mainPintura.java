package Tarea3_Ej4;

public class mainPintura {
    public static void main(String[] args) {
        Pintura pintura = new Pintura(250.0);

        Rectangulo rectangulo = new Rectangulo("Rectangulo", 35.0,20.0);
        Esfera esfera = new Esfera(15);
        Cilindro cilindro = new Cilindro("Cilindro ", 10, 30);

        System.out.println("Pintura para el " + rectangulo + ": "+  pintura.cantidadPintura(rectangulo));
        System.out.println("Pintura para el " + esfera + ": "+ pintura.cantidadPintura(esfera));
        System.out.println("Pintura para el " +  cilindro + ": "+ pintura.cantidadPintura(cilindro));
    }
}
