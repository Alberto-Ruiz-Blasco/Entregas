package impresora;

import java.util.Scanner;

public class impresora {

    Scanner sc = new Scanner(System.in);

    private int nivel_toner;
    private int pag_impresas;
    private boolean doble_cara;

    public impresora(int nivel_toner, int pag_impresas, boolean doble_cara) {
        this.nivel_toner = nivel_toner;
        this.pag_impresas = pag_impresas;
        this.doble_cara = doble_cara;
    }

    public int ponerToner(int toner_poner){
        nivel_toner = nivel_toner + toner_poner;

        if (nivel_toner<0 || nivel_toner>100){
            return -1;
        }
        System.out.println("Nivel total de tóner: ");
        return nivel_toner;
    }

    public int impresionPaginas (int paginas_imprimir){
        if (doble_cara){
            paginas_imprimir = paginas_imprimir * 2;
        }
        System.out.println("Páginas a imprimir: " + paginas_imprimir);

        pag_impresas = pag_impresas + paginas_imprimir;
        System.out.println("Número de páginas totales: ");
        return pag_impresas;
    }

    public int getPag_impresas() {
        System.out.println("Getter");
        return pag_impresas;
    }
}
