package Impresora;

public class Impresora {

    private int nivel_toner;
    private int pag_impresas;
    private boolean doble_cara;

    public Impresora(int nivel_toner, int pag_impresas, boolean doble_cara) {
        this.nivel_toner = nivel_toner;
        this.pag_impresas = pag_impresas;
        this.doble_cara = doble_cara;
    }

    public Impresora(boolean doble_cara) {
        this.doble_cara = doble_cara;
    }

    public void setNivel_toner(int nivel_toner) {
        this.nivel_toner = nivel_toner;
    }

    public int ponerToner(int toner_poner){
        nivel_toner = nivel_toner + toner_poner;

        if (nivel_toner<0 || nivel_toner>100){
            return -1;
        }
        return nivel_toner;
    }

    public int impresionPaginas (int paginas_imprimir){
        if (doble_cara){
            paginas_imprimir = paginas_imprimir / 2;
        }

        pag_impresas = pag_impresas + paginas_imprimir;
        return pag_impresas;
    }

    public int getPag_impresas() {
        System.out.println("Getter");
        return pag_impresas;
    }
}
