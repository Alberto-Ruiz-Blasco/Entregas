import java.time.LocalDate;

public class Empleado {

    private int id;
    private String nombre;
    private String cargo;
    private LocalDate fcontratacion;

    public Empleado(int id, String nombre, String cargo, LocalDate fcontratacion) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.fcontratacion = fcontratacion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public LocalDate getFcontratacion() {
        return fcontratacion;
    }

    public static Empleado createEmpleado(int id, String nombre, String cargo, LocalDate fcontratacion){
        Empleado empleado = new Empleado(id,nombre,cargo,fcontratacion);
        return empleado;
    }

    @Override
    public String toString() {
        return "EMPLEADO: [id: " + id + ", nombre: " + nombre + ", cargo: " + cargo + ", fecha de contratación: " + fcontratacion + "]";
    }
}
