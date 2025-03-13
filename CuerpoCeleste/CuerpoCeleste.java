package CuerpoCeleste;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CuerpoCeleste {

    public enum TipoCuerpoCeleste {
        ESTRELLA, PLANETA, PLANETA_ENANO, LUNA, COMETA, ASTEROIDE
    }

    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satelites;
    private TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        this.tipoCuerpo = tipoCuerpo;
        satelites = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public Set<CuerpoCeleste> getSatelites() {
        return satelites;
    }

    public boolean addSatelite (CuerpoCeleste cuerpoceleste){
        if (satelites.add(cuerpoceleste)){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        CuerpoCeleste that = (CuerpoCeleste) obj;
        return nombre.equals(that.nombre) && tipoCuerpo == that.tipoCuerpo;
    }


    @Override
    public int hashCode() {
        return Objects.hash(nombre, tipoCuerpo) + 10;
    }

    @Override
    public String toString() {
        return "CUERPO CELESTE: [Nombre: " + nombre + ", tipo: " + tipoCuerpo + ", periodo orbital: " + periodoOrbital + "]";
    }
}
