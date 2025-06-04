package Forma;

public class Pintura {

    protected double cobertura;

    public Pintura(double cobertura) {
        this.cobertura = cobertura;
    }

    public double cantidadPintura(Forma forma){
        return forma.area() / cobertura;
    }
}

