package ohtu.kivipaperisakset.logiikka;

import ohtu.kivipaperisakset.domain.Tekoaly;
import ohtu.kivipaperisakset.domain.Tuomari;
import java.util.Scanner;
import ohtu.kivipaperisakset.domain.Tekoaly;
import ohtu.kivipaperisakset.domain.Tuomari;

public class KPSTekoaly extends KiviPaperiSaksetAbs {
    private static final Tekoaly tekoaly = new Tekoaly();
    
    @Override
    protected String toisenSiirto(String ekanSiirto) {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}