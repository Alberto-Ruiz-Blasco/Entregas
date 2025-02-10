package ej1;

import java.util.*;

public class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contacto contacto) {
        if (findContact(contacto.getName()) >= 0) {
            return false;
        }

        myContacts.add(contacto);
        return true;
    }

    public boolean updateContact(Contacto oldContact, Contacto newContact) {
        int position = myContacts.indexOf(oldContact);

        if (position < 0) {
            return false;
        }

        for (Contacto contacto : myContacts) {
            if (contacto.getName().equals(newContact.getName()) && !contacto.equals(oldContact)) {
                return false;
            }
        }

        myContacts.set(position, newContact);
        return true;
    }


    public boolean removeContact(Contacto contacto) {
        int position = findContact(contacto.getName());

        if (position >= 0) {
            myContacts.remove(position);
            return true;
        }

        return false;
    }

    private int findContact (Contacto contacto){
        if (myContacts.contains(contacto)){
            return myContacts.indexOf(contacto);
        } else {
            return -1;
        }
    }

    private int findContact (String name){
        int index = 0;

        for (Contacto contacto : myContacts){
            if (contacto.getName().equalsIgnoreCase(name)){
                return index;
            }
            index++;
        }
        return -1;
    }

    public Contacto queryContact (String name){
        for (Contacto contacto : myContacts){
            if (name.equals(contacto.getName())){
                return contacto;
            }
        }
        return null;
    }

    public Contacto findByNumber (String phoneNumber){
        for (Contacto contacto : myContacts){
            if (phoneNumber.equals(contacto.getPhoneNumber())){
                return contacto;
            }
        }
        return null;
    }

    public void orderByName(){
        if (myContacts.isEmpty()){
            System.out.println("<<No hay ningún contacto>>");
        }

        Collections.sort(myContacts, Comparator.comparing(Contacto::getName, String.CASE_INSENSITIVE_ORDER));

        printContacts();
    }

    public void removeAllContacts() {
        myContacts.clear();
        System.out.println("<<Todos los contactos han sido eliminados>>");
    }

    public void numberOfContacts(){
        System.out.println("<<Número de contactos: " + myContacts.size() + ">>");
    }

    public void printContacts(){
        System.out.println("<<LISTA DE CONTACTOS>>");
        for (Contacto contacto : myContacts){
            System.out.println(contacto.getName() + " --> " + contacto.getPhoneNumber());
        }
    }
}
