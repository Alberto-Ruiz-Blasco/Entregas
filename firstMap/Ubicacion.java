package ej1;

import java.util.HashMap;

public class Ubicacion {

    int id;
    String descripcion;
    HashMap<String, Integer> exists;

    public Ubicacion(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        exists = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public HashMap<String, Integer> getExists() {
        return exists;
    }

    public void addExit (String direccion, int idUbicacion){
        exists.put(direccion.toUpperCase(), idUbicacion);
    }
}
