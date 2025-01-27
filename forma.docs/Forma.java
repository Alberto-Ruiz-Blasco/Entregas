package Tarea3_Ej4;

public class Forma {

    protected String nombre;

    public Forma(String nombre) {
        this.nombre = nombre;
    }

    public double area(){
        return 0;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
