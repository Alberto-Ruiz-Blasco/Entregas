package tareaSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class mainCuerpoCeleste {

    static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    static Set<CuerpoCeleste> planetas = new HashSet<>();
    static Set<CuerpoCeleste> lunas = new HashSet<>();

    public static void main(String[] args) {
        CuerpoCeleste mercurio = new Planeta("Mercurio", 88);
        sistemaSolar.put(mercurio.getNombre(), mercurio);
        planetas.add(mercurio);

        CuerpoCeleste venus = new Planeta("Venus", 225);
        sistemaSolar.put(venus.getNombre(), venus);
        planetas.add(venus);

        CuerpoCeleste tierra = new Planeta("La Tierra", 365);
        sistemaSolar.put(tierra.getNombre(), tierra);
        planetas.add(tierra);

        CuerpoCeleste marte = new Planeta("Marte", 687);
        sistemaSolar.put(marte.getNombre(), marte);
        planetas.add(marte);

        CuerpoCeleste jupiter = new Planeta("Júpiter", 4332);
        sistemaSolar.put(jupiter.getNombre(), jupiter);
        planetas.add(jupiter);

        CuerpoCeleste saturno = new Planeta("Saturno", 10759);
        sistemaSolar.put(saturno.getNombre(), saturno);
        planetas.add(saturno);

        CuerpoCeleste urano = new Planeta("Urano", 30660);
        sistemaSolar.put(urano.getNombre(), urano);
        planetas.add(urano);

        CuerpoCeleste neptuno = new Planeta("Neptuno", 165);
        sistemaSolar.put(neptuno.getNombre(), neptuno);
        planetas.add(neptuno);

        CuerpoCeleste pluton = new Planeta("Plutón", 365);
        sistemaSolar.put(pluton.getNombre(), pluton);
        planetas.add(pluton);

        CuerpoCeleste luna = new Luna("Luna", 27);
        sistemaSolar.put(luna.getNombre(), luna);
        tierra.addSatelite(luna);

        CuerpoCeleste deimos = new Luna("Deimos", 1.3);
        sistemaSolar.put(deimos.getNombre(), deimos);
        marte.addSatelite(deimos);

        CuerpoCeleste phobos = new Luna("Phobos", 0.3);
        sistemaSolar.put(phobos.getNombre(), phobos);
        marte.addSatelite(phobos);

        CuerpoCeleste io = new Luna("Io", 1.8);
        sistemaSolar.put(io.getNombre(), io);
        jupiter.addSatelite(io);

        CuerpoCeleste europa = new Luna("Europa", 3.5);
        sistemaSolar.put(europa.getNombre(), europa);
        jupiter.addSatelite(europa);

        CuerpoCeleste ganymede = new Luna("Ganymede", 7.1);
        sistemaSolar.put(ganymede.getNombre(), ganymede);
        jupiter.addSatelite(ganymede);

        CuerpoCeleste callisto = new Luna("Callisto", 16.7);
        sistemaSolar.put(callisto.getNombre(), callisto);
        jupiter.addSatelite(callisto);

        System.out.println("<<PLANETAS>>");
        for(CuerpoCeleste cuerpo: planetas) {
            System.out.println(cuerpo);
        }

        System.out.println();

        System.out.println("<<LUNAS MARTE>>");
        for (CuerpoCeleste lunasMarte : marte.getSatelites()){
            System.out.println(lunasMarte.getNombre() + ", " + lunasMarte.getPeriodoOrbital());
        }

        System.out.println();

        System.out.println("<<UNIÓN DE LUNAS>>");
        for (CuerpoCeleste planeta : planetas){
            lunas.addAll(planeta.getSatelites());
        }
        for (CuerpoCeleste unionLunas : lunas){
            System.out.println(unionLunas.getNombre() + " " + unionLunas.getPeriodoOrbital());
        }

        System.out.println();

        System.out.println("TODAS LAS LUNAS");
        for(CuerpoCeleste lunazas: lunas) {
            System.out.println(lunazas);
        }

        System.out.println();
        System.out.println("-Plutón no se crea porque ya existe como planeta enano-");
        System.out.println();

        CuerpoCeleste plutonEnano = new Planeta("Plutón", 365);
        sistemaSolar.put(pluton.getNombre(), pluton);
        planetas.add(pluton);
        System.out.println(plutonEnano);
        System.out.println("-Si es enano sí se podría-");
        System.out.println();
    }
}
