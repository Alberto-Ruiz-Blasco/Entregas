package Heores_del_Reino;

import java.util.ArrayList;

public class Heroe {

    private String name;
    private int nivel;
    private int puntosvida;
    private armaEspecial armaespecial;
    private static ArrayList<Heroe> heroes = new ArrayList<>();

    public Heroe(String name, int nivel, int puntosvida, armaEspecial armaespecial) {
        this.name = name;
        this.nivel = nivel;
        this.puntosvida = puntosvida;
        this.armaespecial = armaespecial;
    }

    public String getName() {
        return name;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosvida() {
        return puntosvida;
    }

    public armaEspecial getArmaespecial() {
        return armaespecial;
    }

    public static ArrayList<Heroe> getHeroes() {
        return heroes;
    }

    public boolean addHeroe(Heroe heroe){
        if (findHeroe(heroe.getName()) >= 0) {
            return false;
        }

        heroes.add(heroe);
        return true;
    }

    public boolean removeHeroe(Heroe heroe){
        int position = findHeroe(heroe.getName());

        if (position >= 0) {
            heroes.remove(position);
            return true;
        }

        return false;
    }

    public static Heroe queryHeroe(String name){
        for (Heroe heroe : heroes){
            if (heroe.getName().equalsIgnoreCase(name)){
                return heroe;
            }
        }
        return null;
    }

    private int findHeroe(String name){
        int index = 0;

        for (Heroe heroe : heroes){
            if (heroe.getName().equalsIgnoreCase(name)){
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Héroe: [Nombre: " + name + ", nivel: " + nivel + ", puntos de vida: " + puntosvida + ", arma especial: " + armaespecial + "]";
    }
}
