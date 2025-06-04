package Forma;

public class Esfera extends Forma{

    protected double radio;

    public Esfera(double radio) {
        super("Esfera");
        this.radio = radio;
    }

    @Override
    public double area(){
        return 4 * Math.PI * radio *radio;
    }
}

