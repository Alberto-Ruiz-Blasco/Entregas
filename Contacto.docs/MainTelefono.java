package ej1;

import java.util.Scanner;

public class mainTelefono {

    private static Scanner scanner = new Scanner(System.in);
    private static TelefonoMovil telefonoMovil = new TelefonoMovil("555 01 20 31");

    public static void imprimirMenu() {
        System.out.println("-------------------------");
        System.out.println("0 - Salir");
        System.out.println("1 - Imprimir contactos");
        System.out.println("2 - Agregar contacto");
        System.out.println("3 - Actualizar contacto");
        System.out.println("4 - Eliminar contacto");
        System.out.println("5 - Encontrar contacto");
        System.out.println("6 - Menú");
        System.out.println("7 - Búsqueda por teléfono");
        System.out.println("8 - Ordenar por nombre");
        System.out.println("9 - Borrar todo");
        System.out.println("10 - Número de contactos");
        System.out.println("-------------------------");
    }

    public static void printContacts(){
        telefonoMovil.printContacts();
    }

    public static void addNewContact(){
        System.out.println("<<AGREGAR CONTACTO>>");
        String name, phoneNumber;

        do {
            System.out.print("Introduce el nombre: ");
            name = scanner.nextLine();

            if (!name.matches("[a-zA-Z]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!name.matches("[a-zA-Z]+"));

        do {
            System.out.print("Introduce el número de teléfono: ");
            phoneNumber = scanner.nextLine();

            if (!phoneNumber.matches("\\d{9}")){
                System.out.println("Error. Formato no válido");
            }
        } while (!phoneNumber.matches("\\d{9}"));

        Contacto newContact = Contacto.createContact(name,phoneNumber);

        if (telefonoMovil.addNewContact(newContact)){
            System.out.println("Se ha añadido correctamente");
        } else {
            System.out.println("Error. Este contacto ya existe");
        }
    }

    public static void updateContact(){
        System.out.println("<<ACTUALIZAR CONTACTO>>");
        String name, newName, tlf;

        do {
            System.out.print("Introduce el nombre: ");
            name = scanner.nextLine();

            if (!name.matches("[a-zA-Z]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!name.matches("[a-zA-Z]+"));

        Contacto oldContact = telefonoMovil.queryContact(name);
        if (oldContact == null){
            System.out.println("Contrato no encontrado");
            return;
        }

        do {
            System.out.print("Introduce el nuevo nombre: ");
            newName = scanner.nextLine();

            if (!newName.matches("[a-zA-Z]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!newName.matches("[a-zA-Z]+"));

        do {
            System.out.print("Introduce el número de teléfono: ");
            tlf = scanner.nextLine();

            if (!tlf.matches("\\d{9}")){
                System.out.println("Error. Formato no válido");
            }
        } while (!tlf.matches("\\d{9}"));

        Contacto newContact = Contacto.createContact(newName, tlf);
        telefonoMovil.updateContact(oldContact,newContact);
    }

    public static void removeContact(){
        System.out.println("<<ELIMINAR CONTACTO>>");
        String name;

        do {
            System.out.print("Introduce el nombre: ");
            name = scanner.nextLine();

            if (!name.matches("[a-zA-Z]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!name.matches("[a-zA-Z]+"));

        Contacto contacto = telefonoMovil.queryContact(name);
        if (contacto == null){
            System.out.println("Contrato no encontrado");
            return;
        }
        telefonoMovil.removeContact(contacto);
    }

    public static void findContact(){
        System.out.println("<<ENCONTRAR CONTACTO>>");
        String name;

        do {
            System.out.print("Introduce el nombre: ");
            name = scanner.nextLine();

            if (!name.matches("[a-zA-Z]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!name.matches("[a-zA-Z]+"));

        Contacto contacto;
        contacto = telefonoMovil.queryContact(name);
        if (contacto == null){
            System.out.println("Contacto no encontrado");
            return;
        }
        System.out.println(contacto);
    }

    public static void findByNumber(){
        System.out.println("<<ENCONTRAR CONTACTO POR NÚMERO>>");
        String phoneNumber;

        do {
            System.out.print("Introduce el número de teléfono: ");
            phoneNumber = scanner.nextLine();

            if (!phoneNumber.matches("\\d{9}")){
                System.out.println("Error. Formato no válido");
            }
        } while (!phoneNumber.matches("\\d{9}"));

        Contacto contacto;
        contacto = telefonoMovil.findByNumber(phoneNumber);
        if (contacto == null){
            System.out.println("Contacto no encontrado");
            return;
        }
        System.out.println(contacto);
    }

    public static void orderByName(){
        telefonoMovil.orderByName();
    }

    public static void removeAllContacts(){
        telefonoMovil.removeAllContacts();
    }

    public static void numberOfContacts(){
        telefonoMovil.numberOfContacts();
    }



    public static void main(String[] args) {
        boolean continuar = true;
        int opcion = 0;
        imprimirMenu();

        while(continuar) {
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    imprimirMenu();
                    break;
                case 7:
                    findByNumber();
                    break;
                case 8:
                    orderByName();
                    break;
                case 9:
                    removeAllContacts();
                    break;
                case 10:
                    numberOfContacts();
                    break;
                default:
                    System.out.println("OPCIÓN NO VÁLIDA");
            }
        }
    }
}
