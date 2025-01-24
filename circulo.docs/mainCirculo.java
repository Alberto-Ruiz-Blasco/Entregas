public class mainCirculo {

    public static void main(String[] args) {
        circulo circulo1 = new circulo(4.0);
        circulo circulo2 = new circulo(-1.0);
        cilindro cilindro1 = new cilindro(5.0, 10.0);
        cilindro cilindro2 = new cilindro(9.0, -3.0);

        System.out.println("<<CÍRCULO 1>>");
        System.out.println("Radio del círculo: " + circulo1.getRadio());
        System.out.println("Área del círculo: " + circulo1.getArea());

        System.out.println();

        System.out.println("<<CÍRCULO 2>>");
        System.out.println("Radio del círculo: " + circulo2.getRadio());
        System.out.println("Área del círculo: " + circulo2.getArea());

        System.out.println();
        System.out.println();

        System.out.println("<<CILINDRO 1>>");
        System.out.println("Radio del cilindro: " + cilindro1.getRadio());
        System.out.println("Altura del cilindro: " + cilindro1.getAltura());
        System.out.println("Área del cilindro: " + cilindro1.getArea());
        System.out.println("Volumen del cilindro: " + cilindro1.getVolume());

        System.out.println();

        System.out.println("<<CILINDRO 2>>");
        System.out.println("Radio del cilindro: " + cilindro2.getRadio());
        System.out.println("Altura del cilindro: " + cilindro2.getAltura());
        System.out.println("Área del cilindro: " + cilindro2.getArea());
        System.out.println("Volumen del cilindro: " + cilindro2.getVolume());
    }
}
