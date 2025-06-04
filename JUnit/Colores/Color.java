package Colores;

public class Color {

    String nombre;

    public Color(String nombre) {
        this.nombre = nombre;
    }

    public static String queColorSoy(String nombre){
        String color;
        if (nombre.charAt(0)>='A' && nombre.charAt(0)<='F'){
           color = "rojo";
        }
        else if(nombre.charAt(0)>='G' && nombre.charAt(0)<='M'){
            color = "verde";
        }
        else if(nombre.charAt(0)>='N' && nombre.charAt(0)<='S'){
            color = "azul";
        }
        else if(nombre.charAt(0)>='T' && nombre.charAt(0)<='Z'){
            color = "amarillo";
        }
        else {
            color = "blanco";
        }
        return color;
    }
}
