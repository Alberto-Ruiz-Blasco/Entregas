package BusElche;

import java.util.*;

public class mainBuses {

    static Map<String, ParadaBus> lineaA = new HashMap<>();
    static Map<String, ParadaBus> lineaI = new HashMap<>();
    static Map<String, ParadaBus> lineaJ = new HashMap<>();
    static Map<String, ParadaBus> lineaF = new HashMap<>();
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

        lineaI.put(parada003.getNombre(), parada003);
        paradas.add(parada003);

        ParadaBus parada071 = new ParadaBus(71, "Jorge Juan-Reina Victoria", "Jorge Juan-Reina Victoria");
        lineaI.put(parada071.getNombre(), parada071);
        paradas.add(parada071);

        ParadaBus parada335 = new ParadaBus(335, "Gabriel Miró", "Gabriel Miró");
        lineaI.put(parada335.getNombre(), parada335);
        paradas.add(parada335);

        ParadaBus parada346 = new ParadaBus(346, "Passeig de les Germanies", "Passeig de les Germanies");
        lineaI.put(parada346.getNombre(), parada346);
        paradas.add(parada346);

        ParadaBus parada347 = new ParadaBus(347, "Federico G.Lorca-Asilo", "Federico G.Lorca-Asilo");
        lineaI.put(parada347.getNombre(), parada347);
        paradas.add(parada347);

        ParadaBus parada115 = new ParadaBus(115, "Centre-Avg. C.Valenciana", "Centre-Avg. C.Valenciana");
        lineaJ.put(parada115.getNombre(), parada115);
        paradas.add(parada115);

        lineaJ.put(parada002.getNombre(), parada002);
        paradas.add(parada002);

        ParadaBus parada089 = new ParadaBus(89, "Avinguda Llibertat", "Avinguda Llibertat, 11");
        lineaJ.put(parada089.getNombre(), parada089);
        paradas.add(parada089);

        ParadaBus parada090 = new ParadaBus(90, "Renfe-Parc Municipal", "Renfe-Parc Municipal");
        lineaJ.put(parada090.getNombre(), parada090);
        paradas.add(parada090);

        ParadaBus parada117 = new ParadaBus(117, "Virgen de la Cabeza", "Virgen de la Cabeza-LI. del Pensionista");
        lineaJ.put(parada117.getNombre(), parada117);
        paradas.add(parada117);

        lineaF.put(parada115.getNombre(), parada115);
        paradas.add(parada115);

        lineaF.put(parada002.getNombre(), parada002);
        paradas.add(parada002);

        ParadaBus parada056 = new ParadaBus(56, "Cristóbal Sanz", "Cristóbal Sanz");
        lineaF.put(parada056.getNombre(), parada056);
        paradas.add(parada056);

        lineaF.put(parada089.getNombre(), parada089);
        paradas.add(parada089);

        lineaF.put(parada090.getNombre(), parada090);
        paradas.add(parada090);


        tramos.add(new Tramo("A", 1, 2, 75));
        tramos.add(new Tramo("A", 2, 3, 60));
        tramos.add(new Tramo("A", 3, 4, 40));
        tramos.add(new Tramo("A", 4, 5, 50));
        tramos.add(new Tramo("A", 5, 6, 80));

        tramos.add(new Tramo("I", 3, 71, 50));
        tramos.add(new Tramo("I", 71, 335, 100));
        tramos.add(new Tramo("I", 335, 346, 70));
        tramos.add(new Tramo("I", 346, 347, 50));
        tramos.add(new Tramo("I", 347, 400, 120));

        tramos.add(new Tramo("J", 115, 2, 125));
        tramos.add(new Tramo("J", 2, 89, 75));
        tramos.add(new Tramo("J", 56, 90, 40));
        tramos.add(new Tramo("J", 89, 117, 80));
        tramos.add(new Tramo("J", 90, 600, 40));

        tramos.add(new Tramo("F", 115, 2, 125));
        tramos.add(new Tramo("F", 2, 56, 45));
        tramos.add(new Tramo("F", 56, 89, 40));
        tramos.add(new Tramo("F", 89, 90, 75));
        tramos.add(new Tramo("F", 90, 900, 70));
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
