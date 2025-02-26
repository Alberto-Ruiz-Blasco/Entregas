package Car;

import java.time.LocalDate;
import java.util.ArrayList;

public class Vehiculo {

    private String marca;
    private String modelo;
    private LocalDate fFabricacion;
    private double kilometraje;
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();

    public Vehiculo(String marca, String modelo, LocalDate fFabricacion, double kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.fFabricacion = fFabricacion;
        this.kilometraje = kilometraje;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDate getfFabricacion() {
        return fFabricacion;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public static ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public boolean addVehiculo(Vehiculo vehiculo){
        if (findVehiculo(vehiculo.getModelo()) >= 0){
            return false;
        }
        vehiculos.add(vehiculo);
        return true;
    }

    public boolean removeVehiculo(Vehiculo vehiculo){
        int position = findVehiculo(vehiculo.getModelo());

        if (position >= 0){
            vehiculos.remove(position);
            return true;
        }
        return false;
    }

    public Vehiculo queryVehiculo(String modelo){
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getModelo().equalsIgnoreCase(modelo)){
                return vehiculo;
            }
        }
        return null;
    }



    private int findVehiculo(String modelo){
        int index = 0;
        for (Vehiculo vehiculo : vehiculos){
            if (vehiculo.getModelo().equalsIgnoreCase(modelo)){
                return index;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "VEHÍCULO: [Marca: " + marca + ", modelo: " + modelo + ", fecha de fabricación: " + fFabricacion + ", kilometraje: " + kilometraje + "]";
    }
}
