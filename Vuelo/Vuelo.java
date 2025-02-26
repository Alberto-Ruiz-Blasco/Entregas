package Vuelo;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;

public class Vuelo {

    private YearMonth numero;
    private String origen;
    private String destino;
    private Dia dia;
    private String clase;
    private static ArrayList<Vuelo> vuelos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public Vuelo(YearMonth numero, String origen, String destino, Dia dia, String clase) {
        this.numero = numero;
        this.origen = origen;
        this.destino = destino;
        this.dia = dia;
        this.clase = clase;
    }

    public YearMonth getNumero() {
        return numero;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public Dia getDia() {
        return dia;
    }

    public String getClase() {
        return clase;
    }

    public static ArrayList<Vuelo> getVuelos() {
        return vuelos;
    }

    public boolean addNewVuelo(Vuelo vuelo){
        if (findVuelo(vuelo.getNumero()) >= 0){
            return false;
        }
        vuelos.add(vuelo);
        return true;
    }

    public boolean removeVuelo(Vuelo vuelo){
        int position = findVuelo(vuelo.getNumero());

        if (position > 0){
            vuelos.remove(vuelo);
            return true;
        }
        return false;
    }

    public static Vuelo queryVuelo(YearMonth numero){
        for (Vuelo vuelo : vuelos){
            if (vuelo.getNumero().equals(numero)){
                return vuelo;
            }
        }
        return null;
    }

    public int findVuelo(YearMonth numero){
        int index = 0;
        for (Vuelo vuelo : vuelos){
            if (vuelo.getNumero().equals(numero)){
                return index;
            }
        }
        return -1;
    }

    public ArrayList<Vuelo> queryClave(String clave, String valor){
        ArrayList<Vuelo> losVuelos = new ArrayList<>();

        for (Vuelo vuelo : vuelos){
            switch (clave){
                case "numero":
                    if (vuelo.getNumero().equals(valor)){
                        losVuelos.add(vuelo);
                    }
                    break;
                case "origen":
                    if (vuelo.getOrigen().equalsIgnoreCase(valor)){
                        losVuelos.add(vuelo);
                    }
                    break;
                case "destino":
                    if (vuelo.getDestino().equalsIgnoreCase(valor)){
                        losVuelos.add(vuelo);
                    }
                    break;
                case "dia":
                    try {
                        String[] partes = valor.split("-");
                        int dia = Integer.parseInt(partes[0].trim());
                        int mes = Integer.parseInt(partes[1].trim());
                        Dia diaBuscado = new Dia(dia, mes);

                        if (vuelo.getDia().equals(diaBuscado)) {
                            losVuelos.add(vuelo);
                        }
                    } catch (Exception e) {
                        System.out.println("Formato incorrecto para día. Usa 'día-mes'");
                    }
                    break;
                case "clase":
                    if (vuelo.getClase().equalsIgnoreCase(valor)){
                        losVuelos.add(vuelo);
                    }
                    break;
            }
        }
        return losVuelos;
    }

    @Override
    public String toString() {
        return "VUELO: [Número: " + numero + ", origen: " + origen + ", destino: " + destino + ", día: " + dia + ", clase: " + clase + "]";
    }
}
