package impresora;

public class mainEncapsulacion {

    public static void main(String[] args) {
        impresora impresora = new impresora(30,2,true);
        System.out.println(impresora.ponerToner(70));
        System.out.println(impresora.impresionPaginas(5));
        System.out.println(impresora.getPag_impresas());
    }
}
