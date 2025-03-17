package BusElche;

import java.util.*;

public class mainBusElche {

    static Map<String, ParadaBus> lineaA = new HashMap<>();
    static List<Tramo> tramos = new ArrayList<>();
    static Set<ParadaBus> paradas = new HashSet<>();

    public static void main(String[] args) {

        inicializarDatos();

        Scanner scanner = new Scanner(System.in);

        int paradaInicial;

        do {
            try {
                System.out.print("Elige parada inicial: ");
                paradaInicial = scanner.nextInt();

            } catch (Exception e){
                System.out.println("Error. Formato no válido");
                scanner.next();
                paradaInicial = -1;
            }
        } while (paradaInicial<0);

        ParadaBus origen = buscarParada(paradaInicial);
        if (origen == null) {
            System.out.println("Parada no encontrada.");
            return;
        }
        System.out.println("Has elegido " + origen.getNombre() + " – " + origen.getDireccion());

        String lineaInicial;

        do {
            System.out.print("Bus línea: ");
            lineaInicial = scanner.next().toUpperCase();

            if (!lineaInicial.matches("[a-zA-Z\\s]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!lineaInicial.matches("[a-zA-Z\\s]+"));

        boolean lineaExiste = false;
        for (Tramo tramo : tramos) {
            if (tramo.getLinea().equalsIgnoreCase(lineaInicial)) {
                lineaExiste = true;
                break;
            }
        }
        if (!lineaExiste) {
            System.out.println("Línea no encontrada.");
            return;
        }


        int paradaFinal;

        do {
            try {
                System.out.print("Elige Parada final: ");
                paradaFinal = scanner.nextInt();

            } catch (Exception e){
                System.out.println("Error. Formato no válido");
                scanner.next();
                paradaFinal = -1;
            }
        } while (paradaFinal<0);

        ParadaBus destino = buscarParada(paradaFinal);
        if (destino == null) {
            System.out.println("Parada no encontrada.");
            return;
        }
        System.out.println("Has elegido " + destino.getNombre() + " – " + destino.getDireccion());

        List<Tramo> ruta = encontrarRuta(paradaInicial, paradaFinal, lineaInicial);
        if (ruta.isEmpty()) {
            System.out.println("No se encontró una ruta válida.");
            return;
        }

        int tiempoTotal = 0;
        System.out.println("Salida:");
        for (Tramo tramo : ruta) {
            System.out.println(tramo.getLinea() + " desde " + tramo.getOrigen() + " hasta " + tramo.getDestino() + " - " + tramo.getTiempo() + " segundos");
            tiempoTotal += tramo.getTiempo();
        }

        int minutos = tiempoTotal / 60;
        int segundos = tiempoTotal % 60;
        System.out.println("Duración trayecto: " + tiempoTotal + " segundos, " + minutos + " minutos y " + segundos + " segundos.");
    }

    private static void inicializarDatos() {
        ParadaBus parada001 = new ParadaBus(1, "Doctor Caro", "C/Doctor Caro");
        lineaA.put(parada001.getNombre(), parada001);
        paradas.add(parada001);

        ParadaBus parada002 = new ParadaBus(2, "Vicente Blasco Ibáñez", "Vicente Blasco Ibáñez, 22");
        lineaA.put(parada002.getNombre(), parada002);
        paradas.add(parada002);

        ParadaBus parada003 = new ParadaBus(3, "Vicente Blasco Ibáñez", "Vicente Blasco Ibáñez, 80");
        lineaA.put(parada003.getNombre(), parada003);
        paradas.add(parada003);

        ParadaBus parada004 = new ParadaBus(4, "Inem Carrús", "Inem Carrús");
        lineaA.put(parada004.getNombre(), parada004);
        paradas.add(parada004);

        ParadaBus parada005 = new ParadaBus(5, "Pedro Moreno Sastre", "Pedro Moreno Sastre, 62");
        lineaA.put(parada005.getNombre(), parada005);
        paradas.add(parada005);

        tramos.add(new Tramo("A", 1, 2, 75));
        tramos.add(new Tramo("A", 2, 3, 60));
        tramos.add(new Tramo("A", 3, 4, 40));
        tramos.add(new Tramo("A", 4, 5, 50));
        tramos.add(new Tramo("A", 5, 6, 80));
    }

    private static ParadaBus buscarParada(int numero) {
        for (ParadaBus parada : paradas) {
            if (parada.getNumero() == numero) {
                return parada;
            }
        }
        return null;
    }

    private static List<Tramo> encontrarRuta(int inicio, int fin, String lineaInicial) {
        Queue<List<Tramo>> cola = new LinkedList<>();
        Set<Integer> visitados = new HashSet<>();

        for (Tramo tramo : tramos) {
            if (tramo.getOrigen() == inicio) {
                List<Tramo> nuevaRuta = new ArrayList<>();
                nuevaRuta.add(tramo);
                cola.add(nuevaRuta);
                visitados.add(inicio);
            }
        }

        while (!cola.isEmpty()) {
            List<Tramo> rutaActual = cola.poll();
            Tramo ultimoTramo = rutaActual.get(rutaActual.size() - 1);

            if (ultimoTramo.getDestino() == fin) {
                return rutaActual;
            }

            for (Tramo tramo : tramos) {
                if (tramo.getOrigen() == ultimoTramo.getDestino() && !visitados.contains(tramo.getDestino())) {
                    List<Tramo> nuevaRuta = new ArrayList<>(rutaActual);
                    nuevaRuta.add(tramo);
                    cola.add(nuevaRuta);
                    visitados.add(tramo.getDestino());
                }
            }
        }

        return new ArrayList<>();
    }
}

