package BusElche;

import java.util.Objects;

public class ParadaBus {

    private int numero;
    private String nombre;
    private String direccion;

    public ParadaBus(int numero, String nombre, String direccion) {
        this.numero = numero;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParadaBus paradaBus = (ParadaBus) o;
        return numero == paradaBus.numero && Objects.equals(nombre, paradaBus.nombre) && Objects.equals(direccion, paradaBus.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, nombre, direccion);
    }

    @Override
    public String toString() {
        return "PARADA: [Nombre: " + nombre + ", número: " + numero + ", dirección: " + direccion + "]";
    }
}
