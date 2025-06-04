package Impresora;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImpresoraTest {
    @Test

    void testImprimirDobleCaraActivada() {
        boolean isDobleCara = true;
        Impresora impresora = new Impresora(isDobleCara);

        int entrada = 10;
        int salidaEsperada = 5;
        int salidaRecibida = impresora.impresionPaginas(entrada);
        assertEquals(salidaEsperada, salidaRecibida);
    }

    @Test
    void testPonerToner(){
        Impresora impresora = new Impresora(50,2, false);

        int entrada = 20;
        int salidaEsperada = 70;
        int salidaRecibida = impresora.ponerToner(entrada);
        assertEquals(salidaEsperada, salidaRecibida);

        impresora.setNivel_toner(-50);
        salidaEsperada = -1;
        salidaRecibida = impresora.ponerToner(entrada);
        assertEquals(salidaEsperada, salidaRecibida);
    }

}