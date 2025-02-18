package Tarea2;

import java.util.*;

public class mainCancion {

    private static Scanner scanner = new Scanner(System.in);

    public static void imprimirMenu(){
        System.out.println("--------------------------------------------------");
        System.out.println("0 -Salir de la lista de reproducción");
        System.out.println("1 -Reproducir siguiente canción en la lista");
        System.out.println("2 -Reproducir la canción previa de la lista");
        System.out.println("3 -Repetir canción actual");
        System.out.println("4 -Imprimir la lista de canciones en la playlist");
        System.out.println("5 -Volver a imprimir el menú");
        System.out.println("6 -Eliminar canción actual de la playlist");
        System.out.println("7 -Imprimir canciones por álbum");
        System.out.println("--------------------------------------------------");
    }

    public static void main(String[] args) {
        ArrayList<Album> albumes = new ArrayList<>();

        Album album1 = new Album("Sakura","Saiko");
        album1.addSong("Supernova",3.5);
        album1.addSong("Badgyal",4.0);
        album1.addSong("Boreal",2.5);
        albumes.add(album1);

        Album album2 = new Album("Sr Santos","Arcángel");
        album2.addSong("La Jumpa",3.4);
        album2.addSong("Bottas",2.2);
        album2.addSong("Portobello",2.5);
        albumes.add(album2);

        Album album3 = new Album("DTMF", "Bad Bunny");
        album3.addSong("NUEVAYol", 2.5);
        album3.addSong("DtMF",3.5);
        album3.addSong("EoO",3.0);
        albumes.add(album3);


        LinkedList<Cancion> listaReproducion = new LinkedList<>();
        album1.addToPlayList(2,listaReproducion);
        album2.addToPlayList("Portobello",listaReproducion);
        album3.addToPlayList("NUEVAYol", listaReproducion);
        album3.addToPlayList(3, listaReproducion);
        album2.addToPlayList(1,listaReproducion);
        album3.addToPlayList(10,listaReproducion);

        System.out.println(listaReproducion);
        play(listaReproducion, albumes);


    }

    public static void printPlayList(LinkedList<Cancion> listaReproduccion, ArrayList<Album> albumes){
        Iterator<Cancion> iterator = listaReproduccion.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("------------");
    }

    public static void printAlbum(ArrayList<Album> albumes){
        System.out.println("<<ENCONTRAR ÁLBUM>>");
        String name;

        do {
            System.out.print("Introduce el nombre del álbum: ");
            name = scanner.nextLine();

            if (!name.matches("[a-zA-Z]+")){
                System.out.println("Error. Formato no válido");
            }
        } while (!name.matches("[a-zA-Z]+"));

        boolean encontrado = false;
        for (Album album : albumes){
            if (album.getNombre().equalsIgnoreCase(name)){
                System.out.println("Álbum encontrado: " + album.getNombre() + " de " + album.getArtista() + " | Canciones: " + album.getCanciones());
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("Álbum no encontrado");
        }
    }

    public static void play(LinkedList<Cancion> listaReproduccion, ArrayList<Album> albumes) {
        boolean haciaAdelante = true;
        boolean continuar = true;
        ListIterator<Cancion> iterator = listaReproduccion.listIterator();
        int opcion = 0;
        imprimirMenu();

        while(continuar) {
            do {
                try {
                    System.out.print("Elige una opción: ");
                    opcion = scanner.nextInt();

                    if (opcion < 0 || opcion > 7) {
                        System.out.println("<<OPCIÓN NO VÁLIDA>> Debe ser un número entre 0 y 7");
                    }
                } catch (Exception e) {
                    System.out.println("<<ERROR>> Debes ingresar un número válido");
                    scanner.next();
                    opcion = -1;
                }
            } while (opcion < 0 || opcion > 7);

            switch (opcion) {
                case 0:
                    System.out.println("Saliendo...");
                    continuar = false;
                    break;
                case 1:
                    if (!haciaAdelante) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        haciaAdelante = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Reproduciendo " + iterator.next());
                    } else {
                        System.out.println("Has llegado al final de la lista de reproducción.");
                        haciaAdelante = false;
                    }
                    break;
                case 2:
                    if (haciaAdelante) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        haciaAdelante = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Reproduciendo " + iterator.previous());
                    } else {
                        System.out.println("Has llegado al inicio de la lista de reproducción.");
                        haciaAdelante = true;
                    }
                    break;
                case 3:
                    if (haciaAdelante) {
                        if (iterator.hasPrevious()) {
                            System.out.println("Repitiendo " + iterator.previous());
                            haciaAdelante = false;
                        } else {
                            System.out.println("No se ha reproducido ninguna canción");
                        }
                    } else {
                        if (iterator.hasNext()) {
                            System.out.println("Repitiendo " + iterator.next());
                            haciaAdelante = true;
                        }else {
                            System.out.println("No se ha reproducido ninguna canción");
                        }
                    }
                    if (listaReproduccion.isEmpty()){
                        System.out.println("La playlist está vacía");
                    }
                    break;
                case 4:
                    System.out.println("------------");
                    System.out.println("<<PLAYLIST>>");
                    if (listaReproduccion.isEmpty()){
                        System.out.println("No hay canciones en la playlist");
                    }
                    printPlayList(listaReproduccion, albumes);
                    break;
                case 5:
                    imprimirMenu();
                    break;
                case 6:
                    iterator.remove();
                    System.out.println("<<CANCIÓN ELIMINADA>>");
                    if (iterator.hasNext()) {
                        System.out.println("Siguiente canción --> " + iterator.next());
                    } else if (iterator.hasPrevious()) {
                        System.out.println("Canción anterior --> " + iterator.previous());
                    } else if (listaReproduccion.isEmpty()){
                        System.out.println("No quedan canciones para eliminar");
                        imprimirMenu();
                    }
                    break;
                case 7:
                    scanner.nextLine();
                    printAlbum(albumes);
                    break;
                default:
                    System.out.println("<<OPCIÓN NO VÁLIDA>>");
            }
        }
    }
}
