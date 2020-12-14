package ohtu.kivipaperisakset.logiikka;

import ohtu.kivipaperisakset.domain.Tuomari;
import java.util.Scanner;

import java.util.Scanner;
import ohtu.kivipaperisakset.domain.TekoalyParannettu;
import ohtu.kivipaperisakset.domain.Tuomari;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends KiviPaperiSaksetAbs {
    private static final TekoalyParannettu tekoaly = new TekoalyParannettu(20);
    
    @Override
    protected String toisenSiirto(String ekanSiirto) {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}
