//Alberto Ruiz Blasco

public class Autor {

    private int idautor;
    private String nacionalidad;
    private String premios;
    private String nombre;
    private String apellido1;
    private String apellido2;

    public Autor(int idautor, String nacionalidad, String premios, String nombre, String apellido1, String apellido2) {
        this.idautor = idautor;
        this.nacionalidad = nacionalidad;
        this.premios = premios;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;

    }

    @Override
    public String toString() {
        return  "ID: " + idautor + ", Nacionalidad: " + nacionalidad + ", Premios: " + premios +
                ", Nombre completo: " + nombre + " " + apellido1 + " " + apellido2;
    }
}
