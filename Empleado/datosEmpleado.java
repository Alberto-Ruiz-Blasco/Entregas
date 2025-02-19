import java.util.*;

public class datosEmpleado {

    private ArrayList<Empleado> empleados;

    public datosEmpleado() {
        this.empleados = new ArrayList<>();
    }

    public boolean addNewEmpleado(Empleado empleado) {
        if (findEmpleado(empleado.getId()) >= 0) {
            return false;
        }

        empleados.add(empleado);
        return true;
    }

    public boolean removeEmployee(Empleado empleado) {
        int position = findEmpleado(empleado.getId());

        if (position >= 0) {
            empleados.remove(position);
            return true;
        }

        return false;
    }

    public boolean updateEmpleado(Empleado oldEmployee, Empleado newEmployee) {
        int position = empleados.indexOf(oldEmployee);

        if (position < 0) {
            return false;
        }

        for (Empleado empleado : empleados) {
            if (empleado.getId() == (newEmployee.getId()) && !empleado.equals(oldEmployee)) {
                return false;
            }
        }

        empleados.set(position, newEmployee);
        return true;
    }

    public Empleado queryEmpleado (int id){
        for (Empleado contacto : empleados){
            if (id == (contacto.getId())){
                return contacto;
            }
        }
        return null;
    }

    private int findEmpleado (int id){
        int index = 0;

        for (Empleado empleado : empleados){
            if (empleado.getId() == id){
                return index;
            }
            index++;
        }
        return -1;
    }

    public void printEmpleado(){
        System.out.println("<<LISTA DE EMPLEADOS>>");
        for (Empleado empleado : empleados){
            System.out.println("[id: " + empleado.getId() + ", nombre: " + empleado.getNombre() + ", cargo: " + empleado.getCargo() + ", fecha de contratación: " + empleado.getFcontratacion() + "]");
        }
    }
}
