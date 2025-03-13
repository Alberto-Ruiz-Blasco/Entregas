package tareaSet;

public class Luna extends CuerpoCeleste{

    private String nombreLuna;
    private double periodoOrbitalLuna;

    public Luna(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.PLANETA);
        this.nombreLuna = nombre;
        this.periodoOrbitalLuna = periodoOrbital;
    }
}
