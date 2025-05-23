package datosXML;// Alberto Ruiz Blasco

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class mainEmpleado {

    private static Scanner scanner = new Scanner(System.in);
    private static datosEmpleado datosempleado = new datosEmpleado();

    public static void play() {
        System.out.println("--------------------------------------");
        System.out.println("|0- Salir                            |");
        System.out.println("|1- Insertar empleado                |");
        System.out.println("|2- Eliminar empleado                |");
        System.out.println("|3- Actualizar empleado              |");
        System.out.println("|4- Consultar empleado               |");
        System.out.println("|5- Imprimir lista de empleados      |");
        System.out.println("|6- Imprimir menú                    |");
        System.out.println("|7- Generar fichero en formato XML   |");
        System.out.println("|8- Información de las clases        |");
        System.out.println("-------------------------------------|");
    }

    public static void addNewEmployee() {
        System.out.println("<<INSERTAR EMPLEADO>>");
        int id;
        String name;
        String cargo;

        LocalDate fcontratacion = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            try {
                System.out.print("Introduce el id (debe ser menor a 1000): ");
                id = scanner.nextInt();

                scanner.nextLine();

                if (!(datosempleado.queryEmpleado(id) == null)) {
                    System.out.println("Ya hay un empleado con este id");
                    id = -1;
                }

                if (id >= 1000) {
                    System.out.println("Error. El id debe ser menor a 1000");
                    id = -1;
                }
            } catch (Exception e) {
                System.out.println("Error. Formato no válido");
                scanner.nextLine();
                id = -1;
            }
        } while (id < 0);

        do {
            System.out.print("Introduce el nombre del empleado: ");
            name = scanner.nextLine();

            if (!name.matches("[a-zA-Z]+")) {
                System.out.println("Error. Formato no válido");
            }
        } while (!name.matches("[a-zA-Z]+"));

        do {
            System.out.print("Introduce el cargo: ");
            cargo = scanner.nextLine();

            if (!cargo.matches("[a-zA-Z\\s]+")) {
                System.out.println("Error. Formato no válido");
            }
        } while (!cargo.matches("[a-zA-Z\\s]+"));

        do {
            try {
                System.out.print("Introduce una fecha de contratación (dd/MM/yyyy): ");
                String input = scanner.nextLine();
                fcontratacion = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Error. Formato de fecha no válido");
            }
        } while (fcontratacion == null);

        Empleado empleado = new Empleado(id, name, cargo, fcontratacion);
        if (datosempleado.addNewEmpleado(empleado)) {
            System.out.println("Se ha añadido correctamente");
        } else {
            System.out.println("Error. Este empleado ya existe");
        }
    }

    public static void eliminarEmpleado() {
        System.out.println("<<ELIMINAR EMPLEADO>>");
        int id;

        do {
            try {
                System.out.print("Introduce el id (debe ser menor a 1000): ");
                id = scanner.nextInt();

                scanner.nextLine();

                if ((datosempleado.queryEmpleado(id) == null)) {
                    System.out.println("No se ha encontrado el empleado");
                    id = -1;
                }

                if (id >= 1000) {
                    System.out.println("Error. El id debe ser menor a 1000");
                    id = -1;
                }
            } catch (Exception e) {
                System.out.println("Error. Formato no válido");
                scanner.nextLine();
                id = -1;
            }
        } while (id < 0);

        Empleado empleado = datosempleado.queryEmpleado(id);
        if (empleado == null) {
            System.out.println("No se ha encontrado el empleado");
            return;
        }
        datosempleado.removeEmployee(empleado);
        System.out.println("<<datosXML.Empleado eliminado>>");
    }

    public static void actualizarEmpleado() {
        System.out.println("<<ACTUALIZAR EMPLEADO>>");
        int id, newId;
        String newName, newCargo;

        LocalDate newDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            try {
                System.out.print("Introduce el viejo id (debe ser menor a 1000): ");
                id = scanner.nextInt();

                scanner.nextLine();

                if ((datosempleado.queryEmpleado(id) == null)) {
                    System.out.println("Ya hay un empleado con este id");
                    id = -1;
                }

                if (id >= 1000) {
                    System.out.println("Error. El id debe ser menor a 1000");
                    id = -1;
                }
            } catch (Exception e) {
                System.out.println("Error. Formato no válido");
                scanner.nextLine();
                id = -1;
            }
        } while (id < 0);

        Empleado oldEmployee = datosempleado.queryEmpleado(id);
        if (oldEmployee == null) {
            System.out.println("datosXML.Empleado no encontrado");
            return;
        }

        do {
            try {
                System.out.print("Introduce el nuevo id (debe ser menor a 1000): ");
                newId = scanner.nextInt();

                scanner.nextLine();

                if (!(datosempleado.queryEmpleado(newId) == null)) {
                    System.out.println("Ya hay un empleado con este id");
                    newId = -1;
                }

                if (newId >= 1000) {
                    System.out.println("Error. El id debe ser menor a 1000");
                    newId = -1;
                }
            } catch (Exception e) {
                System.out.println("Error. Formato no válido");
                scanner.nextLine();
                newId = -1;
            }
        } while (newId < 0);

        do {
            System.out.print("Introduce el nuevo nombre: ");
            newName = scanner.nextLine();

            if (!newName.matches("[a-zA-Z]+")) {
                System.out.println("Error. Formato no válido");
            }
        } while (!newName.matches("[a-zA-Z]+"));

        do {
            System.out.print("Introduce el nuevo cargo: ");
            newCargo = scanner.nextLine();

            if (!newCargo.matches("[a-zA-Z\\s]+")) {
                System.out.println("Error. Formato no válido");
            }
        } while (!newCargo.matches("[a-zA-Z\\s]+"));

        do {
            try {
                System.out.print("Introduce la nueva fecha de contratación (dd/MM/yyyy): ");
                String input = scanner.nextLine();
                newDate = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Error. Formato de fecha no válido");
            }
        } while (newDate == null);

        Empleado newEmployee = new Empleado(newId, newName, newCargo, newDate);
        datosempleado.updateEmpleado(oldEmployee, newEmployee);
        System.out.println("datosXML.Empleado actualizado");
    }

    public static void consultarEmpleado() {
        System.out.println("<<CONSULTAR EMPLEADO>>");
        int id;

        do {
            try {
                System.out.print("Introduce el id (debe ser menor a 1000): ");
                id = scanner.nextInt();

                scanner.nextLine();

                if ((datosempleado.queryEmpleado(id) == null)) {
                    System.out.println("Ya hay un empleado con este id");
                    id = -1;
                }

                if (id >= 1000) {
                    System.out.println("Error. El id debe ser menor a 1000");
                    scanner.nextLine();
                    id = -1;
                }
            } catch (Exception e) {
                System.out.println("Error. Formato no válido");
                scanner.next();
                id = -1;
            }
        } while (id < 0);

        Empleado empleado;
        empleado = datosempleado.queryEmpleado(id);
        if (empleado == null) {
            System.out.println("Contacto no encontrado");
            return;
        }
        System.out.println(empleado);

    }

    public static void imprimirEmpleados() {
        datosempleado.printEmpleado();
    }

    public static void imprimirXML(){
        File archivo = new File("C:\\Users\\SRQ2\\Desktop\\ALBERTO FP\\Programación\\Ficheros\\xml.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))){
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.write("<empleados>\n");

            for (Empleado empleado : datosempleado.getListaEmpleados()) {
                writer.write("    <empleado>\n");
                writer.write("        <id>" + empleado.getId() + "</id>\n");
                writer.write("        <nombre>" + empleado.getNombre() + "</nombre>\n");
                writer.write("        <cargo>" + empleado.getCargo() + "</cargo>\n");
                writer.write("        <fechaContratacion>" + empleado.getFcontratacion() + "</fechaContratacion>\n");
                writer.write("    </empleado>\n");
            }

            writer.write("</empleados>\n");
            System.out.println("Se ha generado el archvo correctamente");
        } catch (IOException e){
            System.out.println("No se ha podido generar el xml");
        }
    }

    public static void infoclase(Object o)
    {
        Class<?> c;
        c=o.getClass();
        System.out.println("Nombre de la clase: "+c.getName());
        System.out.println("Nombre del paquete: "+c.getPackage().getName());
        System.out.println("Hereda de la clase: "+c.getSuperclass().getName());
        System.out.println("Posee los campos:");
        for (int i=0;i<c.getDeclaredFields().length;i++)
        {
            System.out.println("\t"+ ""+c.getDeclaredFields()[i].getName()+ " "+c.getDeclaredFields()[i].getType().getName());
        }
    }

    public static void main(String[] args) {
        boolean continuar = true;
        int opcion = 0;
        play();

        while (continuar) {
            do {
                try {
                    System.out.print("Elige una opción: ");
                    opcion = scanner.nextInt();

                    if (opcion < 0 || opcion > 9) {
                        System.out.println("<<OPCIÓN NO VÁLIDA>> Debe ser un número entre 0 y 8");
                    }
                } catch (Exception e) {
                    System.out.println("<<ERROR>> Debes ingresar un número válido");
                    scanner.next();
                    opcion = -1;
                }
            } while (opcion < 0 || opcion > 9);

            switch (opcion) {
                case 0:
                    continuar = false;
                    System.out.println("Saliendo...");
                    break;
                case 1:
                    addNewEmployee();
                    break;
                case 2:
                    eliminarEmpleado();
                    break;
                case 3:
                    actualizarEmpleado();
                    break;
                case 4:
                    consultarEmpleado();
                    break;
                case 5:
                    imprimirEmpleados();
                    break;
                case 6:
                    play();
                    break;
                case 7:
                    imprimirXML();
                    break;
                case 8:
                    Empleado emp = new Empleado(1, "Pepe", "Jefe", LocalDate.of(1990, 2, 10));
                    infoclase(emp);
                    break;
                default:
                    System.out.println("OPCIÓN NO VÁLIDA");
            }
        }
    }
}
