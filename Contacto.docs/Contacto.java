package ej1;

public class Contacto {
    private String name;
    private String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contacto createContact (String name, String phoneNumber){
        Contacto contacto = new Contacto(name, phoneNumber);
        return contacto;
    }

    @Override
    public String toString() {
        return "Contacto: " + name + " --> " + phoneNumber;
    }
}
