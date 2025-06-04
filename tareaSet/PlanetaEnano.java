package tareaSet;

public class PlanetaEnano extends CuerpoCeleste{

    private String nombrePlanetaEnano;
    private double periodoOrbitalPlanetaEnano;

    public PlanetaEnano(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.PLANETA);
        this.nombrePlanetaEnano = nombre;
        this.periodoOrbitalPlanetaEnano = periodoOrbital;
    }
}
