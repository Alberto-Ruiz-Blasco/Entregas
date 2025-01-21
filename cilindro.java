public class cilindro extends circulo{

    double altura;

    public cilindro(double radio, double altura) {
        super(radio);
        if (altura<=0){
            this.altura=0;
        } else {
            this.altura = altura;
        }
    }

    public double getAltura() {
        return altura;
    }

    public double getVolume(){
        return getArea() * altura;
    }
}
