package tareaSet;

public class Planeta extends CuerpoCeleste{

    private String nombrePlaneta;
    private double periodoOrbitalPlaneta;

    public Planeta(String nombre, double periodoOrbital) {
        super(nombre, periodoOrbital, TipoCuerpoCeleste.PLANETA);
        this.nombrePlaneta = nombre;
        this.periodoOrbitalPlaneta = periodoOrbital;
    }

    public boolean addSatelitePlaneta(CuerpoCeleste luna) {
        if (luna.getTipoCuerpo() == TipoCuerpoCeleste.LUNA) {
            return addSatelite(luna);
        }
        return false;
    }
}
